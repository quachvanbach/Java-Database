package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		
		// Transient
		Cat cat1 = new Cat();
		cat1.setId(1);

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

				// Persistent
				cat1 = session.get(Cat.class, 1); // load()/find()
				transaction.commit();
				session.close();
			}

		} catch (Exception e) {
			System.out.println();
		}
	}
}
