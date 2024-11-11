package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.exception.UserException;

/**
 * La clase {@code UserDAO} proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) para los objetos {@link UserDTO}.
 * Interactúa con la base de datos para almacenar y recuperar la información de
 * los usuarios. Esta clase también valida los datos de los usuarios antes de
 * realizar operaciones en la base de datos.
 * 
 * <p>
 * Utiliza una {@link DBConnection} para gestionar la conexión a la base de
 * datos y ejecutar consultas SQL. Los usuarios se almacenan en un
 * {@link HashMap} indexado por su ID único.
 * </p>
 *
 * @see DBConnection
 * @see UserDTO
 * @see UserException
 */
public class UserDAO implements OperationsDAO<UserDTO> {

	private DBConnection dbcon;
	private HashMap<Integer, UserDTO> users;

	/**
	 * Constructor de la clase {@code UserDAO}. Inicializa la conexión con la base
	 * de datos y carga los usuarios existentes desde la base de datos en el
	 * {@code HashMap}.
	 */
	public UserDAO() {
		dbcon = new DBConnection();
		users = loadUsers();
	}

	/**
	 * Crea un nuevo usuario en la base de datos. Valida los datos del usuario antes
	 * de realizar la inserción en la base de datos.
	 * 
	 * @param object el objeto {@link UserDTO} que representa el nuevo usuario a
	 *               crear.
	 * @throws UserException si los datos del usuario no son válidos o si ocurre un
	 *                       error al insertar el usuario en la base de datos.
	 */
	@Override
	public void create(UserDTO object) throws UserException {
		UserDTO newUser = object;

		// Validación de los datos del nuevo usuario
		if (verifyUserName(newUser.getName())) {
			throw new UserException(1); // Nombre de usuario ya existe
		} else if (newUser.getName().length() <= 0 || newUser.getName().length() > 45) {
			throw new UserException(2); // Longitud de nombre inválida
		} else if (newUser.getPassword().length() <= 0 || newUser.getPassword().length() > 255) {
			throw new UserException(3); // Longitud de contraseña inválida
		} else if (newUser.getQuestion().length() <= 0 || newUser.getQuestion().length() > 80) {
			throw new UserException(4); // Longitud de pregunta inválida
		} else if (newUser.getAnswer().length() <= 0 || newUser.getAnswer().length() > 80) {
			throw new UserException(5); // Longitud de respuesta inválida
		}

		// Inserción del usuario en la base de datos
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO user_stationery (name_user, password_user, question, answer, is_administrator) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setString(1, newUser.getName());
			dbcon.getPreparedstatement().setString(2, newUser.getPassword());
			dbcon.getPreparedstatement().setString(3, newUser.getQuestion());
			dbcon.getPreparedstatement().setString(4, newUser.getAnswer());
			dbcon.getPreparedstatement().setBoolean(5, newUser.isAdministrator());
			dbcon.getPreparedstatement().executeUpdate();

			ResultSet key = dbcon.getPreparedstatement().getGeneratedKeys();
			if (!key.next()) {
				dbcon.close();
				throw new UserException(6); // Error al obtener la clave generada
			}

			users.put(key.getInt(1), newUser); // Agregar el nuevo usuario al mapa local
		} catch (SQLException e) {
			dbcon.close();
			throw new UserException(6); // Error durante la inserción
		}
		dbcon.close();
	}

	/**
	 * Actualiza los datos de un usuario existente en la base de datos. Valida los
	 * datos antes de realizar la actualización.
	 * 
	 * @param id     el ID del usuario a actualizar.
	 * @param object el objeto {@link UserDTO} con los nuevos datos del usuario.
	 * @throws UserException si el usuario no existe, el nombre ya está en uso o si
	 *                       los datos son inválidos.
	 */
	@Override
	public void update(int id, UserDTO object) throws UserException {
		UserDTO updateUser = object;

		if (!users.containsKey(id)) {
			throw new UserException(7); // Usuario no encontrado
		}

		// Validación de los datos del usuario
		if (verifyUserName(id, updateUser.getName())) {
			throw new UserException(1); // Nombre de usuario ya existe
		} else if (updateUser.getName().length() <= 0 || updateUser.getName().length() > 45) {
			throw new UserException(2); // Longitud de nombre inválida
		} else if (updateUser.getPassword().length() <= 0 || updateUser.getPassword().length() > 255) {
			throw new UserException(3); // Longitud de contraseña inválida
		} else if (updateUser.getQuestion().length() <= 0 || updateUser.getQuestion().length() > 80) {
			throw new UserException(4); // Longitud de pregunta inválida
		} else if (updateUser.getAnswer().length() <= 0 || updateUser.getAnswer().length() > 80) {
			throw new UserException(5); // Longitud de respuesta inválida
		}

		// Actualización del usuario en la base de datos
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"UPDATE user_stationery SET name_user = ?, password_user = ?, question = ?, answer = ?, is_administrator = ? WHERE id_user = ?;"));
			dbcon.getPreparedstatement().setString(1, updateUser.getName());
			dbcon.getPreparedstatement().setString(2, updateUser.getPassword());
			dbcon.getPreparedstatement().setString(3, updateUser.getQuestion());
			dbcon.getPreparedstatement().setString(4, updateUser.getAnswer());
			dbcon.getPreparedstatement().setBoolean(5, updateUser.isAdministrator());
			dbcon.getPreparedstatement().setInt(6, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new UserException(9); // Error durante la actualización
		}
		dbcon.close();
		users.replace(id, updateUser);
	}

	/**
	 * Elimina un usuario de la base de datos.
	 * 
	 * @param id el ID del usuario a eliminar.
	 * @throws UserException si el usuario no existe o si ocurre un error durante la
	 *                       eliminación.
	 */
	@Override
	public void delete(int id) throws UserException {
		if (!users.containsKey(id)) {
			throw new UserException(7); // Usuario no encontrado
		}

		// Eliminación del usuario en la base de datos
		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(
					dbcon.getConnect().prepareStatement("DELETE FROM user_stationery WHERE id_user = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new UserException(8); // Error durante la eliminación
		}
		dbcon.close();
		users.remove(id);
	}

	/**
	 * Carga todos los usuarios desde la base de datos y los almacena en un
	 * {@link HashMap}.
	 * 
	 * @return un {@link HashMap} con todos los usuarios indexados por su ID.
	 */
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
				data.put(idUser, new UserDTO(name, password, question, answer, isAdministrator));
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}

	/**
	 * Obtiene el ID del usuario correspondiente al nombre de usuario proporcionado.
	 * 
	 * @param username el nombre de usuario a buscar.
	 * @return el ID del usuario si existe, o -1 si no se encuentra.
	 */
	public int getId(String username) {
		for (int id : users.keySet()) {
			UserDTO us = users.get(id);
			if (us.getName().equals(username)) {
				return id;
			}
		}
		return -1;
	}

	/**
	 * Verifica las credenciales de un usuario (nombre de usuario y contraseña).
	 * 
	 * @param username el nombre de usuario.
	 * @param password la contraseña.
	 * @return 0 si el usuario es administrador, 1 si es vendedor, o 2 si las
	 *         credenciales son incorrectas.
	 */
	public int verifyUser(String username, String password) {
		for (UserDTO user : users.values()) {
			if (user.getName().equals(username) && user.getPassword().equals(password)) {
				return (user.isAdministrator() ? 0 : 1);
			}
		}
		return 2;
	}

	/**
	 * Obtiene un usuario por su nombre de usuario.
	 * 
	 * @param username el nombre de usuario a buscar.
	 * @return el objeto {@link UserDTO} correspondiente al nombre de usuario, o
	 *         {@code null} si no se encuentra.
	 */
	public UserDTO getUser(String username) {
		for (UserDTO user : users.values()) {
			if (user.getName().toLowerCase().equals(username.toLowerCase())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Muestra todos los usuarios en una matriz.
	 * 
	 * @return una matriz de {@code String} donde cada fila contiene el ID, nombre,
	 *         contraseña, pregunta de seguridad, respuesta de seguridad y el rol
	 *         del usuario (Administrador o Vendedor).
	 */
	public String[][] showAll() {
		String[][] result = new String[users.size()][6];
		int i = 0;
		for (int id : users.keySet()) {
			UserDTO user = users.get(id);
			result[i][0] = Integer.toString(id);
			result[i][1] = user.getName();
			result[i][2] = user.getPassword();
			result[i][3] = user.getQuestion();
			result[i][4] = user.getAnswer();
			result[i][5] = (user.isAdministrator() ? "Administrador" : "Vendedor");
			i++;
		}
		return result;
	}

	/**
	 * Verifica si el nombre de usuario ya está en uso por otro usuario.
	 * 
	 * @param username el nombre de usuario a verificar.
	 * @return {@code true} si el nombre de usuario ya existe, {@code false} en caso
	 *         contrario.
	 */
	public boolean verifyUserName(String username) {
		for (UserDTO user : users.values()) {
			if (user.getName().toLowerCase().equals(username.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica si el nombre de usuario ya está en uso por otro usuario, excluyendo
	 * el usuario con el ID proporcionado.
	 * 
	 * @param id       el ID del usuario actual.
	 * @param username el nombre de usuario a verificar.
	 * @return {@code true} si el nombre de usuario ya existe para otro usuario,
	 *         {@code false} en caso contrario.
	 */
	public boolean verifyUserName(int id, String username) {
		for (int idUs : users.keySet()) {
			if (users.get(idUs).getName().toLowerCase().equals(username.toLowerCase()) && id != idUs) {
				return true;
			}
		}
		return false;
	}

	// Métodos getter y setter para las propiedades dbcon y users.

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
