package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.SaleDTO;
import co.edu.unbosque.model.persistence.SaleDAO;
import co.edu.unbosque.util.exception.SaleException;
import java.time.LocalDate;
import java.util.HashMap;

class SaleDAOTest {

	private SaleDAO mockDAO;
	private HashMap<Integer, SaleDTO> salesDatabase;

	@BeforeEach
	void setUp() {
		salesDatabase = new HashMap<>();
		mockDAO = new MockSaleDAO(salesDatabase); // Usamos un DAO simulado
	}

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

	@Test
	void testLoadEmptySales() {
		try {
			HashMap<Integer, SaleDTO> loadedSales = mockDAO.loadSales();
			assertTrue(loadedSales.isEmpty(), "El mapa de ventas debería estar vacío.");
		} catch (Exception e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

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

	@Test
	void testErrorCase1() {
		try {
			throw new SaleException(1);
		} catch (SaleException e) {
			assertEquals("Venta invalida.Por favor ponga al menos un producto en la venta.", e.getMessage(),
					"El mensaje no coincide para el código de error 1");
		}
	}

	@Test
	void testErrorCase2() {
		try {
			throw new SaleException(2);
		} catch (SaleException e) {
			assertEquals("Error al registrar la venta. Intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 2");
		}
	}

	@Test
	void testErrorCase3() {
		try {
			throw new SaleException(3);
		} catch (SaleException e) {
			assertEquals("Venta no encontrada", e.getMessage(), "El mensaje no coincide para el código de error 3");
		}
	}

	@Test
	void testErrorCase4() {
		try {
			throw new SaleException(4);
		} catch (SaleException e) {
			assertEquals("Error al eliminar venta. Intentelo de nuevo.", e.getMessage(),
					"El mensaje no coincide para el código de error 4");
		}
	}

	@Test
	void testErrorCase5() {
		try {
			throw new SaleException(5);
		} catch (SaleException e) {
			assertEquals("Error al actualizar venta. Intentelo de nuevo.", e.getMessage(),
					"El mensaje no coincide para el código de error 5");
		}
	}

	@Test
	void testErrorCase6() {
		try {
			throw new SaleException(6);
		} catch (SaleException e) {
			assertEquals("Fecha no válida", e.getMessage(), "El mensaje no coincide para el código de error 6");
		}
	}

	@Test
	void testErrorCase7() {
		try {
			throw new SaleException(7);
		} catch (SaleException e) {
			assertEquals("Total de pago invalido", e.getMessage(), "El mensaje no coincide para el código de error 7");
		}
	}

	@Test
	void testDefaultErrorCase() {
		try {
			throw new SaleException(999); // Caso por defecto
		} catch (SaleException e) {
			assertEquals("Venta invalida", e.getMessage(), "El mensaje no coincide para el caso por defecto");
		}
	}

	// Implementación de un DAO simulado para pruebas
	private static class MockSaleDAO extends SaleDAO {

		private final HashMap<Integer, SaleDTO> salesDatabase;
		private int idCounter = 1;

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
