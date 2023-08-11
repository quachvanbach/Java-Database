package main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.AccountDao;
import dao.AccountProtectionDao;
import model.Account;
import model.AccountProtection;
import util.HibernateUtil;

public class AccountsManagement {
	public static void main(String[] args) {
		AccountProtectionDao accountProtectionDao = new AccountProtectionDao();
		AccountDao accountDao = new AccountDao();
		AccountProtection accountProtection;
		Account account;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào lựa chọn: \n" + "1. Thêm tài khoản.\n" + "2. Sửa tài khoản.\n"
				+ "3. Xoá tài khoản.\n" + "4. In danh sách tài khoản.\n" + "5. Tìm theo tên tài khoản.\n"
				+ "6. Lấy ra thông tin bảo mật của tài khoản.\n" + "7. ");
		int choose = sc.nextInt();
		sc.nextLine();
		while (choose != 0) {
			switch (choose) {
			case 1:
				System.out.println("Thêm thông tin vào tài khoản: \n");
				System.out.println("Account Type: ");
				String accountType = sc.nextLine();
				System.out.println("Username: ");
				String username = sc.nextLine();
				System.out.println("Password: ");
				String password = sc.nextLine();
				System.out.println("2FA: ");
				String twoFA = sc.nextLine();
				System.out.println("Full name: ");
				String fullName = sc.nextLine();
				System.out.println("Email: ");
				String email = sc.nextLine();
				System.out.println("Passmail: ");
				String passmail = sc.nextLine();

				accountProtection = new AccountProtection(twoFA, fullName, email, passmail);
				System.out.println("Id của accountProtection là: " + accountProtection.getProtectId());		
				account = new Account(accountType, username, password, accountProtection);
				accountProtectionDao.insert(accountProtection);
				accountDao.insert(account);
				System.out.println("Protect Id: " + account.getAccountProtection().getProtectId());

				break;
			case 2:

			default:
				break;
			}
		}

	}
}
