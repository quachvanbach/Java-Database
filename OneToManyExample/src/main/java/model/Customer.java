package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String phonenumber;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<>();

	public Customer() {
	}

	public Customer(String fullName, String phonenumber) { // , List<Invoice> invoices) {
		this.fullName = fullName;
		this.phonenumber = phonenumber;
//		this.invoices = invoices;
	}

	public Customer(int id, String fullName, String phonenumber) { // , List<Invoice> invoices) {
		this.id = id;
		this.fullName = fullName;
		this.phonenumber = phonenumber;
//		this.invoices = invoices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + ", phonenumber=" + phonenumber + ", invoice="
				+ invoices.toString() + "]";
	}
}
