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
 * Esta clase representa un panel en la interfaz gráfica de usuario que muestra
 * la información de las compras realizadas. El panel contiene una tabla para
 * listar las compras, un botón para realizar una nueva compra y un indicador
 * que describe la acción.
 */
public class PurchasePanel extends JPanel {

	private JTable listPurchase;
	private JPanel listPurPanel;
	private JLabel indAddPur;
	private JButton addPur;
	private JScrollPane barPur;

	/**
	 * Constructor de la clase {@link PurchasePanel}. Inicializa los componentes
	 * visuales del panel, como la tabla de compras, el botón para realizar una
	 * nueva compra y el indicador textual.
	 */
	public PurchasePanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		// Configuración de la tabla para mostrar las compras
		listPurchase = new JTable();
		listPurchase.setBounds(0, 0, 400, 350);
		listPurchase.setBackground(Color.LIGHT_GRAY);
		listPurchase.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPurchase.getTableHeader().setReorderingAllowed(false);

		// Barra de desplazamiento para la tabla
		barPur = new JScrollPane(listPurchase);
		barPur.setBounds(0, 0, 400, 350);

		// Panel que contiene la tabla y la barra de desplazamiento
		listPurPanel = new JPanel();
		listPurPanel.setLayout(null);
		listPurPanel.setBounds(113, 60, 400, 350);
		listPurPanel.add(barPur);
		add(listPurPanel);

		// Indicador de la acción de realizar una compra
		indAddPur = new JLabel("Realizar Compra");
		indAddPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indAddPur.setForeground(Color.WHITE);
		indAddPur.setBounds(230, 435, 180, 30);
		add(indAddPur);

		// Botón para realizar la compra
		addPur = new JButton(new ImageIcon("src/Assets/registerpurchase.png"));
		addPur.setBounds(220, 430, 177, 47);
		addPur.setFocusable(false);
		addPur.setBorderPainted(false);
		addPur.setContentAreaFilled(false);
		add(addPur);
	}

	/**
	 * Rellena la tabla con la información de las compras.
	 * 
	 * @param information Un arreglo bidimensional con los datos de las compras a
	 *                    mostrar en la tabla. Cada fila contiene los datos de una
	 *                    compra, como su ID, fecha y total pagado.
	 */
	public void fillTable(String[][] information) {
		DefaultTableModel model = new DefaultTableModel(information, new String[] { "ID", "Fecha", "Total pagado" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Las celdas no son editables
			}
		};
		listPurchase.setModel(model);
	}

	// Métodos getter y setter para los componentes de la interfaz

	public JTable getListPurchase() {
		return listPurchase;
	}

	public void setListPurchase(JTable listPurchase) {
		this.listPurchase = listPurchase;
	}

	public JPanel getListPurPanel() {
		return listPurPanel;
	}

	public void setListPurPanel(JPanel listPurPanel) {
		this.listPurPanel = listPurPanel;
	}

	public JLabel getIndAddPur() {
		return indAddPur;
	}

	public void setIndAddPur(JLabel indAddPur) {
		this.indAddPur = indAddPur;
	}

	public JScrollPane getBarPur() {
		return barPur;
	}

	public void setBarPur(JScrollPane barPur) {
		this.barPur = barPur;
	}

	public JButton getAddPur() {
		return addPur;
	}

	public void setAddPur(JButton addPur) {
		this.addPur = addPur;
	}
}
