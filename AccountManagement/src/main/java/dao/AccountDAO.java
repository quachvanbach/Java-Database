package dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Account;
import util.HibernateUtil;

public class AccountDAO implements DAO<Account> {

	@Override
	public List<Account> selectAll() {
		List<Account> accountList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from Account";
			Query<Account> query = session.createQuery(hql, Account.class);
			accountList = query.list();
			session.close();
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(null, "Lỗi lấy danh sách Account:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
		return accountList;
	}

	@Override
	public Account selectById(Account t) {
		Account account = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from Account a where a.id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", t.getId());
			account = (Account) query.uniqueResult();
			session.close();
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(null, "Lỗi hàm selectAccountById:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
		return account;
	}

	private boolean saveOrUpdate(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(t);
			transaction.commit();
			session.close();
			return true;

		} catch (Throwable ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Lỗi commit():\n" + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	@Override
	public boolean insert(Account t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Account t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.delete(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(null, "Lỗi hàm delete:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	@Override
	public List<Account> getAccount(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Account a where a.accountType = :accountType and a.username = :username";
			Query query = session.createQuery(hql, Account.class);
			query.setParameter("accountType", t.getAccountType());
			query.setParameter("username", t.getUsername());
			return query.list();
			
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(null, "Lỗi hàm getAccount:\n" + ex.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}


}
