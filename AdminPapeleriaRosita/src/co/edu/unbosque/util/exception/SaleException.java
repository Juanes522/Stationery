package co.edu.unbosque.util.exception;

/**
 * Clase {@code SaleException} que representa excepciones relacionadas con las
 * ventas.
 * 
 * <p>
 * Esta clase maneja y proporciona mensajes de error específicos en relación con
 * las ventas, como cuando no se han agregado productos a la venta o cuando se
 * producen errores al registrar, eliminar o actualizar una venta.
 * </p>
 * 
 * <p>
 * La clase usa códigos de error definidos que permiten identificar el tipo de
 * fallo ocurrido en el proceso de venta, proporcionando mensajes adecuados para
 * cada situación.
 * </p>
 * 
 * @see Exception
 */
public class SaleException extends Exception {

	private int error;

	/**
	 * Constructor de {@code SaleException} que recibe un código de error
	 * específico.
	 * 
	 * @param error El código de error que representa el tipo de problema
	 *              relacionado con la venta.
	 */
	public SaleException(int error) {
		super();
		this.error = error;
	}

	/**
	 * Método que retorna un mensaje de error según el código proporcionado.
	 * 
	 * <p>
	 * Dependiendo del código de error, el método retorna un mensaje específico
	 * sobre el tipo de problema ocurrido en el proceso de venta, como la falta de
	 * productos, problemas con el registro, la eliminación, o la actualización de
	 * la venta, o errores con la fecha o el total de pago.
	 * </p>
	 * 
	 * @return Un mensaje que describe el error asociado al código de error.
	 */
	@Override
	public String getMessage() {
		switch (error) {
		case 1:
			return "Venta invalida. Por favor ponga al menos un producto en la venta.";
		case 2:
			return "Error al registrar la venta. Intentelo de nuevo";
		case 3:
			return "Venta no encontrada";
		case 4:
			return "Error al eliminar venta. Intentelo de nuevo.";
		case 5:
			return "Error al actualizar venta. Intentelo de nuevo.";
		case 6:
			return "Fecha no válida";
		case 7:
			return "Total de pago invalido";
		}
		return "Venta invalida";
	}
}
