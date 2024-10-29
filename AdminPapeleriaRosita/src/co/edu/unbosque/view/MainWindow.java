package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	private LoginPanel loginPanel;
	
	public MainWindow() {
		
		setSize(800, 600);
		setTitle("Administrador papeleria de Rosita");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		loginPanel = new LoginPanel();
			
		add(loginPanel).setVisible(false);
		setVisible(true);
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	
	
}
