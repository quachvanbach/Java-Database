package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class CachKetNoiVoiDatabase {
	public static void main(String[] args) {
		
		try {
			// Bước 1: Toạ kết nối;
			Connection connection = JDBCUtil.getConnection();

			// Bước 2: Tạo đối tượng stament
			Statement st = connection.createStatement();
			
			// Bước 3: Thực thi 1 câu lệnh sql
			String sql = "INSERT INTO persons (last_name, first_name, gender, dob, income) "
					+ "VALUES "
					+ "(\"Duong\", \"Thi F\",\"F\",\"1999-12-12\", 20000000), "
					+ "(\"Pham\", \"Van G\",\"M\",\"1992-05-08\", 14000000)";
			int check = st.executeUpdate(sql);
						
			// Bước 4: Xử lý kết quả:
			System.out.println("Số dòng thay đổi: "+check);
			if(check>0) {	
				System.out.println("Thêm dữ liệu thành công!");
			}else {
				System.out.println("Thêm dữ liệu thất bại!");
			}
			
			// Bước 5: Ngắt kết nối:
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
