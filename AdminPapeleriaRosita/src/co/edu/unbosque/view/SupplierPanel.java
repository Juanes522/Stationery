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
 * La clase {@code SupplierPanel} representa el panel de proveedores dentro de
 * la interfaz gráfica de usuario (GUI). Este panel permite al usuario
 * visualizar una lista de proveedores, así como realizar acciones sobre ellos,
 * como agregar, eliminar o actualizar.
 * <p>
 * El panel contiene una tabla con la lista de proveedores, junto con botones y
 * etiquetas que permiten al usuario interactuar con los datos de los
 * proveedores.
 * </p>
 * <p>
 * El panel está diseñado para ofrecer una manera sencilla y clara de gestionar
 * la información de los proveedores en la aplicación.
 * </p>
 * 
 * @see JPanel
 * @see JTable
 * @see JScrollPane
 */
public class SupplierPanel extends JPanel {

	private JTable listSupplier;
	private JPanel listSupPanel;
	private JLabel titleSup, indAddSup, indDelSup, indUpSup;
	private JButton addSup, delSup, upSup;
	private JScrollPane barSup;

	/**
	 * Constructor que inicializa todos los componentes del panel de proveedores.
	 * Establece los límites, los colores de fondo, los iconos de los botones y las
	 * etiquetas que describen las acciones posibles.
	 */
	public SupplierPanel() {
		// Establece el diseño y el color de fondo para el panel principal.
		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		// Inicializa la etiqueta de título para la acción de eliminar o actualizar
		// proveedor.
		titleSup = new JLabel("Seleccione proveedor a eliminar/actualizar");
		titleSup.setBounds(130, 15, 370, 30);
		titleSup.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleSup.setForeground(new Color(2, 58, 98));
		add(titleSup);

		// Inicializa la tabla de proveedores con un fondo gris y una selección única
		// por fila.
		listSupplier = new JTable();
		listSupplier.setBounds(0, 0, 400, 350);
		listSupplier.setBackground(Color.LIGHT_GRAY);
		listSupplier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSupplier.getTableHeader().setReorderingAllowed(false);

		// Inicializa la barra de desplazamiento para la tabla de proveedores.
		barSup = new JScrollPane(listSupplier);
		barSup.setBounds(0, 0, 400, 350);

		// Inicializa el panel que contiene la barra de desplazamiento.
		listSupPanel = new JPanel();
		listSupPanel.setLayout(null);
		listSupPanel.setBounds(113, 60, 400, 350);
		listSupPanel.add(barSup);
		add(listSupPanel);

		// Inicializa las etiquetas para las acciones de agregar, eliminar y actualizar
		// proveedor.
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

		// Inicializa los botones para agregar, eliminar y actualizar proveedor con
		// iconos.
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

	/**
	 * Llena la tabla de proveedores con la información proporcionada.
	 * 
	 * @param information un arreglo bidimensional que contiene la información de
	 *                    los proveedores. Cada fila debe contener los datos del
	 *                    proveedor, como ID, nombre, dirección y teléfono.
	 */
	public void fillTable(String[][] information) {
		DefaultTableModel model = new DefaultTableModel(information,
				new String[] { "ID", "Nombre", "Direccion", "Telefono" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		listSupplier.setModel(model);
	}

	// Métodos getter y setter para los atributos del panel.

	public JTable getListSupplier() {
		return listSupplier;
	}

	public void setListSupplier(JTable listSupplier) {
		this.listSupplier = listSupplier;
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
