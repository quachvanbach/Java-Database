package Test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				Author author_1 = new Author("001", "Nguyen Van A",Date.valueOf("1990-12-2"));
				Book book_1 = new Book("B01", "Quyen Sach 1", 100000, author_1);
				Book book_2 = new Book("B02", "Quyen Sach 2", 120000, author_1);
				Book book_3 = new Book("B03", "Quyen Sach 3", 75000, author_1);
				
				session.saveOrUpdate(author_1);
				session.saveOrUpdate(book_1);
				session.saveOrUpdate(book_2);			
				session.saveOrUpdate(book_3);
//
//				transaction.commit();
//				session.close();
//
//				Session session = sessionFactory.openSession();
//				Transaction transaction = session.beginTransaction();

				Author author_2 = new Author("002", "Tran Van B", Date.valueOf("1990-12-2"));
				Book book_4 = new Book("B04", "Quyen Sach 4", 95000, author_2);
				Book book_5 = new Book("B05", "Quyen Sach 5", 200000, author_2);
				Book book_6 = new Book("B06", "Quyen Sach 6", 189000, author_2);

				session.saveOrUpdate(author_2);
				session.saveOrUpdate(book_4);
				session.saveOrUpdate(book_5);
				session.saveOrUpdate(book_6);
				
				

				transaction.commit();
				session.close();
			}

		} catch (Exception e) {
			System.out.println();
		}
	}
}
