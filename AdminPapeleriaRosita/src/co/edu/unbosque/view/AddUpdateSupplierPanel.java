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

public class AddUpdateSupplierPanel extends JPanel{
	
	private JLabel form, titleRegister, titleUpdate ,indNameSup, indPhoneSup, indDirSup, indRegisterSup, indUpdateSup;
	private JTextField nameSup, phoneSup, directionSup;
	private JButton registerSup, updateSup, close;

	public AddUpdateSupplierPanel() {
		
		setBounds(216, 120, 512, 344);
		setLayout(null);
		setBackground(Color.WHITE);
		
		form = new JLabel(new ImageIcon("src/Assets/form.png"));
		form.setBounds(0, 0, 512, 344);
		form.setLayout(null);
		add(form);
		
		titleRegister = new JLabel("Registrar Proveedor");
		titleRegister.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegister.setForeground(Color.WHITE);
		titleRegister.setBounds(125, 20, 250, 30);
		form.add(titleRegister).setVisible(false);
		
		titleUpdate = new JLabel("Actualizar Proveedor");
		titleUpdate.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleUpdate.setForeground(Color.WHITE);
		titleUpdate.setBounds(125, 20, 280, 30);
		form.add(titleUpdate).setVisible(false);
		
		close = new JButton(new ImageIcon("src/Assets/xwhite.png"));
		close.setBounds(450, 20, 32, 32);
		close.setFocusable(false);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		form.add(close);
	
		indNameSup = new JLabel("Nombre del proveedor");
		indNameSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indNameSup.setForeground(Color.WHITE);
		indNameSup.setBounds(40, 80, 220, 30);
		form.add(indNameSup);
		
		nameSup = new JTextField();
		nameSup.setBounds(40, 120, 175, 30);
		MatteBorder borderName = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		nameSup.setBorder(borderName);
		nameSup.setOpaque(false);
		nameSup.setForeground(Color.WHITE);
		nameSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		form.add(nameSup);
		
		indPhoneSup = new JLabel("Teléfono");
		indPhoneSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indPhoneSup.setForeground(Color.WHITE);
		indPhoneSup.setBounds(300, 80, 220, 30);
		form.add(indPhoneSup);
		
		phoneSup = new JTextField();
		phoneSup.setBounds(300, 120, 175, 30);
		MatteBorder borderPhone = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		phoneSup.setBorder(borderPhone);
		phoneSup.setOpaque(false);
		phoneSup.setForeground(Color.WHITE);
		phoneSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		form.add(phoneSup);
	
		indDirSup = new JLabel("Dirección");
		indDirSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indDirSup.setForeground(Color.WHITE);
		indDirSup.setBounds(40, 180, 220, 30);
		form.add(indDirSup);
		
		directionSup = new JTextField();
		directionSup.setBounds(40, 220, 175, 30);
		MatteBorder borderDir = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		directionSup.setBorder(borderDir);
		directionSup.setOpaque(false);
		directionSup.setForeground(Color.WHITE);
		directionSup.setFont(new Font("Leelawadee", Font.BOLD, 20));
		form.add(directionSup);
		
		
//		botones e indicador
		
		indRegisterSup = new JLabel("Registrar");
		indRegisterSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indRegisterSup.setForeground(new Color(2,58,98));
		indRegisterSup.setBounds(208, 285, 150, 30);
		form.add(indRegisterSup).setVisible(false);
		
		indUpdateSup = new JLabel("Actualizar");
		indUpdateSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpdateSup.setForeground(new Color(2,58,98));
		indUpdateSup.setBounds(205, 285, 150, 30);
		form.add(indUpdateSup).setVisible(false);
		
		registerSup = new JButton(new ImageIcon("src/Assets/register.png"));
		registerSup.setBounds(198, 280, 115, 45);
		registerSup.setFocusable(false);
		registerSup.setBorderPainted(false);
		registerSup.setContentAreaFilled(false);
		form.add(registerSup).setVisible(false);
		
		updateSup = new JButton(new ImageIcon("src/Assets/update.png"));
		updateSup.setBounds(195, 280, 123, 45);
		updateSup.setFocusable(false);
		updateSup.setBorderPainted(false);
		updateSup.setContentAreaFilled(false);
		form.add(updateSup).setVisible(false);
	}

	public JLabel getTitleRegister() {
		return titleRegister;
	}

	public void setTitleRegister(JLabel titleRegister) {
		this.titleRegister = titleRegister;
	}

	public JLabel getTitleUpdate() {
		return titleUpdate;
	}

	public void setTitleUpdate(JLabel titleUpdate) {
		this.titleUpdate = titleUpdate;
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

	public JButton getClose() {
		return close;
	}

	public void setClose(JButton close) {
		this.close = close;
	}
	
	
}
