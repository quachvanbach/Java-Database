package Test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {

		// Transient
		Cat cat1 = new Cat("Meow Meow", Date.valueOf("2022-1-2"), false);

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

				// Persistent
				session.save(cat1);
				transaction.commit();

				// Detached => Persistent
				session.refresh(cat1);
				session.close();
				// Sau khi đóng session, đối tượng đó chuyển sang trạng thái detached.
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cat1);
	}
}
