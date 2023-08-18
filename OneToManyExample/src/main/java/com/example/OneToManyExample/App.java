package com.example.OneToManyExample;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import dao.CustomerDAO;
import dao.InvoiceDAO;
import model.Customer;
import model.Invoice;
import viewer.AppView;

public class App {
	public static void main(String[] args) {
		AppView view = new AppView();
		view.setVisible(true); 
	}
}
