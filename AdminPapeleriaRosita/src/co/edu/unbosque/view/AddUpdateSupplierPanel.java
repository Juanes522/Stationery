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

public class AddUpdateSupplierPanel extends JPanel {

	private JLabel formS, titleRegisterS, titleUpdateS, indNameSup, indPhoneSup, indDirSup, indRegisterSup,
			indUpdateSup;
	private JTextField nameSup, phoneSup, directionSup;
	private JButton registerSup, updateSup, closeSup;

	public AddUpdateSupplierPanel() {

		setBounds(216, 120, 512, 344);
		setLayout(null);
		setBackground(Color.WHITE);

		formS = new JLabel(new ImageIcon("src/Assets/form.png"));
		formS.setBounds(0, 0, 512, 344);
		formS.setLayout(null);
		add(formS);

		titleRegisterS = new JLabel("Registrar Proveedor");
		titleRegisterS.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegisterS.setForeground(Color.WHITE);
		titleRegisterS.setBounds(125, 20, 250, 30);
		formS.add(titleRegisterS).setVisible(false);

		titleUpdateS = new JLabel("Actualizar Proveedor");
		titleUpdateS.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleUpdateS.setForeground(Color.WHITE);
		titleUpdateS.setBounds(125, 20, 280, 30);
		formS.add(titleUpdateS).setVisible(false);

		closeSup = new JButton(new ImageIcon("src/Assets/xwhite.png"));
		closeSup.setBounds(450, 20, 32, 32);
		closeSup.setFocusable(false);
		closeSup.setBorderPainted(false);
		closeSup.setContentAreaFilled(false);
		formS.add(closeSup);

		indNameSup = new JLabel("Nombre del proveedor");
		indNameSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indNameSup.setForeground(Color.WHITE);
		indNameSup.setBounds(40, 80, 220, 30);
		formS.add(indNameSup);

		nameSup = new JTextField();
		nameSup.setBounds(40, 120, 175, 30);
		MatteBorder borderName = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		nameSup.setBorder(borderName);
		nameSup.setOpaque(false);
		nameSup.setForeground(Color.WHITE);
		nameSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		nameSup.setCaretColor(Color.WHITE);
		formS.add(nameSup);

		indPhoneSup = new JLabel("Teléfono");
		indPhoneSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indPhoneSup.setForeground(Color.WHITE);
		indPhoneSup.setBounds(300, 80, 220, 30);
		formS.add(indPhoneSup);

		phoneSup = new JTextField();
		phoneSup.setBounds(300, 120, 175, 30);
		MatteBorder borderPhone = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		phoneSup.setBorder(borderPhone);
		phoneSup.setOpaque(false);
		phoneSup.setForeground(Color.WHITE);
		phoneSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		phoneSup.setCaretColor(Color.WHITE);
		formS.add(phoneSup);

		indDirSup = new JLabel("Dirección");
		indDirSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indDirSup.setForeground(Color.WHITE);
		indDirSup.setBounds(40, 180, 220, 30);
		formS.add(indDirSup);

		directionSup = new JTextField();
		directionSup.setBounds(40, 220, 175, 30);
		MatteBorder borderDir = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		directionSup.setBorder(borderDir);
		directionSup.setOpaque(false);
		directionSup.setForeground(Color.WHITE);
		directionSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		directionSup.setCaretColor(Color.WHITE);
		formS.add(directionSup);

//		botones e indicador

		indRegisterSup = new JLabel("Registrar");
		indRegisterSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indRegisterSup.setForeground(new Color(2, 58, 98));
		indRegisterSup.setBounds(208, 285, 150, 30);
		formS.add(indRegisterSup).setVisible(false);

		indUpdateSup = new JLabel("Actualizar");
		indUpdateSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpdateSup.setForeground(new Color(2, 58, 98));
		indUpdateSup.setBounds(205, 285, 150, 30);
		formS.add(indUpdateSup).setVisible(false);

		registerSup = new JButton(new ImageIcon("src/Assets/register.png"));
		registerSup.setBounds(198, 280, 115, 45);
		registerSup.setFocusable(false);
		registerSup.setBorderPainted(false);
		registerSup.setContentAreaFilled(false);
		formS.add(registerSup).setVisible(false);

		updateSup = new JButton(new ImageIcon("src/Assets/update.png"));
		updateSup.setBounds(195, 280, 123, 45);
		updateSup.setFocusable(false);
		updateSup.setBorderPainted(false);
		updateSup.setContentAreaFilled(false);
		formS.add(updateSup).setVisible(false);
	}

	public JLabel getTitleRegisterS() {
		return titleRegisterS;
	}

	public void setTitleRegisterS(JLabel titleRegisterS) {
		this.titleRegisterS = titleRegisterS;
	}

	public JLabel getTitleUpdateS() {
		return titleUpdateS;
	}

	public void setTitleUpdateS(JLabel titleUpdateS) {
		this.titleUpdateS = titleUpdateS;
	}

	public JLabel getIndRegisterSup() {
		return indRegisterSup;
	}

	public void setIndRegisterSup(JLabel indRegisterSup) {
		this.indRegisterSup = indRegisterSup;
	}

	public JLabel getIndUpdateSup() {
		return indUpdateSup;
	}

	public void setIndUpdateSup(JLabel indUpdateSup) {
		this.indUpdateSup = indUpdateSup;
	}

	public JTextField getNameSup() {
		return nameSup;
	}

	public void setNameSup(JTextField nameSup) {
		this.nameSup = nameSup;
	}

	public JTextField getPhoneSup() {
		return phoneSup;
	}

	public void setPhoneSup(JTextField phoneSup) {
		this.phoneSup = phoneSup;
	}

	public JTextField getDirectionSup() {
		return directionSup;
	}

	public void setDirectionSup(JTextField directionSup) {
		this.directionSup = directionSup;
	}

	public JButton getRegisterSup() {
		return registerSup;
	}

	public void setRegisterSup(JButton registerSup) {
		this.registerSup = registerSup;
	}

	public JButton getUpdateSup() {
		return updateSup;
	}

	public void setUpdateSup(JButton updateSup) {
		this.updateSup = updateSup;
	}

	public JButton getCloseSup() {
		return closeSup;
	}

	public void setCloseSup(JButton closeSup) {
		this.closeSup = closeSup;
	}

}
