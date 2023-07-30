package Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();

			String hql = "SELECT p.name, p.spouse.name FROM Person p";
			List<Object[]> result = session.createQuery(hql).list();

			for (Object[] rs : result) {
				String name = rs[0] + "";
				String spouseName = rs[1] + "";

				System.out.println(name + " is married to " + spouseName);
			}

			tr.commit();
			session.close();
		}
	}
}
