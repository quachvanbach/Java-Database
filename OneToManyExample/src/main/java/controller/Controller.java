package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.OneToManyExample.App;

import viewer.AppView;

public class Controller implements ActionListener {
	AppView view;

	public Controller(AppView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Add Customer")) {
			view.addCustomer();
//		} else if (action.equals("Click Me")) {
//			view.showInvoicesInformation();
//			;
//		} else if (action.equals("Back")) {
//			view.goBack();
//		} else {
//			view.goBack();
		}
	}

}
