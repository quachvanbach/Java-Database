package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User> {

	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
//			String sql = "INSERT INTO  user (username, password, hoVaTen) " + "VALUES ('" + t.getUsername()
//			+ "', '" + t.getPassword() + "', '" + t.getHoVaTen() + "');";
//			Statement st = conn.createStatement();

			// Thay Statement = PreparedStatement
			String sql = "INSERT INTO  user (username, password, hoVaTen) " + "VALUES (?, ?, ?);";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHoVaTen());

			// Bước 3: thực thi câu lệnh sql

			ketQua = pst.executeUpdate();

			// Bước 4: Xử lý kết quả:
			System.out.println("Bạn đã thực thi " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
//			String sql = "UPDATE user" + " SET password = '" + t.getPassword() + "', hoVaTen = '" + t.getHoVaTen() + "'"
//					+ " WHERE id = '" + t.getUsername() + "'";
//			Statement st = conn.createStatement();

			// Thay Statement = PreparedStatement
			String sql = "UPDATE user SET password = ?, hoVaTen = ? WHERE username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getHoVaTen());
			pst.setString(3, t.getUsername());

			// Bước 3: thực thi câu lệnh sql

			System.out.println("Bạn đã thực thi " + sql);
			ketQua = pst.executeUpdate();

			// Bước 4: Xử lý kết quả:
			System.out.println("Có " + ketQua + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
//			String sql = "DELETE FROM user" + " WHERE username = '" + t.getUsername() + "'";
//			Statement st = conn.createStatement();

			// Thay Statement = PreparedStatement
			String sql = "DELETE FROM user WHERE username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());

			// Bước 3: thực thi câu lệnh sql

			System.out.println("Bạn đã thực thi " + sql);
			ketQua = pst.executeUpdate();

			// Bước 4: Xử lý kết quả:
			System.out.println("Có " + ketQua + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
//			String sql = "SELECT * FROM user";
//			Statement st = conn.createStatement();

			// Thay Statement = PreparedStatement
			String sql = "SELECT * FROM user";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh sql

			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				User user = new User(username, password, hoVaTen);
				ketQua.add(user);
			}

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public User selectById(User t) {
		User ketQua = null;

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
//			String sql = "SELECT * FROM user WHERE username = '" + t.getUsername() + "'";
//			Statement st = conn.createStatement();

			// Thay Statement = PreparedStatement
			String sql = "SELECT * FROM user WHERE username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			
			// Bước 3: thực thi câu lệnh sql
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");
				ketQua = new User(username, password, hoVaTen);
			}

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();

		return ketQua;
	}

}
