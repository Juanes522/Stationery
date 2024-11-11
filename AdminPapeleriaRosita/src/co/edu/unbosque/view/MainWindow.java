package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Representa la ventana principal de la aplicación. Esta clase es responsable
 * de gestionar los diferentes paneles de control y las interfaces de usuario de
 * la aplicación, incluyendo el panel de inicio de sesión, paneles de
 * administración, inventarios, ventas, compras y otros controles del sistema.
 */
public class MainWindow extends JFrame {

	private LoginPanel loginPanel;
	private AdminControlPanel adminControlPanel;
	private SellerControlPanel sellerControlPanel;
	private SupplierPanel supplierPanel;
	private AddUpdateSupplierPanel addUpdateSupplierPanel;
	private InventoryPanel inventoryPanel;
	private AddUpdateInventoryPanel addUpdateInventoryPanel;
	private SalesPanel salesPanel;
	private AddUpdateSalesPanel addUpdateSalesPanel;
	private UserControlPanel userControlPanel;
	private AddUpdateUserControlPanel addUpdateUserControlPanel;
	private CashControlPanel cashControlPanel;
	private PurchasePanel purchasePanel;
	private AddPurchasePanel addPurchasePanel;
	private RegisterPurchasePanel registerPurchasePanel;

	/**
	 * Constructor de la clase MainWindow que inicializa los paneles de la ventana
	 * principal y configura las propiedades de la ventana, como el tamaño, el
	 * título, la ubicación y el comportamiento al cerrarse. Además, agrega todos
	 * los paneles a la ventana, pero los hace invisibles por defecto.
	 */
	public MainWindow() {

		setSize(800, 600);
		setTitle("Administrador papeleria de Rosita");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Inicialización de paneles
		loginPanel = new LoginPanel();
		adminControlPanel = new AdminControlPanel();
		supplierPanel = new SupplierPanel();
		addUpdateSupplierPanel = new AddUpdateSupplierPanel();
		inventoryPanel = new InventoryPanel();
		addUpdateInventoryPanel = new AddUpdateInventoryPanel();
		salesPanel = new SalesPanel();
		addUpdateSalesPanel = new AddUpdateSalesPanel();
		userControlPanel = new UserControlPanel();
		addUpdateUserControlPanel = new AddUpdateUserControlPanel();
		cashControlPanel = new CashControlPanel();
		purchasePanel = new PurchasePanel();
		addPurchasePanel = new AddPurchasePanel();
		registerPurchasePanel = new RegisterPurchasePanel();
		sellerControlPanel = new SellerControlPanel();

		// Agregar paneles a la ventana, pero mantenerlos invisibles al inicio
		add(loginPanel).setVisible(false);
		add(supplierPanel).setVisible(false);
		add(addUpdateSupplierPanel).setVisible(false);
		add(inventoryPanel).setVisible(false);
		add(addUpdateInventoryPanel).setVisible(false);
		add(salesPanel).setVisible(false);
		add(addUpdateSalesPanel).setVisible(false);
		add(userControlPanel).setVisible(false);
		add(addUpdateUserControlPanel).setVisible(false);
		add(cashControlPanel).setVisible(false);
		add(purchasePanel).setVisible(false);
		add(addPurchasePanel).setVisible(false);
		add(registerPurchasePanel).setVisible(false);

		add(adminControlPanel).setVisible(false);
		add(sellerControlPanel).setVisible(false);
		setVisible(true);
	}

	/**
	 * Obtiene el panel de inicio de sesión.
	 * 
	 * @return El panel de inicio de sesión {@link LoginPanel}.
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	/**
	 * Establece el panel de inicio de sesión.
	 * 
	 * @param loginPanel El panel de inicio de sesión {@link LoginPanel}.
	 */
	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	/**
	 * Obtiene el panel de control administrativo.
	 * 
	 * @return El panel de control administrativo {@link AdminControlPanel}.
	 */
	public AdminControlPanel getAdminControlPanel() {
		return adminControlPanel;
	}

	/**
	 * Establece el panel de control administrativo.
	 * 
	 * @param adminControlPanel El panel de control administrativo
	 *                          {@link AdminControlPanel}.
	 */
	public void setAdminControlPanel(AdminControlPanel adminControlPanel) {
		this.adminControlPanel = adminControlPanel;
	}

	/**
	 * Obtiene el panel de inventario.
	 * 
	 * @return El panel de inventario {@link InventoryPanel}.
	 */
	public InventoryPanel getInventoryPanel() {
		return inventoryPanel;
	}

	/**
	 * Establece el panel de inventario.
	 * 
	 * @param inventoryPanel El panel de inventario {@link InventoryPanel}.
	 */
	public void setInventoryPanel(InventoryPanel inventoryPanel) {
		this.inventoryPanel = inventoryPanel;
	}

	/**
	 * Obtiene el panel de proveedores.
	 * 
	 * @return El panel de proveedores {@link SupplierPanel}.
	 */
	public SupplierPanel getSupplierPanel() {
		return supplierPanel;
	}

	/**
	 * Establece el panel de proveedores.
	 * 
	 * @param supplierPanel El panel de proveedores {@link SupplierPanel}.
	 */
	public void setSupplierPanel(SupplierPanel supplierPanel) {
		this.supplierPanel = supplierPanel;
	}

	/**
	 * Obtiene el panel de agregar o actualizar proveedor.
	 * 
	 * @return El panel de agregar o actualizar proveedor
	 *         {@link AddUpdateSupplierPanel}.
	 */
	public AddUpdateSupplierPanel getAddUpdateSupplierPanel() {
		return addUpdateSupplierPanel;
	}

	/**
	 * Establece el panel de agregar o actualizar proveedor.
	 * 
	 * @param addUpdateSupplierPanel El panel de agregar o actualizar proveedor
	 *                               {@link AddUpdateSupplierPanel}.
	 */
	public void setAddUpdateSupplierPanel(AddUpdateSupplierPanel addUpdateSupplierPanel) {
		this.addUpdateSupplierPanel = addUpdateSupplierPanel;
	}

	/**
	 * Obtiene el panel de agregar o actualizar inventario.
	 * 
	 * @return El panel de agregar o actualizar inventario
	 *         {@link AddUpdateInventoryPanel}.
	 */
	public AddUpdateInventoryPanel getAddUpdateInventoryPanel() {
		return addUpdateInventoryPanel;
	}

	/**
	 * Establece el panel de agregar o actualizar inventario.
	 * 
	 * @param addUpdateInventoryPanel El panel de agregar o actualizar inventario
	 *                                {@link AddUpdateInventoryPanel}.
	 */
	public void setAddUpdateInventoryPanel(AddUpdateInventoryPanel addUpdateInventoryPanel) {
		this.addUpdateInventoryPanel = addUpdateInventoryPanel;
	}

	/**
	 * Obtiene el panel de ventas.
	 * 
	 * @return El panel de ventas {@link SalesPanel}.
	 */
	public SalesPanel getSalesPanel() {
		return salesPanel;
	}

	/**
	 * Establece el panel de ventas.
	 * 
	 * @param salesPanel El panel de ventas {@link SalesPanel}.
	 */
	public void setSalesPanel(SalesPanel salesPanel) {
		this.salesPanel = salesPanel;
	}

	/**
	 * Obtiene el panel de agregar o actualizar ventas.
	 * 
	 * @return El panel de agregar o actualizar ventas {@link AddUpdateSalesPanel}.
	 */
	public AddUpdateSalesPanel getAddUpdateSalesPanel() {
		return addUpdateSalesPanel;
	}

	/**
	 * Establece el panel de agregar o actualizar ventas.
	 * 
	 * @param addUpdateSalesPanel El panel de agregar o actualizar ventas
	 *                            {@link AddUpdateSalesPanel}.
	 */
	public void setAddUpdateSalesPanel(AddUpdateSalesPanel addUpdateSalesPanel) {
		this.addUpdateSalesPanel = addUpdateSalesPanel;
	}

	/**
	 * Obtiene el panel de control de usuarios.
	 * 
	 * @return El panel de control de usuarios {@link UserControlPanel}.
	 */
	public UserControlPanel getUserControlPanel() {
		return userControlPanel;
	}

	/**
	 * Establece el panel de control de usuarios.
	 * 
	 * @param userControlPanel El panel de control de usuarios
	 *                         {@link UserControlPanel}.
	 */
	public void setUserControlPanel(UserControlPanel userControlPanel) {
		this.userControlPanel = userControlPanel;
	}

	/**
	 * Obtiene el panel de agregar o actualizar control de usuarios.
	 * 
	 * @return El panel de agregar o actualizar control de usuarios
	 *         {@link AddUpdateUserControlPanel}.
	 */
	public AddUpdateUserControlPanel getAddUpdateUserControlPanel() {
		return addUpdateUserControlPanel;
	}

	/**
	 * Establece el panel de agregar o actualizar control de usuarios.
	 * 
	 * @param addUpdateUserControlPanel El panel de agregar o actualizar control de
	 *                                  usuarios {@link AddUpdateUserControlPanel}.
	 */
	public void setAddUpdateUserControlPanel(AddUpdateUserControlPanel addUpdateUserControlPanel) {
		this.addUpdateUserControlPanel = addUpdateUserControlPanel;
	}

	/**
	 * Obtiene el panel de control de caja.
	 * 
	 * @return El panel de control de caja {@link CashControlPanel}.
	 */
	public CashControlPanel getCashControlPanel() {
		return cashControlPanel;
	}

	/**
	 * Establece el panel de control de caja.
	 * 
	 * @param cashControlPanel El panel de control de caja {@link CashControlPanel}.
	 */
	public void setCashControlPanel(CashControlPanel cashControlPanel) {
		this.cashControlPanel = cashControlPanel;
	}

	/**
	 * Obtiene el panel de compras.
	 * 
	 * @return El panel de compras {@link PurchasePanel}.
	 */
	public PurchasePanel getPurchasePanel() {
		return purchasePanel;
	}

	/**
	 * Establece el panel de compras.
	 * 
	 * @param purchasePanel El panel de compras {@link PurchasePanel}.
	 */
	public void setPurchasePanel(PurchasePanel purchasePanel) {
		this.purchasePanel = purchasePanel;
	}

	/**
	 * Obtiene el panel de agregar compra.
	 * 
	 * @return El panel de agregar compra {@link AddPurchasePanel}.
	 */
	public AddPurchasePanel getAddPurchasePanel() {
		return addPurchasePanel;
	}

	/**
	 * Establece el panel de agregar compra.
	 * 
	 * @param addPurchasePanel El panel de agregar compra {@link AddPurchasePanel}.
	 */
	public void setAddPurchasePanel(AddPurchasePanel addPurchasePanel) {
		this.addPurchasePanel = addPurchasePanel;
	}

	/**
	 * Obtiene el panel de registrar compra.
	 * 
	 * @return El panel de registrar compra {@link RegisterPurchasePanel}.
	 */
	public RegisterPurchasePanel getRegisterPurchasePanel() {
		return registerPurchasePanel;
	}

	/**
	 * Establece el panel de registrar compra.
	 * 
	 * @param registerPurchasePanel El panel de registrar compra
	 *                              {@link RegisterPurchasePanel}.
	 */
	public void setRegisterPurchasePanel(RegisterPurchasePanel registerPurchasePanel) {
		this.registerPurchasePanel = registerPurchasePanel;
	}

	/**
	 * Obtiene el panel de control de vendedor.
	 * 
	 * @return El panel de control de vendedor {@link SellerControlPanel}.
	 */
	public SellerControlPanel getSellerControlPanel() {
		return sellerControlPanel;
	}

	/**
	 * Establece el panel de control de vendedor.
	 * 
	 * @param sellerControlPanel El panel de control de vendedor
	 *                           {@link SellerControlPanel}.
	 */
	public void setSellerControlPanel(SellerControlPanel sellerControlPanel) {
		this.sellerControlPanel = sellerControlPanel;
	}
}
