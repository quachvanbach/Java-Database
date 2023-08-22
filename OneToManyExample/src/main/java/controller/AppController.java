package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.OneToManyExample.App;

import lombok.AllArgsConstructor;
import viewer.AppView;
import viewer.CustomView;

public class AppController implements ActionListener {
	AppView appView;
	CustomView customView;

	public AppController(AppView appView, CustomView customView) {
		this.appView = appView;
		this.customView = customView;
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
			appView.showInvoicesInformation();
		} else if (action.equals("Show customers")) {
			appView.showCustomersInformation();
		} else if (action.equals("Cancel")) {
			appView.cancel();
		} else if (action.equals("Add customer")) {
			customView.addCustomer();
		} else if (action.equals("Edit customer")) {
			customView.editCustomer();
		} else if (action.equals("Save customer")) {
			customView.saveCustomer();
		} else if (action.equals("Delete customer")) {
			customView.deleteCustomer();
		} else if (action.equals("Add invoice")) {
			customView.addInvoice();
		} else if (action.equals("Edit invoice")) {
			customView.editInvoice();
		} else if (action.equals("Save invoice")) {
			customView.saveInvoice();
		} else if (action.equals("Delete invoice")) {
			customView.deleteInvoice();
		}

	}
}
