package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import viewer.CustomView;

public class CustomerController implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals("Add Customer")) {}
	}
	
}
