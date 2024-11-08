package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PurchaseDTO;

public class PurchaseDAO implements OperationsDAO<PurchaseDTO> {
	
	private DBConnection dbcon;
	private HashMap<Integer, PurchaseDTO> purchases;
	
	public PurchaseDAO() {
		dbcon=new DBConnection();
		purchases=new HashMap<>();
	}
	
	@Override
	public void create(PurchaseDTO object) {
		PurchaseDTO newPurchase=object;
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO purchase(purchase_date, total_pay) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setDate(1, Date.valueOf(newPurchase.getPurchaseDate()));
			dbcon.getPreparedstatement().setDouble(2, newPurchase.getTotalPay());
			ResultSet key=dbcon.getPreparedstatement().getGeneratedKeys();
			if(!key.next()) {
				dbcon.close();
			}
			int idPurchase=key.getInt(1);
			purchases.put(idPurchase,newPurchase);
			HashMap<Integer, Integer> aux=newPurchase.getProducts();
			for(int idProduct:aux.keySet()) {
				dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO purchase_product (id_purchase, id_product, quantity) VALUES (?, ?, ?)"));
				dbcon.getPreparedstatement().setInt(1,idPurchase);
				dbcon.getPreparedstatement().setInt(2,idProduct);
				dbcon.getPreparedstatement().setInt(3,aux.get(idProduct));
			}
		} catch (SQLException e) {
			dbcon.close();
		}
		dbcon.close();
	}

	@Override
	public void update(int id, PurchaseDTO object) {
		PurchaseDTO updatePurchase=object;
		if(!purchases.containsKey(id)) {
			
		}
	    dbcon.initConnection();
	    try {
	        dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE purchase SET purchase_date = ?, total_pay = ? WHERE id_purchase = ?"));
	        dbcon.getPreparedstatement().setDate(1, Date.valueOf(updatePurchase.getPurchaseDate()));
	        dbcon.getPreparedstatement().setDouble(2, updatePurchase.getTotalPay());
	        dbcon.getPreparedstatement().setInt(3, id);
	        dbcon.getPreparedstatement().executeUpdate();

	        dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM purchase_product WHERE id_purchase = ?"));
	        dbcon.getPreparedstatement().setInt(1, id);
	        dbcon.getPreparedstatement().executeUpdate();

	        HashMap<Integer, Integer> products = updatePurchase.getProducts();
	        for (int idProduct : products.keySet()) {
	            dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO purchase_product (id_purchase, id_product, quantity) VALUES (?, ?, ?)"));
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


	@Override
	public void delete(int id) {
	    dbcon.initConnection();
	    if(!purchases.containsKey(id)) {
		}
	    try {
	        dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM purchase WHERE id_purchase = ?"));
	        dbcon.getPreparedstatement().setInt(1, id);
	        dbcon.getPreparedstatement().executeUpdate();
	    } catch (SQLException e) {
	        dbcon.close();
	    }
	    dbcon.close();
	    purchases.remove(id);
	}

	
	public HashMap<Integer, PurchaseDTO> loadPurchases(){
		HashMap<Integer, PurchaseDTO> data=new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM purchase;"));
			while(dbcon.getResultset().next()) {
				int id=dbcon.getResultset().getInt("id_purchase");
				LocalDate purchaseDate=dbcon.getResultset().getDate("purchase_date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				double totalPay=dbcon.getResultset().getDouble("total_pay");
				data.put(id, new PurchaseDTO(purchaseDate, totalPay));
			}
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM purchase_product;"));
			while(dbcon.getResultset().next()) {
				int idPurchase=dbcon.getResultset().getInt("id_purchase");
				int idProduct=dbcon.getResultset().getInt("id_product");
				int quantity=dbcon.getResultset().getInt("quantity");
				data.get(idPurchase).getProducts().put(idProduct, quantity);
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}
	
	public String[][] showAll() {
		return null;
	}

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
