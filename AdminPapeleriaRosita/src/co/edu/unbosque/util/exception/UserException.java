package co.edu.unbosque.util.exception;

public class UserException  extends Exception{
	
	public int error;
	
	public UserException(int error) {
		this.error=error;
	}
	
	
	@Override
	public String getMessage() {
		switch (error) {
		case 1:return "Nombre de usuario invalido. El nombre de usuario ya esta registrado ingrese otro.";
		case 2:return "Nombre de usuario invalido. El nombre de usuario esta vacio o tiene mas de 45 caracteres.";
		case 3:return "Contraseña invalida. La contraseña esta vacia o tiene mas de 255 caracteres.";
		case 4:return "Pregunta invalida. La pregunta esta vacia o tiene mas de 80 caracteres.";
		case 5:return "Respuesta invalida. La respueta esta vacia o tiene mas de 80 caracteres.";
		}
		return "Ususario unvalido";
	}

}
