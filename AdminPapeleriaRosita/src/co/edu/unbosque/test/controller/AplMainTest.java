package co.edu.unbosque.test.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.AplMain;
import co.edu.unbosque.controller.Controller;

/**
 * Clase de prueba {@code AplMainTest} que realiza pruebas unitarias sobre la
 * ejecución de la clase {@link AplMain} y el funcionamiento del
 * {@link Controller}. Utiliza el framework JUnit para asegurar que los métodos
 * principales de estas clases no lancen excepciones durante su ejecución.
 * 
 * <p>
 * Los métodos probados incluyen la ejecución del método
 * {@link AplMain#main(String[])} y el método {@link Controller#run()}.
 * </p>
 * 
 * @see AplMain
 * @see Controller
 */
public class AplMainTest {

	private Controller controller;

	/**
	 * Configuración previa a cada prueba. Inicializa el objeto {@link Controller}
	 * que se usará en las pruebas.
	 */
	@BeforeEach
	void setUp() {
		// Inicializa el controlador antes de cada prueba
		controller = new Controller();
	}

	/**
	 * Prueba que verifica que la ejecución del método
	 * {@link AplMain#main(String[])} no lance excepciones.
	 * 
	 * <p>
	 * Este test asegura que el método {@code main} de {@code AplMain} pueda
	 * ejecutarse sin errores.
	 * </p>
	 */
	@Test
	void testMainExecution() {
		// Comprobamos que ejecutar el método main no lance excepciones
		assertDoesNotThrow(() -> AplMain.main(new String[] {}));
	}

	/**
	 * Prueba que verifica que la ejecución del método {@link Controller#run()} no
	 * lance excepciones.
	 * 
	 * <p>
	 * Este test asegura que el método {@code run} del {@code Controller} se ejecute
	 * sin errores.
	 * </p>
	 */
	@Test
	void testControllerRun() {
		// Verificamos que el método run() del controlador no lance excepciones
		assertDoesNotThrow(() -> controller.run());
	}
}
