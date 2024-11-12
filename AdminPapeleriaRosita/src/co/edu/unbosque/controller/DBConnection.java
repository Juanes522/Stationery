package co.edu.unbosque.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase proporciona la funcionalidad para establecer una conexión con una
 * base de datos MySQL. Maneja la inicialización de la conexión con la base de
 * datos, el cierre de los recursos, y proporciona acceso a la conexión, las
 * declaraciones y los resultados de las consultas.
 * 
 * <p>
 * Los parámetros de conexión como la dirección IP, el puerto, el nombre de la
 * base de datos, el nombre de usuario y la contraseña están preconfigurados
 * para conectarse a un servidor MySQL local.
 * </p>
 * 
 * <p>
 * La clase gestiona los recursos necesarios para las operaciones SQL,
 * garantizando la correcta gestión de los mismos mediante los métodos de
 * inicialización y cierre.
 * </p>
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class DBConnection {

	/**
	 * Objeto de conexión utilizado para establecer la conexión con la base de datos
	 */
	private Connection connect = null;

	/** Objeto de declaración utilizado para ejecutar consultas SQL */
	private Statement statement = null;

	/**
	 * Objeto de declaración preparada utilizado para ejecutar consultas SQL con
	 * parámetros
	 */
	private PreparedStatement preparedstatement = null;

	/**
	 * Objeto de resultado utilizado para almacenar los resultados de las consultas
	 * SQL
	 */
	private ResultSet resultset = null;

	/** Dirección IP del servidor MySQL */
	private final String IP = "127.0.0.1";

	/** Número de puerto del servidor MySQL */
	private final String PORT = "3306";

	/** Nombre de la base de datos a la que se conectará */
	private final String DATABASE = "rositastationery";

	/** Nombre de usuario para acceder a la base de datos */
	private final String USERNAME = "root";

	/** Contraseña para acceder a la base de datos */
	private final String PASSWORD = "p3r4o";

	/**
	 * Constructor por defecto que inicializa una nueva instancia de la clase
	 * DBConnection. El constructor no realiza ninguna acción directa sobre la
	 * conexión con la base de datos.
	 */
	public DBConnection() {
	}

	/**
	 * Inicializa la conexión a la base de datos MySQL.
	 * <p>
	 * Este método intenta cargar el controlador JDBC de MySQL y luego establece una
	 * conexión con la base de datos utilizando los parámetros de conexión
	 * preconfigurados.
	 * </p>
	 * <p>
	 * En caso de error al cargar el controlador o establecer la conexión, se
	 * captura la excepción y se imprime el seguimiento del error.
	 * </p>
	 */
	public void initConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE, USERNAME,
					PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cierra los recursos de la base de datos para garantizar una correcta gestión
	 * de los mismos.
	 * <p>
	 * Este método cierra el resultset, la declaración y la conexión si no son
	 * nulos. Asegura que los recursos de la base de datos se liberen correctamente
	 * después de su uso.
	 * </p>
	 * <p>
	 * Si ocurre un error al cerrar los recursos, se captura la excepción y se
	 * imprime el seguimiento del error.
	 * </p>
	 */
	public void close() {
		try {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene la conexión actual a la base de datos.
	 * 
	 * @return El objeto de conexión utilizado para interactuar con la base de
	 *         datos.
	 */
	public Connection getConnect() {
		return connect;
	}

	/**
	 * Establece la conexión a la base de datos.
	 * 
	 * @param connect El objeto de conexión que se debe establecer.
	 */
	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	/**
	 * Obtiene el objeto de declaración utilizado para ejecutar consultas SQL.
	 * 
	 * @return El objeto de declaración.
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * Establece el objeto de declaración utilizado para ejecutar consultas SQL.
	 * 
	 * @param statement El objeto de declaración que se debe establecer.
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * Obtiene el objeto de declaración preparada utilizado para ejecutar consultas
	 * SQL parametrizadas.
	 * 
	 * @return El objeto de declaración preparada.
	 */
	public PreparedStatement getPreparedstatement() {
		return preparedstatement;
	}

	/**
	 * Establece el objeto de declaración preparada utilizado para ejecutar
	 * consultas SQL parametrizadas.
	 * 
	 * @param preparedstatement El objeto de declaración preparada que se debe
	 *                          establecer.
	 */
	public void setPreparedstatement(PreparedStatement preparedstatement) {
		this.preparedstatement = preparedstatement;
	}

	/**
	 * Obtiene el objeto de resultado que contiene los resultados de las consultas
	 * SQL.
	 * 
	 * @return El objeto de resultado.
	 */
	public ResultSet getResultset() {
		return resultset;
	}

	/**
	 * Establece el objeto de resultado que contiene los resultados de las consultas
	 * SQL.
	 * 
	 * @param resultset El objeto de resultado que se debe establecer.
	 */
	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	/**
	 * Obtiene la dirección IP del servidor MySQL.
	 * 
	 * @return La dirección IP del servidor MySQL.
	 */
	public String getIP() {
		return IP;
	}

	/**
	 * Obtiene el número de puerto del servidor MySQL.
	 * 
	 * @return El número de puerto del servidor MySQL.
	 */
	public String getPORT() {
		return PORT;
	}

	/**
	 * Obtiene el nombre de la base de datos.
	 * 
	 * @return El nombre de la base de datos.
	 */
	public String getDATABASE() {
		return DATABASE;
	}

	/**
	 * Obtiene el nombre de usuario para acceder a la base de datos.
	 * 
	 * @return El nombre de usuario para la base de datos.
	 */
	public String getUSERNAME() {
		return USERNAME;
	}

	/**
	 * Obtiene la contraseña para acceder a la base de datos.
	 * 
	 * @return La contraseña para la base de datos.
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}

}
