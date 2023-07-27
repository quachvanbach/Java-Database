package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "INSERT INTO  sach (id, tenSach, giaBan, namXuatBan) " + "VALUES (\"" + t.getID() + "\", \""
					+ t.getTenSach() + "\", " + t.getGiaBan() + ", " + t.getNamXuatBan() + ");";

			ketQua = st.executeUpdate(sql);

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
	public int update(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "UPDATE sach" + " SET" + " tenSach = '" + t.getTenSach() + "'," + " giaBan = " + t.getGiaBan()
					+ ", namXuatBan = '" + t.getNamXuatBan() + "'" + " WHERE id = '" + t.getID() + "'";

			System.out.println("Bạn đã thực thi " + sql);
			ketQua = st.executeUpdate(sql);

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
	public int delete(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "DELETE FROM sach" + " WHERE id = '" + t.getID() + "'";

			System.out.println("Bạn đã thực thi " + sql);
			ketQua = st.executeUpdate(sql);

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
	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
