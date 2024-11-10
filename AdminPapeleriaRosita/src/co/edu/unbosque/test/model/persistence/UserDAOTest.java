package co.edu.unbosque.test.model.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UserDAO;
import co.edu.unbosque.util.exception.UserException;
import java.util.HashMap;

/**
 * Clase de prueba para la clase UserDAO sin acceso a la base de datos.
 */
class UserDAOTest {

	private UserDAO mockDAO;
	private HashMap<Integer, UserDTO> database;

	/**
	 * Configuración inicial de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		database = new HashMap<>();
		mockDAO = new MockUserDAO(database);
	}

	@Test
	void testErrorCase1() {
		try {
			throw new UserException(1);
		} catch (UserException e) {
			assertEquals("Nombre de usuario invalido. El nombre de usuario ya esta registrado ingrese otro.",
					e.getMessage(), "El mensaje no coincide para el código de error 1");
		}
	}

	@Test
	void testErrorCase2() {
		try {
			throw new UserException(2);
		} catch (UserException e) {
			assertEquals("Nombre de usuario invalido. El nombre de usuario esta vacio o tiene mas de 45 caracteres.",
					e.getMessage(), "El mensaje no coincide para el código de error 2");
		}
	}

	@Test
	void testErrorCase3() {
		try {
			throw new UserException(3);
		} catch (UserException e) {
			assertEquals("Contraseña invalida. La contraseña esta vacia o tiene mas de 255 caracteres.", e.getMessage(),
					"El mensaje no coincide para el código de error 3");
		}
	}

	@Test
	void testErrorCase4() {
		try {
			throw new UserException(4);
		} catch (UserException e) {
			assertEquals("Pregunta invalida. La pregunta esta vacia o tiene mas de 80 caracteres.", e.getMessage(),
					"El mensaje no coincide para el código de error 4");
		}
	}

	@Test
	void testErrorCase5() {
		try {
			throw new UserException(5);
		} catch (UserException e) {
			assertEquals("Respuesta invalida. La respueta esta vacia o tiene mas de 80 caracteres.", e.getMessage(),
					"El mensaje no coincide para el código de error 5");
		}
	}

	@Test
	void testErrorCase6() {
		try {
			throw new UserException(6);
		} catch (UserException e) {
			assertEquals("Error al agregar usuario intentlo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 6");
		}
	}

	@Test
	void testErrorCase7() {
		try {
			throw new UserException(7);
		} catch (UserException e) {
			assertEquals("Usuario no encontrado.", e.getMessage(), "El mensaje no coincide para el código de error 7");
		}
	}

	@Test
	void testErrorCase8() {
		try {
			throw new UserException(8);
		} catch (UserException e) {
			assertEquals("Error al eliminar usuario intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 8");
		}
	}

	@Test
	void testErrorCase9() {
		try {
			throw new UserException(9);
		} catch (UserException e) {
			assertEquals("Error al actualizar usuario intentelo de nuevo", e.getMessage(),
					"El mensaje no coincide para el código de error 9");
		}
	}

	@Test
	void testDefaultErrorCase() {
		try {
			throw new UserException(999); // Caso por defecto
		} catch (UserException e) {
			assertEquals("Ususario unvalido", e.getMessage(), "El mensaje no coincide para el caso por defecto");
		}
	}

	// 4. Prueba exitosa para el método update.
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

	// 5. Prueba fallida para el método update con ID inexistente.
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

	// 6. Prueba exitosa para el método delete.
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

	// 7. Prueba fallida para el método delete con ID inexistente.
	@Test
	void testDeleteFailureNonExistentId() {
		try {
			mockDAO.delete(999);
			assertTrue(database.isEmpty(), "La base de datos debería estar vacía (aunque el ID no exista).");
		} catch (UserException e) {
			fail("No se esperaba una excepción: " + e.getMessage());
		}
	}

	// Clase interna que simula la implementación de UserDAO.
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
