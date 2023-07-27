package ExecuteQuerry;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
		Sach sach1 = new Sach("1", "Lập trình Java", 50000, 2020);
		Sach sach2 = new Sach("FST", "Fullstack", 70000, 2020);

//		SachDAO.getInstance().insert(sach1);
//		SachDAO.getInstance().insert(sach2);
//
//		for (int i = 0; i < 1000; i++) {
//			sach1 = new Sach("LTJV" + i, "Lập trình Java" + i, 50000 + (i * 1000), 2020 - i);
//			SachDAO.getInstance().insert(sach1);
//		}
//
//		SachDAO.getInstance().update(sach2);
//
//		for (int i = 900; i < 990; i++) {
//			sach1 = new Sach("LTJV" + i, "Lập trình Java" + i, 50000 + (i * 1000), 2020 - i);
//			SachDAO.getInstance().delete(sach1);
//		}
		
		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
		
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
		
		System.out.println("---------------------------------");
		Sach findSach = SachDAO.getInstance().selectById(sach1);
		System.out.println(findSach);
		
		System.out.println("---------------------------------");
		ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("giaBan >60000");
		for (Sach sach : list2) {
			System.out.println(sach.toString());
		}
	}
}