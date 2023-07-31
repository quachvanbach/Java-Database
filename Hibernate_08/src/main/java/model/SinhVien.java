package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class SinhVien extends ConNguoi {
	private double diemTrungBinh;

	public SinhVien() {
	}

	public SinhVien(String id, String hoVaTen, Date ngaySinh, double diemTrungBinh) {
		super(id, hoVaTen, ngaySinh);
		this.diemTrungBinh = diemTrungBinh;
	}
	
	

}
