package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;

/**
 * Esta clase representa un panel en la interfaz gráfica de usuario para
 * registrar una compra. El panel contiene campos de texto para ingresar los
 * detalles del producto y las cantidades, así como botones para registrar la
 * compra o cerrar el panel.
 */
public class RegisterPurchasePanel extends JPanel {

	private JLabel formPur, titleRegisterPur, indNameProPur, indASupPur, indToCoPur, indUniCosPur, indQuaInPur,
			indQuaToPur, indRegisterPur;
	private JTextField nameProPur, aSupplierPur, totalCostPur, uniCostPur, quantityInPur;
	private JSpinner quantityToPur;
	private JButton registerProPur, closePurPanel;

	/**
	 * Constructor de la clase {@link RegisterPurchasePanel}. Inicializa los
	 * componentes visuales del panel, incluyendo los campos de entrada, los botones
	 * y las etiquetas para registrar la compra.
	 */
	public RegisterPurchasePanel() {

		setBounds(216, 120, 513, 382);
		setLayout(null);
		setBackground(Color.WHITE);

		// Fondo del formulario
		formPur = new JLabel(new ImageIcon("src/Assets/bigform.png"));
		formPur.setBounds(0, 0, 513, 382);
		formPur.setLayout(null);
		add(formPur);

		// Título del formulario
		titleRegisterPur = new JLabel("Registrar Compra");
		titleRegisterPur.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegisterPur.setForeground(Color.WHITE);
		titleRegisterPur.setBounds(145, 20, 250, 30);
		formPur.add(titleRegisterPur);

		// Botón para cerrar el panel
		closePurPanel = new JButton(new ImageIcon("src/Assets/xwhite.png"));
		closePurPanel.setBounds(450, 20, 32, 32);
		closePurPanel.setFocusable(false);
		closePurPanel.setBorderPainted(false);
		closePurPanel.setContentAreaFilled(false);
		formPur.add(closePurPanel);

		// Etiqueta y campo para el nombre del producto
		indNameProPur = new JLabel("Nombre del producto");
		indNameProPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indNameProPur.setForeground(Color.WHITE);
		indNameProPur.setBounds(40, 60, 220, 30);
		formPur.add(indNameProPur);

		nameProPur = new JTextField();
		nameProPur.setBounds(40, 100, 175, 30);
		MatteBorder borderName = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		nameProPur.setBorder(borderName);
		nameProPur.setOpaque(false);
		nameProPur.setForeground(Color.WHITE);
		nameProPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		nameProPur.setEditable(false);
		formPur.add(nameProPur);

		// Etiqueta y campo para el proveedor asociado
		indASupPur = new JLabel("Proveedor Asociado");
		indASupPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indASupPur.setForeground(Color.WHITE);
		indASupPur.setBounds(300, 60, 220, 30);
		formPur.add(indASupPur);

		aSupplierPur = new JTextField();
		aSupplierPur.setBounds(300, 100, 175, 30);
		MatteBorder borderAsoSup = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		aSupplierPur.setBorder(borderAsoSup);
		aSupplierPur.setOpaque(false);
		aSupplierPur.setForeground(Color.WHITE);
		aSupplierPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		aSupplierPur.setEditable(false);
		formPur.add(aSupplierPur);

		// Etiqueta y campo para el costo total
		indToCoPur = new JLabel("Costo Total");
		indToCoPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indToCoPur.setForeground(Color.WHITE);
		indToCoPur.setBounds(40, 140, 220, 30);
		formPur.add(indToCoPur);

		totalCostPur = new JTextField();
		totalCostPur.setBounds(40, 180, 175, 30);
		MatteBorder borderToCo = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		totalCostPur.setBorder(borderToCo);
		totalCostPur.setOpaque(false);
		totalCostPur.setForeground(Color.WHITE);
		totalCostPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		totalCostPur.setEditable(false);
		formPur.add(totalCostPur);

		// Etiqueta y campo para el costo unitario
		indUniCosPur = new JLabel("Costo Unitario");
		indUniCosPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indUniCosPur.setForeground(Color.WHITE);
		indUniCosPur.setBounds(300, 140, 220, 30);
		formPur.add(indUniCosPur);

		uniCostPur = new JTextField();
		uniCostPur.setBounds(300, 180, 175, 30);
		MatteBorder borderCo = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		uniCostPur.setBorder(borderCo);
		uniCostPur.setOpaque(false);
		uniCostPur.setForeground(Color.WHITE);
		uniCostPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		uniCostPur.setEditable(false);
		formPur.add(uniCostPur);

		// Etiqueta y campo para la cantidad en inventario
		indQuaInPur = new JLabel("Cantidad inventario");
		indQuaInPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indQuaInPur.setForeground(Color.WHITE);
		indQuaInPur.setBounds(40, 220, 220, 30);
		formPur.add(indQuaInPur);

		quantityInPur = new JTextField();
		quantityInPur.setBounds(40, 260, 175, 30);
		MatteBorder borderQuaIn = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		quantityInPur.setBorder(borderQuaIn);
		quantityInPur.setOpaque(false);
		quantityInPur.setForeground(Color.WHITE);
		quantityInPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		quantityInPur.setEditable(false);
		formPur.add(quantityInPur);

		// Etiqueta y campo para la cantidad a pedir
		indQuaToPur = new JLabel("Cantidad a pedir");
		indQuaToPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indQuaToPur.setForeground(Color.WHITE);
		indQuaToPur.setBounds(300, 220, 220, 30);
		formPur.add(indQuaToPur);

		quantityToPur = new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));
		quantityToPur.setBounds(300, 260, 175, 30);
		quantityToPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		JComponent editor = quantityToPur.getEditor();
		if (editor instanceof JSpinner.DefaultEditor) {
			((JSpinner.DefaultEditor) editor).getTextField().setEditable(false);
			((JSpinner.DefaultEditor) editor).getTextField().setBorder(borderQuaIn);
			((JSpinner.DefaultEditor) editor).getTextField().setForeground(Color.WHITE);
			((JSpinner.DefaultEditor) editor).getTextField().setFont(new Font("Leelawadee", Font.BOLD, 20));
			((JSpinner.DefaultEditor) editor).getTextField().setBackground(new Color(2, 58, 98));
		}
		formPur.add(quantityToPur);

		// Indicador y botón para registrar la compra
		indRegisterPur = new JLabel("Registrar");
		indRegisterPur.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indRegisterPur.setForeground(new Color(2, 58, 98));
		indRegisterPur.setBounds(208, 325, 150, 30);
		formPur.add(indRegisterPur);

		registerProPur = new JButton(new ImageIcon("src/Assets/register.png"));
		registerProPur.setBounds(198, 320, 115, 45);
		registerProPur.setFocusable(false);
		registerProPur.setBorderPainted(false);
		registerProPur.setContentAreaFilled(false);
		formPur.add(registerProPur);
	}

	// Métodos getter y setter para los componentes del formulario

	public JTextField getNameProPur() {
		return nameProPur;
	}

	public void setNameProPur(JTextField nameProPur) {
		this.nameProPur = nameProPur;
	}

	public JTextField getaSupplierPur() {
		return aSupplierPur;
	}

	public void setaSupplierPur(JTextField aSupplierPur) {
		this.aSupplierPur = aSupplierPur;
	}

	public JTextField getTotalCostPur() {
		return totalCostPur;
	}

	public void setTotalCostPur(JTextField totalCostPur) {
		this.totalCostPur = totalCostPur;
	}

	public JTextField getUniCostPur() {
		return uniCostPur;
	}

	public void setUniCostPur(JTextField uniCostPur) {
		this.uniCostPur = uniCostPur;
	}

	public JTextField getQuantityInPur() {
		return quantityInPur;
	}

	public void setQuantityInPur(JTextField quantityInPur) {
		this.quantityInPur = quantityInPur;
	}

	public JSpinner getQuantityToPur() {
		return quantityToPur;
	}

	public void setQuantityToPur(JSpinner quantityToPur) {
		this.quantityToPur = quantityToPur;
	}

	public JButton getRegisterProPur() {
		return registerProPur;
	}

	public void setRegisterProPur(JButton registerProPur) {
		this.registerProPur = registerProPur;
	}

	public JButton getClosePurPanel() {
		return closePurPanel;
	}

	public void setClosePurPanel(JButton closePurPanel) {
		this.closePurPanel = closePurPanel;
	}

}
