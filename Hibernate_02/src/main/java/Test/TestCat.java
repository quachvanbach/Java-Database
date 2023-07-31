package Test;

import java.sql.Date;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO cat_Dao = new CatDAO();

//		Test selectAll():
		List<Cat> list = cat_Dao.selectAll();
		for (Cat cat : list) {
			System.out.println(cat);
		}
		System.out.println("-----------------------------");

//		Test selectById():
		Cat c = new Cat();
		c.setId(1);

		Cat c1 = cat_Dao.selectById(c);
		System.out.println(c1);
//		Test insert():
		Cat c2 = new Cat("Julia 4", Date.valueOf("2015-12-12"), true);
//		c2.setId(10);
		cat_Dao.insert(c2);

		Cat c3 = new Cat("Mun", Date.valueOf("2015-12-12"), true);
		c3.setId(15);
		cat_Dao.update(c3);

		Cat c4 = new Cat(13, "Mun", Date.valueOf("2015-12-12"), true);
		cat_Dao.delete(c4);
	}
}
