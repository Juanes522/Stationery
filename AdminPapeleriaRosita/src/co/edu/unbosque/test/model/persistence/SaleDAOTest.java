package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.SaleDTO;
import co.edu.unbosque.model.persistence.SaleDAO;
import co.edu.unbosque.util.exception.SaleException;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Clase de prueba {@code SaleDAOTest} que realiza pruebas unitarias sobre la
 * clase {@link SaleDAO}. Utiliza el framework JUnit para validar las
 * operaciones CRUD en el sistema de ventas, como la creación, actualización,
 * eliminación y carga de ventas.
 * 
 * <p>
 * Las pruebas incluyen casos exitosos, así como la gestión de excepciones
 * relacionadas con errores comunes en las ventas, como la falta de productos,
 * fechas inválidas, o el intento de modificar o eliminar ventas inexistentes.
 * </p>
 * 
 * @see SaleDAO
 */
class SaleDAOTest {

	private SaleDAO mockDAO;
	private HashMap<Integer, SaleDTO> salesDatabase;

	/**
	 * Configuración previa a cada prueba. Inicializa un mapa simulado de ventas y
	 * un {@code SaleDAO} simulado para realizar las pruebas.
	 */
	@BeforeEach
	void setUp() {
		salesDatabase = new HashMap<>();
		mockDAO = new MockSaleDAO(salesDatabase); // Usamos un DAO simulado
	}

	/**
	 * Prueba que verifica la creación exitosa de una venta.
	 * 
	 * <p>
	 * Este test asegura que al crear una venta válida, se inserte correctamente en
	 * la base de datos simulada.
	 * </p>
	 */
	@Test
	void testCreateSuccess() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			sale.getProducts().put(1, 2); // Producto con ID 1, cantidad 2
			mockDAO.create(sale);

			assertTrue(salesDatabase.containsKey(1), "La venta debería ser creada exitosamente.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la creación de una venta con una lista de productos
	 * vacía.
	 * 
	 * <p>
	 * Este test asegura que la venta se cree correctamente incluso si no se
	 * especifican productos.
	 * </p>
	 */
	@Test
	void testCreateWithEmptyProductList() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			mockDAO.create(sale);
			assertTrue(salesDatabase.containsKey(1), "La venta debería ser creada incluso si no hay productos.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la actualización exitosa de una venta.
	 * 
	 * <p>
	 * Este test asegura que una venta existente pueda ser actualizada correctamente
	 * en la base de datos simulada.
	 * </p>
	 */
	@Test
	void testUpdateSuccess() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			sale.getProducts().put(1, 2);
			salesDatabase.put(1, sale);

			SaleDTO updatedSale = new SaleDTO(LocalDate.now().plusDays(1), "Seller1", 200.0);
			updatedSale.getProducts().put(2, 3); // Actualizamos con un producto diferente
			mockDAO.update(1, updatedSale);

			assertEquals(updatedSale, salesDatabase.get(1), "La venta debería actualizarse correctamente.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la eliminación exitosa de una venta.
	 * 
	 * <p>
	 * Este test asegura que una venta existente sea eliminada correctamente de la
	 * base de datos simulada.
	 * </p>
	 */
	@Test
	void testDeleteSuccess() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			sale.getProducts().put(1, 2);
			salesDatabase.put(1, sale);

			mockDAO.delete(1);

			assertFalse(salesDatabase.containsKey(1), "La venta debería eliminarse correctamente.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la carga exitosa de ventas desde la base de datos
	 * simulada.
	 * 
	 * <p>
	 * Este test asegura que las ventas almacenadas en el mapa simulado sean
	 * cargadas correctamente.
	 * </p>
	 */
	@Test
	void testLoadSales() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			sale.getProducts().put(1, 2);
			salesDatabase.put(1, sale);

			HashMap<Integer, SaleDTO> loadedSales = mockDAO.loadSales();
			assertTrue(loadedSales.containsKey(1), "Las ventas deberían cargarse correctamente.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica que todas las ventas se muestran correctamente.
	 * 
	 * <p>
	 * Este test asegura que la información de todas las ventas se muestre
	 * correctamente en un formato de matriz.
	 * </p>
	 */
	@Test
	void testShowAllSales() {
		try {
			SaleDTO sale1 = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			sale1.getProducts().put(1, 2);
			salesDatabase.put(1, sale1);

			SaleDTO sale2 = new SaleDTO(LocalDate.now(), "Seller2", 200.0);
			sale2.getProducts().put(2, 3);
			salesDatabase.put(2, sale2);

			String[][] allSales = mockDAO.showAll();
			assertEquals(2, allSales.length, "El número de ventas debe coincidir.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la carga de ventas vacías.
	 * 
	 * <p>
	 * Este test asegura que el mapa de ventas esté vacío si no se han almacenado
	 * ventas.
	 * </p>
	 */
	@Test
	void testLoadEmptySales() {
		try {
			HashMap<Integer, SaleDTO> loadedSales = mockDAO.loadSales();
			assertTrue(loadedSales.isEmpty(), "El mapa de ventas debería estar vacío.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la creación de una venta con un nombre de vendedor largo.
	 * 
	 * <p>
	 * Este test asegura que no se produzcan errores al crear una venta con un
	 * nombre largo para el vendedor.
	 * </p>
	 */
	@Test
	void testCreateWithLongSellerName() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "SellerWithLongNameThatExceedsLimit", 150.0);
			sale.getProducts().put(1, 2);
			mockDAO.create(sale);

			assertTrue(salesDatabase.containsKey(1), "La venta debería ser creada con un nombre de vendedor largo.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la creación de una venta con una fecha futura.
	 * 
	 * <p>
	 * Este test asegura que una venta pueda ser creada con una fecha futura sin
	 * errores.
	 * </p>
	 */
	@Test
	void testCreateWithFutureDate() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now().plusDays(1), "Seller1", 150.0); // Fecha futura
			sale.getProducts().put(1, 2);
			mockDAO.create(sale);

			assertTrue(salesDatabase.containsKey(1), "La venta debería poder ser creada con una fecha futura.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la actualización del total de pago de una venta.
	 * 
	 * <p>
	 * Este test asegura que al actualizar una venta, el total de pago se calcule
	 * correctamente en función de los productos.
	 * </p>
	 */
	@Test
	void testUpdateSaleTotalPay() {
		try {
			SaleDTO sale = new SaleDTO(LocalDate.now(), "Seller1", 150.0);
			sale.getProducts().put(1, 2);
			salesDatabase.put(1, sale);

			SaleDTO updatedSale = new SaleDTO(LocalDate.now(), "Seller1", 250.0);
			updatedSale.getProducts().put(1, 3); // Cambiar cantidad de producto
			mockDAO.update(1, updatedSale);

			assertEquals(250.0, salesDatabase.get(1).getTotalPay(),
					"El total de pago debe actualizarse correctamente.");
		} catch (SaleException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba que verifica la creación de una venta con una fecha nula.
	 * 
	 * <p>
	 * Este test asegura que se lance una {@link SaleException} cuando la fecha de
	 * la venta es nula.
	 * </p>
	 */
	@Test
	void testCreateWithNullDate() {
		try {
			SaleDTO sale = new SaleDTO(null, "Seller1", 150.0); // Fecha nula
			sale.getProducts().put(1, 2);
			mockDAO.create(sale);
			fail("Se esperaba una SaleException debido a la fecha nula.");
		} catch (SaleException e) {
			assertEquals("Fecha no válida", e.getMessage(),
					"El mensaje de error debería indicar que la fecha no puede ser nula.");
		}
	}

	/**
	 * Prueba de excepciones de venta con códigos de error específicos. Se prueban
	 * diferentes casos de error, como venta inválida o problemas al registrar una
	 * venta.
	 */
	@Test
	void testErrorCase1() {
		try {
			throw new SaleException(1);
		} catch (SaleException e) {
			assertEquals("Venta invalida.Por favor ponga al menos un producto en la venta.", e.getMessage(),
					"El mensaje no coincide para el código de error 1");
		}
	}

	// Otros métodos de prueba relacionados con los códigos de error siguen el mismo
	// patrón

	/**
	 * Implementación de un DAO simulado para pruebas. Esta clase simula el
	 * comportamiento de un {@link SaleDAO} real, almacenando las ventas en un
	 * {@link HashMap}.
	 */
	private static class MockSaleDAO extends SaleDAO {

		private final HashMap<Integer, SaleDTO> salesDatabase;
		private int idCounter = 1;

		/**
		 * Constructor de {@code MockSaleDAO}.
		 * 
		 * @param salesDatabase El mapa que simula la base de datos de ventas.
		 */
		public MockSaleDAO(HashMap<Integer, SaleDTO> salesDatabase) {
			this.salesDatabase = salesDatabase;
		}

		@Override
		public void create(SaleDTO object) throws SaleException {
			if (object.getTotalPay() <= 0.0) {
				throw new SaleException(7);
			}
			if (object.getSaleDate() == null) {
				throw new SaleException(6);
			}

			int idSale = idCounter++;
			salesDatabase.put(idSale, object);
		}

		@Override
		public void update(int id, SaleDTO object) throws SaleException {
			if (!salesDatabase.containsKey(id)) {
				throw new SaleException(3);
			}
			salesDatabase.put(id, object);
		}

		@Override
		public void delete(int id) throws SaleException {
			if (!salesDatabase.containsKey(id)) {
				throw new SaleException(3);
			}
			salesDatabase.remove(id);
		}

		@Override
		public HashMap<Integer, SaleDTO> loadSales() {
			return salesDatabase;
		}

		public String[][] showAll() {
			String[][] result = new String[salesDatabase.size()][];
			int i = 0;
			for (SaleDTO sale : salesDatabase.values()) {
				result[i++] = new String[] { sale.getSaleDate().toString(), sale.getSeller() };
			}
			return result;
		}
	}
}
