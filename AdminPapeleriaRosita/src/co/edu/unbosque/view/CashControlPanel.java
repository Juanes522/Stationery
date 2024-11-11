package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Representa el panel de control de caja de la aplicación. Este panel muestra
 * información financiera, incluyendo los ingresos, costos y ganancias de los
 * productos. Además, presenta una tabla con los detalles de cada transacción
 * relacionada con el flujo de caja.
 * 
 * <p>
 * El panel está compuesto por:
 * </p>
 * <ul>
 * <li>Una tabla para mostrar los datos de los productos y sus respectivos
 * ingresos, costos y ganancias.</li>
 * <li>Etiquetas para mostrar el total de ingresos, costos y ganancias.</li>
 * <li>Una línea divisoria entre las secciones.</li>
 * </ul>
 */
public class CashControlPanel extends JPanel {

	// Componentes gráficos
	private JTable listCash;
	private JPanel listCashPanel;
	private JScrollPane barCash;
	private JLabel totalIncome, totalExpenses, total;
	private JPanel line;

	/**
	 * Constructor de la clase CashControlPanel. Este constructor inicializa los
	 * componentes gráficos del panel, incluidos los elementos de la tabla y las
	 * etiquetas de total. Se establece el tamaño y el diseño del panel, así como la
	 * configuración de la tabla de flujo de caja.
	 */
	public CashControlPanel() {

		// Configuración del panel principal
		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		// Inicialización de la tabla para mostrar el flujo de caja
		listCash = new JTable();
		listCash.setBounds(0, 0, 470, 350);
		listCash.setBackground(Color.LIGHT_GRAY);
		listCash.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCash.getTableHeader().setReorderingAllowed(false);

		// Agregar la barra de desplazamiento a la tabla
		barCash = new JScrollPane(listCash);
		barCash.setBounds(0, 0, 470, 350);

		// Panel para contener la tabla y la barra de desplazamiento
		listCashPanel = new JPanel();
		listCashPanel.setLayout(null);
		listCashPanel.setBounds(77, 60, 470, 350);
		listCashPanel.add(barCash);
		add(listCashPanel);

		// Línea divisoria al final del panel
		line = new JPanel();
		line.setBounds(60, 470, 500, 4);
		line.setBackground(Color.BLACK);
		add(line);

		// Etiqueta para mostrar el total de ingresos
		totalIncome = new JLabel("Total Ingresos");
		totalIncome.setBounds(100, 420, 150, 60);
		totalIncome.setFont(new Font("Leelawadee", Font.BOLD, 18));
		totalIncome.setForeground(new Color(2, 58, 98));
		add(totalIncome);

		// Etiqueta para mostrar el total de costos
		totalExpenses = new JLabel("Total Costos");
		totalExpenses.setBounds(270, 420, 150, 60);
		totalExpenses.setFont(new Font("Leelawadee", Font.BOLD, 18));
		totalExpenses.setForeground(new Color(2, 58, 98));
		add(totalExpenses);

		// Etiqueta para mostrar el total de ganancias
		total = new JLabel("Total Ganancias");
		total.setBounds(420, 420, 150, 60);
		total.setFont(new Font("Leelawadee", Font.BOLD, 18));
		total.setForeground(new Color(2, 58, 98));
		add(total);
	}

	/**
	 * Rellena la tabla con la información financiera proporcionada. La tabla se
	 * configura con una estructura que contiene las columnas "Producto",
	 * "Ingresos", "Costos" y "Ganancias".
	 * 
	 * @param information Datos a mostrar en la tabla. Se espera una matriz
	 *                    bidimensional de objetos, donde cada fila representa un
	 *                    producto y sus respectivos ingresos, costos y ganancias.
	 */
	public void fillTable(Object[][] information) {
		DefaultTableModel model = new DefaultTableModel(information,
				new String[] { "Producto", "Ingresos", "Costos", "Ganancias" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Evitar la edición de celdas
			}
		};
		listCash.setModel(model);
	}

	// Métodos getters y setters para los componentes gráficos

	public JTable getListCash() {
		return listCash;
	}

	public void setListCash(JTable listCash) {
		this.listCash = listCash;
	}

	public JLabel getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(JLabel totalIncome) {
		this.totalIncome = totalIncome;
	}

	public JLabel getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(JLabel totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public JLabel getTotal() {
		return total;
	}

	public void setTotal(JLabel total) {
		this.total = total;
	}
}
