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
 * Representa el panel de control para la interfaz de usuario del administrador.
 * Este panel proporciona acceso a diversas secciones del sistema, como
 * inventario, proveedores, ventas, control de usuarios, control de caja y
 * compras. Incluye un diseño con botones para navegar entre estas secciones y
 * muestra el nombre del usuario actual en la parte superior.
 * 
 * <p>
 * El panel está dividido en dos secciones:
 * </p>
 * <ul>
 * <li>Panel de título: Muestra el nombre del usuario actual y los títulos para
 * cada sección.</li>
 * <li>Panel de botones: Contiene los botones para navegar a las diferentes
 * secciones del sistema.</li>
 * </ul>
 * Cada botón corresponde a una área funcional como inventario, proveedores,
 * ventas, etc.
 */
public class AdminControlPanel extends JPanel {

	private JLabel curretUser, nameSt, icInv, icSup, icSal, icUsCo, icCaCo, icPur, icEx;
	private JButton inventory, suppliers, sales, userControl, cashControl, purchase, exit;
	private JPanel titlePanel, buttonsPanel;

	private JLabel titleInventory, titleSupplier, titleSales, titleConUser, titleConCash, titlePurchase;

	/**
	 * Constructor de la clase AdminControlPanel. Inicializa todos los componentes y
	 * el diseño del panel. Esto incluye la configuración de los límites, la adición
	 * de etiquetas, botones e íconos en los paneles respectivos.
	 */
	public AdminControlPanel() {

		// Establecer el tamaño y color de fondo del panel principal
		setBounds(0, 0, 800, 600);
		setBackground(Color.WHITE);
		setLayout(null);

		// Inicializar la etiqueta del nombre del usuario actual
		nameSt = new JLabel(new ImageIcon("src/Assets/name.png"));
		nameSt.setBounds(160, 150, 630, 300);
		nameSt.setLayout(null);
		add(nameSt).setVisible(false);

		// Configuración del panel de título
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 800, 50);
		titlePanel.setBackground(new Color(18, 143, 223));
		titlePanel.setLayout(null);
		add(titlePanel);

		// Configuración del panel de botones
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 50, 160, 550);
		buttonsPanel.setBackground(new Color(2, 58, 98));
		buttonsPanel.setLayout(null);
		add(buttonsPanel);

		// Títulos para cada sección en el panel de título
		titleInventory = new JLabel("Inventario");
		titleInventory.setBounds(380, 10, 370, 30);
		titleInventory.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleInventory.setForeground(Color.WHITE);
		titlePanel.add(titleInventory).setVisible(false);

		titleSupplier = new JLabel("Proveedores");
		titleSupplier.setBounds(370, 10, 370, 30);
		titleSupplier.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleSupplier.setForeground(Color.WHITE);
		titlePanel.add(titleSupplier).setVisible(false);

		titleSales = new JLabel("Ventas");
		titleSales.setBounds(410, 10, 370, 30);
		titleSales.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleSales.setForeground(Color.WHITE);
		titlePanel.add(titleSales).setVisible(false);

		titleConUser = new JLabel("Control de usuarios");
		titleConUser.setBounds(310, 10, 350, 30);
		titleConUser.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleConUser.setForeground(Color.WHITE);
		titlePanel.add(titleConUser).setVisible(false);

		titleConCash = new JLabel("Control de caja");
		titleConCash.setBounds(340, 5, 350, 40);
		titleConCash.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titleConCash.setForeground(Color.WHITE);
		titlePanel.add(titleConCash).setVisible(false);

		titlePurchase = new JLabel("Compra");
		titlePurchase.setBounds(410, 5, 370, 40);
		titlePurchase.setFont(new Font("Leelawadee", Font.BOLD, 35));
		titlePurchase.setForeground(Color.WHITE);
		titlePanel.add(titlePurchase).setVisible(false);

		// Configuración de los iconos en el panel de botones
		icInv = new JLabel(new ImageIcon("src/Assets/inventory.png"));
		icInv.setBounds(5, 17, 37, 37);
		icInv.setLayout(null);
		buttonsPanel.add(icInv);

		icSup = new JLabel(new ImageIcon("src/Assets/suppliers.png"));
		icSup.setBounds(5, 94, 37, 37);
		icSup.setLayout(null);
		buttonsPanel.add(icSup);

		icSal = new JLabel(new ImageIcon("src/Assets/sales.png"));
		icSal.setBounds(5, 171, 37, 37);
		icSal.setLayout(null);
		buttonsPanel.add(icSal);

		icUsCo = new JLabel(new ImageIcon("src/Assets/usercontrol.png"));
		icUsCo.setBounds(5, 248, 37, 37);
		icUsCo.setLayout(null);
		buttonsPanel.add(icUsCo);

		icCaCo = new JLabel(new ImageIcon("src/Assets/cashcontrol.png"));
		icCaCo.setBounds(3, 320, 37, 37);
		icCaCo.setLayout(null);
		buttonsPanel.add(icCaCo);

		icPur = new JLabel(new ImageIcon("src/Assets/purchase.png"));
		icPur.setBounds(5, 395, 37, 37);
		icPur.setLayout(null);
		buttonsPanel.add(icPur);

		icEx = new JLabel(new ImageIcon("src/Assets/exit.png"));
		icEx.setBounds(5, 470, 37, 37);
		icEx.setLayout(null);
		buttonsPanel.add(icEx);

		// Configuración de las etiquetas de texto y botones
		curretUser = new JLabel("Nombre Usuario");
		curretUser.setBounds(10, 0, 150, 50);
		curretUser.setFont(new Font("Leelawadee", Font.BOLD, 18));
		curretUser.setForeground(Color.WHITE);
		titlePanel.add(curretUser);

		// Botones de acción para cada sección
		inventory = new JButton("Inventario");
		inventory.setBounds(0, 0, 160, 75);
		inventory.setFocusable(false);
		inventory.setBorderPainted(false);
		inventory.setContentAreaFilled(false);
		inventory.setFont(new Font("Leelawadee", Font.BOLD, 18));
		inventory.setForeground(Color.WHITE);
		inventory.setMargin(new Insets(0, 45, 0, 0));
		inventory.setHorizontalAlignment(SwingConstants.LEADING);
		buttonsPanel.add(inventory);

		suppliers = new JButton("Proveedores");
		suppliers.setBounds(0, 75, 170, 75);
		suppliers.setFocusable(false);
		suppliers.setBorderPainted(false);
		suppliers.setContentAreaFilled(false);
		suppliers.setFont(new Font("Leelawadee", Font.BOLD, 18));
		suppliers.setForeground(Color.WHITE);
		suppliers.setMargin(new Insets(0, 45, 0, 0));
		suppliers.setHorizontalAlignment(SwingConstants.LEADING);
		buttonsPanel.add(suppliers);

		sales = new JButton("Ventas");
		sales.setBounds(0, 150, 160, 75);
		sales.setFocusable(false);
		sales.setBorderPainted(false);
		sales.setContentAreaFilled(false);
		sales.setFont(new Font("Leelawadee", Font.BOLD, 18));
		sales.setForeground(Color.WHITE);
		sales.setMargin(new Insets(0, 45, 0, 0));
		sales.setHorizontalAlignment(SwingConstants.LEADING);
		buttonsPanel.add(sales);

		userControl = new JButton("<html>Control de <br>usuarios</html>");
		userControl.setBounds(0, 225, 180, 75);
		userControl.setFocusable(false);
		userControl.setBorderPainted(false);
		userControl.setContentAreaFilled(false);
		userControl.setFont(new Font("Leelawadee", Font.BOLD, 18));
		userControl.setForeground(Color.WHITE);
		userControl.setMargin(new Insets(0, 40, 0, 0));
		userControl.setHorizontalAlignment(SwingConstants.CENTER);
		buttonsPanel.add(userControl);

		cashControl = new JButton("<html>Control de <br>caja</html>");
		cashControl.setBounds(0, 300, 170, 75);
		cashControl.setFocusable(false);
		cashControl.setBorderPainted(false);
		cashControl.setContentAreaFilled(false);
		cashControl.setFont(new Font("Leelawadee", Font.BOLD, 18));
		cashControl.setMargin(new Insets(0, 40, 0, 0));
		cashControl.setHorizontalAlignment(SwingConstants.CENTER);
		cashControl.setForeground(Color.WHITE);
		buttonsPanel.add(cashControl);

		purchase = new JButton("Compra");
		purchase.setBounds(0, 375, 170, 75);
		purchase.setFocusable(false);
		purchase.setBorderPainted(false);
		purchase.setContentAreaFilled(false);
		purchase.setFont(new Font("Leelawadee", Font.BOLD, 18));
		purchase.setForeground(Color.WHITE);
		buttonsPanel.add(purchase);

		exit = new JButton("Salir");
		exit.setBounds(0, 450, 160, 75);
		exit.setFocusable(false);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFont(new Font("Leelawadee", Font.BOLD, 18));
		exit.setForeground(Color.WHITE);
		buttonsPanel.add(exit);
	}

	// getters y setters//

	public JLabel getCurretUser() {
		return curretUser;
	}

	public void setCurretUser(JLabel curretUser) {
		this.curretUser = curretUser;
	}

	public JLabel getNameSt() {
		return nameSt;
	}

	public void setNameSt(JLabel nameSt) {
		this.nameSt = nameSt;
	}

	public JLabel getIcInv() {
		return icInv;
	}

	public void setIcInv(JLabel icInv) {
		this.icInv = icInv;
	}

	public JLabel getIcSup() {
		return icSup;
	}

	public void setIcSup(JLabel icSup) {
		this.icSup = icSup;
	}

	public JLabel getIcSal() {
		return icSal;
	}

	public void setIcSal(JLabel icSal) {
		this.icSal = icSal;
	}

	public JLabel getIcUsCo() {
		return icUsCo;
	}

	public void setIcUsCo(JLabel icUsCo) {
		this.icUsCo = icUsCo;
	}

	public JLabel getIcCaCo() {
		return icCaCo;
	}

	public void setIcCaCo(JLabel icCaCo) {
		this.icCaCo = icCaCo;
	}

	public JLabel getIcPur() {
		return icPur;
	}

	public void setIcPur(JLabel icPur) {
		this.icPur = icPur;
	}

	public JLabel getIcEx() {
		return icEx;
	}

	public void setIcEx(JLabel icEx) {
		this.icEx = icEx;
	}

	public JButton getInventory() {
		return inventory;
	}

	public void setInventory(JButton inventory) {
		this.inventory = inventory;
	}

	public JButton getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(JButton suppliers) {
		this.suppliers = suppliers;
	}

	public JButton getSales() {
		return sales;
	}

	public void setSales(JButton sales) {
		this.sales = sales;
	}

	public JButton getUserControl() {
		return userControl;
	}

	public void setUserControl(JButton userControl) {
		this.userControl = userControl;
	}

	public JButton getCashControl() {
		return cashControl;
	}

	public void setCashControl(JButton cashControl) {
		this.cashControl = cashControl;
	}

	public JButton getPurchase() {
		return purchase;
	}

	public void setPurchase(JButton purchase) {
		this.purchase = purchase;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public void setTitlePanel(JPanel titlePanel) {
		this.titlePanel = titlePanel;
	}

	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

	public JLabel getTitleInventory() {
		return titleInventory;
	}

	public void setTitleInventory(JLabel titleInventory) {
		this.titleInventory = titleInventory;
	}

	public JLabel getTitleSupplier() {
		return titleSupplier;
	}

	public void setTitleSupplier(JLabel titleSupplier) {
		this.titleSupplier = titleSupplier;
	}

	public JLabel getTitleSales() {
		return titleSales;
	}

	public void setTitleSales(JLabel titleSales) {
		this.titleSales = titleSales;
	}

	public JLabel getTitleConUser() {
		return titleConUser;
	}

	public void setTitleConUser(JLabel titleConUser) {
		this.titleConUser = titleConUser;
	}

	public JLabel getTitleConCash() {
		return titleConCash;
	}

	public void setTitleConCash(JLabel titleConCash) {
		this.titleConCash = titleConCash;
	}

	public JLabel getTitlePurchase() {
		return titlePurchase;
	}

	public void setTitlePurchase(JLabel titlePurchase) {
		this.titlePurchase = titlePurchase;
	}

}
