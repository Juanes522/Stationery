package co.edu.unbosque.model;

/**
 * Esta clase representa un objeto DTO (Data Transfer Object) para un usuario.
 * El DTO es utilizado para transferir datos relacionados con un usuario, tales
 * como su nombre, contraseña, pregunta y respuesta de seguridad, y el rol de
 * administrador.
 * 
 * <p>
 * La clase incluye constructores, getters y setters para acceder y modificar
 * los atributos del usuario.
 * </p>
 * 
 * @autor Zenith Tech
 * @version 1.0
 * @desde 2024-11-11
 */
public class UserDTO {

	/** Nombre del usuario */
	private String name;

	/** Contraseña del usuario */
	private String password;

	/** Respuesta de seguridad del usuario */
	private String answer;

	/** Pregunta de seguridad del usuario */
	private String question;

	/** Indicador si el usuario es un administrador */
	private boolean isAdministrator;

	/**
	 * Constructor vacío de la clase UserDTO. Se utiliza para crear un objeto de
	 * usuario sin inicializar los valores.
	 */
	public UserDTO() {
	}

	/**
	 * Constructor de la clase UserDTO que inicializa el nombre, la contraseña, la
	 * pregunta, la respuesta y el rol de administrador del usuario.
	 * 
	 * @param name            Nombre del usuario.
	 * @param password        Contraseña del usuario.
	 * @param question        Pregunta de seguridad del usuario.
	 * @param answer          Respuesta de seguridad del usuario.
	 * @param isAdministrator Indica si el usuario es administrador.
	 */
	public UserDTO(String name, String password, String question, String answer, boolean isAdministrator) {
		super();
		this.name = name;
		this.password = password;
		this.answer = answer;
		this.question = question;
		this.isAdministrator = isAdministrator;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return El nombre del usuario.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param name El nombre que se desea asignar al usuario.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return La contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param password La contraseña que se desea asignar al usuario.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Verifica si el usuario es un administrador.
	 * 
	 * @return Verdadero si el usuario es un administrador, falso en caso contrario.
	 */
	public boolean isAdministrator() {
		return isAdministrator;
	}

	/**
	 * Establece si el usuario es un administrador.
	 * 
	 * @param isAdministrator Verdadero si el usuario debe ser un administrador,
	 *                        falso en caso contrario.
	 */
	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	/**
	 * Obtiene la respuesta de seguridad del usuario.
	 * 
	 * @return La respuesta de seguridad del usuario.
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Establece la respuesta de seguridad del usuario.
	 * 
	 * @param answer La respuesta de seguridad que se desea asignar al usuario.
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Obtiene la pregunta de seguridad del usuario.
	 * 
	 * @return La pregunta de seguridad del usuario.
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Establece la pregunta de seguridad del usuario.
	 * 
	 * @param question La pregunta de seguridad que se desea asignar al usuario.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Representa al usuario como una cadena de texto.
	 * 
	 * @return Una cadena que contiene el nombre, la contraseña, la respuesta, la
	 *         pregunta y el rol de administrador del usuario.
	 */
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", password=" + password + ", answer=" + answer + ", question=" + question
				+ ", isAdministrator=" + isAdministrator + "]";
	}
}
