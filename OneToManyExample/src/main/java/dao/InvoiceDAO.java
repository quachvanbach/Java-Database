package dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.CustomConfirmDiaglog;
import model.Customer;
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
			JOptionPane.showMessageDialog(null, "Function invoice object SelectAll invoices " + e);
			return null;
		}
	}

	@Override
	public Invoice selectById(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "from Invoice where invoice_id = :invoice_id";
			Query<Invoice> query = session.createQuery(hql, Invoice.class);
			query.setParameter("invoice_id", t.getInvoice_id());
			Invoice invoice = query.uniqueResult();
			session.close();
			return invoice;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in the saveOrUpdate function of customer object " + e);
			return null;
		}
	}

	private boolean save(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.save(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in the saveOrUpdate function of customer object " + e);
			return false;
		}
	}

	@Override
	public boolean saveOrUpdate(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			t.setTotalAmount(t.getQuantity() * t.getPrice());
			
			session.persist(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			int result = CustomConfirmDiaglog.showCustomConfirmDialog(
					"A invoice with this ID already exists. Do you want to edit the information of this invoice or create a new invoice with this information?",
					"Duplicate Invoice ID", "Edit Invoice Information", "Create a New Invoice", 0);
			if (result == JOptionPane.YES_OPTION) {
				return update(t);
			} else {
				return save(t);
			}
		}
	}

	@Override
	public boolean update(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in the saveOrUpdate function of invoice object " + e);
			return false;
		}
	}

	@Override
	public boolean delete(Invoice t) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			t.setTotalAmount(t.getQuantity() * t.getPrice());

			session.delete(t);

			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Function invoice object deletion  error " + e);
			return false;
		}
	}


	@Override
	public List<Invoice> getAccount(Invoice t) {
		return null;
	}

}
