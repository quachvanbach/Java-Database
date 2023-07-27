package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
