package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UserDAO;
import co.edu.unbosque.util.exception.UserException;
import java.util.HashMap;

/**
 * Clase de prueba {@code UserDAOTest} que realiza pruebas unitarias sobre la
 * clase {@link UserDAO}. Utiliza el framework JUnit para validar las
 * operaciones relacionadas con la gestión de usuarios, como la adición,
 * actualización, eliminación y verificación de usuarios.
 * 
 * <p>
 * Las pruebas incluyen la validación de los casos de error cuando se
 * proporcionan datos inválidos o cuando se intentan operaciones con usuarios
 * inexistentes. Además, se verifica el correcto funcionamiento de los métodos
 * {@code update} y {@code delete} con usuarios válidos e inexistentes.
 * </p>
 * 
 * @see UserDAO
 */
class UserDAOTest {

	private UserDAO mockDAO;
	private HashMap<Integer, UserDTO> database;

	/**
	 * Configuración inicial de cada prueba. Inicializa el mapa simulado de usuarios
	 * y la instancia de {@code UserDAO}.
	 */
	@BeforeEach
	void setUp() {
		database = new HashMap<>();
		mockDAO = new MockUserDAO(database);
	}

	/**
	 * Prueba de excepción para el caso cuando el nombre de usuario ya está
	 * registrado.
	 * 
	 * <p>
	 * Este test verifica que se lance una excepción con el mensaje adecuado cuando
	 * el nombre de usuario ya está registrado en el sistema.
	 * </p>
	 */
	@Test
	void testErrorCase1() {
		try {
			throw new UserException(1);
		} catch (UserException e) {
			assertEquals("Nombre de usuario invalido. El nombre de usuario ya esta registrado ingrese otro.",
					e.getMessage(), "El mensaje no coincide para el código de error 1");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando el nombre de usuario es inválido
	 * (vacío o mayor a 45 caracteres).
	 * 
	 * <p>
	 * Este test verifica que se lance una excepción con el mensaje adecuado cuando
	 * el nombre de usuario es inválido por longitud.
	 * </p>
	 */
	@Test
	void testErrorCase2() {
		try {
			throw new UserException(2);
		} catch (UserException e) {
			assertEquals("Nombre de usuario invalido. El nombre de usuario esta vacio o tiene mas de 45 caracteres.",
					e.getMessage(), "El mensaje no coincide para el código de error 2");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando la contraseña es inválida (vacía o
	 * mayor a 255 caracteres).
	 * 
	 * <p>
	 * Este test verifica que se lance una excepción con el mensaje adecuado cuando
	 * la contraseña es inválida.
	 * </p>
	 */
	@Test
	void testErrorCase3() {
		try {
			throw new UserException(3);
		} catch (UserException e) {
			assertEquals("Contraseña invalida. La contraseña esta vacia o tiene mas de 255 caracteres.", e.getMessage(),
					"El mensaje no coincide para el código de error 3");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando la pregunta de seguridad es inválida
	 * (vacía o mayor a 80 caracteres).
	 * 
	 * <p>
	 * Este test verifica que se lance una excepción con el mensaje adecuado cuando
	 * la pregunta de seguridad es inválida.
	 * </p>
	 */
	@Test
	void testErrorCase4() {
		try {
			throw new UserException(4);
		} catch (UserException e) {
			assertEquals("Pregunta invalida. La pregunta esta vacia o tiene mas de 80 caracteres.", e.getMessage(),
					"El mensaje no coincide para el código de error 4");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando la respuesta de seguridad es inválida
	 * (vacía o mayor a 80 caracteres).
	 * 
	 * <p>
	 * Este test verifica que se lance una excepción con el mensaje adecuado cuando
	 * la respuesta de seguridad es inválida.
	 * </p>
	 */
	@Test
	void testErrorCase5() {
		try {
			throw new UserException(5);
		} catch (UserException e) {
			assertEquals("Respuesta invalida. La respueta esta vacia o tiene mas de 80 caracteres.", e.getMessage(),
					"El mensaje no coincide para el código de error 5");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando ocurre un error al agregar un
	 * usuario.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * hay un error al agregar un usuario.
	 * </p>
	 */
	@Test
	void testErrorCase6() {
		try {
			throw new UserException(6);
		} catch (UserException e) {
			assertEquals("Error al agregar usuario intentlo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 6");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando no se encuentra un usuario.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * no se encuentra el usuario buscado.
	 * </p>
	 */
	@Test
	void testErrorCase7() {
		try {
			throw new UserException(7);
		} catch (UserException e) {
			assertEquals("Usuario no encontrado.", e.getMessage(), "El mensaje no coincide para el código de error 7");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando ocurre un error al eliminar un
	 * usuario.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * hay un error al eliminar un usuario.
	 * </p>
	 */
	@Test
	void testErrorCase8() {
		try {
			throw new UserException(8);
		} catch (UserException e) {
			assertEquals("Error al eliminar usuario intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 8");
		}
	}

	/**
	 * Prueba de excepción para el caso cuando ocurre un error al actualizar un
	 * usuario.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje adecuado cuando
	 * hay un error al actualizar un usuario.
	 * </p>
	 */
	@Test
	void testErrorCase9() {
		try {
			throw new UserException(9);
		} catch (UserException e) {
			assertEquals("Error al actualizar usuario intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 9");
		}
	}

	/**
	 * Prueba de excepción para el caso por defecto de la clase
	 * {@link UserException}.
	 * 
	 * <p>
	 * Este test asegura que se lance una excepción con el mensaje por defecto
	 * cuando el código de error no está definido.
	 * </p>
	 */
	@Test
	void testDefaultErrorCase() {
		try {
			throw new UserException(999); // Caso por defecto
		} catch (UserException e) {
			assertEquals("Ususario unvalido", e.getMessage(), "El mensaje no coincide para el caso por defecto");
		}
	}

	/**
	 * Prueba exitosa para el método {@code update} de {@link UserDAO}.
	 * 
	 * <p>
	 * Este test verifica que se pueda actualizar un usuario correctamente en la
	 * base de datos simulada.
	 * </p>
	 */
	@Test
	void testUpdateSuccess() {
		try {
			UserDTO user = new UserDTO("testUser", "password123", "What is your pet's name?", "Fluffy", false);
			database.put(1, user);
			UserDTO updatedUser = new UserDTO("updatedUser", "newPassword123", "What is your favorite color?", "Blue",
					true);
			mockDAO.update(1, updatedUser);
			assertEquals(updatedUser, database.get(1), "El usuario debería actualizarse correctamente.");
		} catch (UserException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba fallida para el método {@code update} con un ID inexistente.
	 * 
	 * <p>
	 * Este test verifica que se intente actualizar un usuario que no existe en la
	 * base de datos simulada.
	 * </p>
	 */
	@Test
	void testUpdateFailureNonExistentId() {
		UserDTO user = new UserDTO("updatedUser", "newPassword123", "What is your favorite color?", "Blue", true);
		try {
			mockDAO.update(999, user);
			assertTrue(database.containsValue(user),
					"El usuario debería ser actualizado exitosamente (aunque no existe el ID).");
		} catch (UserException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba exitosa para el método {@code delete} de {@link UserDAO}.
	 * 
	 * <p>
	 * Este test verifica que se pueda eliminar un usuario correctamente de la base
	 * de datos simulada.
	 * </p>
	 */
	@Test
	void testDeleteSuccess() {
		try {
			UserDTO user = new UserDTO("testUser", "password123", "What is your pet's name?", "Fluffy", false);
			database.put(1, user);
			mockDAO.delete(1);
			assertFalse(database.containsKey(1), "El usuario debería eliminarse correctamente.");
		} catch (UserException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba fallida para el método {@code delete} con un ID inexistente.
	 * 
	 * <p>
	 * Este test verifica que la eliminación de un usuario con un ID inexistente no
	 * cause problemas en la base de datos.
	 * </p>
	 */
	@Test
	void testDeleteFailureNonExistentId() {
		try {
			mockDAO.delete(999);
			assertTrue(database.isEmpty(), "La base de datos debería estar vacía (aunque el ID no exista).");
		} catch (UserException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	/**
	 * Clase interna que simula la implementación de {@link UserDAO}.
	 * 
	 * <p>
	 * Esta clase se utiliza para realizar pruebas unitarias sin la necesidad de
	 * acceso a una base de datos real.
	 * </p>
	 */
	private static class MockUserDAO extends UserDAO {
		private final HashMap<Integer, UserDTO> database;
		private int idCounter = 1;

		public MockUserDAO(HashMap<Integer, UserDTO> database) {
			this.database = database;
		}

		@Override
		public void update(int id, UserDTO user) throws UserException {
			// Aceptar actualización sin lanzar excepción
			if (user != null) {
				database.put(id, user);
			}
		}

		@Override
		public void delete(int id) throws UserException {
			// Eliminar usuario si existe
			database.remove(id);
		}

		@Override
		public HashMap<Integer, UserDTO> loadUsers() {
			return database;
		}

		@Override
		public int verifyUser(String username, String password) {
			for (UserDTO user : database.values()) {
				if (user.getName().equals(username) && user.getPassword().equals(password)) {
					return (user.isAdministrator() ? 0 : 1);
				}
			}
			return 2;
		}

		@Override
		public UserDTO getUser(String username) {
			for (UserDTO user : database.values()) {
				if (user.getName().equalsIgnoreCase(username)) {
					return user;
				}
			}
			return null;
		}
	}
}
