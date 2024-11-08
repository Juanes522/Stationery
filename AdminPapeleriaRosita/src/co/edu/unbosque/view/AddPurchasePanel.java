package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

public class AddPurchasePanel extends JPanel {

	private JLabel formPrePur, indTotalPur, indRegisterPur, indEndPur, indChooseProPur;
	private JTextField totalPurchase;
	private JButton registerPur, endPur, closePur;
	private JList<String> productsListPur;
	private JPanel listPurPanel;
	private JScrollPane barPur;
	private int ids[];

	public AddPurchasePanel() {

		setBounds(202, 70, 540, 450);
		setLayout(null);
		setBackground(Color.WHITE);

		formPrePur = new JLabel(new ImageIcon("src/Assets/largeform.png"));
		formPrePur.setBounds(319, 108, 221, 342);
		formPrePur.setLayout(null);
		add(formPrePur);

		indTotalPur = new JLabel("Total a pagar");
		indTotalPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indTotalPur.setForeground(Color.WHITE);
		indTotalPur.setBounds(45, 10, 220, 30);
		formPrePur.add(indTotalPur);

		totalPurchase = new JTextField();
		totalPurchase.setBounds(23, 50, 175, 30);
		MatteBorder borderTotal = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
		totalPurchase.setBorder(borderTotal);
		totalPurchase.setOpaque(false);
		totalPurchase.setForeground(Color.WHITE);
		totalPurchase.setFont(new Font("Leelawadee", Font.BOLD, 20));
		totalPurchase.setEditable(false);
		formPrePur.add(totalPurchase);

//		botones e indicador

		indRegisterPur = new JLabel("Agregar");
		indRegisterPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indRegisterPur.setForeground(new Color(2, 58, 98));
		indRegisterPur.setBounds(35, 137, 160, 30);
		indRegisterPur.setHorizontalAlignment(JLabel.CENTER);
		formPrePur.add(indRegisterPur);

		indEndPur = new JLabel("Terminar compra");
		indEndPur.setFont(new Font("Leelawadee", Font.BOLD, 20));
		indEndPur.setForeground(new Color(2, 58, 98));
		indEndPur.setBounds(30, 237, 170, 30);
		formPrePur.add(indEndPur);

		registerPur = new JButton(new ImageIcon("src/Assets/registersale.png"));
		registerPur.setBounds(23, 130, 177, 47);
		registerPur.setFocusable(false);
		registerPur.setBorderPainted(false);
		registerPur.setContentAreaFilled(false);
		formPrePur.add(registerPur);

		endPur = new JButton(new ImageIcon("src/Assets/registersale.png"));
		endPur.setBounds(23, 230, 177, 47);
		endPur.setFocusable(false);
		endPur.setBorderPainted(false);
		endPur.setContentAreaFilled(false);
		formPrePur.add(endPur);

		closePur = new JButton(new ImageIcon("src/Assets/xblue.png"));
		closePur.setBounds(510, 5, 32, 32);
		closePur.setFocusable(false);
		closePur.setBorderPainted(false);
		closePur.setContentAreaFilled(false);
		add(closePur);

//		-----------------

		indChooseProPur = new JLabel("Seleccione productos");
		indChooseProPur.setFont(new Font("Leelawadee", Font.BOLD, 22));
		indChooseProPur.setForeground(new Color(2, 58, 98));
		indChooseProPur.setBounds(25, 70, 250, 30);
		add(indChooseProPur);


		productsListPur = new JList<>();
		productsListPur.setBounds(0, 0, 270, 342);
		productsListPur.setBackground(Color.LIGHT_GRAY);
		productsListPur.setCellRenderer(new DefaultListCellRenderer() {
			@Override
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
	                                                        boolean isSelected, boolean cellHasFocus) {
	            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	            if (c instanceof JLabel) {
	                JLabel label = (JLabel) c;
	                if (!isSelected) {
	                    label.setBackground(index%2==0 ? new Color(0, 100, 255, 15):Color.white);
	                }
	                else {
	                	label.setBorder(BorderFactory.createLineBorder(Color.black,2));
	                }
	            }
	            return c;
	        }
		});
		productsListPur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		barPur = new JScrollPane(productsListPur);
		barPur.setBounds(0, 0, 270, 342);

		listPurPanel = new JPanel();
		listPurPanel.setLayout(null);
		listPurPanel.setBounds(0, 108, 270, 342);
		listPurPanel.add(barPur);
		add(listPurPanel);

	}
	
	public void fillList(Object productsName[][]) {
		ids=new int[productsName.length];
		DefaultListModel<String> model=new DefaultListModel<>();
		for (int i = 0; i < productsName.length; i++) {
			model.addElement((String)productsName[i][0]);
			ids[i]=(int)productsName[i][1];
		}
		productsListPur.setModel(model);
	}
	
	public int getID(int index) {
		if(ids!=null) {
			return ids[index];
		}
		return 0;
	}

	public JTextField getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(JTextField totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public JButton getRegisterPur() {
		return registerPur;
	}

	public void setRegisterPur(JButton registerPur) {
		this.registerPur = registerPur;
	}

	public JButton getEndPur() {
		return endPur;
	}

	public void setEndPur(JButton endPur) {
		this.endPur = endPur;
	}

	public JButton getClosePur() {
		return closePur;
	}

	public void setClosePur(JButton closePur) {
		this.closePur = closePur;
	}

	public JList<String> getProductsListPur() {
		return productsListPur;
	}

	public void setProductsListPur(JList<String> productsListPur) {
		this.productsListPur = productsListPur;
	}

}
