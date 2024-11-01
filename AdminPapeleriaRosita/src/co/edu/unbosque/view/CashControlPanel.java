package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CashControlPanel extends JPanel {

	private JList<String> listCash;
	private DefaultListModel<String> modelCash;
	private JPanel listCashPanel;
	private JScrollPane barCash;
	private JLabel totalIncome, totalExpenses, total;
	private JPanel line;

	public CashControlPanel() {

		setBounds(160, 50, 640, 550);
		setBackground(Color.WHITE);
		setLayout(null);

		modelCash = new DefaultListModel<>();

		listCash = new JList<>(modelCash);
		listCash.setBounds(0, 0, 470, 350);
		listCash.setBackground(Color.LIGHT_GRAY);
		listCash.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
		totalIncome.setBounds(100, 420, 150, 30);
		totalIncome.setFont(new Font("Leelawadee", Font.BOLD, 18));
		totalIncome.setForeground(new Color(2, 58, 98));
		add(totalIncome);

		totalExpenses = new JLabel("Total Gastos");
		totalExpenses.setBounds(270, 420, 150, 30);
		totalExpenses.setFont(new Font("Leelawadee", Font.BOLD, 18));
		totalExpenses.setForeground(new Color(2, 58, 98));
		add(totalExpenses);

		total = new JLabel("Total");
		total.setBounds(460, 420, 150, 30);
		total.setFont(new Font("Leelawadee", Font.BOLD, 18));
		total.setForeground(new Color(2, 58, 98));
		add(total);
	}

	public JList<String> getListCash() {
		return listCash;
	}

	public void setListCash(JList<String> listCash) {
		this.listCash = listCash;
	}

	public DefaultListModel<String> getModelCash() {
		return modelCash;
	}

	public void setModelCash(DefaultListModel<String> modelCash) {
		this.modelCash = modelCash;
	}

}
