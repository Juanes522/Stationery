package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.SupplierDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.exception.SupplierException;

public class SupplierDAO implements OperationsDAO<SupplierDTO> {
	
	private DBConnection dbcon;
	private HashMap<Integer,SupplierDTO> suppliers;
	
	public SupplierDAO() {
		dbcon=new DBConnection();
		suppliers=loadSuppliers();
	}

	@Override
	public void create(SupplierDTO object) throws SupplierException{
		SupplierDTO newSupplier=object;
		if(repeatedName(newSupplier.getName())) {
			throw new SupplierException(1);
		}
		else if(newSupplier.getName().trim().length()<=0||newSupplier.getName().trim().length()>60) {
			throw new SupplierException(2);
		}
		else if(newSupplier.getAddress().trim().length()<=0||newSupplier.getAddress().trim().length()>100) {
			throw new SupplierException(3);
		}
		else if(newSupplier.getPhone().matches(".*[^0-9].*")) {
			throw new SupplierException(4);
		}
		else if(newSupplier.getPhone().trim().length()<=0||newSupplier.getPhone().trim().length()>20) {
			throw new SupplierException(5);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO supplier(name_supplier,address,phone) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setString(1, newSupplier.getName());
			dbcon.getPreparedstatement().setString(2, newSupplier.getAddress());
			dbcon.getPreparedstatement().setString(3, newSupplier.getPhone());
			dbcon.getPreparedstatement().executeUpdate();
			ResultSet key=dbcon.getPreparedstatement().getGeneratedKeys();
			if(!key.next()) {
				dbcon.close();
				throw new SupplierException(5);
			}
			suppliers.put(key.getInt(1),newSupplier);
		}catch (SQLException e) {
			dbcon.close();
			throw new SupplierException(5);
		}
		dbcon.close();
	}

	@Override
	public void update(int id, SupplierDTO object) throws SupplierException {
		SupplierDTO updateSupplier=object;
		if(!suppliers.containsKey(id)) {
			throw new SupplierException(7);
		}
		if(repeatedName(updateSupplier.getName(),id)) {
			throw new SupplierException(1);
		}
		else if(updateSupplier.getName().trim().length()<=0||updateSupplier.getName().trim().length()>60) {
			throw new SupplierException(2);
		}
		else if(updateSupplier.getAddress().trim().length()<=0||updateSupplier.getAddress().trim().length()>100) {
			throw new SupplierException(3);
		}
		else if(updateSupplier.getPhone().matches(".*[^0-9].*")) {
			throw new SupplierException(4);
		}
		else if(updateSupplier.getPhone().trim().length()<=0||updateSupplier.getPhone().trim().length()>20) {
			throw new SupplierException(5);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE supplier SET name_supplier=?, address=?, phone=? WHERE id_supplier=?;"));
			dbcon.getPreparedstatement().setString(1, updateSupplier.getName());
			dbcon.getPreparedstatement().setString(2, updateSupplier.getAddress());
			dbcon.getPreparedstatement().setString(3, updateSupplier.getPhone());
			dbcon.getPreparedstatement().setInt(4, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			e.printStackTrace();
			throw new SupplierException(9);
		}
		dbcon.close();
		suppliers.replace(id, updateSupplier);
	}

	@Override
	public void delete(int id) throws SupplierException {
		if(!suppliers.containsKey(id)) {
			throw new SupplierException(7);
		}
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM supplier WHERE id_supplier=?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new SupplierException(8);
		}
		dbcon.close();
		suppliers.remove(id);
	}
	
	public HashMap<Integer,SupplierDTO> loadSuppliers(){
		HashMap<Integer,SupplierDTO> data=new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM supplier;"));
			while(dbcon.getResultset().next()) {
				int id=dbcon.getResultset().getInt("id_supplier");
				String name=dbcon.getResultset().getString("name_supplier");
				String address=dbcon.getResultset().getString("address");
				String phone=dbcon.getResultset().getString("phone");
				data.put(id,new SupplierDTO(name, address, phone));
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}
	
	public boolean repeatedName(String name) {
		for(SupplierDTO sup:suppliers.values()) {
			if(sup.getName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean repeatedName(String name, int id) {
		for(int idSup:suppliers.keySet()) {
			if(suppliers.get(idSup).getName().toLowerCase().equals(name.toLowerCase())&&idSup!=id) {
				return true;
			}
		}
		return false;
	}
	
	public String[][] showAll() {
		String[][] result=new String[suppliers.size()][4];
		int i=0;
		for(int id:suppliers.keySet()) {
			SupplierDTO sup=suppliers.get(id);
			result[i][0]=Integer.toString(id);
			result[i][1]=sup.getName();
			result[i][2]=sup.getAddress();
			result[i][3]=sup.getPhone();
			i++;
		}
		return result;
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public HashMap<Integer, SupplierDTO> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(HashMap<Integer, SupplierDTO> suppliers) {
		this.suppliers = suppliers;
	}

}
