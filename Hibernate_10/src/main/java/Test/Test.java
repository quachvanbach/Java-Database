package Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
//
//			DonHang dh1 = new DonHang();
//			dh1.setTenKhachHang("Nguyen Van A");
//			dh1.setNgayMua(Date.valueOf("2023-05-07"));
//
//			for (int i = 0; i < 10000; i++) {
//				ChiTietDonHang ctdh1 = new ChiTietDonHang("Mi Tom Hao Hao" + i, 10, 4000, 40000, dh1);
//				ChiTietDonHang ctdh2 = new ChiTietDonHang("Sting do" + i, 6, 10000, 60000, dh1);
//
//				dh1.addCTDH(ctdh1);
//				dh1.addCTDH(ctdh2);
//			}
//
//			session.save(dh1);

			long batDau = System.currentTimeMillis();
			DonHang dh = session.load(DonHang.class, 1);
			System.out.println(dh.toString());
			List<ChiTietDonHang> ds = dh.getDanhSachChiTiet();
			for (ChiTietDonHang ctdh : ds) {
				System.out.println(ctdh.toString());
			}
			long ketThuc = System.currentTimeMillis();
			
			
			System.out.println("Thoi gian thuc hien cau lenh la: " + (ketThuc - batDau));

//			DonHang dh = session.load(DonHang.class, 1);
//			session.delete(dh);

			transaction.commit();
			session.close();
		}

	}
}
