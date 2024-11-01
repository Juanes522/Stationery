package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class RegisterPurchasePanel extends JPanel {

	private JLabel formPur, titleRegisterPur, indNameProPur, indASupPur, indToCoPur, indUniCosPur, indQuaInPur,
			indQuaToPur, indRegisterPur;
	private JTextField nameProPur, aSupplierPur, totalCostPur, uniCostPur, quantityInPur, quantityToPur;
	private JButton registerProPur, closePurPanel;

	public RegisterPurchasePanel() {

		setBounds(216, 120, 513, 382);
		setLayout(null);
		setBackground(Color.WHITE);

		formPur = new JLabel(new ImageIcon("src/Assets/bigform.png"));
		formPur.setBounds(0, 0, 513, 382);
		formPur.setLayout(null);
		add(formPur);

		titleRegisterPur = new JLabel("Registrar Compra");
		titleRegisterPur.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegisterPur.setForeground(Color.WHITE);
		titleRegisterPur.setBounds(145, 20, 250, 30);
		formPur.add(titleRegisterPur);

		closePurPanel = new JButton(new ImageIcon("src/Assets/xwhite.png"));
		closePurPanel.setBounds(450, 20, 32, 32);
		closePurPanel.setFocusable(false);
		closePurPanel.setBorderPainted(false);
		closePurPanel.setContentAreaFilled(false);
		formPur.add(closePurPanel);

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

		indQuaToPur = new JLabel("Cantidad a pedir");
		indQuaToPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indQuaToPur.setForeground(Color.WHITE);
		indQuaToPur.setBounds(300, 220, 220, 30);
		formPur.add(indQuaToPur);

		quantityToPur = new JTextField();
		quantityToPur.setBounds(300, 260, 175, 30);
		MatteBorder borderQuaToPur = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		quantityToPur.setBorder(borderQuaToPur);
		quantityToPur.setOpaque(false);
		quantityToPur.setForeground(Color.WHITE);
		quantityToPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		quantityToPur.setCaretColor(Color.WHITE);
		formPur.add(quantityToPur);

//		boton e indicador

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

	public JTextField getQuantityToPur() {
		return quantityToPur;
	}

	public void setQuantityToPur(JTextField quantityToPur) {
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
