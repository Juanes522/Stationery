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

/**
 * Representa el panel de inventario de la aplicación. Este panel permite
 * visualizar y administrar los productos del inventario, incluyendo su
 * información y la capacidad de agregar, eliminar o actualizar productos.
 * 
 * <p>
 * El panel está compuesto por:
 * </p>
 * <ul>
 * <li>Una tabla para mostrar los productos del inventario con información
 * detallada.</li>
 * <li>Botones para agregar, eliminar o actualizar productos en el
 * inventario.</li>
 * <li>Etiquetas descriptivas que indican la acción de cada botón.</li>
 * </ul>
 */
public class InventoryPanel extends JPanel {

	// Componentes gráficos
	private JTable listInventory;
	private JPanel listInPanel;
	private JLabel titleIn, indAddP, indDelP, indUpP;
	private JButton addPro, delPro, upPro;
	private JScrollPane barIn;

	/**
	 * Constructor de la clase InventoryPanel. Este constructor inicializa los
	 * componentes gráficos del panel, incluidos los elementos de la tabla y los
	 * botones de acción. Se establece el tamaño, diseño y los iconos de los botones
	 * correspondientes para agregar, eliminar y actualizar productos.
	 */
	public InventoryPanel() {

		// Configuración del panel principal
		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		// Título para indicar la acción a realizar
		titleIn = new JLabel("Seleccione material a eliminar/actualizar");
		titleIn.setBounds(130, 15, 370, 30);
		titleIn.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleIn.setForeground(new Color(2, 58, 98));
		add(titleIn);

		// Inicialización de la tabla para mostrar los productos del inventario
		listInventory = new JTable();
		listInventory.setBounds(0, 0, 400, 350);
		listInventory.setBackground(Color.LIGHT_GRAY);
		listInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listInventory.getTableHeader().setReorderingAllowed(false);

		// Barra de desplazamiento para la tabla
		barIn = new JScrollPane(listInventory);
		barIn.setBounds(0, 0, 400, 350);

		// Panel para contener la tabla y la barra de desplazamiento
		listInPanel = new JPanel();
		listInPanel.setLayout(null);
		listInPanel.setBounds(113, 60, 400, 350);
		listInPanel.add(barIn);
		add(listInPanel);

		// Etiquetas para los botones de acción
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

		// Botones para agregar, eliminar y actualizar productos
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

	/**
	 * Rellena la tabla de inventario con la información proporcionada. La tabla se
	 * configura con una estructura que contiene las columnas "ID", "Nombre",
	 * "Precio", "Costo", "Cantidad" y "Proveedor".
	 * 
	 * @param information Datos a mostrar en la tabla. Se espera una matriz
	 *                    bidimensional de cadenas, donde cada fila representa un
	 *                    producto y su información correspondiente.
	 */
	public void fillTable(String[][] information) {
		DefaultTableModel model = new DefaultTableModel(information,
				new String[] { "ID", "Nombre", "Precio", "Costo", "Cantidad", "Proveedor" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Evitar la edición de celdas
			}
		};
		listInventory.setModel(model);
	}

	// Métodos getters y setters para los componentes gráficos

	public JTable getListInventory() {
		return listInventory;
	}

	public void setListInventory(JTable listInventory) {
		this.listInventory = listInventory;
	}

	public JPanel getListInPanel() {
		return listInPanel;
	}

	public void setListInPanel(JPanel listInPanel) {
		this.listInPanel = listInPanel;
	}

	public JScrollPane getBarIn() {
		return barIn;
	}

	public void setBarIn(JScrollPane barIn) {
		this.barIn = barIn;
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
