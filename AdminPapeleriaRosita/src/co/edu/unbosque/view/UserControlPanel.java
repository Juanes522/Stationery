package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * La clase {@code UserControlPanel} representa un panel de control para la
 * gestión de usuarios dentro de la interfaz gráfica de usuario (GUI). Este
 * panel permite al usuario visualizar, agregar, eliminar o actualizar los datos
 * de los usuarios en el sistema.
 * <p>
 * El panel incluye una tabla con la lista de usuarios, así como botones para
 * agregar, eliminar o actualizar la información de los usuarios.
 * </p>
 * <p>
 * Está diseñado para facilitar la administración de los usuarios de una
 * aplicación mediante una interfaz amigable y fácil de usar.
 * </p>
 * 
 * @see JPanel
 * @see JTable
 * @see JScrollPane
 */
public class UserControlPanel extends JPanel {

	private JTable listUser;
	private JPanel listUserPanel;
	private JLabel titleUser, indAddUser, indDelUser, indUpUser;
	private JButton addUser, delUser, upUser;
	private JScrollPane barUser;

	/**
	 * Constructor que inicializa todos los componentes del panel de control de
	 * usuarios. Establece los límites, colores de fondo, iconos de los botones y
	 * las etiquetas para las acciones de los usuarios.
	 */
	public UserControlPanel() {
		// Establece el diseño y el color de fondo para el panel principal.
		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		// Inicializa la etiqueta de título para la acción de eliminar o actualizar
		// usuario.
		titleUser = new JLabel("Seleccione usuario a eliminar/actualizar");
		titleUser.setBounds(138, 15, 370, 30);
		titleUser.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleUser.setForeground(new Color(2, 58, 98));
		add(titleUser);

		// Inicializa la tabla de usuarios con un fondo gris y una selección única por
		// fila.
		listUser = new JTable();
		listUser.setBounds(0, 0, 400, 350);
		listUser.setBackground(Color.LIGHT_GRAY);
		listUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUser.getTableHeader().setReorderingAllowed(false);

		// Inicializa la barra de desplazamiento para la tabla de usuarios.
		barUser = new JScrollPane(listUser);
		barUser.setBounds(0, 0, 400, 350);

		// Inicializa el panel que contiene la barra de desplazamiento.
		listUserPanel = new JPanel();
		listUserPanel.setLayout(null);
		listUserPanel.setBounds(113, 60, 400, 350);
		listUserPanel.add(barUser);
		add(listUserPanel);

		// Inicializa las etiquetas para las acciones de agregar, eliminar y actualizar
		// usuario.
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

		// Inicializa los botones para agregar, eliminar y actualizar usuario con
		// iconos.
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

	/**
	 * Llena la tabla de usuarios con la información proporcionada.
	 * 
	 * @param information un arreglo bidimensional que contiene la información de
	 *                    los usuarios. Cada fila debe contener los datos del
	 *                    usuario, como ID, nombre de usuario, contraseña, pregunta
	 *                    de seguridad, respuesta y rol.
	 */
	public void fillTable(String[][] information) {
		DefaultTableModel model = new DefaultTableModel(information,
				new String[] { "ID", "Usuario", "Contraseña", "Pregunta", "Respuesta", "Rol" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Evita la edición de celdas en la tabla.
			}
		};
		listUser.setModel(model); // Establece el modelo de la tabla con la información proporcionada.
	}

	// Métodos getter y setter para los atributos del panel.

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
