package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class AddUpdateUserControlPanel extends JPanel {

	private JLabel formU, titleRegisterU, titleUpdateU, indNameUs, indPassUs, indIsAdmin, indQuestion, indAnswer, indRegisterUs, indUpdateUs;
	private JTextField nameUser, passUser, questionUser, answerUser;
	private JButton registerUser, updateUser, closeUser;
	private JRadioButton isAdmin, notAdmin;
	private ButtonGroup rol;

	public AddUpdateUserControlPanel() {

		setBounds(216, 120, 513, 382);
		setLayout(null);
		setBackground(Color.WHITE);

		formU = new JLabel(new ImageIcon("src/Assets/bigform.png"));
		formU.setBounds(0, 0, 513, 382);
		formU.setLayout(null);
		add(formU);

		titleRegisterU = new JLabel("Registrar Usuario");
		titleRegisterU.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegisterU.setForeground(Color.WHITE);
		titleRegisterU.setBounds(145, 20, 250, 30);
		formU.add(titleRegisterU).setVisible(false);

		titleUpdateU = new JLabel("Actualizar Usuario");
		titleUpdateU.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleUpdateU.setForeground(Color.WHITE);
		titleUpdateU.setBounds(145, 20, 280, 30);
		formU.add(titleUpdateU).setVisible(false);

		closeUser = new JButton(new ImageIcon("src/Assets/xwhite.png"));
		closeUser.setBounds(450, 20, 32, 32);
		closeUser.setFocusable(false);
		closeUser.setBorderPainted(false);
		closeUser.setContentAreaFilled(false);
		formU.add(closeUser);

		indNameUs = new JLabel("Nombre de usuario");
		indNameUs.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indNameUs.setForeground(Color.WHITE);
		indNameUs.setBounds(30, 60, 220, 30);
		formU.add(indNameUs);

		nameUser = new JTextField();
		nameUser.setBounds(30, 100, 175, 30);
		MatteBorder borderName = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		nameUser.setBorder(borderName);
		nameUser.setOpaque(false);
		nameUser.setForeground(Color.WHITE);
		nameUser.setFont(new Font("Leelawadee", Font.BOLD, 20));
		nameUser.setCaretColor(Color.WHITE);
		formU.add(nameUser);

		indPassUs = new JLabel("Contraseña");
		indPassUs.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indPassUs.setForeground(Color.WHITE);
		indPassUs.setBounds(290, 60, 220, 30);
		formU.add(indPassUs);

		passUser = new JTextField();
		passUser.setBounds(290, 100, 175, 30);
		MatteBorder borderPhone = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		passUser.setBorder(borderPhone);
		passUser.setOpaque(false);
		passUser.setForeground(Color.WHITE);
		passUser.setFont(new Font("Leelawadee", Font.BOLD, 20));
		passUser.setCaretColor(Color.WHITE);
		formU.add(passUser);

		indIsAdmin = new JLabel("Es Administrador?");
		indIsAdmin.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indIsAdmin.setForeground(Color.WHITE);
		indIsAdmin.setBounds(30, 140, 220, 30);
		formU.add(indIsAdmin);

		isAdmin = new JRadioButton("Sí");
		isAdmin.setFocusPainted(false);
		isAdmin.setBounds(30, 180, 50, 30);
		isAdmin.setForeground(Color.WHITE);
		isAdmin.setContentAreaFilled(false);
		isAdmin.setBackground(new Color(2, 58, 98));
		isAdmin.setFont(new Font("Leelawadee", Font.BOLD, 20));
		isAdmin.setBorderPainted(false);
		formU.add(isAdmin);

		notAdmin = new JRadioButton("No");
		notAdmin.setFocusPainted(false);
		notAdmin.setBounds(150, 180, 60, 30);
		notAdmin.setForeground(Color.WHITE);
		notAdmin.setContentAreaFilled(false);
		notAdmin.setBackground(new Color(2, 58, 98));
		notAdmin.setFont(new Font("Leelawadee", Font.BOLD, 20));
		notAdmin.setBorderPainted(false);
		formU.add(notAdmin);
		
		rol = new ButtonGroup();
		rol.add(isAdmin);
		rol.add(notAdmin);
		rol.clearSelection();
		notAdmin.setSelected(true);

		indQuestion = new JLabel("Pregunta de usuario");
		indQuestion.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indQuestion.setForeground(Color.WHITE);
		indQuestion.setBounds(290, 140, 220, 30);
		formU.add(indQuestion);
		
		questionUser = new JTextField();
		questionUser.setBounds(290, 180, 175, 30);
		MatteBorder borderQ = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		questionUser.setBorder(borderQ);
		questionUser.setOpaque(false);
		questionUser.setForeground(Color.WHITE);
		questionUser.setFont(new Font("Leelawadee", Font.BOLD, 20));
		questionUser.setCaretColor(Color.WHITE);
		formU.add(questionUser);
		
		indAnswer = new JLabel("Respuesta de la pregunta");
		indAnswer.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indAnswer.setForeground(Color.WHITE);
		indAnswer.setBounds(30, 220, 260, 30);
		formU.add(indAnswer);
		
		answerUser = new JTextField();
		answerUser.setBounds(30, 260, 175, 30);
		MatteBorder borderA = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		answerUser.setBorder(borderA);
		answerUser.setOpaque(false);
		answerUser.setForeground(Color.WHITE);
		answerUser.setFont(new Font("Leelawadee", Font.BOLD, 20));
		answerUser.setCaretColor(Color.WHITE);
		formU.add(answerUser);
		
//		botones e indicador

		indRegisterUs = new JLabel("Registrar");
		indRegisterUs.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indRegisterUs.setForeground(new Color(2, 58, 98));
		indRegisterUs.setBounds(208, 325, 150, 30);
		formU.add(indRegisterUs).setVisible(false);

		indUpdateUs = new JLabel("Actualizar");
		indUpdateUs.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpdateUs.setForeground(new Color(2, 58, 98));
		indUpdateUs.setBounds(205, 325, 150, 30);
		formU.add(indUpdateUs).setVisible(false);

		registerUser = new JButton(new ImageIcon("src/Assets/register.png"));
		registerUser.setBounds(198, 320, 115, 45);
		registerUser.setFocusable(false);
		registerUser.setBorderPainted(false);
		registerUser.setContentAreaFilled(false);
		formU.add(registerUser).setVisible(false);

		updateUser = new JButton(new ImageIcon("src/Assets/update.png"));
		updateUser.setBounds(195, 320, 123, 45);
		updateUser.setFocusable(false);
		updateUser.setBorderPainted(false);
		updateUser.setContentAreaFilled(false);
		formU.add(updateUser).setVisible(false);

	}

	public JLabel getTitleRegisterU() {
		return titleRegisterU;
	}

	public void setTitleRegisterU(JLabel titleRegisterU) {
		this.titleRegisterU = titleRegisterU;
	}

	public JLabel getTitleUpdateU() {
		return titleUpdateU;
	}

	public void setTitleUpdateU(JLabel titleUpdateU) {
		this.titleUpdateU = titleUpdateU;
	}

	public JLabel getIndRegisterUs() {
		return indRegisterUs;
	}

	public void setIndRegisterUs(JLabel indRegisterUs) {
		this.indRegisterUs = indRegisterUs;
	}

	public JLabel getIndUpdateUs() {
		return indUpdateUs;
	}

	public void setIndUpdateUs(JLabel indUpdateUs) {
		this.indUpdateUs = indUpdateUs;
	}

	public JTextField getNameUser() {
		return nameUser;
	}

	public void setNameUser(JTextField nameUser) {
		this.nameUser = nameUser;
	}

	public JTextField getPassUser() {
		return passUser;
	}

	public void setPassUser(JTextField passUser) {
		this.passUser = passUser;
	}

	public JButton getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(JButton registerUser) {
		this.registerUser = registerUser;
	}

	public JButton getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(JButton updateUser) {
		this.updateUser = updateUser;
	}

	public JButton getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(JButton closeUser) {
		this.closeUser = closeUser;
	}

	public JRadioButton getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(JRadioButton isAdmin) {
		this.isAdmin = isAdmin;
	}

	public JRadioButton getNotAdmin() {
		return notAdmin;
	}

	public void setNotAdmin(JRadioButton notAdmin) {
		this.notAdmin = notAdmin;
	}

	public ButtonGroup getRol() {
		return rol;
	}

	public void setRol(ButtonGroup rol) {
		this.rol = rol;
	}

	public JLabel getFormU() {
		return formU;
	}

	public void setFormU(JLabel formU) {
		this.formU = formU;
	}

	public JLabel getIndNameUs() {
		return indNameUs;
	}

	public void setIndNameUs(JLabel indNameUs) {
		this.indNameUs = indNameUs;
	}

	public JLabel getIndPassUs() {
		return indPassUs;
	}

	public void setIndPassUs(JLabel indPassUs) {
		this.indPassUs = indPassUs;
	}

	public JLabel getIndIsAdmin() {
		return indIsAdmin;
	}

	public void setIndIsAdmin(JLabel indIsAdmin) {
		this.indIsAdmin = indIsAdmin;
	}

	public JLabel getIndQuestion() {
		return indQuestion;
	}

	public void setIndQuestion(JLabel indQuestion) {
		this.indQuestion = indQuestion;
	}

	public JLabel getIndAnswer() {
		return indAnswer;
	}

	public void setIndAnswer(JLabel indAnswer) {
		this.indAnswer = indAnswer;
	}

	public JTextField getQuestionUser() {
		return questionUser;
	}

	public void setQuestionUser(JTextField questionUser) {
		this.questionUser = questionUser;
	}

	public JTextField getAnswerUser() {
		return answerUser;
	}

	public void setAnswerUser(JTextField answerUser) {
		this.answerUser = answerUser;
	}
	
	

}
