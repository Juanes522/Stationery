package co.edu.unbosque.util.exception;

/**
 * Clase {@code SupplierException} que representa excepciones relacionadas con
 * proveedores.
 * 
 * <p>
 * Esta clase se utiliza para manejar y proporcionar mensajes de error
 * específicos relacionados con la gestión de proveedores. Los errores pueden
 * estar asociados con la validación de datos del proveedor, como nombre,
 * dirección, teléfono, o problemas al agregar, eliminar o actualizar
 * proveedores en el sistema.
 * </p>
 * 
 * <p>
 * El código de error proporcionado determina qué mensaje de error se devolverá
 * en cada situación.
 * </p>
 * 
 * @see Exception
 */
public class SupplierException extends Exception {

	private int error;

	/**
	 * Constructor de {@code SupplierException} que recibe un código de error
	 * específico.
	 * 
	 * @param error El código de error que representa el tipo de problema
	 *              relacionado con el proveedor.
	 */
	public SupplierException(int error) {
		super();
		this.error = error;
	}

	/**
	 * Método que retorna un mensaje de error según el código proporcionado.
	 * 
	 * <p>
	 * Dependiendo del código de error, el método retorna un mensaje específico
	 * sobre el tipo de problema ocurrido en el proceso de gestión de proveedores,
	 * como nombre inválido, dirección inválida, teléfono inválido o errores al
	 * agregar, eliminar o actualizar un proveedor.
	 * </p>
	 * 
	 * @return Un mensaje que describe el error asociado al código de error.
	 */
	@Override
	public String getMessage() {
		switch (error) {
		case 1:
			return "El nombre del proveedor ya está registrado. Por favor, ingrese otro nombre";
		case 2:
			return "El nombre del proveedor es invalido. El nombre esta vacio o tiene mas de 60 caracteres.";
		case 3:
			return "La dirección es invalida. La dirección esta vacia o tiene mas de 60 caracteres.";
		case 4:
			return "El telefono es invalido. El telefono tiene caracteres invalidos.";
		case 5:
			return "El telefono es invalido. El telefono esta vacio o tiene mas de 20 caracteres.";
		case 6:
			return "Error al ingresar el proveedor. Intentelo de nuevo.";
		case 7:
			return "Proveedor no encontrado.";
		case 8:
			return "Error al eliminar proveedor. Intentelo de nuevo.";
		case 9:
			return "Error al actualizar proveedor.";
		}
		return "Proveedor invalido";
	}
}
