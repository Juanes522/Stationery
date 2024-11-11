package co.edu.unbosque.util.exception;

/**
 * Clase {@code ProductException} que representa excepciones relacionadas con
 * productos.
 * 
 * <p>
 * Esta clase se utiliza para manejar y proporcionar mensajes de error
 * específicos en relación con los productos, como errores de validación de
 * datos o problemas al agregar, actualizar o eliminar productos.
 * </p>
 * 
 * <p>
 * Los códigos de error definidos en esta clase permiten identificar el tipo de
 * error relacionado con el producto, con mensajes descriptivos según el código
 * recibido.
 * </p>
 * 
 * @see Exception
 */
public class ProductException extends Exception {

	private int error;

	/**
	 * Constructor de {@code ProductException} que recibe un código de error
	 * específico.
	 * 
	 * @param error El código de error que representa el tipo de problema
	 *              relacionado con el producto.
	 */
	public ProductException(int error) {
		super();
		this.error = error;
	}

	/**
	 * Método que retorna un mensaje de error según el código proporcionado.
	 * 
	 * <p>
	 * Dependiendo del valor del código de error, este método retorna un mensaje
	 * detallado sobre el tipo de error ocurrido al trabajar con un producto, como
	 * errores en el nombre del proveedor, precio, costo, cantidad, y más.
	 * </p>
	 * 
	 * @return Un mensaje que describe el error asociado al código de error.
	 */
	@Override
	public String getMessage() {
		switch (error) {
		case 1:
			return "El nombre del proveedor es invalido. El nombre esta vacio o tiene mas de 40 caracteres.";
		case 2:
			return "El precio es invalido. Por favor ingrese un numero decimal.";
		case 3:
			return "El costo es invalido. Por favor ingrese un numero decimal.";
		case 4:
			return "La cantidad es invalida. Por favor ingrese un numero entero.";
		case 5:
			return "Error al agregar el producto. Intentelo de nuevo";
		case 6:
			return "Producto no encontrado.";
		case 7:
			return "Error al eliminar el producto. Intentelo de nuevo";
		case 8:
			return "Error al actualizar el producto. Intentelo de nuevo";
		}
		return "Producto invalido";
	}
}
