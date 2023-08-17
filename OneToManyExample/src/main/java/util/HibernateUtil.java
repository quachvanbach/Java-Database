package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Lỗi tạo kết nối Hibernate");
			e.printStackTrace();
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void shutdown() {
		sessionFactory.close();
	}
}
