package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.SupplierDTO;
import co.edu.unbosque.util.exception.SupplierException;

/**
 * La clase {@code SupplierDAO} proporciona métodos para realizar operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) para los objetos
 * {@code SupplierDTO}. Interactúa con la base de datos para almacenar y
 * recuperar la información de los proveedores. Esta clase es responsable de
 * garantizar la integridad de los datos y la validación de la información de
 * los proveedores.
 * 
 * <p>
 * Utiliza una {@link DBConnection} para establecer conexiones con la base de
 * datos y ejecutar consultas SQL. Los proveedores se almacenan en un
 * {@link HashMap}, donde cada proveedor está identificado por un ID único.
 * </p>
 * 
 * @see DBConnection
 * @see SupplierDTO
 * @see SupplierException
 */
public class SupplierDAO implements OperationsDAO<SupplierDTO> {

	private DBConnection dbcon;
	private HashMap<Integer, SupplierDTO> suppliers;

	/**
	 * Construye un nuevo objeto {@code SupplierDAO}. Inicializa la conexión con la
	 * base de datos y carga los proveedores desde la base de datos en el
	 * {@code HashMap} de proveedores.
	 */
	public SupplierDAO() {
		dbcon = new DBConnection();
		suppliers = loadSuppliers();
	}

	/**
	 * Crea un nuevo proveedor en la base de datos. Valida la entrada antes de
	 * agregarla a la base de datos.
	 * 
	 * @param object el objeto {@link SupplierDTO} que se va a crear.
	 * @throws SupplierException si hay un error con los datos del proveedor o si ya
	 *                           existe un proveedor con el mismo nombre.
	 */
	@Override
	public void create(SupplierDTO object) throws SupplierException {
		SupplierDTO newSupplier = object;

		// Validar los datos del proveedor
		if (repeatedName(newSupplier.getName())) {
			throw new SupplierException(1); // El nombre ya existe
		} else if (newSupplier.getName().trim().length() <= 0 || newSupplier.getName().trim().length() > 60) {
			throw new SupplierException(2); // Longitud de nombre inválida
		} else if (newSupplier.getAddress().trim().length() <= 0 || newSupplier.getAddress().trim().length() > 100) {
			throw new SupplierException(3); // Longitud de dirección inválida
		} else if (newSupplier.getPhone().matches(".*[^0-9].*")) {
			throw new SupplierException(4); // Formato de número de teléfono inválido
		} else if (newSupplier.getPhone().trim().length() <= 0 || newSupplier.getPhone().trim().length() > 20) {
			throw new SupplierException(5); // Longitud de número de teléfono inválida
		}

		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO supplier(name_supplier, address, phone) VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS));
			dbcon.getPreparedstatement().setString(1, newSupplier.getName());
			dbcon.getPreparedstatement().setString(2, newSupplier.getAddress());
			dbcon.getPreparedstatement().setString(3, newSupplier.getPhone());
			dbcon.getPreparedstatement().executeUpdate();

			ResultSet key = dbcon.getPreparedstatement().getGeneratedKeys();
			if (!key.next()) {
				dbcon.close();
				throw new SupplierException(5); // Error generando ID
			}

			suppliers.put(key.getInt(1), newSupplier); // Agregar al mapa local
		} catch (SQLException e) {
			dbcon.close();
			throw new SupplierException(5); // Error en la inserción a la base de datos
		}
		dbcon.close();
	}

	/**
	 * Actualiza un proveedor existente en la base de datos. Valida la entrada antes
	 * de realizar la actualización.
	 * 
	 * @param id     el ID del proveedor a actualizar.
	 * @param object el objeto {@link SupplierDTO} actualizado.
	 * @throws SupplierException si el proveedor no existe, el nombre se repite o
	 *                           los datos del proveedor son inválidos.
	 */
	@Override
	public void update(int id, SupplierDTO object) throws SupplierException {
		SupplierDTO updateSupplier = object;

		if (!suppliers.containsKey(id)) {
			throw new SupplierException(7); // Proveedor no encontrado
		}

		if (repeatedName(updateSupplier.getName(), id)) {
			throw new SupplierException(1); // El nombre ya existe
		} else if (updateSupplier.getName().trim().length() <= 0 || updateSupplier.getName().trim().length() > 60) {
			throw new SupplierException(2); // Longitud de nombre inválida
		} else if (updateSupplier.getAddress().trim().length() <= 0
				|| updateSupplier.getAddress().trim().length() > 100) {
			throw new SupplierException(3); // Longitud de dirección inválida
		} else if (updateSupplier.getPhone().matches(".*[^0-9].*")) {
			throw new SupplierException(4); // Formato de número de teléfono inválido
		} else if (updateSupplier.getPhone().trim().length() <= 0 || updateSupplier.getPhone().trim().length() > 20) {
			throw new SupplierException(5); // Longitud de número de teléfono inválida
		}

		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(dbcon.getConnect().prepareStatement(
					"UPDATE supplier SET name_supplier = ?, address = ?, phone = ? WHERE id_supplier = ?;"));
			dbcon.getPreparedstatement().setString(1, updateSupplier.getName());
			dbcon.getPreparedstatement().setString(2, updateSupplier.getAddress());
			dbcon.getPreparedstatement().setString(3, updateSupplier.getPhone());
			dbcon.getPreparedstatement().setInt(4, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new SupplierException(9); // Error durante la actualización
		}
		dbcon.close();
		suppliers.replace(id, updateSupplier);
	}

	/**
	 * Elimina un proveedor de la base de datos.
	 * 
	 * @param id el ID del proveedor a eliminar.
	 * @throws SupplierException si el proveedor no existe o si ocurre un error
	 *                           durante la operación de eliminación.
	 */
	@Override
	public void delete(int id) throws SupplierException {
		if (!suppliers.containsKey(id)) {
			throw new SupplierException(7); // Proveedor no encontrado
		}

		dbcon.initConnection();
		try {
			dbcon.setPreparedstatement(
					dbcon.getConnect().prepareStatement("DELETE FROM supplier WHERE id_supplier = ?;"));
			dbcon.getPreparedstatement().setInt(1, id);
			dbcon.getPreparedstatement().executeUpdate();
		} catch (SQLException e) {
			dbcon.close();
			throw new SupplierException(8); // Error durante la eliminación
		}
		dbcon.close();
		suppliers.remove(id);
	}

	/**
	 * Carga todos los proveedores desde la base de datos en el mapa
	 * {@code suppliers}.
	 * 
	 * @return un {@link HashMap} con todos los proveedores indexados por su ID.
	 */
	public HashMap<Integer, SupplierDTO> loadSuppliers() {
		HashMap<Integer, SupplierDTO> data = new HashMap<>();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultset(dbcon.getStatement().executeQuery("SELECT * FROM supplier;"));
			while (dbcon.getResultset().next()) {
				int id = dbcon.getResultset().getInt("id_supplier");
				String name = dbcon.getResultset().getString("name_supplier");
				String address = dbcon.getResultset().getString("address");
				String phone = dbcon.getResultset().getString("phone");
				data.put(id, new SupplierDTO(name, address, phone));
			}
		} catch (SQLException e) {
			dbcon.close();
			return new HashMap<>();
		}
		dbcon.close();
		return data;
	}

	/**
	 * Verifica si ya existe un proveedor con el mismo nombre.
	 * 
	 * @param name el nombre del proveedor a verificar.
	 * @return {@code true} si el nombre ya está en uso, de lo contrario
	 *         {@code false}.
	 */
	public boolean repeatedName(String name) {
		for (SupplierDTO sup : suppliers.values()) {
			if (sup.getName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica si ya existe un proveedor con el mismo nombre, excluyendo el ID
	 * especificado.
	 * 
	 * @param name el nombre del proveedor a verificar.
	 * @param id   el ID que debe excluirse de la verificación.
	 * @return {@code true} si el nombre ya está en uso por otro proveedor, de lo
	 *         contrario {@code false}.
	 */
	public boolean repeatedName(String name, int id) {
		for (int idSup : suppliers.keySet()) {
			if (suppliers.get(idSup).getName().toLowerCase().equals(name.toLowerCase()) && idSup != id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Muestra todos los proveedores en una matriz.
	 * 
	 * @return una matriz de {@code String} donde cada fila contiene el ID, nombre,
	 *         dirección y teléfono de un proveedor.
	 */
	public String[][] showAll() {
		String[][] result = new String[suppliers.size()][4];
		int i = 0;
		for (int id : suppliers.keySet()) {
			SupplierDTO sup = suppliers.get(id);
			result[i][0] = Integer.toString(id);
			result[i][1] = sup.getName();
			result[i][2] = sup.getAddress();
			result[i][3] = sup.getPhone();
			i++;
		}
		return result;
	}

	/**
	 * Obtiene la conexión a la base de datos actual.
	 * 
	 * @return el objeto {@link DBConnection} utilizado para las operaciones en la
	 *         base de datos.
	 */
	public DBConnection getDbcon() {
		return dbcon;
	}

	/**
	 * Establece la conexión a la base de datos.
	 * 
	 * @param dbcon el nuevo objeto {@link DBConnection}.
	 */
	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	/**
	 * Obtiene el mapa actual de proveedores.
	 * 
	 * @return un {@link HashMap} de proveedores indexados por su ID.
	 */
	public HashMap<Integer, SupplierDTO> getSuppliers() {
		return suppliers;
	}

	/**
	 * Establece el mapa de proveedores.
	 * 
	 * @param suppliers el nuevo mapa de proveedores.
	 */
	public void setSuppliers(HashMap<Integer, SupplierDTO> suppliers) {
		this.suppliers = suppliers;
	}
}
