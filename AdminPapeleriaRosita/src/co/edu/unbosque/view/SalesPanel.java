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
 * La clase {@code SalesPanel} es un JPanel personalizado utilizado para mostrar
 * y gestionar los registros de ventas en una interfaz gráfica de usuario (GUI).
 * Incluye características para mostrar, agregar, eliminar y actualizar ventas
 * en un formato de tabla, proporcionando una interfaz fácil de usar para
 * interactuar con los datos de ventas.
 * <p>
 * Este panel contiene una JTable para mostrar los registros de ventas, así como
 * botones para agregar, eliminar y actualizar entradas de ventas. También
 * incluye indicadores visuales para cada una de estas acciones.
 * </p>
 * <p>
 * El diseño del panel está personalizado, y los componentes están diseñados
 * para proporcionar una interfaz clara e intuitiva para la gestión de ventas.
 * </p>
 * 
 * @see JPanel
 */
public class SalesPanel extends JPanel {

	/**
	 * Tabla que muestra la lista de ventas.
	 */
	private JTable listSales;

	/**
	 * Panel que contiene la tabla de registros de ventas.
	 */
	private JPanel listSaPanel;

	/**
	 * Etiqueta que muestra el título del panel de ventas.
	 */
	private JLabel titleSa;

	/**
	 * Etiqueta que indica la acción de 'Agregar' para las ventas.
	 */
	private JLabel indAddSal;

	/**
	 * Etiqueta que indica la acción de 'Eliminar' para las ventas.
	 */
	private JLabel indDelSal;

	/**
	 * Etiqueta que indica la acción de 'Actualizar' para las ventas.
	 */
	private JLabel indUpSal;

	/**
	 * Botón para agregar una nueva venta.
	 */
	private JButton addSa;

	/**
	 * Botón para eliminar una venta existente.
	 */
	private JButton delSa;

	/**
	 * Botón para actualizar una venta existente.
	 */
	private JButton upSa;

	/**
	 * Barra de desplazamiento que contiene la tabla de ventas.
	 */
	private JScrollPane barSa;

	/**
	 * Construye un nuevo {@code SalesPanel} e inicializa los componentes. El panel
	 * se configura con el título, la tabla para mostrar las ventas, y los botones
	 * para agregar, eliminar y actualizar las ventas.
	 */
	public SalesPanel() {
		// Establece el diseño y el color de fondo para el panel.
		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		// Inicializa y establece propiedades para la etiqueta de título.
		titleSa = new JLabel("Seleccione venta a eliminar/actualizar");
		titleSa.setBounds(145, 15, 370, 30);
		titleSa.setFont(new Font("Leelawadee", Font.BOLD, 18));
		titleSa.setForeground(new Color(2, 58, 98));
		add(titleSa);

		// Inicializa la tabla de ventas.
		listSales = new JTable();
		listSales.setBounds(0, 0, 400, 350);
		listSales.setBackground(Color.LIGHT_GRAY);
		listSales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSales.getTableHeader().setReorderingAllowed(false);

		// Inicializa la barra de desplazamiento para contener la tabla de ventas.
		barSa = new JScrollPane(listSales);
		barSa.setBounds(0, 0, 400, 350);

		// Crea un panel para la tabla de ventas y agrega la barra de desplazamiento.
		listSaPanel = new JPanel();
		listSaPanel.setLayout(null);
		listSaPanel.setBounds(113, 60, 400, 350);
		listSaPanel.add(barSa);
		add(listSaPanel);

		// Inicializa y establece propiedades para las etiquetas de acción.
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

		// Inicializa y establece propiedades para los botones de acción.
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

	/**
	 * Llena la tabla de ventas con la información proporcionada.
	 * 
	 * @param information Un arreglo bidimensional de cadenas que representa los
	 *                    datos de ventas que se mostrarán en la tabla.
	 */
	public void fillTable(String[][] information) {
		DefaultTableModel model = new DefaultTableModel(information,
				new String[] { "ID", "Vendedor", "Fecha", "Total pagado" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Las celdas no son editables
			}
		};
		listSales.setModel(model);
	}

	// Métodos getter y setter para los atributos del panel.

	public JTable getListSales() {
		return listSales;
	}

	public void setListSales(JTable listSales) {
		this.listSales = listSales;
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
