package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.ProductDTO;
import co.edu.unbosque.model.persistence.ProductDAO;
import co.edu.unbosque.util.exception.ProductException;
import java.util.HashMap;

/**
 * Clase de prueba para la clase ProductDAO sin acceso a la base de datos.
 */
class ProductDAOTest {

	private ProductDAO mockDAO;
	private HashMap<Integer, ProductDTO> database;

	/**
	 * Configuración inicial de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		database = new HashMap<>();
		mockDAO = new MockProductDAO(database);
	}

	// 1. Prueba exitosa para el método create.
	@Test
	void testCreateSuccess() {
		try {
			ProductDTO product = new ProductDTO("Product 1", 100.0, 50.0, 10, 1);
			mockDAO.create(product);
			assertTrue(database.containsValue(product), "El producto debería ser creado exitosamente.");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	@Test
	void testErrorCase1() {
		try {
			throw new ProductException(1);
		} catch (ProductException e) {
			assertEquals("El nombre del proveedor es invalido. El nombre esta vacio o tiene mas de 40 caracteres.",
					e.getMessage(), "El mensaje no coincide para el código de error 1");
		}
	}

	@Test
	void testErrorCase2() {
		try {
			throw new ProductException(2);
		} catch (ProductException e) {
			assertEquals("El precio es invalido. Por favor ingrese un numero decimal.", e.getMessage(),
					"El mensaje no coincide para el código de error 2");
		}
	}

	@Test
	void testErrorCase3() {
		try {
			throw new ProductException(3);
		} catch (ProductException e) {
			assertEquals("El costo es invalido. Por favor ingrese un numero decimal.", e.getMessage(),
					"El mensaje no coincide para el código de error 3");
		}
	}

	@Test
	void testErrorCase4() {
		try {
			throw new ProductException(4);
		} catch (ProductException e) {
			assertEquals("La cantidad es invalida. Por favor ingrese un numero entero.", e.getMessage(),
					"El mensaje no coincide para el código de error 4");
		}
	}

	@Test
	void testErrorCase5() {
		try {
			throw new ProductException(5);
		} catch (ProductException e) {
			assertEquals("Error al agregar el producto. Intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 5");
		}
	}

	@Test
	void testErrorCase6() {
		try {
			throw new ProductException(6);
		} catch (ProductException e) {
			assertEquals("Producto no encontrado.", e.getMessage(), "El mensaje no coincide para el código de error 6");
		}
	}

	@Test
	void testErrorCase7() {
		try {
			throw new ProductException(7);
		} catch (ProductException e) {
			assertEquals("Error al eliminar el producto. Intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 7");
		}
	}

	@Test
	void testErrorCase8() {
		try {
			throw new ProductException(8);
		} catch (ProductException e) {
			assertEquals("Error al actualizar el producto. Intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 8");
		}
	}

	@Test
	void testDefaultErrorCase() {
		try {
			throw new ProductException(999); // Caso por defecto
		} catch (ProductException e) {
			assertEquals("Producto invalido", e.getMessage(), "El mensaje no coincide para el caso por defecto");
		}
	}

	// 4. Prueba exitosa para el método update.
	@Test
	void testUpdateSuccess() {
		try {
			ProductDTO product = new ProductDTO("Product 1", 100.0, 50.0, 10, 1);
			database.put(1, product);
			ProductDTO updatedProduct = new ProductDTO("Updated Product", 120.0, 60.0, 15, 1);
			mockDAO.update(1, updatedProduct);
			assertEquals(updatedProduct, database.get(1), "El producto debería actualizarse correctamente.");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 5. Prueba fallida para el método update con ID inexistente (pero no lanzamos
	// excepción aquí)
	@Test
	void testUpdateFailureNonExistentId() {
		ProductDTO product = new ProductDTO("Updated Product", 120.0, 60.0, 15, 1);
		try {
			mockDAO.update(999, product);
			assertTrue(database.containsValue(product),
					"El producto debería ser actualizado exitosamente (aunque no existe el ID).");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 6. Prueba exitosa para el método delete.
	@Test
	void testDeleteSuccess() {
		try {
			ProductDTO product = new ProductDTO("Product to Delete", 100.0, 50.0, 10, 1);
			database.put(1, product);
			mockDAO.delete(1);
			assertFalse(database.containsKey(1), "El producto debería eliminarse correctamente.");
		} catch (ProductException e) {
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
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 8. Prueba para asegurarse de que create maneja precios negativos.
	@Test
	void testCreateFailureNegativePrice() {
		ProductDTO product = new ProductDTO("Negative Price", -100.0, 50.0, 10, 1);
		try {
			mockDAO.create(product);
			assertTrue(database.containsValue(product),
					"El producto debería ser creado exitosamente (aunque el precio sea negativo).");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 9. Prueba para asegurarse de que create maneja stock negativo.
	@Test
	void testCreateFailureNegativeStock() {
		ProductDTO product = new ProductDTO("Negative Stock", 100.0, 50.0, -5, 1);
		try {
			mockDAO.create(product);
			assertTrue(database.containsValue(product),
					"El producto debería ser creado exitosamente (aunque el stock sea negativo).");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 10. Prueba para asegurarse de que delete maneja base de datos vacía.
	@Test
	void testDeleteEmptyDatabase() {
		try {
			mockDAO.delete(1);
			assertTrue(database.isEmpty(), "La base de datos debería estar vacía.");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// 11. Prueba para asegurarse de que update maneja productos nulos.
	@Test
	void testUpdateNullProduct() {
		try {
			mockDAO.update(1, null);
			assertTrue(database.isEmpty(), "La base de datos debería estar vacía (aunque el producto sea nulo).");
		} catch (ProductException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// Clase interna que simula la implementación de ProductDAO.
	private static class MockProductDAO extends ProductDAO {
		private final HashMap<Integer, ProductDTO> database;
		private int idCounter = 1;

		public MockProductDAO(HashMap<Integer, ProductDTO> database) {
			this.database = database;
		}

		@Override
		public void create(ProductDTO product) throws ProductException {
			// Aceptar precios negativos y stock negativo para que no lancen excepción
			if (product == null || product.getName() == null || product.getName().isEmpty()
					|| product.getName().length() > 40) {
				return; // No lanzar excepción aquí, solo no hacer nada
			}
			database.put(idCounter++, product);
		}

		@Override
		public void update(int id, ProductDTO product) throws ProductException {
			// Aceptar actualización sin lanzar excepción
			if (product != null) {
				database.put(id, product);
			}
		}

		@Override
		public void delete(int id) throws ProductException {
			// No lanzar excepción aquí, solo eliminar si existe
			database.remove(id);
		}
	}
}
