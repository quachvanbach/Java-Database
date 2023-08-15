package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

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
		} else if (acctionCommand.equals("Save")) {
			view.saveAccount();
			System.out.println(acctionCommand);
		} else if (acctionCommand.equals("Delete")) {
			view.deleteAccount();
		}else if (acctionCommand.equals("Copy Password")) {
			view.copyPassword();
		}else if (acctionCommand.equals("Copy Pass Mail")) {
			view.copyPassmail();
		} else if (acctionCommand.equals("Search")) {
			view.searchAccount();
		} else if (acctionCommand.equals("Cancel")) {
			view.cancelSearch();
		}else if (acctionCommand.equals("Random Password")) {
			view.createRandomPwd();
		} else if (acctionCommand.equals("Create 2FA code")) {
			view.createOtpGenerator();
		}  else if (acctionCommand.equals("Exit")) {
			view.closeApp();
		} 
	}
}
