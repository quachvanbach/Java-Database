package main;

import java.util.List;
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

		int choose = 0;
		do {
			try {
				System.out.println("-------------------------------------------");
				System.out.println("Nhập vào lựa chọn: \n" + "1. Thêm tài khoản.\n" + "2. Sửa tài khoản.\n"
						+ "3. Xoá tài khoản.\n" + "4. Tìm tài khoản.\n" + "5. In ra danh sách tài khoản.\n"
						+ "6. Lấy ra thông tin bảo mật của tài khoản.\n" + "7. ");
				choose = sc.nextInt();
				sc.nextLine();
				if (choose == 1) {
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
//				accountProtectionDao.insert(accountProtection);
					accountDao.insert(account);
					System.out.println("Protect Id: " + account.getAccountProtection().getProtectId());
				} else if (choose == 2) {
					System.out.println("Sửa thông tin vào tài khoản: \n");
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
					System.out.println("Id cần sửa: ");
					int id = sc.nextInt();

					accountProtection = new AccountProtection(id, twoFA, fullName, email, passmail);
					System.out.println("Id của accountProtection là: " + accountProtection.getProtectId());
					account = new Account(id, accountType, username, password, accountProtection);
					accountProtectionDao.update(accountProtection);
					accountDao.update(account);
					System.out.println("Protect Id: " + account.getAccountProtection().getProtectId());
				} else if (choose == 3) {
					System.out.println("Id cần xoá: ");
					int id = sc.nextInt();
					account = new Account();
					account.setAccountId(id);
					Account account1 = accountDao.selectBy(account);
					System.out.println( account1.getAccountProtection().getProtectId());
					accountDao.delete(account);
					System.out.println("Đã xoá " + account.getAccountId());
				} else if (choose == 4) {
					System.out.println("Id hoặc username cần tìm: ");
					String input = sc.nextLine();
					try {
						if (isInteger(input)) {
							int id = Integer.parseInt(input);
							account = new Account();
							account.setAccountId(id);
							Account result = accountDao.selectBy(account);
							System.out.println(result.getUsername());
						} else {
							account = new Account();
							account.setUsername(input);
							List<Account> results = accountDao.selectLike(account);
							System.err.println("Các tài khoản phù hợp là: ");
							for (Account result : results) {
								System.out.println("Id: " + result.getAccountId());
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (choose == 5) {
					List<Account> accounts = accountDao.selectAll();
					for (Account accountInfo : accounts) {
						System.out.println(accountInfo);
					}
				} else if (choose == 6) {
					List accountList = accountDao.join();
					for (Object accountInfo : accountList) {
						System.out.println(accountInfo);
					}
				}
			} catch (Exception e) {
				System.out.println("Nhập không đúng, mời nhập lại");
				e.printStackTrace();
				main(args);
			}

		} while (choose != 0);

	}

	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
