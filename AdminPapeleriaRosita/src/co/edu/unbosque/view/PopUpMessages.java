package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopUpMessages {
	
	public PopUpMessages() {}
	
	public static void errorMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void informationMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message, "Save", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int confirmMessage(String mensaje,JFrame vista) {
		return JOptionPane.showConfirmDialog(vista, mensaje);
	}
	
	public static String inputMessage(JFrame view,String message, String content) {
		return JOptionPane.showInputDialog(view, message, content, JOptionPane.PLAIN_MESSAGE);
	}

}
