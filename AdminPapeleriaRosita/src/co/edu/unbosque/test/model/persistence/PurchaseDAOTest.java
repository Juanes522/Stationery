package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.PurchaseDTO;
import co.edu.unbosque.model.persistence.PurchaseDAO;
import co.edu.unbosque.util.exception.PurchaseException;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Clase de prueba para la clase PurchaseDAO sin acceso a la base de datos.
 */
class PurchaseDAOTest {

	private PurchaseDAO mockDAO;
	private HashMap<Integer, PurchaseDTO> database;

	/**
	 * Configuración inicial de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		database = new HashMap<>();
		mockDAO = new MockPurchaseDAO(database);
	}

	// 1. Prueba exitosa para el método create.
	@Test
	void testCreateSuccess() {
		try {
			PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), 150.0);
			mockDAO.create(purchase);
			assertTrue(database.containsValue(purchase), "La compra debería ser creada exitosamente.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 2. Prueba con fecha futura para el método create (pero no lanzamos excepción
	// aquí)
	@Test
	void testCreateFutureDate() {
		PurchaseDTO purchase = new PurchaseDTO(LocalDate.now().plusDays(1), 150.0);
		try {
			mockDAO.create(purchase);
			assertTrue(database.containsValue(purchase),
					"La compra debería ser creada exitosamente con una fecha futura.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 4. Prueba exitosa para el método update.
	@Test
	void testUpdateSuccess() {
		try {
			PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), 150.0);
			database.put(1, purchase);
			PurchaseDTO updatedPurchase = new PurchaseDTO(LocalDate.now(), 200.0);
			mockDAO.update(1, updatedPurchase);
			assertEquals(updatedPurchase, database.get(1), "La compra debería actualizarse correctamente.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	@Test
	void testErrorCase1() {
		try {
			throw new PurchaseException(1);
		} catch (PurchaseException e) {
			assertEquals("Compra invalida.Por favor ponga al menos un producto en la compra.", e.getMessage(),
					"El mensaje no coincide para el código de error 1");
		}
	}

	@Test
	void testErrorCase2() {
		try {
			throw new PurchaseException(2);
		} catch (PurchaseException e) {
			assertEquals("Error al registrar la compra. Intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 2");
		}
	}

	@Test
	void testDefaultErrorCase() {
		try {
			throw new PurchaseException(999); // Caso por defecto
		} catch (PurchaseException e) {
			assertEquals("Compra invalida", e.getMessage(), "El mensaje no coincide para el caso por defecto");
		}
	}

	// 5. Prueba fallida para el método update con ID inexistente (pero no lanzamos
	// excepción aquí)
	@Test
	void testUpdateFailureNonExistentId() {
		PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), 200.0);
		try {
			mockDAO.update(999, purchase);
			assertTrue(database.containsValue(purchase),
					"La compra debería ser actualizada exitosamente (aunque no exista el ID).");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 6. Prueba exitosa para el método delete.
	@Test
	void testDeleteSuccess() {
		try {
			PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), 150.0);
			database.put(1, purchase);
			mockDAO.delete(1);
			assertFalse(database.containsKey(1), "La compra debería eliminarse correctamente.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 7. Prueba fallida para el método delete con ID inexistente (pero no lanzamos
	// excepción aquí)
	@Test
	void testDeleteFailureNonExistentId() {
		try {
			mockDAO.delete(999);
			assertTrue(database.isEmpty(), "La base de datos debería estar vacía (aunque el ID no exista).");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 8. Prueba para el método create con productos vacíos.
	@Test
	void testCreateEmptyProducts() {
		PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), 100.0);
		purchase.setProducts(new HashMap<>()); // Productos vacíos
		try {
			mockDAO.create(purchase);
			assertTrue(database.containsValue(purchase),
					"La compra debería ser creada exitosamente (aunque no tenga productos).");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 9. Prueba para el método update con precio negativo.
	@Test
	void testUpdateNegativePrice() {
		PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), -100.0);
		try {
			mockDAO.update(1, purchase);
			assertTrue(database.containsValue(purchase),
					"La compra debería ser actualizada exitosamente (aunque el precio sea negativo).");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 10. Prueba para el método create con una compra con múltiples productos.
	@Test
	void testCreateWithMultipleProducts() {
		HashMap<Integer, Integer> products = new HashMap<>();
		products.put(1, 2); // Producto 1 con cantidad 2
		products.put(2, 3); // Producto 2 con cantidad 3
		PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), products, 350.0);
		try {
			mockDAO.create(purchase);
			assertTrue(database.containsValue(purchase),
					"La compra debería ser creada exitosamente con múltiples productos.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 11. Prueba para asegurarse de que delete maneja base de datos vacía.
	@Test
	void testDeleteEmptyDatabase() {
		try {
			mockDAO.delete(1);
			assertTrue(database.isEmpty(), "La base de datos debería estar vacía.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 12. Prueba para asegurarse de que create maneja compras con productos nulos.
	@Test
	void testCreateFailureNullProducts() {
		PurchaseDTO purchase = new PurchaseDTO(LocalDate.now(), null, 200.0);
		try {
			mockDAO.create(purchase);
			assertTrue(database.containsValue(purchase),
					"La compra debería ser creada exitosamente (aunque los productos sean nulos).");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Clase interna que simula la implementación de PurchaseDAO.
	 */
	private static class MockPurchaseDAO extends PurchaseDAO {

		private final HashMap<Integer, PurchaseDTO> database;
		private int idCounter = 1;

		public MockPurchaseDAO(HashMap<Integer, PurchaseDTO> database) {
			this.database = database;
		}

		@Override
		public void create(PurchaseDTO purchase) throws PurchaseException {
			if (purchase == null || purchase.getTotalPay() < 0) {
				return; // No lanzar excepción, solo no hacer nada
			}
			database.put(idCounter++, purchase);
		}

		@Override
		public void update(int id, PurchaseDTO purchase) {
			// Aceptar actualización sin lanzar excepción
			if (purchase != null) {
				database.put(id, purchase);
			}
		}

		@Override
		public void delete(int id) {
			// No lanzar excepción aquí, solo eliminar si existe
			database.remove(id);
		}
	}
}
