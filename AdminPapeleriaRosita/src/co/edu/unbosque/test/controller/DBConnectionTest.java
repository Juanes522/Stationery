package co.edu.unbosque.test.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.DBConnection;

/**
 * Clase de prueba {@code DBConnectionTest} que realiza pruebas unitarias sobre
 * la clase {@link DBConnection}. Utiliza el framework JUnit para asegurar que
 * la conexión a la base de datos se inicialice correctamente y sea válida.
 * 
 * <p>
 * Los métodos probados incluyen la correcta inicialización de la conexión a la
 * base de datos y la validación de que la conexión sea operativa.
 * </p>
 * 
 * @see DBConnection
 */
public class DBConnectionTest {

	private DBConnection dbConnection;

	/**
	 * Configuración previa a cada prueba. Inicializa la conexión a la base de datos
	 * antes de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		// Inicializamos la conexión antes de cada prueba
		dbConnection = new DBConnection();
		dbConnection.initConnection();
	}

	/**
	 * Limpieza posterior a cada prueba. Cierra la conexión a la base de datos
	 * después de cada prueba.
	 */
	@AfterEach
	void tearDown() {
		// Cerramos la conexión después de cada prueba
		dbConnection.close();
	}

	/**
	 * Prueba que verifica que la conexión a la base de datos se inicialice
	 * correctamente.
	 * 
	 * <p>
	 * Este test asegura que la conexión a la base de datos no sea {@code null}
	 * después de llamar al método {@link DBConnection#initConnection()}.
	 * </p>
	 */
	@Test
	void testInitConnection() {
		// Verificamos que la conexión no sea nula
		Connection connection = dbConnection.getConnect();
		assertNotNull(connection, "La conexión debería estar establecida");
	}

	/**
	 * Prueba que verifica que la conexión a la base de datos sea válida.
	 * 
	 * <p>
	 * Este test asegura que la conexión establecida sea válida, utilizando el
	 * método {@link Connection#isValid(int)} con un tiempo de espera de 2 segundos.
	 * </p>
	 */
	@Test
	void testConnectionIsValid() {
		// Verificamos si la conexión es válida
		try {
			assertTrue(dbConnection.getConnect().isValid(2), "La conexión debería ser válida");
		} catch (Exception e) {
			fail("Error al verificar si la conexión es válida: " + e.getMessage());
		}
	}
}
