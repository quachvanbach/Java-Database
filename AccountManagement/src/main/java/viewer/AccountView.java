package viewer;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AccountController;
import dao.AccountDAO;
import model.Account;
import model.AccountModel;

import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Button;
import java.awt.Component;

public class AccountView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Label label_accountType;
	private Label label_username;
	private Label label_password;
	private Label label_twoFA;
	private Label label_phonenumber;
	private Label label_email;
	private Label label_passMail;
	private TextField textField_accountType;
	private TextField textField_username;
	private TextField textField_password;
	private TextField textField_twoFA;
	private TextField textField_phonenumber;
	private TextField textField_email;
	private TextField textField_passMail;
	private Account account;
	private AccountDAO accountDao = new AccountDAO();
	private AccountModel accountModel = new AccountModel();
	private Button button_add;
	private Button button_edit;
	private Button button_delete;

	public AccountView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 486);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		refreshTable();

		ActionListener action = new AccountController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setModel(accountModel);
		table.setBounds(167, 156, 1, 1);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(366, 0, 639, 437);
		scrollPane.add(table);
		contentPane.add(scrollPane);

		label_accountType = new Label("Account Type");
		label_accountType.setBounds(10, 38, 92, 22);
		contentPane.add(label_accountType);

		label_username = new Label("Username");
		label_username.setBounds(10, 66, 92, 22);
		contentPane.add(label_username);

		label_password = new Label("Password:");
		label_password.setBounds(10, 94, 92, 22);
		contentPane.add(label_password);

		label_twoFA = new Label("2FA:");
		label_twoFA.setBounds(10, 122, 92, 22);
		contentPane.add(label_twoFA);

		label_phonenumber = new Label("Phonenumber:");
		label_phonenumber.setBounds(10, 150, 92, 22);
		contentPane.add(label_phonenumber);

		label_email = new Label("Email:");
		label_email.setBounds(10, 178, 92, 22);
		contentPane.add(label_email);

		label_passMail = new Label("Pass Mail:");
		label_passMail.setBounds(10, 206, 92, 22);
		contentPane.add(label_passMail);

		textField_accountType = new TextField();
		textField_accountType.setBounds(108, 38, 225, 22);
		contentPane.add(textField_accountType);

		textField_username = new TextField();
		textField_username.setBounds(108, 66, 225, 22);
		contentPane.add(textField_username);

		textField_password = new TextField();
		textField_password.setBounds(108, 94, 225, 22);
		contentPane.add(textField_password);

		textField_twoFA = new TextField();
		textField_twoFA.setBounds(108, 122, 225, 22);
		contentPane.add(textField_twoFA);

		textField_phonenumber = new TextField();
		textField_phonenumber.setBounds(108, 150, 225, 22);
		contentPane.add(textField_phonenumber);

		textField_email = new TextField();
		textField_email.setBounds(108, 178, 225, 22);
		contentPane.add(textField_email);

		textField_passMail = new TextField();
		textField_passMail.setBounds(108, 206, 225, 22);
		contentPane.add(textField_passMail);

		button_add = new Button("Add");
		button_add.addActionListener(action);
		button_add.setBounds(10, 246, 70, 22);
		contentPane.add(button_add);

		button_edit = new Button("Edit");
		button_edit.addActionListener(action);
		button_edit.setBounds(139, 246, 70, 22);
		contentPane.add(button_edit);

		button_delete = new Button("Delete");
		button_delete.addActionListener(action);
		button_delete.setBounds(263, 246, 70, 22);
		contentPane.add(button_delete);

	}

	public void refreshTable() {
		List<Account> acounts = accountDao.selectAll();
		accountModel.setData(acounts);
		accountModel.fireTableDataChanged();
	}

	private Account accountInfo() {
		String accountType = textField_accountType.getText();
		String username = textField_username.getText();
		String password = textField_password.getText();
		String twoFA = textField_twoFA.getText();
		String phonenumber = textField_phonenumber.getText();
		String email = textField_email.getText();
		String passMail = textField_passMail.getText();
		account = new Account(accountType, username, password, twoFA, phonenumber, email, passMail);
		return account;
	}

	public void addAccount() {
		try {
			accountDao.insert(accountInfo());
			refreshTable();
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(this, "Lỗi thêm tài khoản:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private Account getSelectedAccount() {
		account = new Account();
		int selectedRow = table.getSelectedRow();
		account.setId(Integer.valueOf(accountModel.getValueAt(selectedRow, 0) + ""));
		account.setAccountType(accountModel.getValueAt(selectedRow, 1) + "");
		account.setUsername(accountModel.getValueAt(selectedRow, 2) + "");
		account.setPassword(accountModel.getValueAt(selectedRow, 3) + "");
		account.setTwoFA(accountModel.getValueAt(selectedRow, 4) + "");
		account.setPhonenumber(accountModel.getValueAt(selectedRow, 5) + "");
		account.setEmail(accountModel.getValueAt(selectedRow, 6) + "");
		account.setPassMail(accountModel.getValueAt(selectedRow, 7) + "");

		return account;
	}

	public void editAccount() {
		textField_accountType.setText(getSelectedAccount().getAccountType() + "");
		textField_username.setText(getSelectedAccount().getUsername());
		textField_password.setText(getSelectedAccount().getPassword());
		textField_twoFA.setText(getSelectedAccount().getTwoFA());
		textField_phonenumber.setText(getSelectedAccount().getPhonenumber());
		textField_email.setText(getSelectedAccount().getEmail());
		textField_passMail.setText(getSelectedAccount().getPassMail());

		button_edit.setLabel("Save");
	}

	public void saveAccount() {
		try {
			int id = getSelectedAccount().getId();
			account = accountInfo();
			account.setId(id);
			accountDao.update(account);
			button_edit.setLabel("Edit");
			refreshTable();
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(this, "Lỗi sửa tài khoản: \n" + ex);
		}
	}

	public void deleteAccount() {
		account = getSelectedAccount();
		accountDao.delete(account);
		refreshTable();
	}
}
