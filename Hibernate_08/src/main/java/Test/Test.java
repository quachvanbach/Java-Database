package Test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.SinhVien;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			GiaoVien gv = new GiaoVien("GV01", "Tran Giao Vien", Date.valueOf("1990-11-11"), "Tin hoc");
			SinhVien sv = new SinhVien("SV01", "Nguyen Sinh Vien", Date.valueOf("2002-2-2"), 7.0);
			
			session.saveOrUpdate(gv);
			session.saveOrUpdate(sv);
			
			transaction.commit();
			session.close();
		}

	}
}
