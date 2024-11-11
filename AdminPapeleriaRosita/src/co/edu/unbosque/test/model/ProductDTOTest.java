package co.edu.unbosque.test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.ProductDTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase ProductDTO. Esta clase contiene pruebas
 * unitarias que validan el correcto funcionamiento de los métodos y atributos
 * de la clase ProductDTO. Se realizan pruebas de éxito y de fallo para el
 * constructor, los métodos get y set, y el método toString.
 */
class ProductDTOTest {

	private ProductDTO product;

	/**
	 * Configuración inicial para cada prueba. Se ejecuta antes de cada prueba
	 * individual, inicializando el objeto product con valores específicos.
	 */
	@BeforeEach
	void setUp() {
		product = new ProductDTO("Laptop", 1500.0, 1000.0, 10, 1234);
	}

	/**
	 * Prueba exitosa del método getName. Verifica que el nombre devuelto sea el
	 * esperado.
	 */
	@Test
	void testGetNameSuccess() {
		assertEquals("Laptop", product.getName(), "El nombre del producto debe ser 'Laptop'");
	}

	/**
	 * Prueba fallida del método getName. Verifica que el nombre devuelto no sea
	 * incorrecto.
	 */
	@Test
	void testGetNameFailure() {
		assertNotEquals("Tablet", product.getName(), "El nombre del producto no debe ser 'Tablet'");
	}

	/**
	 * Prueba exitosa del método setName. Verifica que el nombre se actualice
	 * correctamente.
	 */
	@Test
	void testSetNameSuccess() {
		product.setName("Smartphone");
		assertEquals("Smartphone", product.getName(),
				"El nombre del producto debe ser 'Smartphone' después de actualizar");
	}

	/**
	 * Prueba fallida del método setName. Verifica que el nombre no permanezca sin
	 * cambios tras la actualización.
	 */
	@Test
	void testSetNameFailure() {
		product.setName("Smartphone");
		assertNotEquals("Laptop", product.getName(),
				"El nombre del producto no debe ser 'Laptop' después de actualizar");
	}

	/**
	 * Prueba exitosa del método getPrice. Verifica que el precio devuelto sea el
	 * esperado.
	 */
	@Test
	void testGetPriceSuccess() {
		assertEquals(1500.0, product.getPrice(), "El precio del producto debe ser 1500.0");
	}

	/**
	 * Prueba fallida del método getPrice. Verifica que el precio devuelto no sea
	 * incorrecto.
	 */
	@Test
	void testGetPriceFailure() {
		assertNotEquals(2000.0, product.getPrice(), "El precio del producto no debe ser 2000.0");
	}

	/**
	 * Prueba exitosa del método setPrice. Verifica que el precio se actualice
	 * correctamente.
	 */
	@Test
	void testSetPriceSuccess() {
		product.setPrice(1800.0);
		assertEquals(1800.0, product.getPrice(), "El precio del producto debe ser 1800.0 después de actualizar");
	}

	/**
	 * Prueba fallida del método setPrice. Verifica que el precio no permanezca sin
	 * cambios tras la actualización.
	 */
	@Test
	void testSetPriceFailure() {
		product.setPrice(1800.0);
		assertNotEquals(1500.0, product.getPrice(), "El precio del producto no debe ser 1500.0 después de actualizar");
	}

	/**
	 * Prueba exitosa del método getCost. Verifica que el costo devuelto sea el
	 * esperado.
	 */
	@Test
	void testGetCostSuccess() {
		assertEquals(1000.0, product.getCost(), "El costo del producto debe ser 1000.0");
	}

	/**
	 * Prueba fallida del método getCost. Verifica que el costo devuelto no sea
	 * incorrecto.
	 */
	@Test
	void testGetCostFailure() {
		assertNotEquals(1200.0, product.getCost(), "El costo del producto no debe ser 1200.0");
	}

	/**
	 * Prueba exitosa del método setCost. Verifica que el costo se actualice
	 * correctamente.
	 */
	@Test
	void testSetCostSuccess() {
		product.setCost(900.0);
		assertEquals(900.0, product.getCost(), "El costo del producto debe ser 900.0 después de actualizar");
	}

	/**
	 * Prueba fallida del método setCost. Verifica que el costo no permanezca sin
	 * cambios tras la actualización.
	 */
	@Test
	void testSetCostFailure() {
		product.setCost(900.0);
		assertNotEquals(1000.0, product.getCost(), "El costo del producto no debe ser 1000.0 después de actualizar");
	}

	/**
	 * Prueba exitosa del método getQuantity. Verifica que la cantidad devuelta sea
	 * la esperada.
	 */
	@Test
	void testGetQuantitySuccess() {
		assertEquals(10, product.getQuantity(), "La cantidad del producto debe ser 10");
	}

	/**
	 * Prueba fallida del método getQuantity. Verifica que la cantidad devuelta no
	 * sea incorrecta.
	 */
	@Test
	void testGetQuantityFailure() {
		assertNotEquals(5, product.getQuantity(), "La cantidad del producto no debe ser 5");
	}

	/**
	 * Prueba exitosa del método setQuantity. Verifica que la cantidad se actualice
	 * correctamente.
	 */
	@Test
	void testSetQuantitySuccess() {
		product.setQuantity(15);
		assertEquals(15, product.getQuantity(), "La cantidad del producto debe ser 15 después de actualizar");
	}

	/**
	 * Prueba fallida del método setQuantity. Verifica que la cantidad no permanezca
	 * sin cambios tras la actualización.
	 */
	@Test
	void testSetQuantityFailure() {
		product.setQuantity(15);
		assertNotEquals(10, product.getQuantity(), "La cantidad del producto no debe ser 10 después de actualizar");
	}

	/**
	 * Prueba exitosa del método getIdSuplierPartner. Verifica que el ID del
	 * proveedor devuelto sea el esperado.
	 */
	@Test
	void testGetIdSuplierPartnerSuccess() {
		assertEquals(1234, product.getIdSuplierPartner(), "El ID del proveedor asociado debe ser 1234");
	}

	/**
	 * Prueba fallida del método getIdSuplierPartner. Verifica que el ID del
	 * proveedor devuelto no sea incorrecto.
	 */
	@Test
	void testGetIdSuplierPartnerFailure() {
		assertNotEquals(5678, product.getIdSuplierPartner(), "El ID del proveedor asociado no debe ser 5678");
	}

	/**
	 * Prueba exitosa del método setIdSuplierPartner. Verifica que el ID del
	 * proveedor se actualice correctamente.
	 */
	@Test
	void testSetIdSuplierPartnerSuccess() {
		product.setIdSuplierPartner(5678);
		assertEquals(5678, product.getIdSuplierPartner(),
				"El ID del proveedor asociado debe ser 5678 después de actualizar");
	}

	/**
	 * Prueba fallida del método setIdSuplierPartner. Verifica que el ID del
	 * proveedor no permanezca sin cambios tras la actualización.
	 */
	@Test
	void testSetIdSuplierPartnerFailure() {
		product.setIdSuplierPartner(5678);
		assertNotEquals(1234, product.getIdSuplierPartner(),
				"El ID del proveedor asociado no debe ser 1234 después de actualizar");
	}

	/**
	 * Prueba fallida del método toString. Verifica que la representación en cadena
	 * del objeto no coincida con una cadena incorrecta.
	 */
	@Test
	void testToStringFailure() {
		String incorrectString = "ProductDTO [name=Tablet, pice=2000.0, cost=1500.0, quantity=5, idSuplierPartner=5678]";
		assertNotEquals(incorrectString, product.toString(),
				"La representación en cadena no debe coincidir con el valor incorrecto");
	}
}
