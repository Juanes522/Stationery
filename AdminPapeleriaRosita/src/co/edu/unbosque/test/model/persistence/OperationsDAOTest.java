package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.persistence.OperationsDAO;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de prueba para la interfaz OperationsDAO.
 */
class OperationsDAOTest {

	private OperationsDAO<String> mockDAO;
	private Map<Integer, String> database;

	/**
	 * Configuración inicial de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		// Simula un DAO usando un HashMap como base de datos en memoria.
		database = new HashMap<>();
		mockDAO = new MockOperationsDAO(database);
	}

	/**
	 * Prueba exitosa para el método create.
	 */
	@Test
	void testCreateSuccess() {
		try {
			mockDAO.create("New Entry");
			assertTrue(database.containsValue("New Entry"),
					"La entrada debería ser creada exitosamente en la base de datos.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba fallida para el método create.
	 */
	@Test
	void testCreateFailure() {
		try {
			mockDAO.create(null); // Insertar un valor nulo debería lanzar una excepción.
			fail("Se esperaba una excepción al intentar crear un objeto nulo.");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException, "Se debería lanzar una IllegalArgumentException.");
		}
	}

	/**
	 * Prueba exitosa para el método update.
	 */
	@Test
	void testUpdateSuccess() {
		try {
			database.put(1, "Initial Entry");
			mockDAO.update(1, "Updated Entry");
			assertEquals("Updated Entry", database.get(1),
					"El valor debería actualizarse correctamente en la base de datos.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba fallida para el método update.
	 */
	@Test
	void testUpdateFailure() {
		try {
			mockDAO.update(999, "Nonexistent Entry");
			fail("Se esperaba una excepción al intentar actualizar un ID inexistente.");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException, "Se debería lanzar una IllegalArgumentException.");
		}
	}

	/**
	 * Prueba exitosa para el método delete.
	 */
	@Test
	void testDeleteSuccess() {
		try {
			database.put(1, "Entry to Delete");
			mockDAO.delete(1);
			assertFalse(database.containsKey(1), "El registro debería eliminarse de la base de datos.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba fallida para el método delete.
	 */
	@Test
	void testDeleteFailure() {
		try {
			mockDAO.delete(999); // Intentar eliminar un ID inexistente debería lanzar una excepción.
			fail("Se esperaba una excepción al intentar eliminar un ID inexistente.");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException, "Se debería lanzar una IllegalArgumentException.");
		}
	}

	/**
	 * Clase interna que simula la implementación de OperationsDAO.
	 */
	private static class MockOperationsDAO implements OperationsDAO<String> {

		private final Map<Integer, String> database;
		private int idCounter = 1;

		public MockOperationsDAO(Map<Integer, String> database) {
			this.database = database;
		}

		@Override
		public void create(String object) throws Exception {
			if (object == null) {
				throw new IllegalArgumentException("El objeto no puede ser nulo");
			}
			database.put(idCounter++, object);
		}

		@Override
		public void update(int id, String object) throws Exception {
			if (!database.containsKey(id)) {
				throw new IllegalArgumentException("ID no encontrado para actualizar");
			}
			database.put(id, object);
		}

		@Override
		public void delete(int id) throws Exception {
			if (!database.containsKey(id)) {
				throw new IllegalArgumentException("ID no encontrado para eliminar");
			}
			database.remove(id);
		}
	}
}
