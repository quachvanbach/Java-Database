package dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Customer;
import util.HibernateUtil;

public class CustomerDAO implements DAO<Customer> {
	@Override
	public List<Customer> selectAll() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Customer";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			List<Customer> customers = query.list();
//			session.close();
			return customers;
		} catch (HibernateException e) {
			System.out.println("Lỗi hàm selectAll()");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer selectById(Customer t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Customer where id = :id";
			Query<Customer> query = session.createQuery(hql, Customer.class);
			query.setParameter("id", t.getId());
			Customer customer = query.uniqueResult();
			session.close();
			return customer;
		} catch (HibernateException e) {
			System.out.println("Lỗi hàm selectById của Customer");
			e.printStackTrace();
			return null;
		}
	}

	private boolean saveOrUpdate(Customer t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in the saveOrUpdate function of customer object " + e);
			return false;
		}
	}

	@Override
	public boolean insert(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Customer t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.delete(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(null, "Function customer object deletion error " + ex);
			return false;
		}
	}

	@Override
	public List<Customer> getAccount(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

}
