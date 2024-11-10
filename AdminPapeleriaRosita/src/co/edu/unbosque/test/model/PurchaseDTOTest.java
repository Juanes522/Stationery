package co.edu.unbosque.test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.PurchaseDTO;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Clase de prueba para la clase PurchaseDTO. Contiene pruebas unitarias para
 * verificar el funcionamiento de cada método de la clase PurchaseDTO,
 * incluyendo casos exitosos y erróneos.
 */
class PurchaseDTOTest {

	private PurchaseDTO purchase;
	private LocalDate date;
	private HashMap<Integer, Integer> products;

	/**
	 * Configuración inicial para cada prueba. Se ejecuta antes de cada prueba
	 * individual, inicializando el objeto purchase con valores específicos.
	 */
	@BeforeEach
	void setUp() {
		date = LocalDate.of(2024, 1, 15);
		products = new HashMap<>();
		products.put(1, 5); // Producto 1, cantidad 5
		products.put(2, 2); // Producto 2, cantidad 2
		purchase = new PurchaseDTO(date, 250.0);
		purchase.setProducts(products);
	}

	/**
	 * Prueba exitosa del método getPurchaseDate. Verifica que la fecha de compra
	 * devuelta sea la esperada.
	 */
	@Test
	void testGetPurchaseDateSuccess() {
		assertEquals(date, purchase.getPurchaseDate(), "La fecha de compra debe ser la configurada inicialmente");
	}

	/**
	 * Prueba fallida del método getPurchaseDate. Verifica que la fecha de compra
	 * devuelta no sea incorrecta.
	 */
	@Test
	void testGetPurchaseDateFailure() {
		LocalDate wrongDate = LocalDate.of(2024, 2, 10);
		assertNotEquals(wrongDate, purchase.getPurchaseDate(), "La fecha de compra no debe ser incorrecta");
	}

	/**
	 * Prueba exitosa del método setPurchaseDate. Verifica que la fecha de compra se
	 * actualice correctamente.
	 */
	@Test
	void testSetPurchaseDateSuccess() {
		LocalDate newDate = LocalDate.of(2024, 3, 20);
		purchase.setPurchaseDate(newDate);
		assertEquals(newDate, purchase.getPurchaseDate(), "La fecha de compra debe ser actualizada correctamente");
	}

	/**
	 * Prueba fallida del método setPurchaseDate. Verifica que la fecha de compra no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetPurchaseDateFailure() {
		LocalDate newDate = LocalDate.of(2024, 3, 20);
		purchase.setPurchaseDate(newDate);
		assertNotEquals(date, purchase.getPurchaseDate(),
				"La fecha de compra no debe ser la original después de actualizar");
	}

	/**
	 * Prueba exitosa del método getProducts. Verifica que el mapa de productos sea
	 * el esperado.
	 */
	@Test
	void testGetProductsSuccess() {
		assertEquals(products, purchase.getProducts(),
				"Los productos deben coincidir con los valores configurados inicialmente");
	}

	/**
	 * Prueba fallida del método getProducts. Verifica que el mapa de productos
	 * devuelto no sea incorrecto.
	 */
	@Test
	void testGetProductsFailure() {
		HashMap<Integer, Integer> wrongProducts = new HashMap<>();
		wrongProducts.put(1, 3);
		assertNotEquals(wrongProducts, purchase.getProducts(),
				"Los productos no deben coincidir con un mapa incorrecto");
	}

	/**
	 * Prueba exitosa del método setProducts. Verifica que el mapa de productos se
	 * actualice correctamente.
	 */
	@Test
	void testSetProductsSuccess() {
		HashMap<Integer, Integer> newProducts = new HashMap<>();
		newProducts.put(3, 7);
		purchase.setProducts(newProducts);
		assertEquals(newProducts, purchase.getProducts(), "Los productos deben actualizarse correctamente");
	}

	/**
	 * Prueba fallida del método setProducts. Verifica que el mapa de productos no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetProductsFailure() {
		HashMap<Integer, Integer> newProducts = new HashMap<>();
		newProducts.put(3, 7);
		purchase.setProducts(newProducts);
		assertNotEquals(products, purchase.getProducts(),
				"Los productos no deben ser los valores originales después de actualizar");
	}

	/**
	 * Prueba exitosa del método getTotalPay. Verifica que el total a pagar devuelto
	 * sea el esperado.
	 */
	@Test
	void testGetTotalPaySuccess() {
		assertEquals(250.0, purchase.getTotalPay(), "El total a pagar debe ser 250.0");
	}

	/**
	 * Prueba fallida del método getTotalPay. Verifica que el total a pagar devuelto
	 * no sea incorrecto.
	 */
	@Test
	void testGetTotalPayFailure() {
		assertNotEquals(300.0, purchase.getTotalPay(), "El total a pagar no debe ser 300.0");
	}

	/**
	 * Prueba exitosa del método setTotalPay. Verifica que el total a pagar se
	 * actualice correctamente.
	 */
	@Test
	void testSetTotalPaySuccess() {
		purchase.setTotalPay(300.0);
		assertEquals(300.0, purchase.getTotalPay(), "El total a pagar debe actualizarse a 300.0");
	}

	/**
	 * Prueba fallida del método setTotalPay. Verifica que el total a pagar no
	 * permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetTotalPayFailure() {
		purchase.setTotalPay(300.0);
		assertNotEquals(250.0, purchase.getTotalPay(), "El total a pagar no debe ser 250.0 después de actualizar");
	}
}
