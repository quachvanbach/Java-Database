package model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
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
			System.out.println("Khách hàng lấy được trong getInvoiceByCustomer" + customerResult);
			List<Invoice> invoices = customerResult.getInvoices();
			System.out.println("Những đơn hàng tìm được trong getInvoiceByCustomer");
			for (Invoice invoice : invoices) {
				System.out.println(invoice);
			}
			session.close();
			return invoices;
		} catch (Exception e) {
			System.out.println("Lỗi lấy ra thông tin đơn hàng của khách hàng");
			e.printStackTrace();
			return null;
		}
	}
	
	public Customer getCustomerByInvoice(Invoice invoice) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String getInvoiceHQL = "from Invoice where id = :id";
			Query<Invoice> invoiceQuery = session.createQuery(getInvoiceHQL, Invoice.class);
			invoiceQuery.setParameter("id", invoice.getInvoice_id());
			Invoice invoiceResult = invoiceQuery.uniqueResult();
			System.out.println("Invoice" + invoiceResult);
			Customer customerResult = invoiceResult.getCustomer();
			System.out.println("Customer" + customerResult);
			
			session.close();
			return customerResult;
		} catch (Exception e) {
			System.out.println("Lỗi lấy ra thông tin của khách hàng");
			e.printStackTrace();
			return null;
		}
	}
	
	public Point getScreenSize() {
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int screenWidth = screenSize.width;
	        int screenHeight = screenSize.height;
	        Point point = new Point(screenWidth,screenHeight);
			return point;
	}
}
