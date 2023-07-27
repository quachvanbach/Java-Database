package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;
import model.Sach;

public class KhachHangDAO implements DAOInterface<KhachHang> {
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();

			String sql = "INSERT INTO khachhang(id, hoVaTen, ngaySinh, diaChi)" + " VALUES" + "(" + t.getId() + ", '"
					+ t.getHoVaTen() + "', '" + t.getNgaySinh() + "', '" + t.getDiaChi() + "');";

			System.out.println(sql);
			ketQua = st.executeUpdate(sql);

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();

			String sql = "UPDATE khachhang SET hoVaTen = '" + t.getHoVaTen() + "', ngaySinh = '" + t.getNgaySinh()
					+ "', diaChi = '" + t.getDiaChi() + "' WHERE id = " + t.getId();

			System.out.println(sql);
			ketQua = st.executeUpdate(sql);

			JDBCUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();

			String sql = "DELETE FROM khachhang WHERE id = " + t.getId();

			System.out.println(sql);
			ketQua = st.executeUpdate(sql);

			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();

		try {
			Connection conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();

			String sql = "SELECT * FROM khachhang";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");

				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(khachHang);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "SELECT * FROM khachhang WHERE id = '" + t.getId() + "'";

			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");

				ketQua = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
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
	public ArrayList<KhachHang> selectByCondition(String condition) {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();

		try {
			// Bước 1: Toạ kết nối đến CSDL
			Connection conn = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng Statement
			Statement st = conn.createStatement();

			// Bước 3: thực thi câu lệnh sql
			String sql = "SELECT * FROM khachhang WHERE " + condition;

			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

			// Bước 4: Xử lý kết quả:
			while (rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");

				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(khachHang);
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
