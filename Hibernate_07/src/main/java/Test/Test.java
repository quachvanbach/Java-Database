package Test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			NhanVien nv1 = new NhanVien("NV1", "Nguyen Van A", Date.valueOf("1990-12-12"));
			session.saveOrUpdate(nv1);

			CuocHop ch1 = new CuocHop();
			ch1.setId(1);
			ch1.setTenCuocHop("Hop hoi dong quan tri cong ty");
			ch1.setThoiGian(Date.valueOf("2023-08-30"));
			ch1.setDiaDiem("Phong hop 1");
			ch1.addNhanVien(nv1);

			session.saveOrUpdate(ch1);

			transaction.commit();
			session.close();
		}

	}
}
