package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta clase proporciona métodos estáticos para mostrar diferentes tipos de
 * mensajes emergentes (pop-ups) en la interfaz de usuario. Estos mensajes
 * pueden ser de error, información, confirmación o entrada de datos.
 */
public class PopUpMessages {

	/**
	 * Constructor vacío de la clase {@link PopUpMessages}.
	 * 
	 * No realiza ninguna operación, ya que la clase solo tiene métodos estáticos.
	 */
	public PopUpMessages() {
	}

	/**
	 * Muestra un mensaje de error en una ventana emergente.
	 * 
	 * @param view    La ventana en la que se mostrará el mensaje de error.
	 *                {@link JFrame}.
	 * @param message El mensaje de error a mostrar.
	 */
	public static void errorMessage(JFrame view, String message) {
		JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un mensaje informativo en una ventana emergente.
	 * 
	 * @param view    La ventana en la que se mostrará el mensaje de información.
	 *                {@link JFrame}.
	 * @param message El mensaje de información a mostrar.
	 */
	public static void informationMessage(JFrame view, String message) {
		JOptionPane.showMessageDialog(view, message, "Save", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra un mensaje de confirmación con botones de sí/no en una ventana
	 * emergente.
	 * 
	 * @param mensaje El mensaje que se mostrará en el cuadro de confirmación.
	 * @param vista   La ventana en la que se mostrará el cuadro de confirmación.
	 *                {@link JFrame}.
	 * @return Un entero que representa la respuesta seleccionada (Sí/No).
	 *         {@link JOptionPane#YES_OPTION}, {@link JOptionPane#NO_OPTION}.
	 */
	public static int confirmMessage(String mensaje, JFrame vista) {
		return JOptionPane.showConfirmDialog(vista, mensaje);
	}

	/**
	 * Muestra una ventana emergente para la entrada de datos por parte del usuario.
	 * 
	 * @param view    La ventana en la que se mostrará el cuadro de entrada.
	 *                {@link JFrame}.
	 * @param message El mensaje que se mostrará en el cuadro de entrada.
	 * @param content El valor por defecto que se mostrará en el cuadro de entrada.
	 * @return El valor ingresado por el usuario, o null si se cancela.
	 */
	public static String inputMessage(JFrame view, String message, String content) {
		return JOptionPane.showInputDialog(view, message, content, JOptionPane.PLAIN_MESSAGE);
	}

}
