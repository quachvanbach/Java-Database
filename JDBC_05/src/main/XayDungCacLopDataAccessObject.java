package main;

import java.sql.Connection;

import database.JDBCUtil;

public class XayDungCacLopDataAccessObject {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();

		JDBCUtil.printInfo(connection);
		System.out.println(connection);

		JDBCUtil.closeConnection(connection);
	}
}
