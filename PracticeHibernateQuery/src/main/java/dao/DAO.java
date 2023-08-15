package dao;

import java.util.List;

public interface DAO<T> {
	public List<T> selectAll();
	

	public T selectBy(T t);

	public List<T> selectLike(T t);

	public boolean insert(T t);

	public boolean update(T t);

	public boolean delete(T t);

	public List<T> join();

	public List<T> orderBy(T t);

	public List<Object[]> groupBy(T t);

	public List<Object[]> having(T t);

	public List<T> distinct(T t);
}
