package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Account;
import util.HibernateUtil;

public class AccountDao implements DAO<Account> {

	@Override
	public List<Account> selectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Account";
		Query<Account> query = session.createQuery(hql, Account.class);
		List<Account> accounts = query.getResultList();
		session.close();
		return accounts;
	}

	@Override
	public Account selectBy(Account t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Account a where a.id = :id";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("id", t.getAccountId());
		Account account = query.uniqueResult();
		session.close();
		return account;
	}

	@Override
	public List<Account> selectLike(Account t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Account WHERE username LIKE :username";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("username", t.getUsername() + "%");
		List<Account> accounts = query.getResultList();
		session.close();
		return accounts;
	}

	@Override
	public boolean insert(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Lỗi thêm tài khoản \n");
			return false;
		}
	}

	@Override
	public boolean update(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			String hql = "update Account set accountType = :accountType, username = :username, password = :password where accountId = :accountId";
			Query query = session.createQuery(hql);
			query.setParameter("accountId", t.getAccountId());
			query.setParameter("accountType", t.getAccountType());
			query.setParameter("username", t.getUsername());
			query.setParameter("password", t.getPassword());
			int rowAffect = query.executeUpdate();
			System.out.println("Dòng bị sửa là " + rowAffect);
			transaction.commit();
			session.close();
			return true;
		} catch (Throwable ex) {
			System.out.println("Lỗi hàm update Account " + ex);
			return false;
		}
	}

	@Override
	public boolean delete(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			String hql = "DELETE FROM Account WHERE accountId = :accountId";
			Query query = session.createQuery(hql);
			query.setParameter("accountId", t.getAccountId());
			int rowsAffect = query.executeUpdate();
			System.out.println("Dòng bị xoá là " + rowsAffect);
// 			session.delete(t);
			transaction.commit();
			session.close();
			return true;
		} catch (Throwable ex) {
			System.out.println("Lỗi hàm delete Account " + ex);
			return false;
		}
	}

	@Override
	public List<Account> join() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT a FROM Account a LEFT JOIN FETCH a.accountProtection";
		Query<Account> query = session.createQuery(hql, Account.class);
		List<Account> accounts = query.getResultList();
		return accounts;
	}

	@Override
	public List<Account> orderBy(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> groupBy(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> having(Account t) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Account> distinct(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

}
