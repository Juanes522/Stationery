package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private LoginPanel loginPanel;
	private AdminControlPanel adminControlPanel;
	private SupplierPanel supplierPanel;
	private AddUpdateSupplierPanel addUpdateSupplierPanel;
	private InventoryPanel inventoryPanel;
	private AddUpdateInventoryPanel addUpdateInventoryPanel;
	private SalesPanel salesPanel;
	private addUpdateSalesPanel addUpdateSalesPanel;
	private UserControlPanel userControlPanel;
	private AddUpdateUserControlPanel addUpdateUserControlPanel;

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
		salesPanel = new SalesPanel();
		addUpdateSalesPanel = new addUpdateSalesPanel();
		userControlPanel = new UserControlPanel();
		addUpdateUserControlPanel = new AddUpdateUserControlPanel();

		add(loginPanel).setVisible(false);
		add(supplierPanel).setVisible(false);
		add(addUpdateSupplierPanel).setVisible(false);
		add(inventoryPanel).setVisible(false);
		add(addUpdateInventoryPanel).setVisible(false);
		add(salesPanel).setVisible(false);
		add(addUpdateSalesPanel).setVisible(false);
		add(userControlPanel).setVisible(false);
		add(addUpdateUserControlPanel).setVisible(false);

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

	public SalesPanel getSalesPanel() {
		return salesPanel;
	}

	public void setSalesPanel(SalesPanel salesPanel) {
		this.salesPanel = salesPanel;
	}

	public addUpdateSalesPanel getAddUpdateSalesPanel() {
		return addUpdateSalesPanel;
	}

	public void setAddUpdateSalesPanel(addUpdateSalesPanel addUpdateSalesPanel) {
		this.addUpdateSalesPanel = addUpdateSalesPanel;
	}

	public UserControlPanel getUserControlPanel() {
		return userControlPanel;
	}

	public void setUserControlPanel(UserControlPanel userControlPanel) {
		this.userControlPanel = userControlPanel;
	}

	public AddUpdateUserControlPanel getAddUpdateUserControlPanel() {
		return addUpdateUserControlPanel;
	}

	public void setAddUpdateUserControlPanel(AddUpdateUserControlPanel addUpdateUserControlPanel) {
		this.addUpdateUserControlPanel = addUpdateUserControlPanel;
	}

}
