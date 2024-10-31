package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private LoginPanel loginPanel;
	private AdminControlPanel adminControlPanel;
	private SupplierPanel supplierPanel;
	private AddUpdateSupplierPanel addUpdateSupplierPanel;
	private InventoryPanel inventoryPanel;
	private AddUpdateInventoryPanel addUpdateInventoryPanel;

	public MainWindow() {

		setSize(800, 600);
		setTitle("Administrador papeleria de Rosita");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		loginPanel = new LoginPanel();
		adminControlPanel = new AdminControlPanel();
		supplierPanel = new SupplierPanel();
		addUpdateSupplierPanel = new AddUpdateSupplierPanel();
		inventoryPanel = new InventoryPanel();
		addUpdateInventoryPanel = new AddUpdateInventoryPanel();
		

		add(loginPanel).setVisible(false);
		add(supplierPanel).setVisible(false);
		add(addUpdateSupplierPanel).setVisible(false);
		add(inventoryPanel).setVisible(false);
		add(addUpdateInventoryPanel).setVisible(false);

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

	public AddUpdateInventoryPanel getAddUpdateInventoryPanel() {
		return addUpdateInventoryPanel;
	}

	public void setAddUpdateInventoryPanel(AddUpdateInventoryPanel addUpdateInventoryPanel) {
		this.addUpdateInventoryPanel = addUpdateInventoryPanel;
	}

}
