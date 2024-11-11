package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * La clase {@code SellerControlPanel} representa un panel de control para el
 * vendedor dentro de la interfaz gráfica de usuario (GUI). Este panel
 * proporciona un conjunto de botones y etiquetas para navegar entre las
 * opciones de inventario, ventas y salir del sistema. Además, presenta un área
 * de título con el nombre del usuario actual y botones con íconos
 * representativos para facilitar la interacción.
 * <p>
 * El panel se divide en dos áreas principales: una para el título y otra para
 * los botones de navegación, con íconos acompañando cada opción.
 * </p>
 * <p>
 * La interfaz está diseñada para ser clara y sencilla, brindando acceso rápido
 * a las opciones que un vendedor necesita en su día a día.
 * </p>
 * 
 * @see JPanel
 */
public class SellerControlPanel extends JPanel {

	/**
	 * Etiqueta que muestra el nombre del usuario actual.
	 */
	private JLabel curretUserSe;

	/**
	 * Etiqueta que muestra el nombre de la tienda en la interfaz.
	 */
	private JLabel nameStSe;

	/**
	 * Etiqueta que contiene el ícono de 'Inventario'.
	 */
	private JLabel icInv;

	/**
	 * Etiqueta que contiene el ícono de 'Ventas'.
	 */
	private JLabel icSal;

	/**
	 * Etiqueta que contiene el ícono de 'Salir'.
	 */
	private JLabel icEx;

	/**
	 * Botón para acceder al inventario.
	 */
	private JButton inventorySe;

	/**
	 * Botón para acceder a las ventas.
	 */
	private JButton salesSe;

	/**
	 * Botón para salir del sistema.
	 */
	private JButton exitSe;

	/**
	 * Panel que contiene el título y la barra superior del panel.
	 */
	private JPanel titlePanelSe;

	/**
	 * Panel que contiene los botones de navegación.
	 */
	private JPanel buttonsPanelSe;

	/**
	 * Etiqueta que indica la opción de 'Inventario'.
	 */
	private JLabel titleInventorySe;

	/**
	 * Etiqueta que indica la opción de 'Ventas'.
	 */
	private JLabel titleSalesSe;

	/**
	 * Construye un nuevo {@code SellerControlPanel} e inicializa todos los
	 * componentes del panel. Establece los límites y el diseño de los paneles, así
	 * como las propiedades de los botones, etiquetas y los íconos asociados.
	 */
	public SellerControlPanel() {
		// Establece el diseño y el color de fondo para el panel principal.
		setBounds(0, 0, 800, 600);
		setBackground(Color.WHITE);
		setLayout(null);

		// Inicializa y establece la visibilidad de la etiqueta que muestra el nombre de
		// la tienda.
		nameStSe = new JLabel(new ImageIcon("src/Assets/name.png"));
		nameStSe.setBounds(160, 150, 630, 300);
		nameStSe.setLayout(null);
		add(nameStSe).setVisible(false);

		// Inicializa el panel del título con un fondo de color azul.
		titlePanelSe = new JPanel();
		titlePanelSe.setBounds(0, 0, 800, 50);
		titlePanelSe.setBackground(new Color(18, 143, 223));
		titlePanelSe.setLayout(null);
		add(titlePanelSe);

		// Inicializa el panel de botones con un fondo de color azul oscuro.
		buttonsPanelSe = new JPanel();
		buttonsPanelSe.setBounds(0, 50, 160, 550);
		buttonsPanelSe.setBackground(new Color(2, 58, 98));
		buttonsPanelSe.setLayout(null);
		add(buttonsPanelSe);

		// Inicializa el título de 'Inventario' y lo agrega al panel de título.
		titleInventorySe = new JLabel("Inventario");
		titleInventorySe.setBounds(380, 10, 370, 30);
		titleInventorySe.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleInventorySe.setForeground(Color.WHITE);
		titlePanelSe.add(titleInventorySe).setVisible(false);

		// Inicializa el título de 'Ventas' y lo agrega al panel de título.
		titleSalesSe = new JLabel("Ventas");
		titleSalesSe.setBounds(410, 10, 370, 30);
		titleSalesSe.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleSalesSe.setForeground(Color.WHITE);
		titlePanelSe.add(titleSalesSe).setVisible(false);

		// Inicializa los íconos de los botones de 'Inventario', 'Ventas' y 'Salir'.
		icInv = new JLabel(new ImageIcon("src/Assets/inventory.png"));
		icInv.setBounds(5, 17, 37, 37);
		icInv.setLayout(null);
		buttonsPanelSe.add(icInv);

		icSal = new JLabel(new ImageIcon("src/Assets/sales.png"));
		icSal.setBounds(5, 94, 37, 37);
		icSal.setLayout(null);
		buttonsPanelSe.add(icSal);

		icEx = new JLabel(new ImageIcon("src/Assets/exit.png"));
		icEx.setBounds(5, 171, 37, 37);
		icEx.setLayout(null);
		buttonsPanelSe.add(icEx);

		// Inicializa la etiqueta que muestra el nombre del usuario.
		curretUserSe = new JLabel("Nombre Usuario");
		curretUserSe.setBounds(10, 0, 150, 50);
		curretUserSe.setFont(new Font("Leelawadee", Font.BOLD, 18));
		curretUserSe.setForeground(Color.WHITE);
		titlePanelSe.add(curretUserSe);

		// Inicializa el botón de 'Inventario' y establece sus propiedades.
		inventorySe = new JButton("Inventario");
		inventorySe.setBounds(0, 0, 160, 75);
		inventorySe.setFocusable(false);
		inventorySe.setBorderPainted(false);
		inventorySe.setContentAreaFilled(false);
		inventorySe.setFont(new Font("Leelawadee", Font.BOLD, 18));
		inventorySe.setForeground(Color.WHITE);
		inventorySe.setMargin(new Insets(0, 45, 0, 0));
		inventorySe.setHorizontalAlignment(SwingConstants.LEADING);
		buttonsPanelSe.add(inventorySe);

		// Inicializa el botón de 'Ventas' y establece sus propiedades.
		salesSe = new JButton("Ventas");
		salesSe.setBounds(0, 75, 170, 75);
		salesSe.setFocusable(false);
		salesSe.setBorderPainted(false);
		salesSe.setContentAreaFilled(false);
		salesSe.setFont(new Font("Leelawadee", Font.BOLD, 18));
		salesSe.setForeground(Color.WHITE);
		salesSe.setMargin(new Insets(0, 45, 0, 0));
		salesSe.setHorizontalAlignment(SwingConstants.LEADING);
		buttonsPanelSe.add(salesSe);

		// Inicializa el botón de 'Salir' y establece sus propiedades.
		exitSe = new JButton("Salir");
		exitSe.setBounds(0, 150, 160, 75);
		exitSe.setFocusable(false);
		exitSe.setBorderPainted(false);
		exitSe.setContentAreaFilled(false);
		exitSe.setFont(new Font("Leelawadee", Font.BOLD, 18));
		exitSe.setForeground(Color.WHITE);
		exitSe.setMargin(new Insets(0, 45, 0, 0));
		exitSe.setHorizontalAlignment(SwingConstants.LEADING);
		buttonsPanelSe.add(exitSe);
	}

	// Métodos getter y setter para los atributos del panel.

	public JLabel getCurretUserSe() {
		return curretUserSe;
	}

	public void setCurretUserSe(JLabel curretUserSe) {
		this.curretUserSe = curretUserSe;
	}

	public JLabel getNameStSe() {
		return nameStSe;
	}

	public void setNameStSe(JLabel nameStSe) {
		this.nameStSe = nameStSe;
	}

	public JLabel getIcInv() {
		return icInv;
	}

	public void setIcInv(JLabel icInv) {
		this.icInv = icInv;
	}

	public JLabel getIcSal() {
		return icSal;
	}

	public void setIcSal(JLabel icSal) {
		this.icSal = icSal;
	}

	public JLabel getIcEx() {
		return icEx;
	}

	public void setIcEx(JLabel icEx) {
		this.icEx = icEx;
	}

	public JButton getInventorySe() {
		return inventorySe;
	}

	public void setInventorySe(JButton inventorySe) {
		this.inventorySe = inventorySe;
	}

	public JButton getSalesSe() {
		return salesSe;
	}

	public void setSalesSe(JButton salesSe) {
		this.salesSe = salesSe;
	}

	public JButton getExitSe() {
		return exitSe;
	}

	public void setExitSe(JButton exitSe) {
		this.exitSe = exitSe;
	}

	public JPanel getTitlePanelSe() {
		return titlePanelSe;
	}

	public void setTitlePanelSe(JPanel titlePanelSe) {
		this.titlePanelSe = titlePanelSe;
	}

	public JPanel getButtonsPanelSe() {
		return buttonsPanelSe;
	}

	public void setButtonsPanelSe(JPanel buttonsPanelSe) {
		this.buttonsPanelSe = buttonsPanelSe;
	}

	public JLabel getTitleInventorySe() {
		return titleInventorySe;
	}

	public void setTitleInventorySe(JLabel titleInventorySe) {
		this.titleInventorySe = titleInventorySe;
	}

	public JLabel getTitleSalesSe() {
		return titleSalesSe;
	}

	public void setTitleSalesSe(JLabel titleSalesSe) {
		this.titleSalesSe = titleSalesSe;
	}

}
