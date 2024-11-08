package co.edu.unbosque.util.exception;

public class PurchaseException extends Exception{
	
	private int error;

	public PurchaseException(int error) {
		super();
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		switch (error) {
		case 1:return "Compra invalida.Por favor ponga al menos un producto en la compra.";
		case 2:return "Error al registrar la compra. Intentelo de nuevo";
		}
		return "Compra invalida";
	}

}
