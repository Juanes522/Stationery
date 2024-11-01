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

public class InventoryPanel extends JPanel {

	private JList<String> listInventory;
	private DefaultListModel<String> modelInventory;
	private JPanel listInPanel;
	private JLabel titleIn, indAddP, indDelP, indUpP;
	private JButton addPro, delPro, upPro;
	private JScrollPane barIn;

	public InventoryPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		titleIn = new JLabel("Seleccione material a eliminar/actualizar");
		titleIn.setBounds(130, 15, 370, 30);
		titleIn.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleIn.setForeground(new Color(2, 58, 98));
		add(titleIn);

		modelInventory = new DefaultListModel<>();

		listInventory = new JList<>(modelInventory);
		listInventory.setBounds(0, 0, 400, 350);
		listInventory.setBackground(Color.LIGHT_GRAY);
		listInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barIn = new JScrollPane(listInventory);
		barIn.setBounds(0, 0, 400, 350);

		listInPanel = new JPanel();
		listInPanel.setLayout(null);
		listInPanel.setBounds(113, 60, 400, 350);
		listInPanel.add(barIn);
		add(listInPanel);

		indAddP = new JLabel("Agregar");
		indAddP.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indAddP.setForeground(Color.WHITE);
		indAddP.setBounds(130, 435, 150, 30);
		add(indAddP);

		indDelP = new JLabel("Eliminar");
		indDelP.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indDelP.setForeground(Color.WHITE);
		indDelP.setBounds(265, 435, 150, 30);
		add(indDelP);

		indUpP = new JLabel("Actualizar");
		indUpP.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpP.setForeground(Color.WHITE);
		indUpP.setBounds(394, 435, 150, 30);
		add(indUpP);

		addPro = new JButton(new ImageIcon("src/Assets/addblue.png"));
		addPro.setBounds(120, 430, 105, 46);
		addPro.setFocusable(false);
		addPro.setBorderPainted(false);
		addPro.setContentAreaFilled(false);
		add(addPro);

		delPro = new JButton(new ImageIcon("src/Assets/addblue.png"));
		delPro.setBounds(255, 430, 105, 46);
		delPro.setFocusable(false);
		delPro.setBorderPainted(false);
		delPro.setContentAreaFilled(false);
		add(delPro);

		upPro = new JButton(new ImageIcon("src/Assets/updateblue.png"));
		upPro.setBounds(390, 430, 114, 46);
		upPro.setFocusable(false);
		upPro.setBorderPainted(false);
		upPro.setContentAreaFilled(false);
		add(upPro);

	}

	public JList<String> getListInventory() {
		return listInventory;
	}

	public void setListInventory(JList<String> listInventory) {
		this.listInventory = listInventory;
	}

	public DefaultListModel<String> getModelInventory() {
		return modelInventory;
	}

	public void setModelInventory(DefaultListModel<String> modelInventory) {
		this.modelInventory = modelInventory;
	}

	public JButton getAddPro() {
		return addPro;
	}

	public void setAddPro(JButton addPro) {
		this.addPro = addPro;
	}

	public JButton getDelPro() {
		return delPro;
	}

	public void setDelPro(JButton delPro) {
		this.delPro = delPro;
	}

	public JButton getUpPro() {
		return upPro;
	}

	public void setUpPro(JButton upPro) {
		this.upPro = upPro;
	}

	public JLabel getIndAddP() {
		return indAddP;
	}

	public void setIndAddP(JLabel indAddP) {
		this.indAddP = indAddP;
	}

	public JLabel getIndDelP() {
		return indDelP;
	}

	public void setIndDelP(JLabel indDelP) {
		this.indDelP = indDelP;
	}

	public JLabel getIndUpP() {
		return indUpP;
	}

	public void setIndUpP(JLabel indUpP) {
		this.indUpP = indUpP;
	}

	public JLabel getTitleIn() {
		return titleIn;
	}

	public void setTitleIn(JLabel titleIn) {
		this.titleIn = titleIn;
	}
	
	

}
