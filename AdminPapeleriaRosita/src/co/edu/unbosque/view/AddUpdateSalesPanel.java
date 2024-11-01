package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class AddUpdateSalesPanel extends JPanel {

	private JLabel formSa, titleRegisterSa, titleUpdateSa, indTotal, indSellerName, indChoosePro, indRegisterSale,
			indUpdateSale;
	private JTextField total, sellerName;
	private JButton registerSa, updateSa, closeSa;
	private JTable productsTable;
	private DefaultTableModel modelSales;
	private JPanel tablePanel;
	private JScrollPane barSa;

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

		total = new JTextField();
		total.setBounds(23, 50, 175, 30);
		MatteBorder borderTotal = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		total.setBorder(borderTotal);
		total.setOpaque(false);
		total.setForeground(Color.WHITE);
		total.setFont(new Font("Leelawadee", Font.BOLD, 20));
		total.setEditable(false);
		formSa.add(total);

		indSellerName = new JLabel("Vendedor");
		indSellerName.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indSellerName.setForeground(Color.WHITE);
		indSellerName.setBounds(63, 110, 220, 30);
		formSa.add(indSellerName);

		sellerName = new JTextField();
		sellerName.setBounds(23, 150, 175, 30);
		MatteBorder borderSeller = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		sellerName.setBorder(borderSeller);
		sellerName.setOpaque(false);
		sellerName.setForeground(Color.WHITE);
		sellerName.setFont(new Font("Leelawadee", Font.BOLD, 20));
		formSa.add(sellerName);

//		botones e indicador

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

//-----		

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

		modelSales = new DefaultTableModel();
		modelSales.addColumn("Producto");
		modelSales.addColumn("<html>Cantidad <br>disponible</html>");
		modelSales.addColumn("<html>Cantidad a <br>vender</html>");

		productsTable = new JTable(modelSales);
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

	public JTextField getSellerName() {
		return sellerName;
	}

	public void setSellerName(JTextField sellerName) {
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

	public DefaultTableModel getModelSales() {
		return modelSales;
	}

	public void setModelSales(DefaultTableModel modelSales) {
		this.modelSales = modelSales;
	}

}
