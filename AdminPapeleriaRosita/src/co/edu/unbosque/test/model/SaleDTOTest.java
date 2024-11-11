package co.edu.unbosque.test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.SaleDTO;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Clase de prueba para la clase SaleDTO. Contiene pruebas unitarias para
 * verificar el funcionamiento de cada método de la clase SaleDTO, incluyendo
 * casos exitosos y erróneos.
 */
class SaleDTOTest {

	private SaleDTO sale;
	private LocalDate date;
	private HashMap<Integer, Integer> products;
	private String seller;

	/**
	 * Configuración inicial para cada prueba. Se ejecuta antes de cada prueba
	 * individual, inicializando el objeto sale con valores específicos.
	 */
	@BeforeEach
	void setUp() {
		date = LocalDate.of(2024, 1, 15);
		seller = "Joann Zamudio";
		products = new HashMap<>();
		products.put(1, 3); // Producto 1, cantidad 3
		products.put(2, 4); // Producto 2, cantidad 4
		sale = new SaleDTO(date, products, seller, 500.0);
	}

	/**
	 * Prueba exitosa del método getSaleDate. Verifica que la fecha de venta
	 * devuelta sea la esperada.
	 */
	@Test
	void testGetSaleDateSuccess() {
		assertEquals(date, sale.getSaleDate(), "La fecha de venta debe ser la configurada inicialmente");
	}

	/**
	 * Prueba fallida del método getSaleDate. Verifica que la fecha de venta
	 * devuelta no sea incorrecta.
	 */
	@Test
	void testGetSaleDateFailure() {
		LocalDate wrongDate = LocalDate.of(2024, 2, 10);
		assertNotEquals(wrongDate, sale.getSaleDate(), "La fecha de venta no debe ser incorrecta");
	}

	/**
	 * Prueba exitosa del método setSaleDate. Verifica que la fecha de venta se
	 * actualice correctamente.
	 */
	@Test
	void testSetSaleDateSuccess() {
		LocalDate newDate = LocalDate.of(2024, 3, 20);
		sale.setSaleDate(newDate);
		assertEquals(newDate, sale.getSaleDate(), "La fecha de venta debe actualizarse correctamente");
	}

	/**
	 * Prueba fallida del método setSaleDate. Verifica que la fecha de venta no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetSaleDateFailure() {
		LocalDate newDate = LocalDate.of(2024, 3, 20);
		sale.setSaleDate(newDate);
		assertNotEquals(date, sale.getSaleDate(), "La fecha de venta no debe ser la original después de actualizar");
	}

	/**
	 * Prueba exitosa del método getProducts. Verifica que el mapa de productos sea
	 * el esperado.
	 */
	@Test
	void testGetProductsSuccess() {
		assertEquals(products, sale.getProducts(),
				"Los productos deben coincidir con los valores configurados inicialmente");
	}

	/**
	 * Prueba fallida del método getProducts. Verifica que el mapa de productos
	 * devuelto no sea incorrecto.
	 */
	@Test
	void testGetProductsFailure() {
		HashMap<Integer, Integer> wrongProducts = new HashMap<>();
		wrongProducts.put(1, 1);
		assertNotEquals(wrongProducts, sale.getProducts(), "Los productos no deben coincidir con un mapa incorrecto");
	}

	/**
	 * Prueba exitosa del método setProducts. Verifica que el mapa de productos se
	 * actualice correctamente.
	 */
	@Test
	void testSetProductsSuccess() {
		HashMap<Integer, Integer> newProducts = new HashMap<>();
		newProducts.put(3, 5);
		sale.setProducts(newProducts);
		assertEquals(newProducts, sale.getProducts(), "Los productos deben actualizarse correctamente");
	}

	/**
	 * Prueba fallida del método setProducts. Verifica que el mapa de productos no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetProductsFailure() {
		HashMap<Integer, Integer> newProducts = new HashMap<>();
		newProducts.put(3, 5);
		sale.setProducts(newProducts);
		assertNotEquals(products, sale.getProducts(),
				"Los productos no deben ser los valores originales después de actualizar");
	}

	/**
	 * Prueba exitosa del método getTotalPay. Verifica que el total a pagar devuelto
	 * sea el esperado.
	 */
	@Test
	void testGetTotalPaySuccess() {
		assertEquals(500.0, sale.getTotalPay(), "El total a pagar debe ser 500.0");
	}

	/**
	 * Prueba fallida del método getTotalPay. Verifica que el total a pagar devuelto
	 * no sea incorrecto.
	 */
	@Test
	void testGetTotalPayFailure() {
		assertNotEquals(300.0, sale.getTotalPay(), "El total a pagar no debe ser 300.0");
	}

	/**
	 * Prueba exitosa del método setTotalPay. Verifica que el total a pagar se
	 * actualice correctamente.
	 */
	@Test
	void testSetTotalPaySuccess() {
		sale.setTotalPay(300.0);
		assertEquals(300.0, sale.getTotalPay(), "El total a pagar debe actualizarse a 300.0");
	}

	/**
	 * Prueba fallida del método setTotalPay. Verifica que el total a pagar no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetTotalPayFailure() {
		sale.setTotalPay(300.0);
		assertNotEquals(500.0, sale.getTotalPay(), "El total a pagar no debe ser 500.0 después de actualizar");
	}

	/**
	 * Prueba exitosa del método getSeller. Verifica que el vendedor devuelto sea el
	 * esperado.
	 */
	@Test
	void testGetSellerSuccess() {
		assertEquals(seller, sale.getSeller(), "El vendedor debe coincidir con el configurado inicialmente");
	}

	/**
	 * Prueba fallida del método getSeller. Verifica que el vendedor devuelto no sea
	 * incorrecto.
	 */
	@Test
	void testGetSellerFailure() {
		String wrongSeller = "Javier Meza";
		assertNotEquals(wrongSeller, sale.getSeller(), "El vendedor no debe ser incorrecto");
	}

	/**
	 * Prueba exitosa del método setSeller. Verifica que el nombre del vendedor se
	 * actualice correctamente.
	 */
	@Test
	void testSetSellerSuccess() {
		String newSeller = "Javier Meza";
		sale.setSeller(newSeller);
		assertEquals(newSeller, sale.getSeller(), "El nombre del vendedor debe actualizarse correctamente");
	}

	/**
	 * Prueba fallida del método setSeller. Verifica que el nombre del vendedor no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetSellerFailure() {
		String newSeller = "Javier Meza";
		sale.setSeller(newSeller);
		assertNotEquals(seller, sale.getSeller(),
				"El nombre del vendedor no debe ser el original después de actualizar");
	}
}
