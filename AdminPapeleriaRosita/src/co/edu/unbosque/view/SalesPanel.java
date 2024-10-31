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

public class SalesPanel extends JPanel {

	private JList<String> listSales;
	private DefaultListModel<String> modelSales;
	private JPanel listSaPanel;
	private JLabel titleSa, indAddSal, indDelSal, indUpSal;
	private JButton addSa, delSa, upSa;
	private JScrollPane barSa;

	public SalesPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		titleSa = new JLabel("Seleccione venta a eliminar/actualizar");
		titleSa.setBounds(145, 15, 370, 30);
		titleSa.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleSa.setForeground(new Color(2, 58, 98));
		add(titleSa);

		listSales = new JList<>();
		listSales.setBounds(0, 0, 400, 350);
		modelSales = new DefaultListModel<>();
		listSales.setBackground(Color.LIGHT_GRAY);
		listSales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barSa = new JScrollPane(listSales);
		barSa.setBounds(0, 0, 400, 350);

		listSaPanel = new JPanel();
		listSaPanel.setLayout(null);
		listSaPanel.setBounds(113, 60, 400, 350);
		listSaPanel.add(barSa);
		add(listSaPanel);

		indAddSal = new JLabel("Agregar");
		indAddSal.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indAddSal.setForeground(Color.WHITE);
		indAddSal.setBounds(130, 435, 150, 30);
		add(indAddSal);

		indDelSal = new JLabel("Eliminar");
		indDelSal.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indDelSal.setForeground(Color.WHITE);
		indDelSal.setBounds(265, 435, 150, 30);
		add(indDelSal);

		indUpSal = new JLabel("Actualizar");
		indUpSal.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpSal.setForeground(Color.WHITE);
		indUpSal.setBounds(394, 435, 150, 30);
		add(indUpSal);

		addSa = new JButton(new ImageIcon("src/Assets/addblue.png"));
		addSa.setBounds(120, 430, 105, 46);
		addSa.setFocusable(false);
		addSa.setBorderPainted(false);
		addSa.setContentAreaFilled(false);
		add(addSa);

		delSa = new JButton(new ImageIcon("src/Assets/addblue.png"));
		delSa.setBounds(255, 430, 105, 46);
		delSa.setFocusable(false);
		delSa.setBorderPainted(false);
		delSa.setContentAreaFilled(false);
		add(delSa);

		upSa = new JButton(new ImageIcon("src/Assets/updateblue.png"));
		upSa.setBounds(390, 430, 114, 46);
		upSa.setFocusable(false);
		upSa.setBorderPainted(false);
		upSa.setContentAreaFilled(false);
		add(upSa);

	}

	public JList<String> getListSales() {
		return listSales;
	}

	public void setListSales(JList<String> listSales) {
		this.listSales = listSales;
	}

	public DefaultListModel<String> getModelSales() {
		return modelSales;
	}

	public void setModelSales(DefaultListModel<String> modelSales) {
		this.modelSales = modelSales;
	}

	public JButton getAddSa() {
		return addSa;
	}

	public void setAddSa(JButton addSa) {
		this.addSa = addSa;
	}

	public JButton getDelSa() {
		return delSa;
	}

	public void setDelSa(JButton delSa) {
		this.delSa = delSa;
	}

	public JButton getUpSa() {
		return upSa;
	}

	public void setUpSa(JButton upSa) {
		this.upSa = upSa;
	}

}
