package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.SupplierDTO;
import co.edu.unbosque.model.persistence.SupplierDAO;
import co.edu.unbosque.util.exception.SupplierException;
import java.util.HashMap;

/**
 * Clase de prueba {@code SupplierDAOTest} que realiza pruebas unitarias sobre
 * la clase {@link SupplierDAO}. Utiliza el framework JUnit para validar las
 * operaciones CRUD en el sistema de proveedores, como la creación,
 * actualización, eliminación y carga de proveedores.
 * 
 * <p>
 * Las pruebas incluyen casos exitosos y la validación de excepciones
 * relacionadas con proveedores, como la existencia de proveedores con el mismo
 * nombre, la validación de campos de texto (como nombre, dirección y teléfono),
 * y la correcta gestión de errores al intentar modificar o eliminar proveedores
 * inexistentes.
 * </p>
 * 
 * @see SupplierDAO
 */
class SupplierDAOTest {

	private SupplierDAO supplierDAO;

	/**
	 * Configuración previa a cada prueba. Inicializa un {@code SupplierDAO}
	 * simulado para realizar las pruebas.
	 */
	@BeforeEach
	void setUp() {
		supplierDAO = new MockSupplierDAO(); // Usamos un DAO simulado
	}

	/**
	 * Prueba que verifica que al intentar eliminar un proveedor inexistente, se
	 * lance una excepción.
	 * 
	 * <p>
	 * Este test asegura que la eliminación de un proveedor no válido arroje una
	 * excepción con el mensaje adecuado.
	 * </p>
	 */
	@Test
	void testDeleteNonExistent() {
		try {
			supplierDAO.delete(999); // ID no existente
			fail("Se esperaba una excepción por proveedor no encontrado.");
		} catch (SupplierException e) {
			assertEquals("Provedor no encontrado.", e.getMessage());
		}
	}

	/**
	 * Prueba que verifica que se pueda cargar correctamente la lista de
	 * proveedores.
	 * 
	 * <p>
	 * Este test asegura que la carga de proveedores retorne un mapa de proveedores
	 * no nulo y vacío inicialmente.
	 * </p>
	 */
	@Test
	void testLoadSuppliers() {
		HashMap<Integer, SupplierDTO> suppliers = supplierDAO.loadSuppliers();
		assertNotNull(suppliers, "El mapa de proveedores no debería ser nulo.");
		assertTrue(suppliers.isEmpty(), "El mapa de proveedores debería estar vacío al inicio.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un proveedor con
	 * nombre repetido.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * el nombre del proveedor ya está registrado.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase1() {
		SupplierException exception = new SupplierException(1);
		String expectedMessage = "El nombre del proveedor ya está registrado. Por favor, ingrese otro nombre";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 1 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un nombre de
	 * proveedor inválido.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * el nombre del proveedor es inválido.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase2() {
		SupplierException exception = new SupplierException(2);
		String expectedMessage = "El nombre del proveedor es invalido. El nombre esta vacio o tiene mas de 60 caracteres.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 2 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de una dirección de
	 * proveedor inválida.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * la dirección del proveedor es inválida.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase3() {
		SupplierException exception = new SupplierException(3);
		String expectedMessage = "La dirección es invalida. La dirección esta vacia o tiene mas de 60 caracteres.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 3 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un teléfono de
	 * proveedor inválido.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * el teléfono del proveedor contiene caracteres inválidos.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase4() {
		SupplierException exception = new SupplierException(4);
		String expectedMessage = "El telefono es invalido. El telefono tiene caracteres invalidos.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 4 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un teléfono de
	 * proveedor vacío o con más de 20 caracteres.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * el teléfono del proveedor es inválido por longitud.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase5() {
		SupplierException exception = new SupplierException(5);
		String expectedMessage = "El telefono es invalido. El telefono esta vacio o tiene mas de 20 caracteres.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 5 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un error general
	 * al ingresar un proveedor.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con un mensaje genérico en caso
	 * de fallos al ingresar un proveedor.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase6() {
		SupplierException exception = new SupplierException(6);
		String expectedMessage = "Error al ingresar el proveedor. Intentelo de nuevo.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 6 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un proveedor no
	 * encontrado.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * se intenta operar sobre un proveedor que no existe.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase7() {
		SupplierException exception = new SupplierException(7);
		String expectedMessage = "Provedor no encontrado.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 7 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un error al
	 * eliminar un proveedor.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * hay un error en la eliminación de un proveedor.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase8() {
		SupplierException exception = new SupplierException(8);
		String expectedMessage = "Error al eliminar proveedor. Intentelo de nuevo.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 8 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un error al
	 * actualizar un proveedor.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * se produce un error al actualizar los datos de un proveedor.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageCase9() {
		SupplierException exception = new SupplierException(9);
		String expectedMessage = "Error al actualizar proveedor.";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje de error para el código 9 no es el esperado.");
	}

	/**
	 * Prueba que verifica el mensaje de excepción para el caso de un código de
	 * error desconocido.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con un mensaje por defecto
	 * cuando se proporciona un código de error no definido.
	 * </p>
	 */
	@Test
	void testSupplierExceptionMessageDefault() {
		SupplierException exception = new SupplierException(10); // Un código no definido
		String expectedMessage = "Proveedor invalido";
		assertEquals(expectedMessage, exception.getMessage(),
				"El mensaje para un código de error desconocido no es el esperado.");
	}

	/**
	 * Implementación de un DAO simulado para pruebas. Esta clase simula el
	 * comportamiento de un {@link SupplierDAO} real, almacenando los proveedores en
	 * un {@link HashMap}.
	 */
	private static class MockSupplierDAO extends SupplierDAO {
		private HashMap<Integer, SupplierDTO> suppliersDB = new HashMap<>();
		private int idCounter = 1;

		/**
		 * Constructor de {@code MockSupplierDAO}.
		 * 
		 * @param suppliersDB El mapa que simula la base de datos de proveedores.
		 */
		@Override
		public void create(SupplierDTO object) throws SupplierException {
			if (repeatedName(object.getName())) {
				throw new SupplierException(1);
			}
			if (object.getPhone().matches(".*[^0-9].*")) {
				throw new SupplierException(4);
			}
			suppliersDB.put(idCounter++, object);
		}

		@Override
		public void update(int id, SupplierDTO object) throws SupplierException {
			if (!suppliersDB.containsKey(id)) {
				throw new SupplierException(7);
			}
			suppliersDB.put(id, object);
		}

		@Override
		public void delete(int id) throws SupplierException {
			if (!suppliersDB.containsKey(id)) {
				throw new SupplierException(7);
			}
			suppliersDB.remove(id);
		}

		@Override
		public HashMap<Integer, SupplierDTO> loadSuppliers() {
			return suppliersDB;
		}

		@Override
		public String[][] showAll() {
			String[][] result = new String[suppliersDB.size()][4];
			int i = 0;
			for (int id : suppliersDB.keySet()) {
				SupplierDTO sup = suppliersDB.get(id);
				result[i][0] = Integer.toString(id);
				result[i][1] = sup.getName();
				result[i][2] = sup.getAddress();
				result[i][3] = sup.getPhone();
				i++;
			}
			return result;
		}
	}
}
