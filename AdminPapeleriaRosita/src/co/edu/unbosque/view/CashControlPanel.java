package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CashControlPanel extends JPanel {

	private JTable listCash;
	private JPanel listCashPanel;
	private JScrollPane barCash;
	private JLabel totalIncome, totalExpenses, total;
	private JPanel line;

	public CashControlPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		listCash = new JTable();
		listCash.setBounds(0, 0, 470, 350);
		listCash.setBackground(Color.LIGHT_GRAY);
		listCash.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCash.getTableHeader().setReorderingAllowed(false);

		barCash = new JScrollPane(listCash);
		barCash.setBounds(0, 0, 470, 350);

		listCashPanel = new JPanel();
		listCashPanel.setLayout(null);
		listCashPanel.setBounds(77, 60, 470, 350);
		listCashPanel.add(barCash);
		add(listCashPanel);

		line = new JPanel();
		line.setBounds(60, 470, 500, 4);
		line.setBackground(Color.BLACK);
		add(line);

		totalIncome = new JLabel("Total Ingresos");
		totalIncome.setBounds(100, 420, 150, 60);
		totalIncome.setFont(new Font("Leelawadee", Font.BOLD, 18));
		totalIncome.setForeground(new Color(2, 58, 98));
		add(totalIncome);

		totalExpenses = new JLabel("Total Costos");
		totalExpenses.setBounds(270, 420, 150, 60);
		totalExpenses.setFont(new Font("Leelawadee", Font.BOLD, 18));
		totalExpenses.setForeground(new Color(2, 58, 98));
		add(totalExpenses);

		total = new JLabel("Total Ganancias");
		total.setBounds(420, 420, 150, 60);
		total.setFont(new Font("Leelawadee", Font.BOLD, 18));
		total.setForeground(new Color(2, 58, 98));
		add(total);
	}
	
	public void fillTable(Object[][] information) {
		DefaultTableModel model=new DefaultTableModel(information,new String[]{"Producto","Ingresos","Costos","Ganancias"}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		listCash.setModel(model);
	}

	public JTable getListCash() {
		return listCash;
	}

	public void setListCash(JTable listCash) {
		this.listCash = listCash;
	}

	public JLabel getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(JLabel totalIncome) {
		this.totalIncome = totalIncome;
	}

	public JLabel getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(JLabel totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public JLabel getTotal() {
		return total;
	}

	public void setTotal(JLabel total) {
		this.total = total;
	}
	
	

}
