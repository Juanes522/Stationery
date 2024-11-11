package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 * Clase {@code AddUpdateInventoryPanel} que representa un panel en la interfaz
 * gráfica para registrar o actualizar productos en el inventario.
 * 
 * <p>
 * Este panel contiene campos de texto para ingresar información sobre los
 * productos, como nombre, cantidad, precio y costo, así como un combo box para
 * seleccionar el proveedor asociado. Además, incluye botones para registrar o
 * actualizar un producto en el inventario.
 * </p>
 * 
 * @see JPanel
 */
public class AddUpdateInventoryPanel extends JPanel {

	/** Formulario principal del panel */
	private JLabel formIn, titleRegisterIn, titleUpdateIn, indNamePro, indQuaPro, indPriPro, indCosPro, indSupAss,
			indRegisterPro, indUpdatePro;

	/** Campos de texto para ingresar información del producto */
	private JTextField namePro, quantityPro, pricePro, costPro;

	/** Combo box para seleccionar el proveedor asociado */
	private JComboBox<String> supplierA;

	/** Botones de acción: registrar, actualizar y cerrar */
	private JButton registerPro, updatePro, closeIn;

	/**
	 * Constructor que inicializa el panel para registrar o actualizar productos.
	 * Configura el diseño y los componentes visuales del panel.
	 */
	public AddUpdateInventoryPanel() {

		setBounds(216, 120, 513, 382);
		setLayout(null);
		setBackground(Color.WHITE);

		// Formulario del panel
		formIn = new JLabel(new ImageIcon("src/Assets/bigform.png"));
		formIn.setBounds(0, 0, 513, 382);
		formIn.setLayout(null);
		add(formIn);

		// Títulos de las acciones
		titleRegisterIn = new JLabel("Registrar Producto");
		titleRegisterIn.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegisterIn.setForeground(Color.WHITE);
		titleRegisterIn.setBounds(125, 20, 250, 30);
		formIn.add(titleRegisterIn).setVisible(false);

		titleUpdateIn = new JLabel("Actualizar Producto");
		titleUpdateIn.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleUpdateIn.setForeground(Color.WHITE);
		titleUpdateIn.setBounds(125, 20, 280, 30);
		formIn.add(titleUpdateIn).setVisible(false);

		// Botón para cerrar el panel
		closeIn = new JButton(new ImageIcon("src/Assets/xwhite.png"));
		closeIn.setBounds(450, 20, 32, 32);
		closeIn.setFocusable(false);
		closeIn.setBorderPainted(false);
		closeIn.setContentAreaFilled(false);
		formIn.add(closeIn);

		// Etiquetas y campos de entrada para información del producto
		indNamePro = new JLabel("Nombre del producto");
		indNamePro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indNamePro.setForeground(Color.WHITE);
		indNamePro.setBounds(40, 60, 220, 30);
		formIn.add(indNamePro);

		namePro = new JTextField();
		namePro.setBounds(40, 100, 175, 30);
		MatteBorder borderName = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		namePro.setBorder(borderName);
		namePro.setOpaque(false);
		namePro.setForeground(Color.WHITE);
		namePro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		namePro.setCaretColor(Color.WHITE);
		formIn.add(namePro);

		indQuaPro = new JLabel("Cantidad");
		indQuaPro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indQuaPro.setForeground(Color.WHITE);
		indQuaPro.setBounds(300, 60, 220, 30);
		formIn.add(indQuaPro);

		quantityPro = new JTextField();
		quantityPro.setBounds(300, 100, 175, 30);
		MatteBorder borderQ = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		quantityPro.setBorder(borderQ);
		quantityPro.setOpaque(false);
		quantityPro.setForeground(Color.WHITE);
		quantityPro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		quantityPro.setCaretColor(Color.WHITE);
		formIn.add(quantityPro);

		indPriPro = new JLabel("Precio");
		indPriPro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indPriPro.setForeground(Color.WHITE);
		indPriPro.setBounds(40, 140, 220, 30);
		formIn.add(indPriPro);

		pricePro = new JTextField();
		pricePro.setBounds(40, 180, 175, 30);
		MatteBorder borderPr = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		pricePro.setBorder(borderPr);
		pricePro.setOpaque(false);
		pricePro.setForeground(Color.WHITE);
		pricePro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		pricePro.setCaretColor(Color.WHITE);
		formIn.add(pricePro);

		indCosPro = new JLabel("Costo");
		indCosPro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indCosPro.setForeground(Color.WHITE);
		indCosPro.setBounds(300, 140, 220, 30);
		formIn.add(indCosPro);

		costPro = new JTextField();
		costPro.setBounds(300, 180, 175, 30);
		MatteBorder borderCo = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		costPro.setBorder(borderCo);
		costPro.setOpaque(false);
		costPro.setForeground(Color.WHITE);
		costPro.setFont(new Font("Leelawadee", Font.BOLD, 20));
		costPro.setCaretColor(Color.WHITE);
		formIn.add(costPro);

		indSupAss = new JLabel("Proveedor Asociado");
		indSupAss.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indSupAss.setForeground(Color.WHITE);
		indSupAss.setBounds(40, 220, 220, 30);
		formIn.add(indSupAss);

		supplierA = new JComboBox<>();
		supplierA.setBounds(40, 260, 175, 30);
		supplierA.setFocusable(false);
		formIn.add(supplierA);

		// Botones para registrar o actualizar producto
		indRegisterPro = new JLabel("Registrar");
		indRegisterPro.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indRegisterPro.setForeground(new Color(2, 58, 98));
		indRegisterPro.setBounds(208, 325, 150, 30);
		formIn.add(indRegisterPro).setVisible(false);

		indUpdatePro = new JLabel("Actualizar");
		indUpdatePro.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpdatePro.setForeground(new Color(2, 58, 98));
		indUpdatePro.setBounds(205, 325, 150, 30);
		formIn.add(indUpdatePro).setVisible(false);

		registerPro = new JButton(new ImageIcon("src/Assets/register.png"));
		registerPro.setBounds(198, 320, 115, 45);
		registerPro.setFocusable(false);
		registerPro.setBorderPainted(false);
		registerPro.setContentAreaFilled(false);
		formIn.add(registerPro).setVisible(false);

		updatePro = new JButton(new ImageIcon("src/Assets/update.png"));
		updatePro.setBounds(195, 320, 123, 45);
		updatePro.setFocusable(false);
		updatePro.setBorderPainted(false);
		updatePro.setContentAreaFilled(false);
		formIn.add(updatePro).setVisible(false);

	}

	/**
	 * Rellena el combo box de proveedores con los nombres de los proveedores
	 * disponibles.
	 * 
	 * @param supplierNames Un conjunto de nombres de proveedores.
	 */
	public void addSuplliers(Set<String> supplierNames) {
		supplierA.removeAllItems();
		for (String sn : supplierNames) {
			supplierA.addItem(sn);
		}
	}

	// Métodos getters y setters

	public JLabel getTitleRegisterIn() {
		return titleRegisterIn;
	}

	public void setTitleRegisterIn(JLabel titleRegisterIn) {
		this.titleRegisterIn = titleRegisterIn;
	}

	public JLabel getTitleUpdateIn() {
		return titleUpdateIn;
	}

	public void setTitleUpdateIn(JLabel titleUpdateIn) {
		this.titleUpdateIn = titleUpdateIn;
	}

	public JLabel getIndRegisterPro() {
		return indRegisterPro;
	}

	public void setIndRegisterPro(JLabel indRegisterPro) {
		this.indRegisterPro = indRegisterPro;
	}

	public JLabel getIndUpdatePro() {
		return indUpdatePro;
	}

	public void setIndUpdatePro(JLabel indUpdatePro) {
		this.indUpdatePro = indUpdatePro;
	}

	public JTextField getNamePro() {
		return namePro;
	}

	public void setNamePro(JTextField namePro) {
		this.namePro = namePro;
	}

	public JTextField getQuantityPro() {
		return quantityPro;
	}

	public void setQuantityPro(JTextField quantityPro) {
		this.quantityPro = quantityPro;
	}

	public JTextField getPricePro() {
		return pricePro;
	}

	public void setPricePro(JTextField pricePro) {
		this.pricePro = pricePro;
	}

	public JTextField getCostPro() {
		return costPro;
	}

	public void setCostPro(JTextField costPro) {
		this.costPro = costPro;
	}

	public JComboBox<String> getSupplierA() {
		return supplierA;
	}

	public void setSupplierA(JComboBox<String> supplierA) {
		this.supplierA = supplierA;
	}

	public JButton getRegisterPro() {
		return registerPro;
	}

	public void setRegisterPro(JButton registerPro) {
		this.registerPro = registerPro;
	}

	public JButton getUpdatePro() {
		return updatePro;
	}

	public void setUpdatePro(JButton updatePro) {
		this.updatePro = updatePro;
	}

	public JButton getCloseIn() {
		return closeIn;
	}

	public void setCloseIn(JButton closeIn) {
		this.closeIn = closeIn;
	}
}
