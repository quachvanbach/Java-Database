package main;

import java.sql.Connection;

import database.JDBCUtil;

public class CacBuocTuongTacVoiDatabase {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		System.out.println(connection);
		
		JDBCUtil.printInfo(connection);
		
		JDBCUtil.closeConnection(connection);
	}
}
