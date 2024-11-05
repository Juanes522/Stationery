package co.edu.unbosque.util.exception;

public class ProductException extends Exception {
	
	private int error;

	public ProductException(int error) {
		super();
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		switch (error) {
		case 1:return "El nombre del proveedor es invalido. El nombre esta vacio o tiene mas de 40 caracteres.";
		case 2:return "El precio es invalido. Por favor ingrese un numero decimal.";
		case 3:return "El costo es invalido. Por favor ingrese un numero decimal.";
		case 4:return "La cantidad es invalida. Por favor ingrese un numero entero.";
		case 5:return "Error al agregar el producto. Intentelo de nuevo";
		case 6:return "Producto no encontrado.";
		case 7:return "Error al eliminar el producto. Intentelo de nuevo";
		case 8:return "Error al actualizar el producto. Intentelo de nuevo";
		}
		return "Producto invalido";
	}
	
	

}
