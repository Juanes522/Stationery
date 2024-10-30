package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class InventoryPanel extends JPanel{

	private JList<String> listIventory;
	private DefaultListModel<String> modelInventory;
	private JPanel listInPanel;
	
	public InventoryPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);
		
	}
	
}
