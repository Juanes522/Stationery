package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private LoginPanel loginPanel;
	private AdminControlPanel adminControlPanel;
	private InventoryPanel inventoryPanel;
	private SupplierPanel supplierPanel;
	private AddUpdateSupplierPanel addUpdateSupplierPanel;

	public MainWindow() {

		setSize(800, 600);
		setTitle("Administrador papeleria de Rosita");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		loginPanel = new LoginPanel();
		adminControlPanel = new AdminControlPanel();
		inventoryPanel = new InventoryPanel();
		supplierPanel = new SupplierPanel();
		addUpdateSupplierPanel = new AddUpdateSupplierPanel();

		add(loginPanel).setVisible(false);
		add(supplierPanel).setVisible(false);
		add(inventoryPanel).setVisible(false);
		add(addUpdateSupplierPanel).setVisible(false);

		add(adminControlPanel).setVisible(false);
		setVisible(true);
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	public AdminControlPanel getAdminControlPanel() {
		return adminControlPanel;
	}

	public void setAdminControlPanel(AdminControlPanel adminControlPanel) {
		this.adminControlPanel = adminControlPanel;
	}

	public InventoryPanel getInventoryPanel() {
		return inventoryPanel;
	}

	public void setInventoryPanel(InventoryPanel inventoryPanel) {
		this.inventoryPanel = inventoryPanel;
	}

	public SupplierPanel getSupplierPanel() {
		return supplierPanel;
	}

	public void setSupplierPanel(SupplierPanel supplierPanel) {
		this.supplierPanel = supplierPanel;
	}

	public AddUpdateSupplierPanel getAddUpdateSupplierPanel() {
		return addUpdateSupplierPanel;
	}

	public void setAddUpdateSupplierPanel(AddUpdateSupplierPanel addUpdateSupplierPanel) {
		this.addUpdateSupplierPanel = addUpdateSupplierPanel;
	}

}
