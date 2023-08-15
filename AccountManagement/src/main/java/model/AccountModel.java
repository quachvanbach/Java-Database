package model;

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.table.AbstractTableModel;

public class AccountModel extends AbstractTableModel {
	private List<Account> data;
	private final String[] columnNames = new String[] { "ID", "Account Type", "Username", "Password", "2FA",
			"Phonenumber", "Email", "Pass Mail" };;

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

	public void copyToClipboard(String text) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection(text);
		clipboard.setContents(selection, null);
	}

	public boolean checkEmptyTextField(TextField textField) {
		if (textField.getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkEmptyPasswordField(JPasswordField passwordField) {
		char[] passwordChars = passwordField.getPassword();
		String password = new String(passwordChars);
		if (password.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void recordOperationLog(String string) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessage = "[" + timeStamp + "] :" + string;

        try (PrintWriter out = new PrintWriter(new FileWriter("mylog.log", true))) {
            out.println(new String(logMessage.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
