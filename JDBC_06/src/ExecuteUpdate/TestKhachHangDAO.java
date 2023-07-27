package ExecuteUpdate;

import java.sql.Date;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {
	public static void main(String[] args) {
		KhachHang khachHang = new KhachHang(1, "Quachvanbach", Date.valueOf("1995-05-12"),
				"Thanh Xa Thanh Ha, Hai Duong");

		for (int i = 0; i < 10; i++) {
			khachHang = new KhachHang(1+i, "Quachvanbach", Date.valueOf("1995-05-12"), "Thanh Xa Thanh Ha, Hai Duong");
			KhachHangDAO.getInstance().insert(khachHang);
		}

		KhachHang updateKhachHang = new KhachHang(3, "QuachDaiKa", Date.valueOf("1995-05-12"), "Thanh Ha, Hai Duong");
		KhachHangDAO.getInstance().update(updateKhachHang);

		KhachHang deleteKhachHang = new KhachHang(4, "QuachDaiKa", Date.valueOf("1995-05-12"), "Thanh Ha, Hai Duong");
		KhachHangDAO.getInstance().delete(deleteKhachHang);
	}
}
