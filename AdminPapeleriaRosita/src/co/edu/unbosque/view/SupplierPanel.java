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

public class SupplierPanel extends JPanel {

	private JList<String> listSupplier;
	private DefaultListModel<String> modelSupplier;
	private JPanel listSupPanel;
	private JLabel titleSup, indAddSup, indDelSup, indUpSup;
	private JButton addSup, delSup, upSup;
	private JScrollPane barSup;

	public SupplierPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		titleSup = new JLabel("Seleccione proveedor a eliminar/actualizar");
		titleSup.setBounds(130, 15, 370, 30);
		titleSup.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleSup.setForeground(new Color(2, 58, 98));
		add(titleSup);

		listSupplier = new JList<>();
		listSupplier.setBounds(0, 0, 400, 350);
		modelSupplier = new DefaultListModel<>();
		listSupplier.setBackground(Color.LIGHT_GRAY);
		listSupplier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barSup = new JScrollPane(listSupplier);
		barSup.setBounds(0, 0, 400, 350);

		listSupPanel = new JPanel();
		listSupPanel.setLayout(null);
		listSupPanel.setBounds(113, 60, 400, 350);
		listSupPanel.add(barSup);
		add(listSupPanel);

		indAddSup = new JLabel("Agregar");
		indAddSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indAddSup.setForeground(Color.WHITE);
		indAddSup.setBounds(130, 435, 150, 30);
		add(indAddSup);

		indDelSup = new JLabel("Eliminar");
		indDelSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indDelSup.setForeground(Color.WHITE);
		indDelSup.setBounds(265, 435, 150, 30);
		add(indDelSup);

		indUpSup = new JLabel("Actualizar");
		indUpSup.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpSup.setForeground(Color.WHITE);
		indUpSup.setBounds(394, 435, 150, 30);
		add(indUpSup);

		addSup = new JButton(new ImageIcon("src/Assets/addblue.png"));
		addSup.setBounds(120, 430, 105, 46);
		addSup.setFocusable(false);
		addSup.setBorderPainted(false);
		addSup.setContentAreaFilled(false);
		add(addSup);

		delSup = new JButton(new ImageIcon("src/Assets/addblue.png"));
		delSup.setBounds(255, 430, 105, 46);
		delSup.setFocusable(false);
		delSup.setBorderPainted(false);
		delSup.setContentAreaFilled(false);
		add(delSup);

		upSup = new JButton(new ImageIcon("src/Assets/updateblue.png"));
		upSup.setBounds(390, 430, 114, 46);
		upSup.setFocusable(false);
		upSup.setBorderPainted(false);
		upSup.setContentAreaFilled(false);
		add(upSup);
	}

	public JList<String> getListSupplier() {
		return listSupplier;
	}

	public void setListSupplier(JList<String> listSupplier) {
		this.listSupplier = listSupplier;
	}

	public DefaultListModel<String> getModelSupplier() {
		return modelSupplier;
	}

	public void setModelSupplier(DefaultListModel<String> modelSupplier) {
		this.modelSupplier = modelSupplier;
	}

	public JButton getAddSup() {
		return addSup;
	}

	public void setAddSup(JButton addSup) {
		this.addSup = addSup;
	}

	public JButton getDelSup() {
		return delSup;
	}

	public void setDelSup(JButton delSup) {
		this.delSup = delSup;
	}

	public JButton getUpSup() {
		return upSup;
	}

	public void setUpSup(JButton upSup) {
		this.upSup = upSup;
	}

}
