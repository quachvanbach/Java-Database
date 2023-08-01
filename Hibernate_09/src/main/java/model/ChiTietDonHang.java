package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChiTietDonHang {
	@Id
	@GeneratedValue
	private int id;
	private String tenSanPham;
	private double soLuong;
	private double giaBan;
	private double thanhTien;
	
	@ManyToOne
	@JoinColumn(name = "donhang_id")
	private DonHang donHang;

	public ChiTietDonHang() {
		super();
	}

	
	
	public ChiTietDonHang(String tenSanPham, double soLuong, double giaBan, double thanhTien, DonHang donhang) {
		super();
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thanhTien = thanhTien;
		this.donHang = donhang;
	}



	public ChiTietDonHang(int id, String tenSanPham, double soLuong, double giaBan, double thanhTien, DonHang donhang) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thanhTien = thanhTien;
		this.donHang = donhang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public DonHang getDonhang() {
		return donHang;
	}

	public void setDonhang(DonHang donhang) {
		this.donHang = donhang;
	}
	
	
}
