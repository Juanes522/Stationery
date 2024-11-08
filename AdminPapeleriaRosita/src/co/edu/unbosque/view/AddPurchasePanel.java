package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

public class AddPurchasePanel extends JPanel {

	private JLabel formPrePur, indTotalPur, indRegisterPur, indEndPur, indChooseProPur;
	private JTextField totalPurchase;
	private JButton registerPur, endPur, closePur;
	private JTable productsListPur;
	private JPanel listPurPanel;
	private JScrollPane barPur;

	public AddPurchasePanel() {

		setBounds(202, 70, 540, 450);
		setLayout(null);
		setBackground(Color.WHITE);

		formPrePur = new JLabel(new ImageIcon("src/Assets/largeform.png"));
		formPrePur.setBounds(319, 108, 221, 342);
		formPrePur.setLayout(null);
		add(formPrePur);

		indTotalPur = new JLabel("Total a pagar");
		indTotalPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indTotalPur.setForeground(Color.WHITE);
		indTotalPur.setBounds(45, 10, 220, 30);
		formPrePur.add(indTotalPur);

		totalPurchase = new JTextField();
		totalPurchase.setBounds(23, 50, 175, 30);
		MatteBorder borderTotal = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		totalPurchase.setBorder(borderTotal);
		totalPurchase.setOpaque(false);
		totalPurchase.setForeground(Color.WHITE);
		totalPurchase.setFont(new Font("Leelawadee", Font.BOLD, 20));
		totalPurchase.setEditable(false);
		formPrePur.add(totalPurchase);

//		botones e indicador

		indRegisterPur = new JLabel("Realizar compra");
		indRegisterPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indRegisterPur.setForeground(new Color(2, 58, 98));
		indRegisterPur.setBounds(35, 137, 160, 30);
		formPrePur.add(indRegisterPur);

		indEndPur = new JLabel("Terminar compra");
		indEndPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indEndPur.setForeground(new Color(2, 58, 98));
		indEndPur.setBounds(30, 237, 170, 30);
		formPrePur.add(indEndPur);

		registerPur = new JButton(new ImageIcon("src/Assets/registersale.png"));
		registerPur.setBounds(23, 130, 177, 47);
		registerPur.setFocusable(false);
		registerPur.setBorderPainted(false);
		registerPur.setContentAreaFilled(false);
		formPrePur.add(registerPur);

		endPur = new JButton(new ImageIcon("src/Assets/registersale.png"));
		endPur.setBounds(23, 230, 177, 47);
		endPur.setFocusable(false);
		endPur.setBorderPainted(false);
		endPur.setContentAreaFilled(false);
		formPrePur.add(endPur);

		closePur = new JButton(new ImageIcon("src/Assets/xblue.png"));
		closePur.setBounds(510, 5, 32, 32);
		closePur.setFocusable(false);
		closePur.setBorderPainted(false);
		closePur.setContentAreaFilled(false);
		add(closePur);

//		-----------------

		indChooseProPur = new JLabel("Seleccione productos");
		indChooseProPur.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indChooseProPur.setForeground(new Color(2, 58, 98));
		indChooseProPur.setBounds(25, 70, 250, 30);
		add(indChooseProPur);


		productsListPur = new JTable();
		productsListPur.setBounds(0, 0, 270, 342);
		productsListPur.setBackground(Color.LIGHT_GRAY);
		productsListPur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barPur = new JScrollPane(productsListPur);
		barPur.setBounds(0, 0, 270, 342);

		listPurPanel = new JPanel();
		listPurPanel.setLayout(null);
		listPurPanel.setBounds(0, 108, 270, 342);
		listPurPanel.add(barPur);
		add(listPurPanel);

	}

	public JTextField getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(JTextField totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public JButton getRegisterPur() {
		return registerPur;
	}

	public void setRegisterPur(JButton registerPur) {
		this.registerPur = registerPur;
	}

	public JButton getEndPur() {
		return endPur;
	}

	public void setEndPur(JButton endPur) {
		this.endPur = endPur;
	}

	public JButton getClosePur() {
		return closePur;
	}

	public void setClosePur(JButton closePur) {
		this.closePur = closePur;
	}

	public JTable getProductsListPur() {
		return productsListPur;
	}

	public void setProductsListPur(JTable productsListPur) {
		this.productsListPur = productsListPur;
	}

}
