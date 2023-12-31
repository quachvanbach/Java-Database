package viewer;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import org.passay.*;
import org.hibernate.SessionFactory;
import org.jboss.aerogear.security.otp.Totp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.AccountController;
import dao.AccountDAO;
import model.Account;
import model.AccountModel;
import util.HibernateUtil;

import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.awt.Button;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	private JPasswordField passwordField_password;
	private TextField textField_twoFA;
	private TextField textField_phonenumber;
	private TextField textField_email;
	private JPasswordField passwordField_passMail;
	private Account account;
	private AccountDAO accountDao = new AccountDAO();
	private AccountModel accountModel = new AccountModel();
	private Button button_add;
	private Button button_edit;
	private Button button_delete;
	private TextField textField_search_accountType;
	private Label label_search_accountType;
	private TextField textField_search_username;
	private Label label_search_username;
	private Button button_search;
	private Button button_cancel;
	private Button button_copyPassword;
	private Button button_copyPassMail;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem menuItem_Exit;
	private JMenu menu_tool;
	private JMenuItem menuItem_randomPassword;
	private JMenuItem menuItem_create2FA;

	public AccountView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 486);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		refreshTable();

		ActionListener action = new AccountController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);

		JMenu menu_file = new JMenu("File");
		menuBar.add(menu_file);

		mntmNewMenuItem = new JMenuItem("New menu item");
		menu_file.add(mntmNewMenuItem);

		menuItem_Exit = new JMenuItem("Exit");
		menuItem_Exit.addActionListener(action);
		menu_file.add(menuItem_Exit);

		menu_tool = new JMenu("Tool");
		menuBar.add(menu_tool);

		menuItem_randomPassword = new JMenuItem("Random Password");
		menuItem_randomPassword.addActionListener(action);
		menu_tool.add(menuItem_randomPassword);

		menuItem_create2FA = new JMenuItem("Create 2FA code");
		menuItem_create2FA.addActionListener(action);
		menu_tool.add(menuItem_create2FA);

		table = new JTable();
		table.setModel(accountModel);
		table.setBounds(167, 156, 1, 1);

		JScrollPane jScrollPane = new JScrollPane(table); // Sử dụng JScrollPane thay cho ScrollPane và thêm trực tiếp table vào khi khởi tạo để hiển thị toàn bộ bảng 1 cách đầy đủ.
		jScrollPane.setBounds(456, 0, 665, 437);
		contentPane.add(jScrollPane);

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

		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(108, 94, 225, 22);
		contentPane.add(passwordField_password);

		button_copyPassword = new Button("Copy Password");
		button_copyPassword.addActionListener(action);
		button_copyPassword.setBounds(339, 94, 100, 22);
		contentPane.add(button_copyPassword);

		textField_twoFA = new TextField();
		textField_twoFA.setBounds(108, 122, 225, 22);
		contentPane.add(textField_twoFA);

		textField_phonenumber = new TextField();
		textField_phonenumber.setBounds(108, 150, 225, 22);
		contentPane.add(textField_phonenumber);

		textField_email = new TextField();
		textField_email.setBounds(108, 178, 225, 22);
		contentPane.add(textField_email);

		passwordField_passMail = new JPasswordField();
		passwordField_passMail.setBounds(108, 206, 225, 22);
		contentPane.add(passwordField_passMail);

		button_copyPassMail = new Button("Copy Pass Mail");
		button_copyPassMail.addActionListener(action);
		button_copyPassMail.setBounds(339, 206, 100, 22);
		contentPane.add(button_copyPassMail);

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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 286, 323, 2);
		contentPane.add(separator);

		label_search_accountType = new Label("Account Type");
		label_search_accountType.setBounds(10, 309, 92, 22);
		contentPane.add(label_search_accountType);

		label_search_username = new Label("Username");
		label_search_username.setBounds(10, 337, 92, 22);
		contentPane.add(label_search_username);

		textField_search_accountType = new TextField();
		textField_search_accountType.setBounds(108, 309, 225, 22);
		contentPane.add(textField_search_accountType);

		textField_search_username = new TextField();
		textField_search_username.setBounds(108, 337, 225, 22);
		contentPane.add(textField_search_username);

		button_search = new Button("Search");
		button_search.addActionListener(action);
		button_search.setBounds(108, 365, 84, 22);
		contentPane.add(button_search);

		button_cancel = new Button("Cancel");
		button_cancel.addActionListener(action);
		button_cancel.setBounds(249, 365, 84, 22);
		contentPane.add(button_cancel);

	}

	private void refreshTable() {
		List<Account> acounts = accountDao.selectAll();
		accountModel.setData(acounts);
		accountModel.fireTableDataChanged();
//		accountModel.fireTableStructureChanged();
	}

	private void setEmptyTextField() {
		textField_accountType.setText(null);
		textField_username.setText(null);
		passwordField_password.setText(null);
		textField_twoFA.setText(null);
		textField_phonenumber.setText(null);
		textField_email.setText(null);
		passwordField_passMail.setText(null);
	}

	private Account accountInfo() {

		String accountType = textField_accountType.getText();
		String username = textField_username.getText();
		String password = new String(passwordField_password.getPassword());
		String twoFA = textField_twoFA.getText();
		String phonenumber = textField_phonenumber.getText();
		String email = textField_email.getText();
		String passMail = new String(passwordField_passMail.getPassword());
		account = new Account(accountType, username, password, twoFA, phonenumber, email, passMail);
		return account;
	}

	public void addAccount() {

		try {
			if (!accountModel.checkEmptyTextField(textField_accountType)
					|| !accountModel.checkEmptyTextField(textField_email)
					|| !accountModel.checkEmptyPasswordField(passwordField_password)) {
				accountDao.insert(accountInfo());
				setEmptyTextField();
				refreshTable();
			} else {
				JOptionPane.showMessageDialog(this, "Mời nhập thông tin tài khoản:\n", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
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
		try {
			textField_accountType.setText(getSelectedAccount().getAccountType() + "");
			textField_username.setText(getSelectedAccount().getUsername());
			passwordField_password.setText(getSelectedAccount().getPassword());
			textField_twoFA.setText(getSelectedAccount().getTwoFA());
			textField_phonenumber.setText(getSelectedAccount().getPhonenumber());
			textField_email.setText(getSelectedAccount().getEmail());
			passwordField_passMail.setText(getSelectedAccount().getPassMail());
			
			button_edit.setLabel("Save");

		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(this, "Mời 1 Tài khoản để Edit:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saveAccount() {

		try {
			Account oldAccount = getSelectedAccount();
			int id = oldAccount.getId();
			account = accountInfo();
			account.setId(id);
			accountDao.update(account);
			button_edit.setLabel("Edit");
			setEmptyTextField();
			refreshTable();
			accountModel.recordOperationLog("Update: "+oldAccount.toString()+" to "+ account.toString()+"\n");
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(this, "Lỗi sửa tài khoản: \n" + ex);
		}
	}

	public void deleteAccount() {
		try {
			account = getSelectedAccount();
			accountDao.delete(account);
			refreshTable();
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(this, "Mời 1 Tài khoản để Delete:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void copyPassword() {
		String password = new String(passwordField_password.getPassword());
		accountModel.copyToClipboard(password);
		JOptionPane.showMessageDialog(this, "Password copied to clipboard.", "Success",
				JOptionPane.INFORMATION_MESSAGE);
		System.out.println(password);
	}

	public void copyPassmail() {
		String passMail = new String(passwordField_passMail.getPassword());
		accountModel.copyToClipboard(passMail);
		JOptionPane.showMessageDialog(this, "Password copied to clipboard.", "Success",
				JOptionPane.INFORMATION_MESSAGE);
		System.out.println(passMail);
	}

	public void searchAccount() {
		try {
			account = new Account();
			account.setAccountType(textField_search_accountType.getText());
			account.setUsername(textField_search_username.getText());
			List<Account> listAccount = accountDao.getAccount(account);
			accountModel.setData(listAccount);
			accountModel.fireTableDataChanged();

		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm tài khoản: \n" + ex);
		}

	}

	public void cancelSearch() {
		textField_search_accountType.setText("");
		textField_search_username.setText("");
		refreshTable();
	}

	public void createRandomPwd() {
		boolean validInput = false;

		while (!validInput) {
			String input = JOptionPane.showInputDialog(null, "Enter password length (between 20 and 50):");
			try {
				int passwordLength = Integer.parseInt(input);
				if (passwordLength >= 20 && passwordLength <= 50) {
					generateRandomPassword(passwordLength);
					validInput = true; // Exit the loop if input is valid
				} else {
					JOptionPane.showMessageDialog(null, "Please enter a number between 20 and 50.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number.");
			}
		}
	}

	public void createOtpGenerator() {
		try {
			JTextField secretKeyField = new JTextField(30);

			JPanel panel = new JPanel();
			panel.add(new JLabel("Enter Secret Key:"));
			panel.add(secretKeyField);

			int result = JOptionPane.showConfirmDialog(null, panel, "Generate OTP", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				String secretKey = secretKeyField.getText();
				otpGenerator(secretKey);
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(button_add, "Nhập sai định dạng khoá bí mật! Mời nhập lại.");
		}
	}

	private void generateRandomPassword(int passwordLength) {
		PasswordGenerator generator = new PasswordGenerator();
		List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1),
				new CharacterRule(EnglishCharacterData.Special, 1));

		String randomPassword = generator.generatePassword(passwordLength, rules);

		accountModel.copyToClipboard(randomPassword);
		JOptionPane.showMessageDialog(menuItem_randomPassword, "Đã tạo mật khẩu ngẫu nhiên gồm " + passwordLength
				+ " ký tự.\n" + "Mật khẩu đã được lưu vào Clipboard. Ctrl+V để dán mật khẩu.");
	}

	private void otpGenerator(String secretKey) {
		try {
			Totp totp = new Totp(secretKey);
			String otp = totp.now();

			accountModel.copyToClipboard(otp);

			long currentTime = System.currentTimeMillis() / 1000;
			long timeWindow = 30; // 30-second time window
			long remainingSeconds = timeWindow - (currentTime % timeWindow);

			JOptionPane.showMessageDialog(null, "Mã OTP là: " + otp + "  đã được copy vào Clipboard.\n"
					+ "Thời gian thay đổi mã còn " + remainingSeconds + " giây.");
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(button_add, "Nhập sai định dạng khoá bí mật! Mời nhập lại.");
		}
	}

	public void closeApp() {
		HibernateUtil.shutdown();
		System.exit(0);
	}
}
