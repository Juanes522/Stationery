package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.SupplierDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.SupplierDAO;
import co.edu.unbosque.model.persistence.UserDAO;
import co.edu.unbosque.util.exception.SupplierException;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener {

	private MainWindow mw;
	private UserDAO users;
	private SupplierDAO suppliers;
	private int idUpdate;
	private UserDTO userToRecover;

	public Controller() {
		mw = new MainWindow();
		users=new UserDAO();
		suppliers=new SupplierDAO();
		userToRecover=new UserDTO();
		idUpdate=-1;
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "join": {
			
			String username=mw.getLoginPanel().getUserName().getText();
			String password=new String(mw.getLoginPanel().getPassword().getPassword());
			
			int login=users.verifyUser(username, password);
			
			if(login==0) {
				
				mw.getAdminControlPanel().setVisible(true);
				mw.getLoginPanel().getUserName().setText("");
				mw.getLoginPanel().getPassword().setText("");
				mw.getAdminControlPanel().getNameSt().setVisible(true);
				mw.getLoginPanel().setVisible(false);
				
			}
			else if(login==1) {
				
				mw.getSellerControlPanel().setVisible(true);
				mw.getLoginPanel().getUserName().setText("");
				mw.getLoginPanel().getPassword().setText("");
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
				int res=PopUpMessages.confirmMessage("¿Seguro que quiere eliminar permanentemente el proveedor?", mw);
				if(res==0) {
					try {
						suppliers.delete(id);
						mw.getSupplierPanel().fillTable(suppliers.showAll());
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
			mw.getInventoryPanel().setVisible(false);

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
			break;
		}
		case "deleteProduct": {
//			borrar de la lista
			break;
		}
		case "upProduct": {
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
			break;
		}
		case "registerProduct": {
//			registrar producto en la lista
			
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
			break;
		}
		case "updateProduct": {
//			actualizar producto en la lista
			
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
			
			break;
		}
		case "closeProduct": {
			mw.getInventoryPanel().setVisible(true);
			mw.getAddUpdateInventoryPanel().setVisible(false);
			break;
		}
		case "salesAdmin": {
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

			break;
		}
		case "deleteSale": {
//			borrar de la lista
			break;
		}
		case "upSa": {
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
			break;
		}
		case "registerSale": {
//			registar venta
			
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
			
			break;
		}
		case "updateSale": {
//			actualizar venta
			
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
			
			break;
		}
		case "closeSale": {
			mw.getSalesPanel().setVisible(true);
			mw.getAddUpdateSalesPanel().setVisible(false);
			break;
		}
		case "userControlAdmin":{
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
//			borrar de la lista
			break;
		}
		case "upUser":{
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
			break;
		}
		case "registerUser":{
//			registrar usuario
			
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
			
			break;
		}
		case "updateUser":{
//			actualizar usuario
						
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
			
			break;
		}
		case "closeUser":{
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
			
			break;
		}
		case "addPrePurchase":{
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
			break;
		}
		case "endPurchase":{
			
//			preguntar por confirmar si desea terminar la compra
			
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
}
