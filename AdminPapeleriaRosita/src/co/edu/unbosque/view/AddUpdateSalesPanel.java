package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 * Panel para agregar y actualizar ventas. Este panel permite registrar nuevas
 * ventas y actualizar ventas existentes.
 */
public class AddUpdateSalesPanel extends JPanel {

	private JLabel formSa, titleRegisterSa, titleUpdateSa, indTotal, indSellerName, indChoosePro, indRegisterSale,
			indUpdateSale;
	private JTextField total;
	private JComboBox<String> sellerName;
	private JButton registerSa, updateSa, closeSa;
	private JTable productsTable;
	private JPanel tablePanel;
	private JScrollPane barSa;
	private int valuesQuan[];

	/**
	 * Constructor que inicializa el panel de agregar/actualizar ventas.
	 */
	public AddUpdateSalesPanel() {
		setBounds(202, 70, 540, 450);
		setLayout(null);
		setBackground(Color.WHITE);

		formSa = new JLabel(new ImageIcon("src/Assets/largeform.png"));
		formSa.setBounds(319, 108, 221, 342);
		formSa.setLayout(null);
		add(formSa);

		indTotal = new JLabel("Total a pagar");
		indTotal.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indTotal.setForeground(Color.WHITE);
		indTotal.setBounds(45, 10, 220, 30);
		formSa.add(indTotal);

		total = new JTextField("0");
		total.setBounds(23, 50, 175, 30);
		MatteBorder borderTotal = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		total.setBorder(borderTotal);
		total.setOpaque(false);
		total.setForeground(Color.WHITE);
		total.setHorizontalAlignment(JTextField.CENTER);
		total.setFont(new Font("Leelawadee", Font.BOLD, 20));
		total.setEditable(false);
		formSa.add(total);

		indSellerName = new JLabel("Vendedor");
		indSellerName.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indSellerName.setForeground(Color.WHITE);
		indSellerName.setBounds(63, 110, 220, 30);
		formSa.add(indSellerName);

		sellerName = new JComboBox<>();
		sellerName.setEditor(new BasicComboBoxEditor() {
			@Override
			protected JTextField createEditorComponent() {
				JTextField editor = new JTextField();
				MatteBorder borderTotal = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
				editor.setBackground(new Color(2, 58, 98));
				editor.setBorder(borderTotal);
				editor.setForeground(Color.WHITE);
				editor.setHorizontalAlignment(JTextField.CENTER);
				editor.setFont(new Font("Leelawadee", Font.BOLD, 20));
				return editor;
			}
		});
		sellerName.setEditable(true);
		sellerName.setBounds(23, 150, 175, 30);
		formSa.add(sellerName);

		indRegisterSale = new JLabel("Realizar venta");
		indRegisterSale.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indRegisterSale.setForeground(new Color(2, 58, 98));
		indRegisterSale.setBounds(42, 237, 150, 30);
		formSa.add(indRegisterSale).setVisible(false);

		indUpdateSale = new JLabel("Actualizar venta");
		indUpdateSale.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indUpdateSale.setForeground(new Color(2, 58, 98));
		indUpdateSale.setBounds(33, 237, 170, 30);
		formSa.add(indUpdateSale).setVisible(false);

		registerSa = new JButton(new ImageIcon("src/Assets/registersale.png"));
		registerSa.setBounds(24, 230, 177, 47);
		registerSa.setFocusable(false);
		registerSa.setBorderPainted(false);
		registerSa.setContentAreaFilled(false);
		formSa.add(registerSa).setVisible(false);

		updateSa = new JButton(new ImageIcon("src/Assets/registersale.png"));
		updateSa.setBounds(24, 230, 177, 47);
		updateSa.setFocusable(false);
		updateSa.setBorderPainted(false);
		updateSa.setContentAreaFilled(false);
		formSa.add(updateSa).setVisible(false);

		titleRegisterSa = new JLabel("Registrar Venta");
		titleRegisterSa.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleRegisterSa.setForeground(new Color(2, 58, 98));
		titleRegisterSa.setBounds(175, 5, 250, 30);
		add(titleRegisterSa).setVisible(false);

		titleUpdateSa = new JLabel("Actualizar Venta");
		titleUpdateSa.setFont(new Font("Leelawadee", Font.BOLD, 26));
		titleUpdateSa.setForeground(new Color(2, 58, 98));
		titleUpdateSa.setBounds(167, 5, 250, 30);
		add(titleUpdateSa).setVisible(false);

		closeSa = new JButton(new ImageIcon("src/Assets/xblue.png"));
		closeSa.setBounds(510, 5, 32, 32);
		closeSa.setFocusable(false);
		closeSa.setBorderPainted(false);
		closeSa.setContentAreaFilled(false);
		add(closeSa);

		indChoosePro = new JLabel("Seleccione productos");
		indChoosePro.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indChoosePro.setForeground(new Color(2, 58, 98));
		indChoosePro.setBounds(25, 70, 250, 30);
		add(indChoosePro);

		productsTable = new JTable();
		productsTable.setBounds(0, 0, 270, 342);
		productsTable.setBackground(Color.LIGHT_GRAY);
		productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productsTable.setRowHeight(30);
		productsTable.getTableHeader().setPreferredSize(new Dimension(0, 40));
		productsTable.getTableHeader().setReorderingAllowed(false);

		barSa = new JScrollPane(productsTable);
		barSa.setBounds(0, 0, 270, 342);

		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBounds(0, 108, 270, 342);
		tablePanel.add(barSa);
		add(tablePanel);
	}

	/**
	 * Llena el JComboBox de vendedores con los usuarios proporcionados.
	 * 
	 * @param users Los nombres de los vendedores que se agregarán al JComboBox.
	 */
	public void fillCB(String users[]) {
		sellerName.removeAllItems();
		for (String user : users) {
			sellerName.addItem(user);
		}
	}

	/**
	 * Llena la tabla de productos con la información proporcionada.
	 * 
	 * @param information Los datos de los productos que se mostrarán en la tabla.
	 */
	public void fillTable(Object[][] information) {
		valuesQuan = new int[information.length];
		for (int i = 0; i < information.length; i++) {
			valuesQuan[i] = (int) information[i][3];
		}
		total.setText("0");
		DefaultTableModel model = new DefaultTableModel(information, new String[] { "ID", "Producto",
				"<html>Cantidad <br>disponible</html>", "<html>Cantidad a <br>vender</html>" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 3;
			}
		};
		productsTable.setModel(model);
		productsTable.getColumnModel().getColumn(3).setCellEditor(new SpinnerEditor(information));
	}

	/**
	 * Editor personalizado para las celdas de la columna de cantidad a vender.
	 * Utiliza un JSpinner para seleccionar la cantidad.
	 */
	private class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {

		private JSpinner spinner;
		private Object[][] information;
		private int row, previous[];

		/**
		 * Constructor que inicializa el editor del JSpinner.
		 * 
		 * @param information Los datos de los productos.
		 */
		public SpinnerEditor(Object[][] information) {
			this.information = information;
			spinner = new JSpinner();
			spinner.setValue(0);
			row = 0;
			previous = new int[information.length];
			for (int i = 0; i < information.length; i++) {
				previous[i] = (int) information[i][3];
			}
			spinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					int actual = (int) spinner.getValue();
					double price = (double) information[row][4];
					double aux = Double.parseDouble(total.getText());
					if (actual > previous[row]) {
						total.setText(Double.toString(aux + price));
					} else if (actual < previous[row]) {
						total.setText(Double.toString(aux - price));
					}
					previous[row] = actual;
					valuesQuan[row] = actual;
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			return spinner.getValue();
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.row = row;
			int max = (int) information[row][2];
			spinner.setModel(new SpinnerNumberModel((int) value, 0, max, 1));
			JComponent editor = spinner.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				((JSpinner.DefaultEditor) editor).getTextField().setEditable(false);
				((JSpinner.DefaultEditor) editor).getTextField().setHorizontalAlignment(JTextField.LEFT);
			}
			return spinner;
		}
	}

	/**
	 * Obtiene la cantidad de productos seleccionados en una fila específica.
	 * 
	 * @param row El índice de la fila.
	 * @return La cantidad de productos seleccionados.
	 */
	public int getQuantity(int row) {
		if (valuesQuan != null) {
			return valuesQuan[row];
		}
		return 0;
	}

	// Métodos getters y setters

	public JLabel getTitleRegisterSa() {
		return titleRegisterSa;
	}

	public void setTitleRegisterSa(JLabel titleRegisterSa) {
		this.titleRegisterSa = titleRegisterSa;
	}

	public JLabel getTitleUpdateSa() {
		return titleUpdateSa;
	}

	public void setTitleUpdateSa(JLabel titleUpdateSa) {
		this.titleUpdateSa = titleUpdateSa;
	}

	public JLabel getIndRegisterSale() {
		return indRegisterSale;
	}

	public void setIndRegisterSale(JLabel indRegisterSale) {
		this.indRegisterSale = indRegisterSale;
	}

	public JLabel getIndUpdateSale() {
		return indUpdateSale;
	}

	public void setIndUpdateSale(JLabel indUpdateSale) {
		this.indUpdateSale = indUpdateSale;
	}

	public JTextField getTotal() {
		return total;
	}

	public void setTotal(JTextField total) {
		this.total = total;
	}

	public JComboBox<String> getSellerName() {
		return sellerName;
	}

	public void setSellerName(JComboBox<String> sellerName) {
		this.sellerName = sellerName;
	}

	public JButton getRegisterSa() {
		return registerSa;
	}

	public void setRegisterSa(JButton registerSa) {
		this.registerSa = registerSa;
	}

	public JButton getUpdateSa() {
		return updateSa;
	}

	public void setUpdateSa(JButton updateSa) {
		this.updateSa = updateSa;
	}

	public JButton getCloseSa() {
		return closeSa;
	}

	public void setCloseSa(JButton closeSa) {
		this.closeSa = closeSa;
	}

	public JTable getProductsTable() {
		return productsTable;
	}

	public void setProductsTable(JTable productsTable) {
		this.productsTable = productsTable;
	}
}
