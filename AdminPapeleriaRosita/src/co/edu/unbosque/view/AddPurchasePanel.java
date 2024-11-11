package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

/**
 * Clase {@code AddPurchasePanel} que representa un panel para agregar una
 * compra en la interfaz gráfica.
 * 
 * <p>
 * Este panel proporciona una vista interactiva para ingresar información sobre
 * una compra, como el total a pagar, seleccionar productos, y realizar acciones
 * relacionadas con el registro y finalización de la compra.
 * </p>
 * 
 * <p>
 * Contiene componentes visuales como etiquetas, botones, campos de texto,
 * listas y barras de desplazamiento para proporcionar una interfaz intuitiva
 * para agregar productos a la compra y completar el proceso.
 * </p>
 * 
 * @see JPanel
 */
public class AddPurchasePanel extends JPanel {

	/** Etiqueta para mostrar el formulario previo a la compra */
	private JLabel formPrePur;

	/** Etiqueta para mostrar el total a pagar */
	private JLabel indTotalPur;

	/** Etiqueta para indicar la acción de agregar productos */
	private JLabel indRegisterPur;

	/** Etiqueta para indicar la acción de finalizar la compra */
	private JLabel indEndPur;

	/** Etiqueta para indicar la selección de productos */
	private JLabel indChooseProPur;

	/** Campo de texto para mostrar el total a pagar */
	private JTextField totalPurchase;

	/** Botón para registrar la compra */
	private JButton registerPur;

	/** Botón para finalizar la compra */
	private JButton endPur;

	/** Botón para cerrar el panel */
	private JButton closePur;

	/** Lista de productos disponibles para la compra */
	private JList<String> productsListPur;

	/** Panel que contiene la lista de productos */
	private JPanel listPurPanel;

	/** Barra de desplazamiento para la lista de productos */
	private JScrollPane barPur;

	/** Array que almacena los IDs de los productos */
	private int ids[];

	/**
	 * Constructor que inicializa el panel de la compra. Configura el diseño y los
	 * componentes visuales del panel.
	 */
	public AddPurchasePanel() {
		setBounds(202, 70, 540, 450);
		setLayout(null);
		setBackground(Color.WHITE);

		// Formulario previo a la compra
		formPrePur = new JLabel(new ImageIcon("src/Assets/largeform.png"));
		formPrePur.setBounds(319, 108, 221, 342);
		formPrePur.setLayout(null);
		add(formPrePur);

		// Total a pagar
		indTotalPur = new JLabel("Total a pagar");
		indTotalPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indTotalPur.setForeground(Color.WHITE);
		indTotalPur.setBounds(45, 10, 220, 30);
		formPrePur.add(indTotalPur);

		// Campo de texto para el total a pagar
		totalPurchase = new JTextField();
		totalPurchase.setBounds(23, 50, 175, 30);
		MatteBorder borderTotal = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		totalPurchase.setBorder(borderTotal);
		totalPurchase.setOpaque(false);
		totalPurchase.setForeground(Color.WHITE);
		totalPurchase.setFont(new Font("Leelawadee", Font.BOLD, 20));
		totalPurchase.setEditable(false);
		formPrePur.add(totalPurchase);

		// Indicadores y botones
		indRegisterPur = new JLabel("Agregar");
		indRegisterPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indRegisterPur.setForeground(new Color(2, 58, 98));
		indRegisterPur.setBounds(35, 137, 160, 30);
		indRegisterPur.setHorizontalAlignment(JLabel.CENTER);
		formPrePur.add(indRegisterPur);

		indEndPur = new JLabel("Terminar compra");
		indEndPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indEndPur.setForeground(new Color(2, 58, 98));
		indEndPur.setBounds(30, 237, 170, 30);
		formPrePur.add(indEndPur);

		// Botón para registrar la compra
		registerPur = new JButton(new ImageIcon("src/Assets/registersale.png"));
		registerPur.setBounds(23, 130, 177, 47);
		registerPur.setFocusable(false);
		registerPur.setBorderPainted(false);
		registerPur.setContentAreaFilled(false);
		formPrePur.add(registerPur);

		// Botón para finalizar la compra
		endPur = new JButton(new ImageIcon("src/Assets/registersale.png"));
		endPur.setBounds(23, 230, 177, 47);
		endPur.setFocusable(false);
		endPur.setBorderPainted(false);
		endPur.setContentAreaFilled(false);
		formPrePur.add(endPur);

		// Botón para cerrar el panel
		closePur = new JButton(new ImageIcon("src/Assets/xblue.png"));
		closePur.setBounds(510, 5, 32, 32);
		closePur.setFocusable(false);
		closePur.setBorderPainted(false);
		closePur.setContentAreaFilled(false);
		add(closePur);

		// Indicador para seleccionar productos
		indChooseProPur = new JLabel("Seleccione productos");
		indChooseProPur.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indChooseProPur.setForeground(new Color(2, 58, 98));
		indChooseProPur.setBounds(25, 70, 250, 30);
		add(indChooseProPur);

		// Lista de productos
		productsListPur = new JList<>();
		productsListPur.setBounds(0, 0, 270, 342);
		productsListPur.setBackground(Color.LIGHT_GRAY);
		productsListPur.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (c instanceof JLabel) {
					JLabel label = (JLabel) c;
					if (!isSelected) {
						label.setBackground(index % 2 == 0 ? new Color(0, 100, 255, 15) : Color.white);
					} else {
						label.setBorder(BorderFactory.createLineBorder(Color.black, 2));
					}
				}
				return c;
			}
		});
		productsListPur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Barra de desplazamiento para la lista de productos
		barPur = new JScrollPane(productsListPur);
		barPur.setBounds(0, 0, 270, 342);

		// Panel que contiene la lista de productos
		listPurPanel = new JPanel();
		listPurPanel.setLayout(null);
		listPurPanel.setBounds(0, 108, 270, 342);
		listPurPanel.add(barPur);
		add(listPurPanel);
	}

	/**
	 * Rellena la lista de productos con los datos proporcionados.
	 * 
	 * @param productsName Una matriz bidimensional que contiene los nombres de los
	 *                     productos y sus IDs.
	 */
	public void fillList(Object productsName[][]) {
		ids = new int[productsName.length];
		DefaultListModel<String> model = new DefaultListModel<>();
		for (int i = 0; i < productsName.length; i++) {
			model.addElement((String) productsName[i][0]);
			ids[i] = (int) productsName[i][1];
		}
		productsListPur.setModel(model);
	}

	/**
	 * Obtiene el ID del producto en el índice proporcionado.
	 * 
	 * @param index El índice del producto en la lista.
	 * @return El ID del producto.
	 */
	public int getID(int index) {
		if (ids != null) {
			return ids[index];
		}
		return 0;
	}

	// Métodos getters y setters

	public JTextField getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(JTextField totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public JButton getRegisterPur() {
		return registerPur;
	}

	public void setRegisterPur(JButton registerPur) {
		this.registerPur = registerPur;
	}

	public JButton getEndPur() {
		return endPur;
	}

	public void setEndPur(JButton endPur) {
		this.endPur = endPur;
	}

	public JButton getClosePur() {
		return closePur;
	}

	public void setClosePur(JButton closePur) {
		this.closePur = closePur;
	}

	public JList<String> getProductsListPur() {
		return productsListPur;
	}

	public void setProductsListPur(JList<String> productsListPur) {
		this.productsListPur = productsListPur;
	}
}
