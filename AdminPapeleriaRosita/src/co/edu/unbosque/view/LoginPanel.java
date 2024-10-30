package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.MatteBorder;

public class LoginPanel extends JPanel {

	private JTextField userName;
	private JLabel indUser, indPass, box, shadow, title, indButton;
	private JButton join, recoverKey;
	private JPasswordField password;
	private JToggleButton showPass;
	
	private JLabel titleRec, indUserRec, indCancel, indFollow;
	private JTextField userNameRec;
	private JButton cancel, follow;
	
	private JLabel indUserChoose, indQuestion, indAnswer;
	private JTextField answer;
	private JButton checkanswer;

	public LoginPanel() {
		
		setBounds(0, 0, 800, 600);
		setBackground(new Color(11, 161, 187));
		setLayout(null);
	
		
		title = new JLabel("Inicio de Sesión");
		title.setFont(new Font("Leelawadee", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		title.setBounds(250, 30, 370, 45);
		add(title);
		
		box = new JLabel(new ImageIcon("src/Assets/box.png"));
		box.setBounds(200, 70, 400, 400);
		box.setLayout(null);
		add(box);
		
		shadow = new JLabel(new ImageIcon("src/Assets/boxshadow.png"));
		shadow.setBounds(186, 85, 400, 400);
		shadow.setLayout(null);
		add(shadow);
		
		
		indUser = new JLabel("Nombre de Usuario");
		indUser.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUser.setForeground(Color.WHITE);
		indUser.setBounds(50, 60, 220, 30);
		box.add(indUser);
		
		userName = new JTextField();
		userName.setBounds(50, 105, 260, 30);
		MatteBorder border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		userName.setBorder(border);
		userName.setOpaque(false);
		userName.setForeground(Color.WHITE);
		userName.setFont(new Font("Leelawadee", Font.BOLD, 22));
		box.add(userName);
		
		indPass = new JLabel("Contraseña");
		indPass.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indPass.setForeground(Color.WHITE);
		indPass.setBounds(50, 180, 220, 30);
		box.add(indPass);
		
		password = new JPasswordField();
		password.setBounds(50, 225, 260, 30);
		MatteBorder border2 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		password.setBorder(border2);
		password.setOpaque(false);
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Leelawadee", Font.BOLD, 22));
		box.add(password);
		
		showPass = new JToggleButton();
		showPass.setBounds(325, 225, 30, 30);
		showPass.setIcon(new ImageIcon("src/Assets/closedeye.png"));
		showPass.setFocusable(false);
		showPass.setBorderPainted(false);
		showPass.setContentAreaFilled(false);
		box.add(showPass);
		
		indButton = new JLabel("Ingresar");
		indButton.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indButton.setForeground(Color.WHITE);
		indButton.setBounds(155, 296, 150, 30);
		box.add(indButton);
		
		join = new JButton();
		join.setBounds(100, 290, 193, 47);
		join.setIcon(new ImageIcon("src/Assets/join.png"));
		join.setFocusable(false);
		join.setBorderPainted(false);
		join.setContentAreaFilled(false);
		box.add(join);
		
		recoverKey = new JButton("<html><u>recuperar credenciales</u></html>");
		recoverKey.setBounds(250, 480, 270, 47);
		recoverKey.setFocusable(false);
		recoverKey.setBorderPainted(false);
		recoverKey.setContentAreaFilled(false);
		recoverKey.setFont(new Font("Leelawadee", Font.BOLD, 22));
		recoverKey.setForeground(Color.WHITE);
		add(recoverKey);
		
		
//------------------------------------------------------------------------------------------		
		
		titleRec = new JLabel("Recuperación de Cuenta");
		titleRec.setFont(new Font("Leelawadee", Font.BOLD, 40));
		titleRec.setForeground(Color.WHITE);
		titleRec.setBounds(170, 30, 480, 45);
		add(titleRec).setVisible(false);
		
		
		indUserRec = new JLabel("Nombre de Usuario");
		indUserRec.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUserRec.setForeground(Color.WHITE);
		indUserRec.setBounds(50, 140, 220, 30);
		box.add(indUserRec).setVisible(false);
		
		userNameRec = new JTextField();
		userNameRec.setBounds(50, 185, 285, 30);
		MatteBorder borderRec = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		userNameRec.setBorder(borderRec);
		userNameRec.setOpaque(false);
		userNameRec.setForeground(Color.WHITE);
		userNameRec.setFont(new Font("Leelawadee", Font.BOLD, 22));
		box.add(userNameRec).setVisible(false);
		
		indCancel = new JLabel("Cancelar");
		indCancel.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indCancel.setForeground(Color.WHITE);
		indCancel.setBounds(120, 296, 150, 30);
		box.add(indCancel).setVisible(false);
		
		indFollow = new JLabel("Siguiente");
		indFollow.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indFollow.setForeground(Color.WHITE);
		indFollow.setBounds(235, 296, 150, 30);
		box.add(indFollow).setVisible(false);
		
		cancel = new JButton();
		cancel.setBounds(110, 290, 107, 47);
		cancel.setIcon(new ImageIcon("src/Assets/follow.png"));
		cancel.setFocusable(false);
		cancel.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		box.add(cancel).setVisible(false);
		
		follow = new JButton();
		follow.setBounds(230, 290, 107, 47);
		follow.setIcon(new ImageIcon("src/Assets/follow.png"));
		follow.setFocusable(false);
		follow.setBorderPainted(false);
		follow.setContentAreaFilled(false);
		box.add(follow).setVisible(false);
		
		
//---------------------------------------------------------------------------------------
		
		indUserChoose = new JLabel("Pregunta usuario elegido");
		indUserChoose.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUserChoose.setForeground(Color.WHITE);
		indUserChoose.setBounds(50, 95, 280, 30);
		box.add(indUserChoose).setVisible(false);
		
		indQuestion = new JLabel("¿pregunta del usuario?");
		indQuestion.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indQuestion.setForeground(Color.WHITE);
		indQuestion.setBounds(50, 140, 300, 30);
		box.add(indQuestion).setVisible(false);
		
		indAnswer = new JLabel("Respuesta");
		indAnswer.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indAnswer.setForeground(Color.WHITE);
		indAnswer.setBounds(50, 185, 300, 30);
		box.add(indAnswer).setVisible(false);
		
		answer = new JTextField();
		answer.setBounds(50, 230, 285, 30);
		MatteBorder borderans = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		answer.setBorder(borderans);
		answer.setOpaque(false);
		answer.setForeground(Color.WHITE);
		answer.setFont(new Font("Leelawadee", Font.BOLD, 22));
		box.add(answer).setVisible(false);
			
		checkanswer = new JButton();
		checkanswer.setBounds(230, 290, 107, 47);
		checkanswer.setIcon(new ImageIcon("src/Assets/follow.png"));
		checkanswer.setFocusable(false);
		checkanswer.setBorderPainted(false);
		checkanswer.setContentAreaFilled(false);
		box.add(checkanswer).setVisible(false);
		
	}

	public JTextField getUserName() {
		return userName;
	}

	public void setUserName(JTextField userName) {
		this.userName = userName;
	}

	public JLabel getIndUser() {
		return indUser;
	}

	public void setIndUser(JLabel indUser) {
		this.indUser = indUser;
	}

	public JLabel getIndPass() {
		return indPass;
	}

	public void setIndPass(JLabel indPass) {
		this.indPass = indPass;
	}

	public JLabel getBox() {
		return box;
	}

	public void setBox(JLabel box) {
		this.box = box;
	}

	public JLabel getShadow() {
		return shadow;
	}

	public void setShadow(JLabel shadow) {
		this.shadow = shadow;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JLabel getIndButton() {
		return indButton;
	}

	public void setIndButton(JLabel indButton) {
		this.indButton = indButton;
	}

	public JButton getJoin() {
		return join;
	}

	public void setJoin(JButton join) {
		this.join = join;
	}

	public JButton getRecoverKey() {
		return recoverKey;
	}

	public void setRecoverKey(JButton recoverKey) {
		this.recoverKey = recoverKey;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JToggleButton getShowPass() {
		return showPass;
	}

	public void setShowPass(JToggleButton showPass) {
		this.showPass = showPass;
	}

	public JLabel getTitleRec() {
		return titleRec;
	}

	public void setTitleRec(JLabel titleRec) {
		this.titleRec = titleRec;
	}

	public JLabel getIndUserRec() {
		return indUserRec;
	}

	public void setIndUserRec(JLabel indUserRec) {
		this.indUserRec = indUserRec;
	}

	public JLabel getIndCancel() {
		return indCancel;
	}

	public void setIndCancel(JLabel indCancel) {
		this.indCancel = indCancel;
	}

	public JLabel getIndFollow() {
		return indFollow;
	}

	public void setIndFollow(JLabel indFollow) {
		this.indFollow = indFollow;
	}

	public JTextField getUserNameRec() {
		return userNameRec;
	}

	public void setUserNameRec(JTextField userNameRec) {
		this.userNameRec = userNameRec;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JButton getFollow() {
		return follow;
	}

	public void setFollow(JButton follow) {
		this.follow = follow;
	}

	public JLabel getIndUserChoose() {
		return indUserChoose;
	}

	public void setIndUserChoose(JLabel indUserChoose) {
		this.indUserChoose = indUserChoose;
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

	public JTextField getAnswer() {
		return answer;
	}

	public void setAnswer(JTextField answer) {
		this.answer = answer;
	}

	public JButton getCheckanswer() {
		return checkanswer;
	}

	public void setCheckanswer(JButton checkanswer) {
		this.checkanswer = checkanswer;
	}

	
	
}
