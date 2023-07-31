package Test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;

import java.sql.Date;

import org.hibernate.Session;

import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
//			Person p1 = new Person("Nguyen Van A", new Date(System.currentTimeMillis()), null);
//			session.save(p1);

//			Person p1 = session.load(Person.class, 1L);
//			Person p2 = new Person("Nguyen Thi B", new Date(System.currentTimeMillis()), p1);
//			session.save(p2);

			Person p1 = session.load(Person.class, 1L);
			Person p2 = session.find(Person.class, 2L);
			
			p1.setSpouse(p2);
			session.saveOrUpdate(p1);
			
			p2.setSpouse(p1);
			session.saveOrUpdate(p2);

			tr.commit();
			session.close();
		}
	}
}
