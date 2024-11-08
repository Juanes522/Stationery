package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.SaleDTO;
import co.edu.unbosque.util.exception.SaleException;

public class SaleDAO implements OperationsDAO<SaleDTO> {
	
	private DBConnection dbcon;
	private HashMap<Integer, SaleDTO> sales;
	
	public SaleDAO() {
		dbcon=new DBConnection();
		sales=loadSales();
	}
	
	@Override
	public void create(SaleDTO object) throws SaleException{
		SaleDTO newSale=object;
		if(newSale.getTotalPay()==0.0) {
			throw new SaleException(1);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO sale(sale_date, total_pay, seller) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setDate(1, Date.valueOf(newSale.getSaleDate()));
			dbcon.getPreparedstatement().setDouble(2, newSale.getTotalPay());
			dbcon.getPreparedstatement().setString(3, newSale.getSeller());
			dbcon.getPreparedstatement().executeUpdate();
			ResultSet key=dbcon.getPreparedstatement().getGeneratedKeys();
			if(!key.next()) {
				dbcon.close();
				throw new SaleException(2);
			}
			int idSale=key.getInt(1);
			sales.put(idSale,newSale);
			HashMap<Integer, Integer> aux=newSale.getProducts();
			for(int idProduct:aux.keySet()) {
				dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO sale_product (id_sale, id_product, quantity) VALUES (?, ?, ?)"));
				dbcon.getPreparedstatement().setInt(1,idSale);
				dbcon.getPreparedstatement().setInt(2,idProduct);
				dbcon.getPreparedstatement().setInt(3,aux.get(idProduct));
				dbcon.getPreparedstatement().executeUpdate();
			}
		} catch (SQLException e) {
			dbcon.close();
			e.printStackTrace();
			throw new SaleException(2);
		}
		dbcon.close();
	}

	@Override
	public void update(int id, SaleDTO object) throws SaleException {
		SaleDTO updateSale=object;
		if(!sales.containsKey(id)) {
			throw new SaleException(3);
		}
		if(updateSale.getTotalPay()==0.0) {
			throw new SaleException(1);
		}
	    dbcon.initConnection();
	    try {
	        dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE sale SET sale_date = ?, total_pay = ?, seller=? WHERE id_sale = ?"));
	        dbcon.getPreparedstatement().setDate(1, Date.valueOf(updateSale.getSaleDate()));
	        dbcon.getPreparedstatement().setDouble(2, updateSale.getTotalPay());
	        dbcon.getPreparedstatement().setString(3, updateSale.getSeller());
	        dbcon.getPreparedstatement().setInt(4, id);
	        dbcon.getPreparedstatement().executeUpdate();

	        dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM sale_product WHERE id_sale = ?"));
	        dbcon.getPreparedstatement().setInt(1, id);
	        dbcon.getPreparedstatement().executeUpdate();

	        HashMap<Integer, Integer> products = updateSale.getProducts();
	        for (int idProduct : products.keySet()) {
	            dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO sale_product (id_sale, id_product, quantity) VALUES (?, ?, ?)"));
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


	@Override
	public void delete(int id) throws SaleException{
	    dbcon.initConnection();
	    if(!sales.containsKey(id)) {
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

	
	public HashMap<Integer, SaleDTO> loadSales(){
		HashMap<Integer, SaleDTO> data=new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM sale;"));
			while(dbcon.getResultset().next()) {
				int id=dbcon.getResultset().getInt("id_sale");
				LocalDate saleDate=dbcon.getResultset().getDate("sale_date").toLocalDate();
				double totalPay=dbcon.getResultset().getDouble("total_pay");
				String seller=dbcon.getResultset().getString("seller");
				data.put(id, new SaleDTO(saleDate, seller, totalPay));
			}
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM sale_product;"));
			while(dbcon.getResultset().next()) {
				int idSale=dbcon.getResultset().getInt("id_sale");
				int idProduct=dbcon.getResultset().getInt("id_product");
				int quantity=dbcon.getResultset().getInt("quantity");
				data.get(idSale).getProducts().put(idProduct, quantity);
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}
	
	public String[][] showAll() {
		String info[][]=new String[sales.size()][4];
		int i=0;
		for(int id:sales.keySet()) {
			SaleDTO sale=sales.get(id);
			info[i][0]=Integer.toString(id);
			info[i][1]=sale.getSeller();
			info[i][2]=sale.getSaleDate().toString();
			info[i][3]=Double.toString(sale.getTotalPay());
			i++;
		}
		return info;
	}

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
