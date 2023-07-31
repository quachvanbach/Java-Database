package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat> {

	@Override
	public List<Cat> selectAll() {
		List<Cat> list = new ArrayList<Cat>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				// Thực thi câu lệnh HQL
				String hql = "from Cat";
				Query query = session.createQuery(hql);
				list = query.getResultList();

				tr.commit();
				session.close();
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Lỗi /n" + e);
		}
		return list;
	}

	@Override
	public Cat selectById(Cat t) {
		Cat result = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				// Thực thi câu lệnh HQL
				result = session.get(Cat.class, 1); // get/find/load

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			System.out.println("Lỗi /n" + e);
		}

		return result;
	}

	public boolean saveOrUpdate(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				// Thực thi câu lệnh HQL
//				session.save(t); // Chỉ thêm mới khi chưa tồn tại.
				session.saveOrUpdate(t); // Thêm mới khi chưa tồn tại, hoặc cập nhật khi đã tồn tại.

				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println("Lỗi /n" + e);
		}
		return false;
	}

	@Override
	public boolean insert(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				// Thực thi câu lệnh HQL
				session.delete(t);

				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println("Lỗi /n" + e);
		}
		return false;
	}

}
