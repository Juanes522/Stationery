package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import co.edu.unbosque.model.ProductDTO;
import co.edu.unbosque.model.PurchaseDTO;
import co.edu.unbosque.model.SaleDTO;
import co.edu.unbosque.model.SupplierDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.ProductDAO;
import co.edu.unbosque.model.persistence.PurchaseDAO;
import co.edu.unbosque.model.persistence.SaleDAO;
import co.edu.unbosque.model.persistence.SupplierDAO;
import co.edu.unbosque.model.persistence.UserDAO;
import co.edu.unbosque.util.exception.ProductException;
import co.edu.unbosque.util.exception.PurchaseException;
import co.edu.unbosque.util.exception.SaleException;
import co.edu.unbosque.util.exception.SupplierException;
import co.edu.unbosque.util.exception.UserException;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener {

	private MainWindow mw;
	private UserDAO users;
	private SupplierDAO suppliers;
	private int idUpdate;
	private HashMap<String, Integer>supplierProduct;
	private UserDTO userToRecover;
	private SaleDTO saleToUpdate;
	private ProductDAO products;
	private SaleDAO sales;
	private PurchaseDAO purchases;
	private int idPurchaseProduct;
	private int previous;
	private int idCurrentUser;
	private HashMap<Integer, Integer> productsPurchase;

	public Controller() {
		mw = new MainWindow();
		users=new UserDAO();
		suppliers=new SupplierDAO();
		products=new ProductDAO();
		userToRecover=new UserDTO();
		purchases=new PurchaseDAO();
		sales=new SaleDAO();
		idUpdate=-1;
		idPurchaseProduct=-1;
		previous=0;
		addReaders();
	}

	public void run() {
		mw.getLoginPanel().setVisible(true);

		mw.getAdminControlPanel().setVisible(false);
		
		mw.getSellerControlPanel().setVisible(false);

		mw.getSupplierPanel().setVisible(false);
		mw.getAddUpdateSupplierPanel().setVisible(false);

		mw.getInventoryPanel().setVisible(false);
		mw.getAddUpdateInventoryPanel().setVisible(false);

		mw.getSalesPanel().setVisible(false);
		mw.getAddUpdateSalesPanel().setVisible(false);
		
		mw.getUserControlPanel().setVisible(false);
		mw.getAddUpdateUserControlPanel().setVisible(false);
		
		mw.getCashControlPanel().setVisible(false);
		
		mw.getPurchasePanel().setVisible(false);
		mw.getAddPurchasePanel().setVisible(false);
		mw.getRegisterPurchasePanel().setVisible(false);
	}

	public void addReaders() {
		mw.getLoginPanel().getJoin().addActionListener(this);
		mw.getLoginPanel().getJoin().setActionCommand("join");

		mw.getLoginPanel().getRecoverKey().addActionListener(this);
		mw.getLoginPanel().getRecoverKey().setActionCommand("recoverKey");

		mw.getLoginPanel().getCancel().addActionListener(this);
		mw.getLoginPanel().getCancel().setActionCommand("cancelRec");

		mw.getLoginPanel().getFollow().addActionListener(this);
		mw.getLoginPanel().getFollow().setActionCommand("followRec");

		mw.getLoginPanel().getCheckanswer().addActionListener(this);
		mw.getLoginPanel().getCheckanswer().setActionCommand("checkAns");

//		_______________________________________________________________________
//		control de admin		

		mw.getAdminControlPanel().getInventory().addActionListener(this);
		mw.getAdminControlPanel().getInventory().setActionCommand("inventoryAdmin");

		mw.getAdminControlPanel().getSuppliers().addActionListener(this);
		mw.getAdminControlPanel().getSuppliers().setActionCommand("supplierAdmin");

		mw.getAdminControlPanel().getSales().addActionListener(this);
		mw.getAdminControlPanel().getSales().setActionCommand("salesAdmin");

		mw.getAdminControlPanel().getUserControl().addActionListener(this);
		mw.getAdminControlPanel().getUserControl().setActionCommand("userControlAdmin");

		mw.getAdminControlPanel().getCashControl().addActionListener(this);
		mw.getAdminControlPanel().getCashControl().setActionCommand("cashControlAdmin");

		mw.getAdminControlPanel().getPurchase().addActionListener(this);
		mw.getAdminControlPanel().getPurchase().setActionCommand("purchaseAdmin");

		mw.getAdminControlPanel().getExit().addActionListener(this);
		mw.getAdminControlPanel().getExit().setActionCommand("exitAdmin");

//		_______________________________________________________________________
//		control de vendedor
		
		mw.getSellerControlPanel().getInventorySe().addActionListener(this);
		mw.getSellerControlPanel().getInventorySe().setActionCommand("inventorySeller");
		
		mw.getSellerControlPanel().getSalesSe().addActionListener(this);
		mw.getSellerControlPanel().getSalesSe().setActionCommand("salesSeller");
		
		mw.getSellerControlPanel().getExitSe().addActionListener(this);
		mw.getSellerControlPanel().getExitSe().setActionCommand("exitSeller");
		
//		_______________________________________________________________________
//		panel proveedor

		mw.getSupplierPanel().getAddSup().addActionListener(this);
		mw.getSupplierPanel().getAddSup().setActionCommand("addSupplier");

		mw.getSupplierPanel().getDelSup().addActionListener(this);
		mw.getSupplierPanel().getDelSup().setActionCommand("deleteSupplier");

		mw.getSupplierPanel().getUpSup().addActionListener(this);
		mw.getSupplierPanel().getUpSup().setActionCommand("upSupplier");

//		_______________________________________________________________________
//		agregar o actualizar proveedor	

		mw.getAddUpdateSupplierPanel().getRegisterSup().addActionListener(this);
		mw.getAddUpdateSupplierPanel().getRegisterSup().setActionCommand("registerSupplier");

		mw.getAddUpdateSupplierPanel().getUpdateSup().addActionListener(this);
		mw.getAddUpdateSupplierPanel().getUpdateSup().setActionCommand("updateSupplier");

		mw.getAddUpdateSupplierPanel().getCloseSup().addActionListener(this);
		mw.getAddUpdateSupplierPanel().getCloseSup().setActionCommand("closeSupplier");

//		_______________________________________________________________________
//		panel inventario

		mw.getInventoryPanel().getAddPro().addActionListener(this);
		mw.getInventoryPanel().getAddPro().setActionCommand("addProduct");

		mw.getInventoryPanel().getDelPro().addActionListener(this);
		mw.getInventoryPanel().getDelPro().setActionCommand("deleteProduct");

		mw.getInventoryPanel().getUpPro().addActionListener(this);
		mw.getInventoryPanel().getUpPro().setActionCommand("upProduct");

//		_______________________________________________________________________
//		agregar o actualizar producto

		mw.getAddUpdateInventoryPanel().getRegisterPro().addActionListener(this);
		mw.getAddUpdateInventoryPanel().getRegisterPro().setActionCommand("registerProduct");

		mw.getAddUpdateInventoryPanel().getUpdatePro().addActionListener(this);
		mw.getAddUpdateInventoryPanel().getUpdatePro().setActionCommand("updateProduct");

		mw.getAddUpdateInventoryPanel().getCloseIn().addActionListener(this);
		mw.getAddUpdateInventoryPanel().getCloseIn().setActionCommand("closeProduct");

//		_______________________________________________________________________
//		panel ventas

		mw.getSalesPanel().getAddSa().addActionListener(this);
		mw.getSalesPanel().getAddSa().setActionCommand("addSale");

		mw.getSalesPanel().getDelSa().addActionListener(this);
		mw.getSalesPanel().getDelSa().setActionCommand("deleteSale");

		mw.getSalesPanel().getUpSa().addActionListener(this);
		mw.getSalesPanel().getUpSa().setActionCommand("upSa");

//		_______________________________________________________________________
//		agregar o actualizar venta

		mw.getAddUpdateSalesPanel().getRegisterSa().addActionListener(this);
		mw.getAddUpdateSalesPanel().getRegisterSa().setActionCommand("registerSale");

		mw.getAddUpdateSalesPanel().getUpdateSa().addActionListener(this);
		mw.getAddUpdateSalesPanel().getUpdateSa().setActionCommand("updateSale");

		mw.getAddUpdateSalesPanel().getCloseSa().addActionListener(this);
		mw.getAddUpdateSalesPanel().getCloseSa().setActionCommand("closeSale");
		
//		_______________________________________________________________________
//		panel usuarios

		mw.getUserControlPanel().getAddUser().addActionListener(this);
		mw.getUserControlPanel().getAddUser().setActionCommand("addUser");
		
		mw.getUserControlPanel().getDelUser().addActionListener(this);
		mw.getUserControlPanel().getDelUser().setActionCommand("deleteUser");
		
		mw.getUserControlPanel().getUpUser().addActionListener(this);
		mw.getUserControlPanel().getUpUser().setActionCommand("upUser");
//		_______________________________________________________________________
//		agregar o actualizar usuario
		
		mw.getAddUpdateUserControlPanel().getRegisterUser().addActionListener(this);
		mw.getAddUpdateUserControlPanel().getRegisterUser().setActionCommand("registerUser");
		
		mw.getAddUpdateUserControlPanel().getUpdateUser().addActionListener(this);
		mw.getAddUpdateUserControlPanel().getUpdateUser().setActionCommand("updateUser");
		
		mw.getAddUpdateUserControlPanel().getCloseUser().addActionListener(this);
		mw.getAddUpdateUserControlPanel().getCloseUser().setActionCommand("closeUser");
		
		mw.getAddUpdateUserControlPanel().getIsAdmin().addActionListener(this);
		mw.getAddUpdateUserControlPanel().getIsAdmin().setActionCommand("isAdmin");
		
		mw.getAddUpdateUserControlPanel().getNotAdmin().addActionListener(this);
		mw.getAddUpdateUserControlPanel().getNotAdmin().setActionCommand("notAdmin");
		
//		_______________________________________________________________________
//		agregar compra
		
		mw.getPurchasePanel().getAddPur().addActionListener(this);
		mw.getPurchasePanel().getAddPur().setActionCommand("addPurchase");
//		_______________________________________________________________________
//		registro de compras
		
		mw.getAddPurchasePanel().getRegisterPur().addActionListener(this);
		mw.getAddPurchasePanel().getRegisterPur().setActionCommand("addPrePurchase");
		
		mw.getAddPurchasePanel().getEndPur().addActionListener(this);
		mw.getAddPurchasePanel().getEndPur().setActionCommand("endPurchase");
		
		mw.getAddPurchasePanel().getClosePur().addActionListener(this);
		mw.getAddPurchasePanel().getClosePur().setActionCommand("closePurchase");
		
//		_______________________________________________________________________
//		registro por elemento
		
		mw.getRegisterPurchasePanel().getRegisterProPur().addActionListener(this);
		mw.getRegisterPurchasePanel().getRegisterProPur().setActionCommand("registerPurchase");
		
		mw.getRegisterPurchasePanel().getClosePurPanel().addActionListener(this);
		mw.getRegisterPurchasePanel().getClosePurPanel().setActionCommand("closePurchasePanel");
		
		mw.getRegisterPurchasePanel().getQuantityToPur().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int actual=(int)mw.getRegisterPurchasePanel().getQuantityToPur().getValue();
				double price=products.getProducts().get(idPurchaseProduct).getCost();
				double aux=Double.parseDouble(mw.getRegisterPurchasePanel().getTotalCostPur().getText());
				double res=0.0;
				if(previous<actual) {
					res=aux+price;
				}
				else if(previous>actual) {
					res=aux-price;
				}
				if(res<0)res=0.0;
				mw.getRegisterPurchasePanel().getTotalCostPur().setText(Double.toString(res));
				previous=actual;
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "join": {
			
			String username=mw.getLoginPanel().getUserName().getText();
			String password=new String(mw.getLoginPanel().getPassword().getPassword());
			
			int login=users.verifyUser(username, password);
			
			if(login==0) {
				idCurrentUser=users.getId(username);
				mw.getAdminControlPanel().setVisible(true);
				mw.getLoginPanel().getUserName().setText("");
				mw.getLoginPanel().getPassword().setText("");
				mw.getAdminControlPanel().getCurretUser().setText(username);
				mw.getAdminControlPanel().getNameSt().setVisible(true);
				mw.getLoginPanel().setVisible(false);
				
			}
			else if(login==1) {
				idCurrentUser=users.getId(username);
				mw.getSellerControlPanel().setVisible(true);
				mw.getLoginPanel().getUserName().setText("");
				mw.getLoginPanel().getPassword().setText("");
				mw.getSellerControlPanel().getCurretUserSe().setText(username);
				mw.getSellerControlPanel().getNameStSe().setVisible(true);
				mw.getLoginPanel().setVisible(false);
				
			}
			else {
				PopUpMessages.errorMessage(mw, "El usuario o contraseña son inavlidos.");
			}
			break;
		}
		case "recoverKey": {
			mw.getLoginPanel().getTitle().setVisible(false);
			mw.getLoginPanel().getIndUser().setVisible(false);
			mw.getLoginPanel().getUserName().setVisible(false);
			mw.getLoginPanel().getIndPass().setVisible(false);
			mw.getLoginPanel().getPassword().setVisible(false);
			mw.getLoginPanel().getShowPass().setVisible(false);
			mw.getLoginPanel().getIndButton().setVisible(false);
			mw.getLoginPanel().getJoin().setVisible(false);
			mw.getLoginPanel().getRecoverKey().setVisible(false);

			mw.getLoginPanel().getTitleRec().setVisible(true);
			mw.getLoginPanel().getIndUserRec().setVisible(true);
			mw.getLoginPanel().getUserNameRec().setVisible(true);
			mw.getLoginPanel().getIndCancel().setVisible(true);
			mw.getLoginPanel().getIndFollow().setVisible(true);
			mw.getLoginPanel().getCancel().setVisible(true);
			mw.getLoginPanel().getFollow().setVisible(true);
			break;
		}
		case "cancelRec": {
			mw.getLoginPanel().getTitle().setVisible(true);
			mw.getLoginPanel().getIndUser().setVisible(true);
			mw.getLoginPanel().getUserName().setVisible(true);
			mw.getLoginPanel().getIndPass().setVisible(true);
			mw.getLoginPanel().getPassword().setVisible(true);
			mw.getLoginPanel().getShowPass().setVisible(true);
			mw.getLoginPanel().getIndButton().setVisible(true);
			mw.getLoginPanel().getJoin().setVisible(true);
			mw.getLoginPanel().getRecoverKey().setVisible(true);
			mw.getLoginPanel().getUserNameRec().setText("");
			mw.getLoginPanel().getTitleRec().setVisible(false);
			mw.getLoginPanel().getIndUserRec().setVisible(false);
			mw.getLoginPanel().getUserNameRec().setVisible(false);
			mw.getLoginPanel().getIndCancel().setVisible(false);
			mw.getLoginPanel().getIndFollow().setVisible(false);
			mw.getLoginPanel().getCancel().setVisible(false);
			mw.getLoginPanel().getFollow().setVisible(false);
			break;

		}
		case "followRec": {
			String username=mw.getLoginPanel().getUserNameRec().getText();
			userToRecover=users.getUser(username);
			if(userToRecover!=null) {
				mw.getLoginPanel().getTitleRec().setVisible(true);
				mw.getLoginPanel().getIndUserRec().setVisible(false);
				mw.getLoginPanel().getUserNameRec().setVisible(false);
				mw.getLoginPanel().getIndCancel().setVisible(false);
				mw.getLoginPanel().getIndFollow().setVisible(true);
				mw.getLoginPanel().getCancel().setVisible(false);
				mw.getLoginPanel().getFollow().setVisible(false);
				mw.getLoginPanel().getUserNameRec().setText("");
				mw.getLoginPanel().getIndAnswer().setText(userToRecover.getQuestion());
				mw.getLoginPanel().getIndUserChoose().setVisible(true);
				mw.getLoginPanel().getIndQuestion().setVisible(true);
				mw.getLoginPanel().getIndAnswer().setVisible(true);
				mw.getLoginPanel().getAnswer().setVisible(true);
				mw.getLoginPanel().getCheckanswer().setVisible(true);
			}
			else {
				PopUpMessages.errorMessage(mw, "Nombre de ususario invalido.");
			}
			break;
		}
		case "checkAns": {
			String answer=mw.getLoginPanel().getAnswer().getText();
			if(userToRecover.getAnswer().equals(answer)){
				String newPassword=PopUpMessages.inputMessage(mw,"Ingrese nueva contraseña: ","Recuperación de credenciales.");
				if(newPassword!=null&&newPassword.length()>0&&newPassword.length()<=255) {
					int id=users.getId(userToRecover.getName());
					userToRecover.setPassword(newPassword);
					try {
						users.update(id, userToRecover);
						PopUpMessages.informationMessage(mw, "Contraseña cambiada exitosamente.");
						mw.getLoginPanel().getTitleRec().setVisible(false);
						mw.getLoginPanel().getIndUserChoose().setVisible(false);
						mw.getLoginPanel().getIndQuestion().setVisible(false);
						mw.getLoginPanel().getIndAnswer().setVisible(false);
						mw.getLoginPanel().getAnswer().setVisible(false);
						mw.getLoginPanel().getCheckanswer().setVisible(false);
						mw.getLoginPanel().getIndFollow().setVisible(false);
						mw.getLoginPanel().getIndAnswer().setText("");
						mw.getLoginPanel().getAnswer().setText("");
						mw.getLoginPanel().getTitle().setVisible(true);
						mw.getLoginPanel().getIndUser().setVisible(true);
						mw.getLoginPanel().getUserName().setVisible(true);
						mw.getLoginPanel().getIndPass().setVisible(true);
						mw.getLoginPanel().getPassword().setVisible(true);
						mw.getLoginPanel().getShowPass().setVisible(true);
						mw.getLoginPanel().getIndButton().setVisible(true);
						mw.getLoginPanel().getJoin().setVisible(true);
						mw.getLoginPanel().getRecoverKey().setVisible(true);
					} catch (UserException e1) {
						PopUpMessages.errorMessage(mw, e1.getMessage());
					}
					
				}
				else if(newPassword!=null) {
					PopUpMessages.errorMessage(mw,"Contraseña invalida.\nLa contraseña esta vacia o tiene mas de 255 caracteres.");
				}
			}else {
				PopUpMessages.errorMessage(mw, "Respuesta incorrecta.");
			}
			
			break;

		}
//		*********************************************************
		case "supplierAdmin": {

			mw.getSupplierPanel().setVisible(true);
			mw.getSupplierPanel().fillTable(suppliers.showAll());
			mw.getAddUpdateSupplierPanel().setVisible(false);

			mw.getAdminControlPanel().getTitleSupplier().setVisible(true);
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);

			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "addSupplier": {
			mw.getSupplierPanel().setVisible(false);

			mw.getAddUpdateSupplierPanel().setVisible(true);
			mw.getAddUpdateSupplierPanel().getTitleRegisterS().setVisible(true);
			mw.getAddUpdateSupplierPanel().getRegisterSup().setVisible(true);
			mw.getAddUpdateSupplierPanel().getIndRegisterSup().setVisible(true);
			mw.getAddUpdateSupplierPanel().getTitleUpdateS().setVisible(false);
			mw.getAddUpdateSupplierPanel().getUpdateSup().setVisible(false);
			mw.getAddUpdateSupplierPanel().getIndUpdateSup().setVisible(false);

			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			break;
		}
		case "deleteSupplier": {
			int selectedRow=mw.getSupplierPanel().getListSupplier().getSelectedRow();
			if(selectedRow!=-1) {
				int id=Integer.parseInt((String)mw.getSupplierPanel().getListSupplier().getValueAt(selectedRow, 0));
				int res=PopUpMessages.confirmMessage("¿Seguro que quiere eliminar permanentemente el proveedor.\n"
						+ "Eliminara todos los productos asociados al proveedor?", mw);
				if(res==0) {
					try {
						suppliers.delete(id);
						mw.getSupplierPanel().fillTable(suppliers.showAll());
						reload("supplier");
					} catch (SupplierException error) {
						PopUpMessages.errorMessage(mw, error.getMessage());
					}
				}
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado un proveedor a eliminar.");
			}
			break;
		}
		case "upSupplier": {
			int selectedRow=mw.getSupplierPanel().getListSupplier().getSelectedRow();
			if(selectedRow!=-1) {
				idUpdate=Integer.parseInt((String)mw.getSupplierPanel().getListSupplier().getValueAt(selectedRow, 0));
				SupplierDTO sup=suppliers.getSuppliers().get(idUpdate);
				mw.getAddUpdateSupplierPanel().getNameSup().setText(sup.getName());
				mw.getAddUpdateSupplierPanel().getDirectionSup().setText(sup.getAddress());
				mw.getAddUpdateSupplierPanel().getPhoneSup().setText(sup.getPhone());
				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(true);
				mw.getAddUpdateSupplierPanel().getTitleRegisterS().setVisible(false);
				mw.getAddUpdateSupplierPanel().getRegisterSup().setVisible(false);
				mw.getAddUpdateSupplierPanel().getIndRegisterSup().setVisible(false);
				mw.getAddUpdateSupplierPanel().getTitleUpdateS().setVisible(true);
				mw.getAddUpdateSupplierPanel().getUpdateSup().setVisible(true);
				mw.getAddUpdateSupplierPanel().getIndUpdateSup().setVisible(true);

				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado un proveedor a actualizar.");
			}
			break;
		}
		case "registerSupplier": {
//			agregar proveedor a la lista
			boolean add=false;
			try {
				String name=mw.getAddUpdateSupplierPanel().getNameSup().getText();
				String address=mw.getAddUpdateSupplierPanel().getDirectionSup().getText();
				String phone=mw.getAddUpdateSupplierPanel().getPhoneSup().getText();
				suppliers.create(new SupplierDTO(name, address, phone));
				add=true;
			} catch (SupplierException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Proveedor agregado exitosamente.");
				mw.getAddUpdateSupplierPanel().getNameSup().setText("");
				mw.getAddUpdateSupplierPanel().getDirectionSup().setText("");
				mw.getAddUpdateSupplierPanel().getPhoneSup().setText("");
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);
				
				mw.getSupplierPanel().fillTable(suppliers.showAll());
				mw.getSupplierPanel().setVisible(true);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			break;
		}
		case "updateSupplier": {
//			actualizar proveedor en la lista
			boolean add=false;
			try {
				String name=mw.getAddUpdateSupplierPanel().getNameSup().getText();
				String address=mw.getAddUpdateSupplierPanel().getDirectionSup().getText();
				String phone=mw.getAddUpdateSupplierPanel().getPhoneSup().getText();
				suppliers.update(idUpdate,new SupplierDTO(name, address, phone));
				add=true;
			} catch (SupplierException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Proveedor actualizado exitosamente.");
				mw.getAddUpdateSupplierPanel().getNameSup().setText("");
				mw.getAddUpdateSupplierPanel().getDirectionSup().setText("");
				mw.getAddUpdateSupplierPanel().getPhoneSup().setText("");
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().fillTable(suppliers.showAll());
				mw.getSupplierPanel().setVisible(true);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			
			break;
		}
		case "closeSupplier": {
			mw.getSupplierPanel().setVisible(true);
			mw.getAddUpdateSupplierPanel().getNameSup().setText("");
			mw.getAddUpdateSupplierPanel().getDirectionSup().setText("");
			mw.getAddUpdateSupplierPanel().getPhoneSup().setText("");
			mw.getAddUpdateSupplierPanel().setVisible(false);
			break;
		}
		case "inventoryAdmin": {
			mw.getInventoryPanel().fillTable(products.showAll(suppliers.getSuppliers()));
			mw.getInventoryPanel().setVisible(true);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getAdminControlPanel().getTitleInventory().setVisible(true);
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);

			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "addProduct": {
			if(suppliers.getSuppliers().size()>0) {
				mw.getInventoryPanel().setVisible(false);
				supplierProduct=new HashMap<>();
				for(int idSup:suppliers.getSuppliers().keySet()) {
					String nameSup=suppliers.getSuppliers().get(idSup).getName();
					supplierProduct.put(nameSup, idSup);
				}
				mw.getAddUpdateInventoryPanel().addSuplliers(supplierProduct.keySet());
				mw.getAddUpdateInventoryPanel().setVisible(true);
				mw.getAddUpdateInventoryPanel().getTitleRegisterIn().setVisible(true);
				mw.getAddUpdateInventoryPanel().getRegisterPro().setVisible(true);
				mw.getAddUpdateInventoryPanel().getIndRegisterPro().setVisible(true);
				mw.getAddUpdateInventoryPanel().getTitleUpdateIn().setVisible(false);
				mw.getAddUpdateInventoryPanel().getUpdatePro().setVisible(false);
				mw.getAddUpdateInventoryPanel().getIndUpdatePro().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);

				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			else {
				PopUpMessages.informationMessage(mw, "No se pueden agregar productos si no hay proveedores registrados.");
			}
			break;
		}
		case "deleteProduct": {
			int selectedRow=mw.getInventoryPanel().getListInventory().getSelectedRow();
			if(selectedRow!=-1) {
				int id=Integer.parseInt((String)mw.getInventoryPanel().getListInventory().getValueAt(selectedRow, 0));
				int res=PopUpMessages.confirmMessage("¿Seguro que quiere eliminar permanentemente el producto?", mw);
				if(res==0) {
					try {
						products.delete(id);
						mw.getInventoryPanel().fillTable(products.showAll(suppliers.getSuppliers()));
						reload("product");
					} catch (ProductException error) {
						PopUpMessages.errorMessage(mw, error.getMessage());
					}
				}
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado un producto a eliminar.");
			}
			break;
		}
		case "upProduct": {
			int selectedRow=mw.getInventoryPanel().getListInventory().getSelectedRow();
			if(selectedRow!=-1) {
				idUpdate=Integer.parseInt((String)mw.getInventoryPanel().getListInventory().getValueAt(selectedRow, 0));
				ProductDTO pro=products.getProducts().get(idUpdate);
				mw.getAddUpdateInventoryPanel().getPricePro().setText(Double.toString(pro.getPrice()));
				mw.getAddUpdateInventoryPanel().getNamePro().setText(pro.getName());
				mw.getAddUpdateInventoryPanel().getCostPro().setText(Double.toString(pro.getCost()));
				mw.getAddUpdateInventoryPanel().getQuantityPro().setText(Integer.toString(pro.getQuantity()));
				supplierProduct=new HashMap<>();
				String selectedProv="";
				for(int idSup:suppliers.getSuppliers().keySet()) {
					String nameSup=suppliers.getSuppliers().get(idSup).getName();
					supplierProduct.put(nameSup, idSup);
					if(idSup==pro.getIdSuplierPartner()) {
						selectedProv=nameSup;
					}
				}
				mw.getAddUpdateInventoryPanel().addSuplliers(supplierProduct.keySet());
				mw.getAddUpdateInventoryPanel().getSupplierA().setSelectedItem(selectedProv);
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(true);
				mw.getAddUpdateInventoryPanel().getTitleRegisterIn().setVisible(false);
				mw.getAddUpdateInventoryPanel().getRegisterPro().setVisible(false);
				mw.getAddUpdateInventoryPanel().getIndRegisterPro().setVisible(false);
				mw.getAddUpdateInventoryPanel().getTitleUpdateIn().setVisible(true);
				mw.getAddUpdateInventoryPanel().getUpdatePro().setVisible(true);
				mw.getAddUpdateInventoryPanel().getIndUpdatePro().setVisible(true);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);

				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado un producto a actualizar.");
			}
			break;
		}
		case "registerProduct": {
//			registrar producto en la lista
			boolean add=false;
			try {
				String name=mw.getAddUpdateInventoryPanel().getNamePro().getText();
				double price=0.0;
				try {
					price=Double.parseDouble(mw.getAddUpdateInventoryPanel().getPricePro().getText());
				} catch (NumberFormatException error) {
					throw new ProductException(2);
				}
				double cost=0.0;
				try {
					cost=Double.parseDouble(mw.getAddUpdateInventoryPanel().getCostPro().getText());
				} catch (NumberFormatException error) {
					throw new ProductException(3);
				}
				int quantity=0;
				try {
					quantity=Integer.parseInt(mw.getAddUpdateInventoryPanel().getQuantityPro().getText());
				} catch (NumberFormatException error) {
					throw new ProductException(4);
				}
				int idSup=supplierProduct.get((String)mw.getAddUpdateInventoryPanel().getSupplierA().getSelectedItem());
				products.create(new ProductDTO(name, price, cost, quantity, idSup));
				add=true;
				
			} catch (ProductException err) {
				PopUpMessages.errorMessage(mw, err.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Producto agregado exitosamente.");
				mw.getAddUpdateInventoryPanel().getPricePro().setText("");
				mw.getAddUpdateInventoryPanel().getNamePro().setText("");
				mw.getAddUpdateInventoryPanel().getCostPro().setText("");
				mw.getAddUpdateInventoryPanel().getQuantityPro().setText("");
				mw.getInventoryPanel().fillTable(products.showAll(suppliers.getSuppliers()));
				mw.getInventoryPanel().setVisible(true);
				mw.getAddUpdateInventoryPanel().setVisible(false);
				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			break;
		}
		case "updateProduct": {
			boolean add=false;
			try {
				String name=mw.getAddUpdateInventoryPanel().getNamePro().getText();
				double price=0.0;
				try {
					price=Double.parseDouble(mw.getAddUpdateInventoryPanel().getPricePro().getText());
				} catch (NumberFormatException error) {
					throw new ProductException(2);
				}
				double cost=0.0;
				try {
					cost=Double.parseDouble(mw.getAddUpdateInventoryPanel().getCostPro().getText());
				} catch (NumberFormatException error) {
					throw new ProductException(3);
				}
				int quantity=0;
				try {
					quantity=Integer.parseInt(mw.getAddUpdateInventoryPanel().getQuantityPro().getText());
				} catch (NumberFormatException error) {
					throw new ProductException(4);
				}
				int idSup=supplierProduct.get((String)mw.getAddUpdateInventoryPanel().getSupplierA().getSelectedItem());
				products.update(idUpdate, new ProductDTO(name, price, cost, quantity, idSup));
				add=true;
			} catch (ProductException err) {
				PopUpMessages.errorMessage(mw, err.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Producto actualizado exitosamente.");
				mw.getAddUpdateInventoryPanel().getPricePro().setText("");
				mw.getAddUpdateInventoryPanel().getNamePro().setText("");
				mw.getAddUpdateInventoryPanel().getCostPro().setText("");
				mw.getAddUpdateInventoryPanel().getQuantityPro().setText("");
				mw.getInventoryPanel().fillTable(products.showAll(suppliers.getSuppliers()));
				mw.getInventoryPanel().setVisible(true);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			break;
		}
		case "closeProduct": {
			mw.getAddUpdateInventoryPanel().getPricePro().setText("");
			mw.getAddUpdateInventoryPanel().getNamePro().setText("");
			mw.getAddUpdateInventoryPanel().getCostPro().setText("");
			mw.getAddUpdateInventoryPanel().getQuantityPro().setText("");
			mw.getInventoryPanel().setVisible(true);
			mw.getAddUpdateInventoryPanel().setVisible(false);
			break;
		}
		case "salesAdmin": {
			mw.getSalesPanel().fillTable(sales.showAll());
			mw.getSalesPanel().setVisible(true);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(true);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);

			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "addSale": {
			if(products.getProducts().size()>0) {
				mw.getAddUpdateSalesPanel().fillTable(products.showForSales());
				String usernames[]=new String[users.getUsers().size()];
				int i=0;
				for(UserDTO us:users.getUsers().values()) {
					usernames[i++]=us.getName();
				}
				mw.getAddUpdateSalesPanel().fillCB(usernames);
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(true);
				mw.getAddUpdateSalesPanel().getTitleRegisterSa().setVisible(true);
				mw.getAddUpdateSalesPanel().getRegisterSa().setVisible(true);
				mw.getAddUpdateSalesPanel().getIndRegisterSale().setVisible(true);
				mw.getAddUpdateSalesPanel().getTitleUpdateSa().setVisible(false);
				mw.getAddUpdateSalesPanel().getUpdateSa().setVisible(false);
				mw.getAddUpdateSalesPanel().getIndUpdateSale().setVisible(false);

				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			else {
				PopUpMessages.informationMessage(mw, "No se pueden registrar ventas si no hay productos registrados.");
			}

			break;
		}
		case "deleteSale": {
			int selectedRow=mw.getSalesPanel().getListSales().getSelectedRow();
			if(selectedRow!=-1) {
				int id=Integer.parseInt((String)mw.getSalesPanel().getListSales().getValueAt(selectedRow, 0));
				int res=PopUpMessages.confirmMessage("¿Seguro que quiere eliminar permanentemente la venta?", mw);
				if(res==0) {
					try {
						sales.delete(id);
						mw.getSalesPanel().fillTable(sales.showAll());
					} catch (SaleException error) {
						PopUpMessages.errorMessage(mw, error.getMessage());
					}
				}
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado una venta a eliminar.");
			}
			break;
		}
		case "upSa": {
			int selectedRow=mw.getSalesPanel().getListSales().getSelectedRow();
			if(selectedRow!=-1&&products.getProducts().size()>0) {
				idUpdate=Integer.parseInt((String)mw.getSalesPanel().getListSales().getValueAt(selectedRow, 0));
				saleToUpdate=sales.getSales().get(idUpdate);
				String usernames[]=new String[users.getUsers().size()];
				int i=0;
				for(UserDTO us:users.getUsers().values()) {
					usernames[i++]=us.getName();
				}
				mw.getAddUpdateSalesPanel().fillTable(products.showForSales(saleToUpdate.getProducts()));
				mw.getAddUpdateSalesPanel().getTotal().setText(Double.toString(saleToUpdate.getTotalPay()));
				mw.getAddUpdateSalesPanel().getSellerName().setSelectedItem(saleToUpdate.getSeller());
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(true);
				mw.getAddUpdateSalesPanel().getTitleRegisterSa().setVisible(false);
				mw.getAddUpdateSalesPanel().getRegisterSa().setVisible(false);
				mw.getAddUpdateSalesPanel().getIndRegisterSale().setVisible(false);
				mw.getAddUpdateSalesPanel().getTitleUpdateSa().setVisible(true);
				mw.getAddUpdateSalesPanel().getUpdateSa().setVisible(true);
				mw.getAddUpdateSalesPanel().getIndUpdateSale().setVisible(true);

				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			else if(selectedRow==-1) {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado venta a actualizar.");
			}
			else {
				PopUpMessages.informationMessage(mw, "No se pueden actualizar ventas si no hay productos registrados.");
			}
			break;
		}
		case "registerSale": {
			boolean add=false;
			try {
				double totalPay=Double.parseDouble(mw.getAddUpdateSalesPanel().getTotal().getText());
				LocalDate date=LocalDate.now();
				String seller=(String)mw.getAddUpdateSalesPanel().getSellerName().getSelectedItem();
				HashMap<Integer, Integer> prod=new HashMap<>();
				for(int selectetRow=0;selectetRow<mw.getAddUpdateSalesPanel().getProductsTable().getModel().getRowCount();selectetRow++) {
					int val=mw.getAddUpdateSalesPanel().getQuantity(selectetRow);
					if(val!=0) {
						int idp=(int)mw.getAddUpdateSalesPanel().getProductsTable().getValueAt(selectetRow, 0);
						prod.put(idp, val);
						ProductDTO pro=products.getProducts().get(idp);
						pro.setQuantity(pro.getQuantity()-val);
						products.update(idp, pro);
					}
				}
				sales.create(new SaleDTO(date, prod, seller, totalPay));
				add=true;
			}catch (SaleException | ProductException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Venta agragada exitosamente.");
				mw.getSalesPanel().fillTable(sales.showAll());
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(true);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			
			break;
		}
		case "updateSale": {
			boolean add=false;
			try {
				double totalPay=Double.parseDouble(mw.getAddUpdateSalesPanel().getTotal().getText());
				LocalDate date=LocalDate.now();
				String seller=(String)mw.getAddUpdateSalesPanel().getSellerName().getSelectedItem();
				HashMap<Integer, Integer> prod=new HashMap<>();
				for(int selectetRow=0;selectetRow<mw.getAddUpdateSalesPanel().getProductsTable().getModel().getRowCount();selectetRow++) {
					int val=mw.getAddUpdateSalesPanel().getQuantity(selectetRow);
					int idp=(int)mw.getAddUpdateSalesPanel().getProductsTable().getValueAt(selectetRow, 0);
					if(val!=0) {
						prod.put(idp, val);
						ProductDTO pro=products.getProducts().get(idp);
						int previous=saleToUpdate.getProducts().getOrDefault(idp, 0);
						if(previous>val) {
							pro.setQuantity(pro.getQuantity()+(previous-val));
						}
						else if(previous<val) {
							pro.setQuantity(pro.getQuantity()-(val-previous));
						}
						products.update(idp, pro);
					}
					else if(saleToUpdate.getProducts().containsKey(idp)) {
						ProductDTO pro=products.getProducts().get(idp);
						pro.setQuantity(pro.getQuantity()+saleToUpdate.getProducts().get(idp));
						products.update(idp, pro);
					}
				}
				sales.update(idUpdate,new SaleDTO(date, prod, seller, totalPay));
				add=true;
			}catch (SaleException | ProductException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Venta actualizada exitosamente.");
				mw.getSalesPanel().fillTable(sales.showAll());
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(true);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			break;
		}
		case "closeSale": {
			mw.getSalesPanel().setVisible(true);
			mw.getAddUpdateSalesPanel().setVisible(false);
			break;
		}
		case "userControlAdmin":{
			mw.getUserControlPanel().fillTable(users.showAll());
			mw.getUserControlPanel().setVisible(true);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(true);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);
			
			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "addUser":{
			mw.getUserControlPanel().setVisible(false);

			mw.getAddUpdateUserControlPanel().setVisible(true);
			
			mw.getAddUpdateUserControlPanel().getTitleRegisterU().setVisible(true);
			mw.getAddUpdateUserControlPanel().getRegisterUser().setVisible(true);
			mw.getAddUpdateUserControlPanel().getIndRegisterUs().setVisible(true);
			mw.getAddUpdateUserControlPanel().getTitleUpdateU().setVisible(false);
			mw.getAddUpdateUserControlPanel().getUpdateUser().setVisible(false);
			mw.getAddUpdateUserControlPanel().getIndUpdateUs().setVisible(false);

			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			break;
		}
		case "deleteUser":{
			int selectedRow=mw.getUserControlPanel().getListUser().getSelectedRow();
			if(selectedRow!=-1) {
				int id=Integer.parseInt((String)mw.getUserControlPanel().getListUser().getValueAt(selectedRow, 0));
				if(id!=1) {
					int res=PopUpMessages.confirmMessage("¿Seguro que quiere eliminar permanentemente el usuario?", mw);
					if(res==0) {
						try {
							users.delete(id);
							mw.getUserControlPanel().fillTable(users.showAll());
						} catch (UserException error) {
							PopUpMessages.errorMessage(mw, error.getMessage());
						}
						if(idCurrentUser==id) {
							mw.getLoginPanel().setVisible(true);

							mw.getAdminControlPanel().setVisible(false);
							
							mw.getPurchasePanel().setVisible(false);
							mw.getAddPurchasePanel().setVisible(false);
							mw.getRegisterPurchasePanel().setVisible(false);
							
							mw.getInventoryPanel().setVisible(false);
							mw.getAddUpdateInventoryPanel().setVisible(false);

							mw.getSupplierPanel().setVisible(false);
							mw.getAddUpdateSupplierPanel().setVisible(false);
							
							mw.getSalesPanel().setVisible(false);
							mw.getAddUpdateSalesPanel().setVisible(false);
							
							mw.getUserControlPanel().setVisible(false);
							mw.getAddUpdateUserControlPanel().setVisible(false);
							
							mw.getCashControlPanel().setVisible(false);
							
							mw.getAdminControlPanel().getTitleInventory().setVisible(false);
							mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
							mw.getAdminControlPanel().getTitleSales().setVisible(false);
							mw.getAdminControlPanel().getTitleConUser().setVisible(false);
							mw.getAdminControlPanel().getTitleConCash().setVisible(false);
							mw.getAdminControlPanel().getTitlePurchase().setVisible(false);
							mw.getSellerControlPanel().getTitleInventorySe().setVisible(false);
							mw.getSellerControlPanel().getTitleSalesSe().setVisible(false);
						}
					}
				}
				else {
					PopUpMessages.informationMessage(mw, "No se puede eliminar al administrador principal.");
				}
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado un usuario a eliminar.");
			}
			break;
		}
		case "upUser":{
			int selectedRow=mw.getUserControlPanel().getListUser().getSelectedRow();
			if(selectedRow!=-1) {
				idUpdate=Integer.parseInt((String)mw.getUserControlPanel().getListUser().getValueAt(selectedRow, 0));
				if(idUpdate!=1) {
					UserDTO user=users.getUsers().get(idUpdate);
					mw.getAddUpdateUserControlPanel().getNameUser().setText(user.getName());
					mw.getAddUpdateUserControlPanel().getPassUser().setText(user.getPassword());
					mw.getAddUpdateUserControlPanel().getQuestionUser().setText(user.getQuestion());
					mw.getAddUpdateUserControlPanel().getAnswerUser().setText(user.getAnswer());
					mw.getAddUpdateUserControlPanel().getRol().clearSelection();
					if(user.isAdministrator()) {
						mw.getAddUpdateUserControlPanel().getIsAdmin().setSelected(true);
					}
					else{
						mw.getAddUpdateUserControlPanel().getNotAdmin().setSelected(true);
					}
					mw.getUserControlPanel().setVisible(false);
					mw.getAddUpdateUserControlPanel().setVisible(true);
					mw.getAddUpdateUserControlPanel().getTitleRegisterU().setVisible(false);
					mw.getAddUpdateUserControlPanel().getRegisterUser().setVisible(false);
					mw.getAddUpdateUserControlPanel().getIndRegisterUs().setVisible(false);
					mw.getAddUpdateUserControlPanel().getTitleUpdateU().setVisible(true);
					mw.getAddUpdateUserControlPanel().getUpdateUser().setVisible(true);
					mw.getAddUpdateUserControlPanel().getIndUpdateUs().setVisible(true);

					mw.getInventoryPanel().setVisible(false);
					mw.getAddUpdateInventoryPanel().setVisible(false);

					mw.getSupplierPanel().setVisible(false);
					mw.getAddUpdateSupplierPanel().setVisible(false);
					
					mw.getSalesPanel().setVisible(false);
					mw.getAddUpdateSalesPanel().setVisible(false);
					
					mw.getCashControlPanel().setVisible(false);
					
					mw.getPurchasePanel().setVisible(false);
					mw.getAddPurchasePanel().setVisible(false);
					mw.getRegisterPurchasePanel().setVisible(false);	
				}
				else {
					PopUpMessages.informationMessage(mw, "No se puede actualizar al administrador principal.");
				}
			}
			else {
				PopUpMessages.informationMessage(mw, "No se ha seleccionado usuario a actualizar.");
			}
			break;
		}
		case "registerUser":{
			
			boolean add=false;
			try {
				String username=mw.getAddUpdateUserControlPanel().getNameUser().getText();
				String password=mw.getAddUpdateUserControlPanel().getPassUser().getText();
				String question=mw.getAddUpdateUserControlPanel().getQuestionUser().getText();
				String answer=mw.getAddUpdateUserControlPanel().getAnswerUser().getText();
				boolean isAdmin=mw.getAddUpdateUserControlPanel().getIsAdmin().isSelected();
				users.create(new UserDTO(username, password, question, answer, isAdmin));
				add=true;
			} catch (UserException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			
			if(add) {
				PopUpMessages.informationMessage(mw, "Usuario registrado exitosamente.");
				mw.getAddUpdateUserControlPanel().getNameUser().setText("");
				mw.getAddUpdateUserControlPanel().getPassUser().setText("");
				mw.getAddUpdateUserControlPanel().getQuestionUser().setText("");
				mw.getAddUpdateUserControlPanel().getAnswerUser().setText("");
				mw.getUserControlPanel().fillTable(users.showAll());
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(true);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			
			break;
		}
		case "updateUser":{
			boolean add=false;
			try {
				String username=mw.getAddUpdateUserControlPanel().getNameUser().getText();
				String password=mw.getAddUpdateUserControlPanel().getPassUser().getText();
				String question=mw.getAddUpdateUserControlPanel().getQuestionUser().getText();
				String answer=mw.getAddUpdateUserControlPanel().getAnswerUser().getText();
				boolean isAdmin=mw.getAddUpdateUserControlPanel().getIsAdmin().isSelected();
				String antUsername=users.getUsers().get(idUpdate).getName();
				users.update(idUpdate,new UserDTO(username, password, question, answer, isAdmin));
				for(int ids:sales.getSales().keySet()) {
					SaleDTO sale=sales.getSales().get(ids);
					if(sale.getSeller().equals(antUsername)) {
						sale.setSeller(username);
						sales.update(ids, sale);
					}
				}
				add=true;
			} catch (UserException | SaleException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Usuario actualizado exitosamente.");
				mw.getAddUpdateUserControlPanel().getNameUser().setText("");
				mw.getAddUpdateUserControlPanel().getPassUser().setText("");
				mw.getAddUpdateUserControlPanel().getQuestionUser().setText("");
				mw.getAddUpdateUserControlPanel().getAnswerUser().setText("");
				mw.getUserControlPanel().fillTable(users.showAll());
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(true);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
				
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
			}
			break;
		}
		case "closeUser":{
			mw.getAddUpdateUserControlPanel().getNameUser().setText("");
			mw.getAddUpdateUserControlPanel().getPassUser().setText("");
			mw.getAddUpdateUserControlPanel().getQuestionUser().setText("");
			mw.getAddUpdateUserControlPanel().getAnswerUser().setText("");
			mw.getUserControlPanel().setVisible(true);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			break;
		}
		case "isAdmin":{
//			marcar que es administrador
			break;
		}
		case "notAdmin":{
//			marcar que es vendedor
			break;
		}
		case "cashControlAdmin":{
			infoCashControl();
			mw.getCashControlPanel().setVisible(true);
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(true);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);
			
			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "purchaseAdmin":{
			mw.getPurchasePanel().fillTable(purchases.showAll());
			mw.getPurchasePanel().setVisible(true);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(true);
			
			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "addPurchase":{
			if(products.getProducts().size()>0) {
				mw.getAddPurchasePanel().fillList(products.productsNamesAndIDs());
				mw.getAddPurchasePanel().getTotalPurchase().setText("0");
				productsPurchase=new HashMap<>();
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(true);
				mw.getRegisterPurchasePanel().setVisible(false);
				
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				mw.getCashControlPanel().setVisible(false);
			}
			else {
				PopUpMessages.informationMessage(mw, "No se pueden realizar compras si no hay productos registrados.");
			}
			break;
		}
		case "addPrePurchase":{
			int selectedIndex=mw.getAddPurchasePanel().getProductsListPur().getSelectedIndex();
			if(selectedIndex!=-1) {
				idPurchaseProduct=mw.getAddPurchasePanel().getID(selectedIndex);
				ProductDTO pro=products.getProducts().get(idPurchaseProduct);
				mw.getRegisterPurchasePanel().getNameProPur().setText(pro.getName());
				mw.getRegisterPurchasePanel().getaSupplierPur().setText(suppliers.getSuppliers().get(pro.getIdSuplierPartner()).getName());
				mw.getRegisterPurchasePanel().getTotalCostPur().setText("0");
				mw.getRegisterPurchasePanel().getUniCostPur().setText(Double.toString(pro.getCost()));
				mw.getRegisterPurchasePanel().getQuantityInPur().setText(Integer.toString(pro.getQuantity()));
				mw.getRegisterPurchasePanel().getQuantityToPur().setValue(0);
				previous=0;
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(true);
				
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
			}
			else {
				PopUpMessages.errorMessage(mw, "Por favor seleccione un producto a agregar a la compra.");
			}
			break;
		}
		case "endPurchase":{
			
//			preguntar por confirmar si desea terminar la compra
			boolean add=false;
			try {
				double totalPay=Double.parseDouble(mw.getAddPurchasePanel().getTotalPurchase().getText());
				LocalDate date=LocalDate.now();
				for(int idp:productsPurchase.keySet()) {
					ProductDTO pro=products.getProducts().get(idp);
					pro.setQuantity(pro.getQuantity()+productsPurchase.get(idp));
					products.update(idp, pro);
				}
				purchases.create(new PurchaseDTO(date, productsPurchase, totalPay));
				add=true;
			} catch (PurchaseException | ProductException error) {
				PopUpMessages.errorMessage(mw, error.getMessage());
			}
			if(add) {
				PopUpMessages.informationMessage(mw, "Compra realizada exitosamente.");
				mw.getPurchasePanel().fillTable(purchases.showAll());
				mw.getPurchasePanel().setVisible(true);
				mw.getAddPurchasePanel().setVisible(false);
				mw.getRegisterPurchasePanel().setVisible(false);
				
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
			}
			break;
		}
		case "closePurchase":{
			mw.getPurchasePanel().setVisible(true);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			break;
		}
		case "registerPurchase":{
//			registrar el producto seleccionado en compra
			int quantity=(int)mw.getRegisterPurchasePanel().getQuantityToPur().getValue();
			if(quantity>0) {
				double agre=Double.parseDouble(mw.getRegisterPurchasePanel().getTotalCostPur().getText());
				double amount=Double.parseDouble(mw.getAddPurchasePanel().getTotalPurchase().getText());
				mw.getAddPurchasePanel().getTotalPurchase().setText(Double.toString(agre+amount));
				productsPurchase.put(idPurchaseProduct, productsPurchase.getOrDefault(idPurchaseProduct, 0)+quantity);
				mw.getPurchasePanel().setVisible(false);
				mw.getAddPurchasePanel().setVisible(true);
				mw.getRegisterPurchasePanel().setVisible(false);
				
				mw.getInventoryPanel().setVisible(false);
				mw.getAddUpdateInventoryPanel().setVisible(false);

				mw.getSupplierPanel().setVisible(false);
				mw.getAddUpdateSupplierPanel().setVisible(false);
				
				mw.getSalesPanel().setVisible(false);
				mw.getAddUpdateSalesPanel().setVisible(false);
				
				mw.getUserControlPanel().setVisible(false);
				mw.getAddUpdateUserControlPanel().setVisible(false);
				
				mw.getCashControlPanel().setVisible(false);
			}
			else {
				PopUpMessages.errorMessage(mw, "No se ha agragado ningun producto seleccione una cantidad mayor a cero.");
			}
			break;
		}
		case "closePurchasePanel":{
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(true);
			mw.getRegisterPurchasePanel().setVisible(false);
			break;
		}
		case "exitAdmin":{
			mw.getLoginPanel().setVisible(true);

			mw.getAdminControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);
			mw.getSellerControlPanel().getTitleInventorySe().setVisible(false);
			mw.getSellerControlPanel().getTitleSalesSe().setVisible(false);
			break;
		}
		case "inventorySeller":{
			mw.getSellerControlPanel().getTitleInventorySe().setVisible(true);
			mw.getSellerControlPanel().getTitleSalesSe().setVisible(false);
			
			mw.getInventoryPanel().setVisible(true);
			mw.getInventoryPanel().getTitleIn().setVisible(false);
			mw.getInventoryPanel().getAddPro().setVisible(false);
			mw.getInventoryPanel().getIndAddP().setVisible(false);
			mw.getInventoryPanel().getDelPro().setVisible(false);
			mw.getInventoryPanel().getIndDelP().setVisible(false);
			mw.getInventoryPanel().getUpPro().setVisible(false);
			mw.getInventoryPanel().getIndUpP().setVisible(false);
			
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);

			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			
			break;
		}
		case "salesSeller":{
			
			mw.getSellerControlPanel().getTitleInventorySe().setVisible(false);
			mw.getSellerControlPanel().getTitleSalesSe().setVisible(true);
			
			mw.getAdminControlPanel().setVisible(false);
			
			
			mw.getSalesPanel().setVisible(true);
			mw.getAddUpdateSalesPanel().setVisible(false);

			mw.getInventoryPanel().setVisible(false);
			
			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);

			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getSellerControlPanel().getNameStSe().setVisible(false);
			mw.getAdminControlPanel().getNameSt().setVisible(false);
			break;
		}
		case "exitSeller":{
			mw.getLoginPanel().setVisible(true);

			mw.getAdminControlPanel().setVisible(false);
			mw.getSellerControlPanel().setVisible(false);
			
			mw.getPurchasePanel().setVisible(false);
			mw.getAddPurchasePanel().setVisible(false);
			mw.getRegisterPurchasePanel().setVisible(false);
			
			mw.getInventoryPanel().setVisible(false);
			mw.getAddUpdateInventoryPanel().setVisible(false);

			mw.getSupplierPanel().setVisible(false);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			mw.getSalesPanel().setVisible(false);
			mw.getAddUpdateSalesPanel().setVisible(false);
			
			mw.getUserControlPanel().setVisible(false);
			mw.getAddUpdateUserControlPanel().setVisible(false);
			
			mw.getCashControlPanel().setVisible(false);
			
			mw.getInventoryPanel().getTitleIn().setVisible(true);
			mw.getInventoryPanel().getAddPro().setVisible(true);
			mw.getInventoryPanel().getIndAddP().setVisible(true);
			mw.getInventoryPanel().getDelPro().setVisible(true);
			mw.getInventoryPanel().getIndDelP().setVisible(true);
			mw.getInventoryPanel().getUpPro().setVisible(true);
			mw.getInventoryPanel().getIndUpP().setVisible(true);
			
			mw.getAdminControlPanel().getTitleInventory().setVisible(false);
			mw.getAdminControlPanel().getTitleSupplier().setVisible(false);
			mw.getAdminControlPanel().getTitleSales().setVisible(false);
			mw.getAdminControlPanel().getTitleConUser().setVisible(false);
			mw.getAdminControlPanel().getTitleConCash().setVisible(false);
			mw.getAdminControlPanel().getTitlePurchase().setVisible(false);
			mw.getSellerControlPanel().getTitleInventorySe().setVisible(false);
			mw.getSellerControlPanel().getTitleSalesSe().setVisible(false);

			break;
		}
		
		
		default:
			break;
		}
	}
	
	public void infoCashControl(){
		HashMap<Integer, Double> incomeByProduct=new HashMap<>();
		for(int idp:products.getProducts().keySet()) {
			ProductDTO pro=products.getProducts().get(idp);
			double income=0.0;
			for(SaleDTO sale:sales.getSales().values()) {
				if(sale.getProducts().containsKey(idp)) {
					int quantity=sale.getProducts().get(idp);
					income+=(quantity*pro.getPrice());
				}
			}
			incomeByProduct.put(idp, income);
		}
		HashMap<Integer, Double> expensesByProduct=new HashMap<>();
		for(int idp:products.getProducts().keySet()) {
			ProductDTO pro=products.getProducts().get(idp);
			double expenses=0.0;
			for(PurchaseDTO purchase:purchases.getPurchases().values()) {
				if(purchase.getProducts().containsKey(idp)) {
					int quantity=purchase.getProducts().get(idp);
					expenses+=(quantity*pro.getCost());
				}
			}
			expensesByProduct.put(idp, expenses);
		}
		Object info[][]=new Object[products.getProducts().size()][4];
		int i=0;
		double totalEarnigs=0.0,totalIncomes=0.0,totalExpenses=0.0;
		for(int idp:products.getProducts().keySet()) {
			double income=incomeByProduct.get(idp),expenses=expensesByProduct.get(idp);
			double earnings=income-expenses;
			info[i][0]=products.getProducts().get(idp).getName();
			info[i][1]=income;
			info[i][2]=expenses;
			info[i][3]=earnings;
			totalEarnigs+=earnings;
			totalExpenses+=expenses;
			totalIncomes+=income;
			i++;
		}
		mw.getCashControlPanel().getTotalIncome().setText("<html>Total Ingresos<br>"+totalIncomes+"</html>");
		mw.getCashControlPanel().getTotalExpenses().setText("<html>Total Costos<br>"+totalExpenses+"</html>");
		mw.getCashControlPanel().getTotal().setText("<html>Total Ganancias<br>"+totalEarnigs+"</html>");
		mw.getCashControlPanel().fillTable(info);
	}
	
	
	public void reload(String deleteOperation) {
		if(deleteOperation.equals("supplier")) {
			products=new ProductDAO();
			sales=new SaleDAO();
			purchases=new PurchaseDAO();
		}
		if(deleteOperation.equals("product")) {
			sales=new SaleDAO();
			purchases=new PurchaseDAO();
		}
	}
	
}
