package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Account;
import viewer.AccountView;

public class AccountController implements ActionListener {
	AccountView view;

	public AccountController(AccountView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acctionCommand = e.getActionCommand();
		if (acctionCommand.equals("Add")) {
			System.out.println("Ban da an nut add");
			view.addAccount();
		} else if (acctionCommand.equals("Edit")) {
			view.editAccount();
		} else if (acctionCommand.equals("Delete")) {
			view.deleteAccount();
		}

	}

}
