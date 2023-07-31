package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class GiaoVien extends ConNguoi{
	private String monHocPhuTrach;

	public GiaoVien() {
	}

	public GiaoVien(String id, String hoVaTen, Date ngaySinh, String monHocPhuTrach) {
		super(id, hoVaTen, ngaySinh);
		this.monHocPhuTrach = monHocPhuTrach;
	}


	
	
}
