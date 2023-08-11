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
		String hql = "from account a where a.username = :username";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("username", t.getUsername());
		List<Account> accounts = query.getResultList();
		session.close();
		return accounts;
	}

	@Override
	public boolean insert(Account t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
//			String hql = "insert into account(accountType, username, password, protect_method) values (:accountType, :username, :password, :protect_method)";
//			Query<Account> query = session.createNativeQuery(hql);
//			query.setParameter("accountType", t.getAccountType());
//			query.setParameter("username", t.getUsername());
//			query.setParameter("password", t.getPassword());
//			query.setParameter("protect_method", t.getAccountProtection().getProtectId());
//			int rowAffected = query.executeUpdate();
//			System.out.println("Thêm dữ liệu dòng " + rowAffected);

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

	}

	@Override
	public boolean delete(Account t) {

	}

	@Override
	public List<Account> join(Account t, Account t1) {

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
	public List<Account> join(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> distinct(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

}
