package model;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.CustomerDAO;
import dao.InvoiceDAO;
import util.HibernateUtil;

public class AppModel {
	Customer customer;
	Invoice invoice;
	CustomerDAO customerDAO = new CustomerDAO();
	InvoiceDAO invoiceDAO = new InvoiceDAO();

	public List<Invoice> getInvoiceByCustomer(Customer customer) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String getCustomerHQL = "from Customer where id = :id";
			Query<Customer> customerQuery = session.createQuery(getCustomerHQL, Customer.class);
			customerQuery.setParameter("id", customer.getId());
			Customer customerResult = customerQuery.uniqueResult();
			List<Invoice> invoices = customerResult.getInvoices();
			session.close();
			return invoices;
		} catch (Exception e) {
			System.out.println("Lỗi lấy ra thông tin đơn hàng của khách hàng");
			e.printStackTrace();
			return null;
		}
	}
}
