package co.edu.unbosque.test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.SupplierDTO;

/**
 * Clase de prueba para SupplierDTO. Incluye pruebas unitarias para verificar
 * cada método de la clase.
 */
class SupplierDTOTest {

	private SupplierDTO supplier;

	/**
	 * Configuración inicial de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		supplier = new SupplierDTO("Papeleria la mayor de san victorino", "Cra. 12a #10-29 sotano, Bogotá",
				"321 4681402");
	}

	/**
	 * Prueba exitosa para getName. Verifica que el nombre devuelto sea el esperado.
	 */
	@Test
	void testGetNameSuccess() {
		assertEquals("Papeleria la mayor de san victorino", supplier.getName(),
				"El nombre debe ser 'Papeleria la mayor de san victorino'");
	}

	/**
	 * Prueba fallida para getName. Verifica que el nombre no sea incorrecto.
	 */
	@Test
	void testGetNameFailure() {
		assertNotEquals("XYZ Supplies", supplier.getName(), "El nombre no debe ser 'XYZ Supplies'");
	}

	/**
	 * Prueba exitosa para setName. Verifica que el nombre se actualice
	 * correctamente.
	 */
	@Test
	void testSetNameSuccess() {
		supplier.setName("XYZ Supplies");
		assertEquals("XYZ Supplies", supplier.getName(), "El nombre debe actualizarse a 'XYZ Supplies'");
	}

	/**
	 * Prueba fallida para setName. Verifica que el nombre original no permanezca
	 * después de actualizar.
	 */
	@Test
	void testSetNameFailure() {
		supplier.setName("XYZ Supplies");
		assertNotEquals("Papeleria la mayor de san victorino", supplier.getName(),
				"El nombre no debe ser el original después de actualizar");
	}

	/**
	 * Prueba exitosa para getAddress. Verifica que la dirección devuelta sea la
	 * esperada.
	 */
	@Test
	void testGetAddressSuccess() {
		assertEquals("Cra. 12a #10-29 sotano, Bogotá", supplier.getAddress(),
				"La dirección debe ser 'Cra. 12a #10-29 sotano, Bogotá'");
	}

	/**
	 * Prueba fallida para getAddress. Verifica que la dirección no sea incorrecta.
	 */
	@Test
	void testGetAddressFailure() {
		assertNotEquals("456 Elm St", supplier.getAddress(), "La dirección no debe ser '456 Elm St'");
	}

	/**
	 * Prueba exitosa para setAddress. Verifica que la dirección se actualice
	 * correctamente.
	 */
	@Test
	void testSetAddressSuccess() {
		supplier.setAddress("456 Elm St");
		assertEquals("456 Elm St", supplier.getAddress(), "La dirección debe actualizarse a '456 Elm St'");
	}

	/**
	 * Prueba fallida para setAddress. Verifica que la dirección original no
	 * permanezca después de actualizar.
	 */
	@Test
	void testSetAddressFailure() {
		supplier.setAddress("456 Elm St");
		assertNotEquals("Cra. 12a #10-29 sotano, Bogotá", supplier.getAddress(),
				"La dirección no debe ser la original después de actualizar");
	}

	/**
	 * Prueba exitosa para getPhone. Verifica que el teléfono devuelto sea el
	 * esperado.
	 */
	@Test
	void testGetPhoneSuccess() {
		assertEquals("321 4681402", supplier.getPhone(), "El teléfono debe ser '321 4681402'");
	}

	/**
	 * Prueba fallida para getPhone. Verifica que el teléfono no sea incorrecto.
	 */
	@Test
	void testGetPhoneFailure() {
		assertNotEquals("098-765-4321", supplier.getPhone(), "El teléfono no debe ser '098-765-4321'");
	}

	/**
	 * Prueba exitosa para setPhone. Verifica que el teléfono se actualice
	 * correctamente.
	 */
	@Test
	void testSetPhoneSuccess() {
		supplier.setPhone("098-765-4321");
		assertEquals("098-765-4321", supplier.getPhone(), "El teléfono debe actualizarse a '098-765-4321'");
	}

	/**
	 * Prueba fallida para setPhone. Verifica que el teléfono original no permanezca
	 * después de actualizar.
	 */
	@Test
	void testSetPhoneFailure() {
		supplier.setPhone("098-765-4321");
		assertNotEquals("321 4681402", supplier.getPhone(),
				"El teléfono no debe ser el original después de actualizar");
	}

	/**
	 * Prueba exitosa para el método toString. Verifica que el método toString
	 * devuelva el formato esperado.
	 */
	@Test
	void testToStringSuccess() {
		String expected = "SupplierDTO [name=Papeleria la mayor de san victorino, address=Cra. 12a #10-29 sotano, Bogotá, phone=321 4681402]";
		assertEquals(expected, supplier.toString(), "El toString debe coincidir con el formato esperado");
	}

	/**
	 * Prueba fallida para el método toString. Verifica que el método toString no
	 * devuelva un formato incorrecto.
	 */
	@Test
	void testToStringFailure() {
		String wrongString = "SupplierDTO [name=XYZ Supplies, address=456 Elm St, phone=098-765-4321]";
		assertNotEquals(wrongString, supplier.toString(), "El toString no debe coincidir con un formato incorrecto");
	}
}
