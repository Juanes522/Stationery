package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ProductDTO;
import co.edu.unbosque.model.SupplierDTO;
import co.edu.unbosque.util.exception.ProductException;
import co.edu.unbosque.util.exception.SupplierException;

public class ProductDAO implements OperationsDAO<ProductDTO>{
	
	private DBConnection dbcon;
	private HashMap<Integer,ProductDTO> products;
	
	public ProductDAO() {
		dbcon=new DBConnection();
		products=loadProducts();
	}

	@Override
	public void create(ProductDTO object) throws ProductException {
		ProductDTO newProduct=object;
		if(newProduct.getName().length()<=0||newProduct.getName().length()>40) {
			throw new ProductException(1);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO product(name_product,price,cost,id_supplier, quantity) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setString(1, newProduct.getName());
			dbcon.getPreparedstatement().setDouble(2, newProduct.getPrice());
			dbcon.getPreparedstatement().setDouble(3, newProduct.getCost());
			dbcon.getPreparedstatement().setInt(4, newProduct.getIdSuplierPartner());
			dbcon.getPreparedstatement().setInt(5, newProduct.getQuantity());
			dbcon.getPreparedstatement().executeUpdate();
			ResultSet key=dbcon.getPreparedstatement().getGeneratedKeys();
			if(!key.next()) {
				
				dbcon.close();
				throw new ProductException(5);
			}
			products.put(key.getInt(1),newProduct);
		} catch (SQLException e) {
			dbcon.close();
			e.printStackTrace();
			throw new ProductException(5);
		}
		dbcon.close();
	}

	@Override
	public void update(int id, ProductDTO object) throws ProductException {
		ProductDTO updateProduct=object;
		if(!products.containsKey(id)) {
			throw new ProductException(6);
		}
		if(updateProduct.getName().length()<=0||updateProduct.getName().length()>40) {
			throw new ProductException(1);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE product SET name_product=?, price=?, cost=?, id_supplier=?, quantity=? WHERE id_product=?"));
			dbcon.getPreparedstatement().setString(1, updateProduct.getName());
			dbcon.getPreparedstatement().setDouble(2, updateProduct.getPrice());
			dbcon.getPreparedstatement().setDouble(3, updateProduct.getCost());
			dbcon.getPreparedstatement().setInt(4, updateProduct.getIdSuplierPartner());
			dbcon.getPreparedstatement().setInt(5, updateProduct.getQuantity());
			dbcon.getPreparedstatement().setInt(6, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new ProductException(8);
		}
		dbcon.close();
		products.replace(id, updateProduct);
	}

	@Override
	public void delete(int id) throws ProductException {
		if(!products.containsKey(id)) {
			throw new ProductException(6);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM product WHERE id_product=?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new ProductException(7);
		}
		dbcon.close();
		products.remove(id);
	}
	
	public HashMap<Integer,ProductDTO> loadProducts(){
		HashMap<Integer,ProductDTO> data=new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM product;"));
			while(dbcon.getResultset().next()) {
				int id=dbcon.getResultset().getInt("id_product");
				String name=dbcon.getResultset().getString("name_product");
				double price=dbcon.getResultset().getDouble("price");
				double cost=dbcon.getResultset().getDouble("cost");
				int quantity=dbcon.getResultset().getInt("quantity");
				int idSupplier=dbcon.getResultset().getInt("id_supplier");
				data.put(id,new ProductDTO(name, price, cost, quantity, idSupplier));
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}
	
	public String[][] showAll(HashMap<Integer, SupplierDTO> sup) {
		String[][] result=new String[products.size()][6];
		int i=0;
		for(int id:products.keySet()) {
			ProductDTO pro=products.get(id);
			result[i][0]=Integer.toString(id);
			result[i][1]=pro.getName();
			result[i][2]=Double.toString(pro.getPrice());
			result[i][3]=Double.toString(pro.getCost());
			result[i][4]=Integer.toString(pro.getQuantity());
			result[i][5]=sup.get(pro.getIdSuplierPartner()).getName();
			i++;
		}
		return result;
	}
	
	public Object[][] showForSales() {
		Object[][] info=new Object[products.size()][5];
		int i=0;
		for(int id:products.keySet()) {
			ProductDTO pro=products.get(id);
			info[i][0]=id;
			info[i][1]=pro.getName();
			info[i][2]=pro.getQuantity();
			info[i][3]=0;
			info[i][4]=pro.getPrice();
			i++;
		}
		return info;
	}
	
	public Object[][] showForSales(HashMap<Integer, Integer> productsSale) {
		Object[][] info=new Object[products.size()][5];
		int i=0;
		for(int id:products.keySet()) {
			ProductDTO pro=products.get(id);
			info[i][0]=id;
			info[i][1]=pro.getName();
			info[i][2]=pro.getQuantity();
			info[i][3]=productsSale.getOrDefault(id,0);
			info[i][4]=pro.getPrice();
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

	public HashMap<Integer, ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Integer, ProductDTO> products) {
		this.products = products;
	}

}
