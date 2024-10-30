package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mw;
	
	public Controller() {
		mw = new MainWindow();
		addReaders();
	}
	
	public void run() {
		mw.getLoginPanel().setVisible(true);
		mw.getAdminControlPanel().setVisible(false);
		mw.getSupplierPanel().setVisible(false);
		mw.getAddUpdateSupplierPanel().setVisible(false);
//		mw.getInventoryPanel().setVisible(true);
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
		mw.getAdminControlPanel().getUserControl().setActionCommand("userControl");
		
		mw.getAdminControlPanel().getCashControl().addActionListener(this);
		mw.getAdminControlPanel().getCashControl().setActionCommand("cashControl");
		
		mw.getAdminControlPanel().getPurchase().addActionListener(this);
		mw.getAdminControlPanel().getPurchase().setActionCommand("purchaseAdmin");
		
		mw.getAdminControlPanel().getExit().addActionListener(this);
		mw.getAdminControlPanel().getExit().setActionCommand("exitAdmin");
		
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
		
		mw.getAddUpdateSupplierPanel().getClose().addActionListener(this);
		mw.getAddUpdateSupplierPanel().getClose().setActionCommand("closeSupplier");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "join":{
//			verificar entre admin y vendedor
			
			mw.getLoginPanel().setVisible(false);
			
			mw.getAdminControlPanel().setVisible(true);
			break;
		}
		case "recoverKey":{
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
		case "cancelRec":{
			mw.getLoginPanel().getTitle().setVisible(true);
			mw.getLoginPanel().getIndUser().setVisible(true);
			mw.getLoginPanel().getUserName().setVisible(true);
			mw.getLoginPanel().getIndPass().setVisible(true);
			mw.getLoginPanel().getPassword().setVisible(true);
			mw.getLoginPanel().getShowPass().setVisible(true);
			mw.getLoginPanel().getIndButton().setVisible(true);
			mw.getLoginPanel().getJoin().setVisible(true);
			mw.getLoginPanel().getRecoverKey().setVisible(true);
			
			mw.getLoginPanel().getTitleRec().setVisible(false);
			mw.getLoginPanel().getIndUserRec().setVisible(false);
			mw.getLoginPanel().getUserNameRec().setVisible(false);
			mw.getLoginPanel().getIndCancel().setVisible(false);
			mw.getLoginPanel().getIndFollow().setVisible(false);
			mw.getLoginPanel().getCancel().setVisible(false);
			mw.getLoginPanel().getFollow().setVisible(false);
			break;
			
		}
		case "followRec":{
			mw.getLoginPanel().getTitleRec().setVisible(true);
			mw.getLoginPanel().getIndUserRec().setVisible(false);
			mw.getLoginPanel().getUserNameRec().setVisible(false);
			mw.getLoginPanel().getIndCancel().setVisible(false);
			mw.getLoginPanel().getIndFollow().setVisible(true);
			mw.getLoginPanel().getCancel().setVisible(false);
			mw.getLoginPanel().getFollow().setVisible(false);
			
			mw.getLoginPanel().getIndUserChoose().setVisible(true);
			mw.getLoginPanel().getIndQuestion().setVisible(true);
			mw.getLoginPanel().getIndAnswer().setVisible(true);
			mw.getLoginPanel().getAnswer().setVisible(true);
			mw.getLoginPanel().getCheckanswer().setVisible(true);
			break;
		}
		case "checkAns":{
			mw.getLoginPanel().getTitleRec().setVisible(false);
			mw.getLoginPanel().getIndUserChoose().setVisible(false);
			mw.getLoginPanel().getIndQuestion().setVisible(false);
			mw.getLoginPanel().getIndAnswer().setVisible(false);
			mw.getLoginPanel().getAnswer().setVisible(false);
			mw.getLoginPanel().getCheckanswer().setVisible(false);
			mw.getLoginPanel().getIndFollow().setVisible(false);
			
			mw.getLoginPanel().getTitle().setVisible(true);
			mw.getLoginPanel().getIndUser().setVisible(true);
			mw.getLoginPanel().getUserName().setVisible(true);
			mw.getLoginPanel().getIndPass().setVisible(true);
			mw.getLoginPanel().getPassword().setVisible(true);
			mw.getLoginPanel().getShowPass().setVisible(true);
			mw.getLoginPanel().getIndButton().setVisible(true);
			mw.getLoginPanel().getJoin().setVisible(true);
			mw.getLoginPanel().getRecoverKey().setVisible(true);
			break;
			
		}
		case "supplierAdmin":{
			
			mw.getSupplierPanel().setVisible(true);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			
			
			mw.getAdminControlPanel().getTitleSupplier().setVisible(true);
			
			break;
		}
		case "addSupplier":{
			mw.getSupplierPanel().setVisible(false);
			
			mw.getAddUpdateSupplierPanel().setVisible(true);
			mw.getAddUpdateSupplierPanel().getTitleRegister().setVisible(true);
			mw.getAddUpdateSupplierPanel().getRegisterSup().setVisible(true);
			mw.getAddUpdateSupplierPanel().getIndRegisterSup().setVisible(true);
			mw.getAddUpdateSupplierPanel().getTitleUpdate().setVisible(false);
			mw.getAddUpdateSupplierPanel().getUpdateSup().setVisible(false);
			mw.getAddUpdateSupplierPanel().getIndUpdateSup().setVisible(false);
			break;
		}
		case "deleteSupplier":{
//			borrar de la lista
			break;
		}
		case "upSupplier":{
			mw.getSupplierPanel().setVisible(false);
			
			mw.getAddUpdateSupplierPanel().setVisible(true);
			mw.getAddUpdateSupplierPanel().getTitleRegister().setVisible(false);
			mw.getAddUpdateSupplierPanel().getRegisterSup().setVisible(false);
			mw.getAddUpdateSupplierPanel().getIndRegisterSup().setVisible(false);
			mw.getAddUpdateSupplierPanel().getTitleUpdate().setVisible(true);
			mw.getAddUpdateSupplierPanel().getUpdateSup().setVisible(true);
			mw.getAddUpdateSupplierPanel().getIndUpdateSup().setVisible(true);
			break;
		}
		case "registerSupplier":{
//			agregar proveedor a la lista
			break;
		}
		case "updateSupplier":{
//			actualizar proveedor en la lista
			break;
		}
		case "closeSupplier":{
			mw.getSupplierPanel().setVisible(true);
			mw.getAddUpdateSupplierPanel().setVisible(false);
			break;
		}

		default:
			break;
		}
	}
}
