package dao;

import java.util.List;

import model.Account;

public interface DAO<T> {
	public List<T> selectAll();

	public T selectById(T t);

	public boolean insert(T t);

	public boolean update(T t);

	public boolean delete(T t);

	public List<T> getAccount(T t);

}