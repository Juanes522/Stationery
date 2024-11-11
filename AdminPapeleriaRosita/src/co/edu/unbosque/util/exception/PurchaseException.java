package co.edu.unbosque.util.exception;

/**
 * Clase {@code PurchaseException} que representa excepciones relacionadas con
 * compras.
 * 
 * <p>
 * Esta clase se utiliza para manejar y proporcionar mensajes de error
 * específicos en relación con las compras, como errores en el registro de
 * compras o cuando la compra no contiene productos.
 * </p>
 * 
 * <p>
 * Los códigos de error definidos en esta clase permiten identificar el tipo de
 * error relacionado con la compra, con mensajes descriptivos según el código
 * recibido.
 * </p>
 * 
 * @see Exception
 */
public class PurchaseException extends Exception {

	private int error;

	/**
	 * Constructor de {@code PurchaseException} que recibe un código de error
	 * específico.
	 * 
	 * @param error El código de error que representa el tipo de problema
	 *              relacionado con la compra.
	 */
	public PurchaseException(int error) {
		super();
		this.error = error;
	}

	/**
	 * Método que retorna un mensaje de error según el código proporcionado.
	 * 
	 * <p>
	 * Dependiendo del valor del código de error, este método retorna un mensaje
	 * detallado sobre el tipo de error ocurrido al realizar una compra, como cuando
	 * no se han agregado productos o cuando se produce un error al registrar la
	 * compra.
	 * </p>
	 * 
	 * @return Un mensaje que describe el error asociado al código de error.
	 */
	@Override
	public String getMessage() {
		switch (error) {
		case 1:
			return "Compra invalida. Por favor ponga al menos un producto en la compra.";
		case 2:
			return "Error al registrar la compra. Intentelo de nuevo";
		}
		return "Compra invalida";
	}
}
