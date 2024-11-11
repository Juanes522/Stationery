/**
 * El paquete {@code util.exception} contiene clases y definiciones de
 * excepciones personalizadas utilizadas en la aplicación para manejar errores
 * específicos de manera controlada.
 * <p>
 * Este paquete es fundamental para mejorar la robustez de la aplicación, ya que
 * permite gestionar errores que pueden ocurrir en el flujo de ejecución de
 * forma clara y estructurada. Las excepciones definidas en este paquete son
 * utilizadas para señalar fallos específicos y proporcionar retroalimentación
 * más detallada sobre los problemas que se presentan.
 * </p>
 * <p>
 * Las clases de este paquete incluyen excepciones personalizadas que pueden ser
 * lanzadas y capturadas en diferentes partes de la aplicación, facilitando el
 * manejo de errores y la depuración del sistema.
 * </p>
 * 
 * Ejemplo de uso:
 * 
 * <pre>
 * {@code
 * if (usuario == null) {
 * 	throw new UsuarioNoEncontradoException("El usuario no fue encontrado");
 * }
 * }
 * </pre>
 * 
 * @see co.edu.unbosque.util
 * @see co.edu.unbosque.model
 * @see co.edu.unbosque.controller
 */
package co.edu.unbosque.util.exception;
