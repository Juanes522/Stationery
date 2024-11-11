package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PurchaseDTO;
import co.edu.unbosque.util.exception.PurchaseException;

/**
 * Implementación de las operaciones CRUD para la entidad {@link PurchaseDTO}.
 * Esta clase maneja las operaciones relacionadas con las compras, como la
 * creación, actualización, eliminación y carga de las compras desde la base de
 * datos, así como la vinculación de productos a las compras.
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class PurchaseDAO implements OperationsDAO<PurchaseDTO> {

	private DBConnection dbcon;
	private HashMap<Integer, PurchaseDTO> purchases;

	/**
	 * Constructor de la clase {@link PurchaseDAO}. Inicializa la conexión con la
	 * base de datos y carga las compras existentes.
	 */
	public PurchaseDAO() {
		dbcon = new DBConnection();
		purchases = loadPurchases();
	}

	/**
	 * Crea una nueva compra en la base de datos.
	 * 
	 * @param object El objeto {@link PurchaseDTO} que representa la nueva compra.
	 * @throws PurchaseException Si el total a pagar es 0 o si ocurre un error al
	 *                           crear la compra.
	 */
	@Override
	public void create(PurchaseDTO object) throws PurchaseException {
		PurchaseDTO newPurchase = object;
		dbcon.initConnection();
		if (newPurchase.getTotalPay() == 0) {
			throw new PurchaseException(1);
		}
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO purchase(purchase_date, total_pay) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setDate(1, Date.valueOf(newPurchase.getPurchaseDate()));
			dbcon.getPreparedstatement().setDouble(2, newPurchase.getTotalPay());
			dbcon.getPreparedstatement().executeUpdate();
			ResultSet key = dbcon.getPreparedstatement().getGeneratedKeys();
			if (!key.next()) {
				dbcon.close();
				throw new PurchaseException(2);
			}
			int idPurchase = key.getInt(1);
			purchases.put(idPurchase, newPurchase);
			HashMap<Integer, Integer> aux = newPurchase.getProducts();
			for (int idProduct : aux.keySet()) {
				dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
						"INSERT INTO purchase_product (id_purchase, id_product, quantity) VALUES (?, ?, ?)"));
				dbcon.getPreparedstatement().setInt(1, idPurchase);
				dbcon.getPreparedstatement().setInt(2, idProduct);
				dbcon.getPreparedstatement().setInt(3, aux.get(idProduct));
				dbcon.getPreparedstatement().executeUpdate();
			}
		} catch (SQLException e) {
			dbcon.close();
			throw new PurchaseException(2);
		}
		dbcon.close();
	}

	/**
	 * Actualiza una compra existente en la base de datos.
	 * 
	 * @param id     El identificador de la compra a actualizar.
	 * @param object El objeto {@link PurchaseDTO} con los nuevos datos de la
	 *               compra.
	 */
	@Override
	public void update(int id, PurchaseDTO object) {
		PurchaseDTO updatePurchase = object;
		if (!purchases.containsKey(id)) {
			// Si no existe la compra, no se realiza ninguna acción
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect()
					.prepareStatement("UPDATE purchase SET purchase_date = ?, total_pay = ? WHERE id_purchase = ?"));
			dbcon.getPreparedstatement().setDate(1, Date.valueOf(updatePurchase.getPurchaseDate()));
			dbcon.getPreparedstatement().setDouble(2, updatePurchase.getTotalPay());
			dbcon.getPreparedstatement().setInt(3, id);
			dbcon.getPreparedstatement().executeUpdate();

			dbcon.setPreparedstatement(
					dbcon.getConnect().prepareStatement("DELETE FROM purchase_product WHERE id_purchase = ?"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();

			HashMap<Integer, Integer> products = updatePurchase.getProducts();
			for (int idProduct : products.keySet()) {
				dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
						"INSERT INTO purchase_product (id_purchase, id_product, quantity) VALUES (?, ?, ?)"));
				dbcon.getPreparedstatement().setInt(1, id);
				dbcon.getPreparedstatement().setInt(2, idProduct);
				dbcon.getPreparedstatement().setInt(3, products.get(idProduct));
				dbcon.getPreparedstatement().executeUpdate();
			}
		} catch (SQLException e) {
			dbcon.close();
		}
		dbcon.close();
		purchases.put(id, updatePurchase);
	}

	/**
	 * Elimina una compra de la base de datos.
	 * 
	 * @param id El identificador de la compra a eliminar.
	 */
	@Override
	public void delete(int id) {
		dbcon.initConnection();
		if (!purchases.containsKey(id)) {
			// Si la compra no existe, no se realiza ninguna acción
		}
		try {
			dbcon.setPreparedstatement(
					dbcon.getConnect().prepareStatement("DELETE FROM purchase WHERE id_purchase = ?"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
		}
		dbcon.close();
		purchases.remove(id);
	}

	/**
	 * Carga todas las compras desde la base de datos.
	 * 
	 * @return Un {@link HashMap} con las compras cargadas, donde la clave es el
	 *         identificador de la compra.
	 */
	public HashMap<Integer, PurchaseDTO> loadPurchases() {
		HashMap<Integer, PurchaseDTO> data = new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM purchase;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id_purchase");
				LocalDate purchaseDate = dbcon.getResultset().getDate("purchase_date").toLocalDate();
				double totalPay = dbcon.getResultset().getDouble("total_pay");
				data.put(id, new PurchaseDTO(purchaseDate, totalPay));
			}
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM purchase_product;"));
			while (dbcon.getResultset().next()) {
				int idPurchase = dbcon.getResultset().getInt("id_purchase");
				int idProduct = dbcon.getResultset().getInt("id_product");
				int quantity = dbcon.getResultset().getInt("quantity");
				data.get(idPurchase).getProducts().put(idProduct, quantity);
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}

	/**
	 * Muestra todas las compras en formato de tabla.
	 * 
	 * @return Una matriz bidimensional con los datos de las compras.
	 */
	public String[][] showAll() {
		String info[][] = new String[purchases.size()][3];
		int i = 0;
		for (int id : purchases.keySet()) {
			PurchaseDTO sale = purchases.get(id);
			info[i][0] = Integer.toString(id);
			info[i][1] = sale.getPurchaseDate().toString();
			info[i][2] = Double.toString(sale.getTotalPay());
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

	public HashMap<Integer, PurchaseDTO> getPurchases() {
		return purchases;
	}

	public void setPurchases(HashMap<Integer, PurchaseDTO> purchases) {
		this.purchases = purchases;
	}
}
