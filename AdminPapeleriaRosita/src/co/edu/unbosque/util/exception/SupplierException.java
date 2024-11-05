package co.edu.unbosque.util.exception;

public class SupplierException extends Exception {
	
	private int error;
	
	public SupplierException(int error) {
		super();
		this.error=error;
	}
	
	@Override
	public String getMessage() {
		switch(error) {
		case 1:return "El nombre del proveedor ya está registrado. Por favor, ingrese otro nombre";
		case 2:return "El nombre del proveedor es invalido. El nombre esta vacio o tiene mas de 60 caracteres.";
		case 3:return "La dirección es invalida. La dirección esta vacia o tiene mas de 60 caracteres.";
		case 4:return "El telefono es invalido. El telefono tiene caracteres invalidos.";
		case 5:return "El telefono es invalido. El telefono esta vacio o tiene mas de 20 caracteres.";
		case 6:return "Error al ingresar el proveedor. Intentelo de nuevo.";
		case 7:return "Provedor no encontrado.";
		case 8:return "Error al eliminar proveedor. Intentelo de nuevo.";
		case 9:return "Error al actualizar proveedor.";
		}
		return "Proveedor invalido";
	}

}
