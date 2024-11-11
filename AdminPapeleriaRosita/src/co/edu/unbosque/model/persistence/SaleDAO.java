package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.SaleDTO;
import co.edu.unbosque.util.exception.SaleException;

/**
 * Implementación de las operaciones CRUD para la entidad {@link SaleDTO}. Esta
 * clase maneja las operaciones relacionadas con las ventas, como la creación,
 * actualización, eliminación y carga de las ventas desde la base de datos, así
 * como la vinculación de productos a las ventas.
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class SaleDAO implements OperationsDAO<SaleDTO> {

	private DBConnection dbcon;
	private HashMap<Integer, SaleDTO> sales;

	/**
	 * Constructor de la clase {@link SaleDAO}. Inicializa la conexión con la base
	 * de datos y carga las ventas existentes.
	 */
	public SaleDAO() {
		dbcon = new DBConnection();
		sales = loadSales();
	}

	/**
	 * Crea una nueva venta en la base de datos.
	 * 
	 * @param object El objeto {@link SaleDTO} que representa la nueva venta.
	 * @throws SaleException Si el total a pagar es 0 o si ocurre un error al crear
	 *                       la venta.
	 */
	@Override
	public void create(SaleDTO object) throws SaleException {
		SaleDTO newSale = object;
		if (newSale.getTotalPay() == 0.0) {
			throw new SaleException(1);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO sale(sale_date, total_pay, seller) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setDate(1, Date.valueOf(newSale.getSaleDate()));
			dbcon.getPreparedstatement().setDouble(2, newSale.getTotalPay());
			dbcon.getPreparedstatement().setString(3, newSale.getSeller());
			dbcon.getPreparedstatement().executeUpdate();
			ResultSet key = dbcon.getPreparedstatement().getGeneratedKeys();
			if (!key.next()) {
				dbcon.close();
				throw new SaleException(2);
			}
			int idSale = key.getInt(1);
			sales.put(idSale, newSale);
			HashMap<Integer, Integer> aux = newSale.getProducts();
			for (int idProduct : aux.keySet()) {
				dbcon.setPreparedstatement(dbcon.getConnect()
						.prepareStatement("INSERT INTO sale_product (id_sale, id_product, quantity) VALUES (?, ?, ?)"));
				dbcon.getPreparedstatement().setInt(1, idSale);
				dbcon.getPreparedstatement().setInt(2, idProduct);
				dbcon.getPreparedstatement().setInt(3, aux.get(idProduct));
				dbcon.getPreparedstatement().executeUpdate();
			}
		} catch (SQLException e) {
			dbcon.close();
			e.printStackTrace();
			throw new SaleException(2);
		}
		dbcon.close();
	}

	/**
	 * Actualiza una venta existente en la base de datos.
	 * 
	 * @param id     El identificador de la venta a actualizar.
	 * @param object El objeto {@link SaleDTO} con los nuevos datos de la venta.
	 * @throws SaleException Si ocurre un error durante la actualización o si el
	 *                       total a pagar es 0.
	 */
	@Override
	public void update(int id, SaleDTO object) throws SaleException {
		SaleDTO updateSale = object;
		if (!sales.containsKey(id)) {
			throw new SaleException(3);
		}
		if (updateSale.getTotalPay() == 0.0) {
			throw new SaleException(1);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect()
					.prepareStatement("UPDATE sale SET sale_date = ?, total_pay = ?, seller=? WHERE id_sale = ?"));
			dbcon.getPreparedstatement().setDate(1, Date.valueOf(updateSale.getSaleDate()));
			dbcon.getPreparedstatement().setDouble(2, updateSale.getTotalPay());
			dbcon.getPreparedstatement().setString(3, updateSale.getSeller());
			dbcon.getPreparedstatement().setInt(4, id);
			dbcon.getPreparedstatement().executeUpdate();

			dbcon.setPreparedstatement(
					dbcon.getConnect().prepareStatement("DELETE FROM sale_product WHERE id_sale = ?"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();

			HashMap<Integer, Integer> products = updateSale.getProducts();
			for (int idProduct : products.keySet()) {
				dbcon.setPreparedstatement(dbcon.getConnect()
						.prepareStatement("INSERT INTO sale_product (id_sale, id_product, quantity) VALUES (?, ?, ?)"));
				dbcon.getPreparedstatement().setInt(1, id);
				dbcon.getPreparedstatement().setInt(2, idProduct);
				dbcon.getPreparedstatement().setInt(3, products.get(idProduct));
				dbcon.getPreparedstatement().executeUpdate();
			}
		} catch (SQLException e) {
			dbcon.close();
		}
		dbcon.close();
		sales.put(id, updateSale);
	}

	/**
	 * Elimina una venta de la base de datos.
	 * 
	 * @param id El identificador de la venta a eliminar.
	 * @throws SaleException Si la venta no existe o si ocurre un error durante la
	 *                       eliminación.
	 */
	@Override
	public void delete(int id) throws SaleException {
		dbcon.initConnection();
		if (!sales.containsKey(id)) {
			throw new SaleException(3);
		}
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM sale WHERE id_sale = ?"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new SaleException(4);
		}
		dbcon.close();
		sales.remove(id);
	}

	/**
	 * Carga todas las ventas desde la base de datos.
	 * 
	 * @return Un {@link HashMap} con las ventas cargadas, donde la clave es el
	 *         identificador de la venta.
	 */
	public HashMap<Integer, SaleDTO> loadSales() {
		HashMap<Integer, SaleDTO> data = new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM sale;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id_sale");
				LocalDate saleDate = dbcon.getResultset().getDate("sale_date").toLocalDate();
				double totalPay = dbcon.getResultset().getDouble("total_pay");
				String seller = dbcon.getResultset().getString("seller");
				data.put(id, new SaleDTO(saleDate, seller, totalPay));
			}
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM sale_product;"));
			while (dbcon.getResultset().next()) {
				int idSale = dbcon.getResultset().getInt("id_sale");
				int idProduct = dbcon.getResultset().getInt("id_product");
				int quantity = dbcon.getResultset().getInt("quantity");
				data.get(idSale).getProducts().put(idProduct, quantity);
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}

	/**
	 * Muestra todas las ventas en formato de tabla.
	 * 
	 * @return Una matriz bidimensional con los datos de las ventas.
	 */
	public String[][] showAll() {
		String info[][] = new String[sales.size()][4];
		int i = 0;
		for (int id : sales.keySet()) {
			SaleDTO sale = sales.get(id);
			info[i][0] = Integer.toString(id);
			info[i][1] = sale.getSeller();
			info[i][2] = sale.getSaleDate().toString();
			info[i][3] = Double.toString(sale.getTotalPay());
			i++;
		}
		return info;
	}

	// Getters y Setters

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public HashMap<Integer, SaleDTO> getSales() {
		return sales;
	}

	public void setSales(HashMap<Integer, SaleDTO> sales) {
		this.sales = sales;
	}
}
