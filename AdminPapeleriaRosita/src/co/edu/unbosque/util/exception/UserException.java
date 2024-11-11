package co.edu.unbosque.util.exception;

/**
 * Clase {@code UserException} que representa excepciones relacionadas con la
 * gestión de usuarios.
 * 
 * <p>
 * Esta clase se utiliza para manejar y proporcionar mensajes de error
 * específicos relacionados con la creación, modificación o eliminación de
 * usuarios en el sistema. Los errores pueden estar asociados con la validación
 * de datos del usuario, como el nombre de usuario, la contraseña, las preguntas
 * y respuestas de seguridad, así como problemas al agregar, eliminar o
 * actualizar un usuario.
 * </p>
 * 
 * <p>
 * El código de error proporcionado determina qué mensaje de error se devolverá
 * en cada situación.
 * </p>
 * 
 * @see Exception
 */
public class UserException extends Exception {

	public int error;

	/**
	 * Constructor de {@code UserException} que recibe un código de error
	 * específico.
	 * 
	 * @param error El código de error que representa el tipo de problema
	 *              relacionado con el usuario.
	 */
	public UserException(int error) {
		this.error = error;
	}

	/**
	 * Método que retorna un mensaje de error según el código proporcionado.
	 * 
	 * <p>
	 * Dependiendo del código de error, el método retorna un mensaje específico
	 * sobre el tipo de problema ocurrido en el proceso de gestión de usuarios, como
	 * nombre de usuario inválido, contraseña inválida, pregunta o respuesta de
	 * seguridad inválida o errores al agregar, eliminar o actualizar un usuario en
	 * el sistema.
	 * </p>
	 * 
	 * @return Un mensaje que describe el error asociado al código de error.
	 */
	@Override
	public String getMessage() {
		switch (error) {
		case 1:
			return "Nombre de usuario invalido. El nombre de usuario ya esta registrado ingrese otro.";
		case 2:
			return "Nombre de usuario invalido. El nombre de usuario esta vacio o tiene mas de 45 caracteres.";
		case 3:
			return "Contraseña invalida. La contraseña esta vacia o tiene mas de 255 caracteres.";
		case 4:
			return "Pregunta invalida. La pregunta esta vacia o tiene mas de 80 caracteres.";
		case 5:
			return "Respuesta invalida. La respueta esta vacia o tiene mas de 80 caracteres.";
		case 6:
			return "Error al agregar usuario intentlo de nuevo";
		case 7:
			return "Usuario no encontrado.";
		case 8:
			return "Error al eliminar usuario intentelo de nuevo";
		case 9:
			return "Error al actualizar usuario intentelo de nuevo";
		}
		return "Usuario invalido";
	}
}
