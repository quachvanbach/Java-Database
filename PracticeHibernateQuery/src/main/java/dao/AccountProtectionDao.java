package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.AccountProtection;
import util.HibernateUtil;

public class AccountProtectionDao implements DAO<AccountProtection> {

	@Override
	public List<AccountProtection> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountProtection selectBy(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountProtection> selectLike(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(AccountProtection t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
//			String hql = "insert into account_protection(twoFA, fullName, email, passmail) values (:twoFA, :fullName, :email, :passmail)";
//			Query<AccountProtection> query = session.createNativeQuery(hql);
//			query.setParameter("twoFA", t.getTwoFA());
//			query.setParameter("fullName", t.getFullName());
//			query.setParameter("email", t.getEmail());
//			query.setParameter("passmail", t.getPassmail());
//			int rowAffects = query.executeUpdate();
//			System.out.println("Thêm dữ liệu tại dòng " + rowAffects);
			
			session.saveOrUpdate(t);;
			
			transaction.commit();
			session.close();
			return true;

		} catch (Throwable ex) {
			System.out.println("Lỗi thêm account protection " + ex);
			return false;
		}
	}

	@Override
	public boolean update(AccountProtection t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(AccountProtection t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AccountProtection> join(AccountProtection t, AccountProtection t1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountProtection> orderBy(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> groupBy(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> having(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountProtection> join(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountProtection> distinct(AccountProtection t) {
		// TODO Auto-generated method stub
		return null;
	}

}
