package preparedstatement;

import java.sql.Date;
import java.util.ArrayList;

import dao.KhachHangDAO;
import dao.SachDAO;
import model.KhachHang;
import model.Sach;

public class TestKhachHangDAO {
	public static void main(String[] args) {
		KhachHang khachHang = new KhachHang(5, "Quachvanbach", Date.valueOf("1995-05-12"),
				"Thanh Xa Thanh Ha, Hai Duong");

//		for (int i = 0; i < 10; i++) {
//			khachHang = new KhachHang(1+i, "Quachvanbach", Date.valueOf("1995-05-12"), "Thanh Xa Thanh Ha, Hai Duong");
//			KhachHangDAO.getInstance().insert(khachHang);
//		}

//		KhachHang updateKhachHang = new KhachHang(3, "QuachDaiKa", Date.valueOf("1995-05-12"), "Thanh Ha, Hai Duong");
//		KhachHangDAO.getInstance().update(updateKhachHang);
//
//		KhachHang deleteKhachHang = new KhachHang(4, "QuachDaiKa", Date.valueOf("1995-05-12"), "Thanh Ha, Hai Duong");
//		KhachHangDAO.getInstance().delete(deleteKhachHang);

		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
		for (KhachHang khachHang2 : list) {
			System.out.println(khachHang2.toString());
		}

		System.out.println("---------------------------------");
		KhachHang findKhachHang = KhachHangDAO.getInstance().selectById(khachHang);
		System.out.println(findKhachHang);

		System.out.println("---------------------------------");
		ArrayList<KhachHang> list2 = KhachHangDAO.getInstance().selectByCondition("hoVaTen = 'QuachDaiKa'");
		for (KhachHang khachHang1 : list2) {
			System.out.println(khachHang1.toString());
		}
	}
}
