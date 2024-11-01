package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PurchasePanel extends JPanel {

	private JList<String> listPurchase;
	private DefaultListModel<String> modelPurchase;
	private JPanel listPurPanel;
	private JLabel indAddPur;
	private JButton addPur;
	private JScrollPane barPur;

	public PurchasePanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		modelPurchase = new DefaultListModel<>();

		listPurchase = new JList<>(modelPurchase);
		listPurchase.setBounds(0, 0, 400, 350);
		listPurchase.setBackground(Color.LIGHT_GRAY);
		listPurchase.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barPur = new JScrollPane(listPurchase);
		barPur.setBounds(0, 0, 400, 350);

		listPurPanel = new JPanel();
		listPurPanel.setLayout(null);
		listPurPanel.setBounds(113, 60, 400, 350);
		listPurPanel.add(barPur);
		add(listPurPanel);

//		boton e indicador
		indAddPur = new JLabel("Realizar Compra");
		indAddPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indAddPur.setForeground(Color.WHITE);
		indAddPur.setBounds(230, 435, 180, 30);
		add(indAddPur);

		addPur = new JButton(new ImageIcon("src/Assets/registerpurchase.png"));
		addPur.setBounds(220, 430, 177, 47);
		addPur.setFocusable(false);
		addPur.setBorderPainted(false);
		addPur.setContentAreaFilled(false);
		add(addPur);

	}

	public JList<String> getListPurchase() {
		return listPurchase;
	}

	public void setListPurchase(JList<String> listPurchase) {
		this.listPurchase = listPurchase;
	}

	public DefaultListModel<String> getModelPurchase() {
		return modelPurchase;
	}

	public void setModelPurchase(DefaultListModel<String> modelPurchase) {
		this.modelPurchase = modelPurchase;
	}

	public JButton getAddPur() {
		return addPur;
	}

	public void setAddPur(JButton addPur) {
		this.addPur = addPur;
	}

}
