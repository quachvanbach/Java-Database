package Test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.My_Order;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

//				Customer customer_1 = new Customer("001", "Quach Dai Ka", "QuachDaiKa@gmail.com");
//				Customer customer_2 = new Customer("002", "Quach Ka Ka", "QuachkaKa@gmail.com");
//				My_Order order_1 = new My_Order("1", "Ha Noi", customer_1);
//				My_Order order_2 = new My_Order("2", "Hai Duong", customer_1);
//				My_Order order_3 = new My_Order("3", "Hai Phong", customer_1);
//				My_Order order_4 = new My_Order("4", "Thai Binh", customer_1);
//
//				List<My_Order> list = new ArrayList<My_Order>();
//
//				list.add(order_1);
//				list.add(order_2);
//				list.add(order_3);
//				list.add(order_4);
//
//				customer_1.setOrders(list);
//
//				session.saveOrUpdate(customer_1);
//				session.saveOrUpdate(customer_2);
//				session.saveOrUpdate(order_1);
//				session.saveOrUpdate(order_2);
//				session.saveOrUpdate(order_3);
//				session.saveOrUpdate(order_4);
				
				String hql = "From Customer c where size(c.orders) > 0";
				List<Customer> customers = session.createQuery(hql).list();
				
				for (Customer customer : customers) {
					System.out.println(customer);
				}
				
				transaction.commit();
				session.close();
			}

		} catch (Exception e) {
			System.out.println();
		}
	}
}
