package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mw;
	
	public Controller() {
		mw = new MainWindow();
	}
	
	public void run() {
		mw.getLoginPanel().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
