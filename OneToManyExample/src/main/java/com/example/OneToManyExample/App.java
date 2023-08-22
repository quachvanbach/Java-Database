package com.example.OneToManyExample;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import dao.CustomerDAO;
import dao.InvoiceDAO;
import model.AppModel;
import model.Customer;
import model.Invoice;
import viewer.AppView;

public class App {
	public static void main(String[] args) {
		AppView view = new AppView();

		view.setVisible(true);

		CustomerDAO customerDAO = new CustomerDAO();
		AppModel appModel = new AppModel();

		Customer customer = new Customer();
		customer.setId(1);

		List<Invoice> gettedCustomers = appModel.getInvoiceByCustomer(customer);

		for (Invoice invoice : gettedCustomers) {
			System.out.println(customer);
		}
		System.out.println("----------------------------------");
	}
}
