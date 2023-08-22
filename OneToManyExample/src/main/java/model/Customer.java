package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JButton;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "customer_name")
	private String fullName;
	@Column(name = "phonenumber")
	private String phonenumber;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<>();

	public Customer(String fullName, String phonenumber, String email, String address, List<Invoice> invoices) {
		this.fullName = fullName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + ", phonenumber=" + phonenumber + ", email=" + email
				+ ", address=" + address + "]";
	}

}
