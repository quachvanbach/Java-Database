package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Book;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();

				Book book_1 = session.get(Book.class,"B05");
				System.out.println("Tac gia cua cuon "+book_1.getTitle()+" la "+book_1.getAuthor().getName());

				transaction.commit();
				session.close();
			}

		} catch (Exception e) {
			System.out.println();
		}
	}
}
