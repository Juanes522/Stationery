package co.edu.unbosque.controller;

/**
 * Clase principal del proyecto que contiene el método `main` para iniciar la
 * aplicación.
 */
public class AplMain {

	/**
	 * Método principal que inicia la ejecución del programa.
	 * 
	 * @param args Argumentos de línea de comandos (no se utilizan en esta
	 *             aplicación).
	 */
	public static void main(String[] args) {
		Controller c = new Controller(); // Crea una instancia del controlador
		c.run(); // Ejecuta el método principal del controlador
	}
}
