package dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
		ArrayList<Sach> ketQua = new ArrayList<Sach>();

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "SELECT * FROM sach";

			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");

				Sach sach = new Sach(id, tenSach, namXuatBan, namXuatBan);
				ketQua.add(sach);
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
	public Sach selectById(Sach t) {
		Sach ketQua = null;

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "SELECT * FROM sach WHERE id = '" + t.getID() + "'";

			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");

				ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
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
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "SELECT * FROM sach WHERE " + condition;

			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}

			// Bước 5: Ngắt kết nối
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
