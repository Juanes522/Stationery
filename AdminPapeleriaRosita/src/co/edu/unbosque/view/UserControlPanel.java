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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UserControlPanel extends JPanel {

	private JTable listUser;
	private JPanel listUserPanel;
	private JLabel titleUser, indAddUser, indDelUser, indUpUser;
	private JButton addUser, delUser, upUser;
	private JScrollPane barUser;

	public UserControlPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		titleUser = new JLabel("Seleccione usuario a eliminar/actualizar");
		titleUser.setBounds(138, 15, 370, 30);
		titleUser.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleUser.setForeground(new Color(2, 58, 98));
		add(titleUser);

		listUser = new JTable();
		listUser.setBounds(0, 0, 400, 350);
		listUser.setBackground(Color.LIGHT_GRAY);
		listUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barUser = new JScrollPane(listUser);
		barUser.setBounds(0, 0, 400, 350);

		listUserPanel = new JPanel();
		listUserPanel.setLayout(null);
		listUserPanel.setBounds(113, 60, 400, 350);
		listUserPanel.add(barUser);
		add(listUserPanel);

		indAddUser = new JLabel("Agregar");
		indAddUser.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indAddUser.setForeground(Color.WHITE);
		indAddUser.setBounds(130, 435, 150, 30);
		add(indAddUser);

		indDelUser = new JLabel("Eliminar");
		indDelUser.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indDelUser.setForeground(Color.WHITE);
		indDelUser.setBounds(265, 435, 150, 30);
		add(indDelUser);

		indUpUser = new JLabel("Actualizar");
		indUpUser.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indUpUser.setForeground(Color.WHITE);
		indUpUser.setBounds(394, 435, 150, 30);
		add(indUpUser);

		addUser = new JButton(new ImageIcon("src/Assets/addblue.png"));
		addUser.setBounds(120, 430, 105, 46);
		addUser.setFocusable(false);
		addUser.setBorderPainted(false);
		addUser.setContentAreaFilled(false);
		add(addUser);

		delUser = new JButton(new ImageIcon("src/Assets/addblue.png"));
		delUser.setBounds(255, 430, 105, 46);
		delUser.setFocusable(false);
		delUser.setBorderPainted(false);
		delUser.setContentAreaFilled(false);
		add(delUser);

		upUser = new JButton(new ImageIcon("src/Assets/updateblue.png"));
		upUser.setBounds(390, 430, 114, 46);
		upUser.setFocusable(false);
		upUser.setBorderPainted(false);
		upUser.setContentAreaFilled(false);
		add(upUser);

	}
	
	public void fillTable(String[][] information) {
		DefaultTableModel model=new DefaultTableModel(information,new String[]{"ID","Usuario","	Contraseña","Pregunta","Respuesta","Rol"}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		listUser.setModel(model);
	}

	public JTable getListUser() {
		return listUser;
	}

	public void setListUser(JTable listUser) {
		this.listUser = listUser;
	}

	public JPanel getListUserPanel() {
		return listUserPanel;
	}

	public void setListUserPanel(JPanel listUserPanel) {
		this.listUserPanel = listUserPanel;
	}

	public JButton getAddUser() {
		return addUser;
	}

	public void setAddUser(JButton addUser) {
		this.addUser = addUser;
	}

	public JButton getDelUser() {
		return delUser;
	}

	public void setDelUser(JButton delUser) {
		this.delUser = delUser;
	}

	public JButton getUpUser() {
		return upUser;
	}

	public void setUpUser(JButton upUser) {
		this.upUser = upUser;
	}

}
