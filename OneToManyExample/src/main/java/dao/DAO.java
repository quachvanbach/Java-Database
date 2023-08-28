package dao;

import java.util.List;

public interface DAO<T> {
	public List<T> selectAll();

	public T selectById(T t);
	
	public boolean saveOrUpdate(T t);

	public boolean update(T t);

	public boolean delete(T t);

	public List<T> getAccount(T t);

}