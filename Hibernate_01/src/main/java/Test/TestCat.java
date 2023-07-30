package Test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try {
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();

				try {
					Transaction tr = session.beginTransaction();

					Cat cat1 = new Cat();
					cat1.setName("Tom");
					cat1.setDateOfBirth(Date.valueOf("1991-1-19"));
					cat1.setSex(true);
					session.save(cat1);
					
					tr.commit();
					
					session.refresh(cat1);
					
				} finally {
					session.close();
				}
			}
		} catch (HibernateException e) {
			System.out.println("Lỗi...");
		}
	}
}
