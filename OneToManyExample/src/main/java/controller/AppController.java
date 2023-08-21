package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.OneToManyExample.App;

import lombok.AllArgsConstructor;
import viewer.AppView;
import viewer.CustomView;

public class AppController implements ActionListener {
	AppView view;
	CustomView customView;

	public AppController(AppView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
//		if (action.equals("Show custom")) {
//			view.showCustom(true);
//		} else if (action.equals("Hide custom")) {
//			view.showCustom(false);
//		} else
		if (action.equals("Show invoices")) {
			view.showInvoicesInformation();
		} else if (action.equals("Show customers")) {
			view.showCustomersInformation();
		} else if (action.equals("Add customer")) {
			view.addCustomer();
		} else if (action.equals("Save customer")) {
			view.saveCustomer();
		} else if (action.equals("Edit customer")) {
			view.editCustomer();
		} else if (action.equals("Delete customer")) {
			view.deleteCustomer();
		} else if (action.equals("Add invoice")) {
			view.addInvoice();
		} else if (action.equals("Save invoice")) {
			view.saveInvoice();
		} else if (action.equals("Edit invoice")) {
			view.editInvoice();
		} else if (action.equals("Delete invoice")) {
			view.deleteInvoice();
		}

	}
}
