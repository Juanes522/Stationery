package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.exception.UserException;

public class UserDAO implements OperationsDAO<UserDTO> {

    private DBConnection dbcon;
    private HashMap<Integer, UserDTO> users;

    public UserDAO() {
        dbcon = new DBConnection();
        users = loadUsers();
    }

    @Override
    public void create(UserDTO object) throws UserException {
    	UserDTO newUser=object;
    	if(verifyUserName(newUser.getName())) {
    		throw new UserException(1);
    	}
    	else if(newUser.getName().length()<=0||newUser.getName().length()>45) {
    		throw new UserException(2);
    	}
    	else if(newUser.getPassword().length()<=0||newUser.getPassword().length()>255) {
    		throw new UserException(3);
    	}
    	else if(newUser.getQuestion().length()<=0||newUser.getQuestion().length()>80) {
    		throw new UserException(4);
    	}
    	else if(newUser.getAnswer().length()<=0||newUser.getAnswer().length()>80) {
    		throw new UserException(5);
    	}
        dbcon.initConnection();
        try {
            dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("INSERT INTO user_stationery (name_user, password_user, question, answer, is_administrator) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS));
            dbcon.getPreparedstatement().setString(1, newUser.getName());
            dbcon.getPreparedstatement().setString(2, newUser.getPassword());
            dbcon.getPreparedstatement().setString(3, newUser.getQuestion());
            dbcon.getPreparedstatement().setString(4, newUser.getAnswer());
            dbcon.getPreparedstatement().setBoolean(5, newUser.isAdministrator());
            dbcon.getPreparedstatement().executeUpdate();
            ResultSet key = dbcon.getPreparedstatement().getGeneratedKeys();
            if (!key.next()) {
            	dbcon.close();
            	throw new UserException(6);
            }
            users.put(key.getInt(1), newUser);
        } catch (SQLException e) {
        	dbcon.close();
        	throw new UserException(6);
        }
        dbcon.close();
    }

    @Override
    public void update(int id, UserDTO object) throws UserException {
    	UserDTO updateUser=object;
    	if(!users.containsKey(id)) {
    		throw new UserException(7);
    	}
    	if(verifyUserName(id,updateUser.getName())) {
    		throw new UserException(1);
    	}
    	else if(updateUser.getName().length()<=0||updateUser.getName().length()>45) {
    		throw new UserException(2);
    	}
    	else if(updateUser.getPassword().length()<=0||updateUser.getPassword().length()>255) {
    		throw new UserException(3);
    	}
    	else if(updateUser.getQuestion().length()<=0||updateUser.getQuestion().length()>80) {
    		throw new UserException(4);
    	}
    	else if(updateUser.getAnswer().length()<=0||updateUser.getAnswer().length()>80) {
    		throw new UserException(5);
    	}
        dbcon.initConnection();
        try {
            dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("UPDATE user_stationery SET name_user = ?, password_user=?, question=?, answer=?, is_administrator = ? WHERE id_user = ?;"));
            dbcon.getPreparedstatement().setString(1, updateUser.getName());
            dbcon.getPreparedstatement().setString(2, updateUser.getPassword());
            dbcon.getPreparedstatement().setString(3, updateUser.getQuestion());
            dbcon.getPreparedstatement().setString(4, updateUser.getAnswer());
            dbcon.getPreparedstatement().setBoolean(5, updateUser.isAdministrator());
            dbcon.getPreparedstatement().setInt(6, id);
            dbcon.getPreparedstatement().executeUpdate();
        } catch (SQLException e) {
            dbcon.close();
           throw new UserException(9);
        }
        dbcon.close();
        users.replace(id, updateUser);
        
    }

    @Override
    public void delete(int id) throws UserException {
        if (!users.containsKey(id)) {
        	throw new UserException(7);
        }
        dbcon.initConnection();
        try {
            dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement("DELETE FROM user_stationery WHERE id_user = ?;"));
            dbcon.getPreparedstatement().setInt(1, id);
            dbcon.getPreparedstatement().executeUpdate();
        } catch (SQLException e) {
        	dbcon.close();
        	throw new UserException(8);
        	
        }
        dbcon.close();
        users.remove(id);
        
    }

    public HashMap<Integer, UserDTO> loadUsers() {
        HashMap<Integer, UserDTO> data = new HashMap<>();
        dbcon.initConnection();
        try {
            dbcon.setStatement(dbcon.getConnect().createStatement());
            dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM user_stationery;"));
            while (dbcon.getResultset().next()) {
                int idUser = dbcon.getResultset().getInt("id_user");
                String name = dbcon.getResultset().getString("name_user");
                String password = dbcon.getResultset().getString("password_user");
                String question = dbcon.getResultset().getString("question");
                String answer = dbcon.getResultset().getString("answer");
                boolean isAdministrator = dbcon.getResultset().getBoolean("is_administrator");
                data.put(idUser, new UserDTO(name, password,question,answer, isAdministrator));
            }
        } catch (SQLException e) {
        	dbcon.close();
            return new HashMap<>();
        }
        dbcon.close();
        return data;
    }
    
    public int getId(String username) {
    	for(int id:users.keySet()) {
    		UserDTO us=users.get(id);
    		if(us.getName().equals(username)) {
    			return id;
    		}
    	}
    	return -1;
    }
    
    public int verifyUser(String username, String password) {
    	for(UserDTO user:users.values()) {
    		if(user.getName().equals(username)&&user.getPassword().equals(password)) {
    			return (user.isAdministrator()?0:1);
    		}
    	}
    	return 2;
    }
    
    public UserDTO getUser(String username) {
    	for(UserDTO user:users.values()) {
    		if(user.getName().toLowerCase().equals(username.toLowerCase())) {
    			return user;
    		}
    	}
    	return null;
    }

    public String[][] showAll() {
		String[][] result=new String[users.size()][6];
		int i=0;
		for(int id:users.keySet()) {
			UserDTO user=users.get(id);
			result[i][0]=Integer.toString(id);
			result[i][1]=user.getName();
			result[i][2]=user.getPassword();
			result[i][3]=user.getQuestion();
			result[i][4]=user.getAnswer();
			result[i][5]=(user.isAdministrator()?"Administrador":"Vendedor");
			i++;
		}
		return result;
	}
    
    public boolean verifyUserName(String username) {
    	for(UserDTO user:users.values()) {
    		if(user.getName().toLowerCase().equals(username.toLowerCase())) {
    			return true;
    		}
    	}
    	return false;
    }
    public boolean verifyUserName(int id,String username) {
    	for(int idUs:users.keySet()) {
    		if(users.get(idUs).getName().toLowerCase().equals(username.toLowerCase())&&id!=idUs) {
    			return true;
    		}
    	}
    	return false;
    }

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public HashMap<Integer, UserDTO> getUsers() {
		return users;
	}

	public void setUsers(HashMap<Integer, UserDTO> users) {
		this.users = users;
	}
    
}
