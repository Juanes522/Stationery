package co.edu.unbosque.test.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.Controller;

/**
 * Clase de prueba {@code ControllerTest} que realiza pruebas unitarias sobre el
 * funcionamiento de la clase {@link Controller}. Utiliza el framework JUnit
 * para asegurar que los métodos principales del controlador se ejecuten
 * correctamente sin lanzar excepciones.
 * 
 * <p>
 * Los métodos probados incluyen la inicialización del controlador, la ejecución
 * del método {@link Controller#run()}, y la correcta ejecución de varios
 * eventos de acción manejados por el controlador.
 * </p>
 * 
 * @see Controller
 */
public class ControllerTest {

	private Controller controller;

	/**
	 * Configuración previa a cada prueba. Inicializa el objeto {@link Controller}
	 * que se usará en las pruebas.
	 */
	@BeforeEach
	void setUp() {
		// Inicializamos el controlador antes de cada prueba
		controller = new Controller();
	}

	/**
	 * Prueba que verifica que el controlador se inicialice correctamente.
	 * 
	 * <p>
	 * Este test asegura que el objeto {@link Controller} no sea {@code null}
	 * después de ser creado.
	 * </p>
	 */
	@Test
	void testControllerInitialization() {
		// Verificamos que el controlador se inicialice correctamente
		assertNotNull(controller);
	}

	/**
	 * Prueba que verifica que la ejecución del método {@link Controller#run()} no
	 * lance excepciones.
	 * 
	 * <p>
	 * Este test asegura que el método {@code run} del {@link Controller} pueda
	 * ejecutarse sin errores.
	 * </p>
	 */
	@Test
	void testRunMethod() {
		// Verificamos que el método run() se ejecute sin lanzar excepciones
		assertDoesNotThrow(() -> controller.run());
	}

	/**
	 * Prueba que verifica que la acción de "login" (unirse) se maneje
	 * correctamente.
	 * 
	 * <p>
	 * Este test simula un evento de acción "join" y verifica que el controlador
	 * maneje la acción sin excepciones.
	 * </p>
	 */
	@Test
	void testLoginAction() {
		// Simulamos el evento "join" (login) y verificamos que no lance excepciones
		ActionEvent joinEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "join");
		assertDoesNotThrow(() -> controller.actionPerformed(joinEvent));
	}

	/**
	 * Prueba que verifica que la acción de "cancelar recuperación" se maneje
	 * correctamente.
	 * 
	 * <p>
	 * Este test simula un evento de acción "cancelRec" y verifica que el
	 * controlador maneje la acción sin excepciones.
	 * </p>
	 */
	@Test
	void testCancelRecoverAction() {
		// Simulamos el evento "cancelRec" (cancelar recuperación) y verificamos que no
		// lance excepciones
		ActionEvent cancelRecEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cancelRec");
		assertDoesNotThrow(() -> controller.actionPerformed(cancelRecEvent));
	}

	/**
	 * Prueba que verifica que la acción de "cerrar proveedor" se maneje
	 * correctamente.
	 * 
	 * <p>
	 * Este test simula un evento de acción "closeSupplier" y verifica que el
	 * controlador maneje la acción sin excepciones.
	 * </p>
	 */
	@Test
	void testCloseSupplierAction() {
		// Simulamos el evento "closeSupplier" (cerrar panel de proveedor) y verificamos
		// que no lance excepciones
		ActionEvent closeSupplierEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "closeSupplier");
		assertDoesNotThrow(() -> controller.actionPerformed(closeSupplierEvent));
	}
}
