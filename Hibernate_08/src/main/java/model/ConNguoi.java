package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Tạo ra 1 bảng chứa thông tin của các lớp con
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Tạo ra bảng cha không lưu trữ dữ liệu, và các lớp con chứa dữ liệu được set.
//@Inheritance(strategy = InheritanceType.JOINED) // Tạo ra bảng cha chứa dữ liệu được kế thừa, lớp con chỉ lưu trữ thông
												// tin được thêm của lớp con và id của đối tượng đó
public class ConNguoi {
	@Id
	private String id;
	private String hoVaTen;
	private Date ngaySinh;

	public ConNguoi() {
	}

	public ConNguoi(String id, String hoVaTen, Date ngaySinh) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

}
