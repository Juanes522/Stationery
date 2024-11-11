package co.edu.unbosque.util.exception;

public class SaleException extends Exception {

	private int error;

	public SaleException(int error) {
		super();
		this.error = error;
	}

	@Override
	public String getMessage() {
		switch (error) {
		case 1:
			return "Venta invalida.Por favor ponga al menos un producto en la venta.";
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
