package model;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Sides;
import javax.swing.table.AbstractTableModel;

public class AccountModel extends AbstractTableModel {
	private List<Account> data;
	private final String[] columnNames = { "ID", "Account Type", "Username", "Password", "2FA", "Phonenumber", "Email",
			"Pass Mail" };

	public AccountModel() {
		data = new ArrayList<Account>();
	}

	public void setData(List<Account> data) {
		this.data = data;
	}

	public void addrow(Account account) {
		data.add(account);
		fireTableDataChanged(); // Dùng thông báo sự thay đổi dữ liệu
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Account account = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return account.getId();
		case 1:
			return account.getAccountType();
		case 2:
			return account.getUsername();
		case 3:
			return account.getPassword();
		case 4:
			return account.getTwoFA();
		case 5:
			return account.getPhonenumber();
		case 6:
			return account.getEmail();
		case 7:
			return account.getPassMail();
		default:
			return null;
		}
	}
}
