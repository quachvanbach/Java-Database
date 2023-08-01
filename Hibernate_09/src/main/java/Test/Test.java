package Test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietDonHang;
import model.DonHang;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			DonHang dh1 = new DonHang();
			dh1.setTenKhachHang("Nguyen Van A");
			dh1.setNgayMua(Date.valueOf("2023-05-07"));
			
			ChiTietDonHang ctdh1 = new ChiTietDonHang("Mi Tom Hao Hao", 10, 4000, 40000, dh1);
			ChiTietDonHang ctdh2 = new ChiTietDonHang("Sting do", 6, 10000, 60000, dh1);
			
			dh1.addCTDH(ctdh1);
			dh1.addCTDH(ctdh2);
			
			session.save(dh1);
			
//			DonHang dh = session.load(DonHang.class, 1);
//			session.delete(dh);
			
			transaction.commit();
			session.close();
		}

	}
}
