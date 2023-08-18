package dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Invoice;
import util.HibernateUtil;

public class InvoiceDAO implements DAO<Invoice> {

	@Override
	public List<Invoice> selectAll() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Invoice";
			Query<Invoice> query = session.createQuery(hql, Invoice.class);
			List<Invoice> invoices = query.list();
			return invoices;
		} catch (Exception e) {
			System.out.println("Lỗi hàm selectAll");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Invoice selectById(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Invoice where invoice_id = :invoice_id";
			Query<Invoice> query = session.createQuery(hql, Invoice.class);
			query.setParameter("customer", t.getInvoice_id());
			Invoice invoice = query.uniqueResult();
			session.close();
			return invoice;
		} catch (Exception e) {
			System.out.println("Lỗi hàm selectById của Invoice");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			session.saveOrUpdate(t);
			
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Lỗi hàm insert()");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Invoice t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Invoice t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Invoice> getAccount(Invoice t) {
		// TODO Auto-generated method stub
		return null;
	}

}
