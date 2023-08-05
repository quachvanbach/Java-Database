package main;

import dao.AccountDAO;
import model.Account;
import viewer.AccountView;

public class App {
	public static void main(String[] args) {
		AccountView view = new AccountView();
		view.setVisible(true);
		AccountDAO accountdao = new AccountDAO();
	}
}
