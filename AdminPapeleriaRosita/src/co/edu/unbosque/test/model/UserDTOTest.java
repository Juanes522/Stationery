package co.edu.unbosque.test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.UserDTO;

/**
 * Clase de prueba para UserDTO. Incluye pruebas unitarias para verificar cada
 * método de la clase.
 */
class UserDTOTest {

	private UserDTO user;

	/**
	 * Configuración inicial de cada prueba.
	 */
	@BeforeEach
	void setUp() {
		user = new UserDTO("Gladys", "UnitTest123.", "¿Cuál es el nombre de su mascota?", "Bigotes", true);
	}

	/**
	 * Prueba exitosa para getName.
	 */
	@Test
	void testGetNameSuccess() {
		assertEquals("Gladys", user.getName(), "El nombre debe ser 'Gladys'");
	}

	/**
	 * Prueba fallida para getName.
	 */
	@Test
	void testGetNameFailure() {
		assertNotEquals("Bob", user.getName(), "El nombre no debe ser 'Bob'");
	}

	/**
	 * Prueba exitosa para setName.
	 */
	@Test
	void testSetNameSuccess() {
		user.setName("Bob");
		assertEquals("Bob", user.getName(), "El nombre debe actualizarse a 'Bob'");
	}

	/**
	 * Prueba fallida para setName.
	 */
	@Test
	void testSetNameFailure() {
		user.setName("Charlie");
		assertNotEquals("Gladys", user.getName(), "El nombre no debe ser el original después de actualizar");
	}

	/**
	 * Prueba exitosa para getPassword.
	 */
	@Test
	void testGetPasswordSuccess() {
		assertEquals("UnitTest123.", user.getPassword(), "La contraseña debe ser 'UnitTest123.'");
	}

	/**
	 * Prueba fallida para getPassword.
	 */
	@Test
	void testGetPasswordFailure() {
		assertNotEquals("wrongPassword", user.getPassword(), "La contraseña no debe ser 'wrongPassword'");
	}

	/**
	 * Prueba exitosa para setPassword.
	 */
	@Test
	void testSetPasswordSuccess() {
		user.setPassword("newPassword123");
		assertEquals("newPassword123", user.getPassword(), "La contraseña debe actualizarse a 'newPassword123'");
	}

	/**
	 * Prueba fallida para setPassword.
	 */
	@Test
	void testSetPasswordFailure() {
		user.setPassword("anotherPassword");
		assertNotEquals("UnitTest123.", user.getPassword(),
				"La contraseña no debe ser la original después de actualizar");
	}

	/**
	 * Prueba exitosa para isAdministrator.
	 */
	@Test
	void testIsAdministratorSuccess() {
		assertTrue(user.isAdministrator(), "El usuario debe ser administrador");
	}

	/**
	 * Prueba fallida para isAdministrator.
	 */
	@Test
	void testIsAdministratorFailure() {
		assertFalse(!user.isAdministrator(), "El usuario no debe ser no-administrador");
	}

	/**
	 * Prueba exitosa para setAdministrator.
	 */
	@Test
	void testSetAdministratorSuccess() {
		user.setAdministrator(false);
		assertFalse(user.isAdministrator(), "El usuario debe establecerse como no-administrador");
	}

	/**
	 * Prueba fallida para setAdministrator.
	 */
	@Test
	void testSetAdministratorFailure() {
		user.setAdministrator(true);
		assertNotEquals(false, user.isAdministrator(), "El usuario no debe establecerse incorrectamente");
	}

	/**
	 * Prueba exitosa para getAnswer.
	 */
	@Test
	void testGetAnswerSuccess() {
		assertEquals("Bigotes", user.getAnswer(), "La respuesta debe ser 'Bigotes'");
	}

	/**
	 * Prueba fallida para getAnswer.
	 */
	@Test
	void testGetAnswerFailure() {
		assertNotEquals("Buddy", user.getAnswer(), "La respuesta no debe ser 'Buddy'");
	}

	/**
	 * Prueba exitosa para setAnswer.
	 */
	@Test
	void testSetAnswerSuccess() {
		user.setAnswer("Buddy");
		assertEquals("Buddy", user.getAnswer(), "La respuesta debe actualizarse a 'Buddy'");
	}

	/**
	 * Prueba fallida para setAnswer.
	 */
	@Test
	void testSetAnswerFailure() {
		user.setAnswer("Max");
		assertNotEquals("Bigotes", user.getAnswer(), "La respuesta no debe ser la original después de actualizar");
	}

	/**
	 * Prueba exitosa para getQuestion.
	 */
	@Test
	void testGetQuestionSuccess() {
		assertEquals("¿Cuál es el nombre de su mascota?", user.getQuestion(),
				"La pregunta debe ser '¿Cuál es el nombre de su mascota?'");
	}

	/**
	 * Prueba fallida para getQuestion.
	 */
	@Test
	void testGetQuestionFailure() {
		assertNotEquals("What is your favorite color?", user.getQuestion(),
				"La pregunta no debe ser 'What is your favorite color?'");
	}

	/**
	 * Prueba exitosa para setQuestion.
	 */
	@Test
	void testSetQuestionSuccess() {
		user.setQuestion("What is your favorite color?");
		assertEquals("What is your favorite color?", user.getQuestion(), "La pregunta debe actualizarse correctamente");
	}

	/**
	 * Prueba fallida para setQuestion.
	 */
	@Test
	void testSetQuestionFailure() {
		user.setQuestion("What was your first pet?");
		assertNotEquals("¿Cuál es el nombre de su mascota?", user.getQuestion(),
				"La pregunta no debe ser la original después de actualizar");
	}

	/**
	 * Prueba exitosa para el método toString.
	 */
	@Test
	void testToStringSuccess() {
		String expected = "UserDTO [name=Gladys, password=UnitTest123., answer=Bigotes, question=¿Cuál es el nombre de su mascota?, isAdministrator=true]";
		assertEquals(expected, user.toString(), "El toString debe coincidir con el formato esperado");
	}

	/**
	 * Prueba fallida para el método toString.
	 */
	@Test
	void testToStringFailure() {
		String wrongString = "UserDTO [name=Bob, password=wrongPassword, answer=Buddy, question=What is your favorite color?, isAdministrator=false]";
		assertNotEquals(wrongString, user.toString(), "El toString no debe coincidir con un formato incorrecto");
	}
}
