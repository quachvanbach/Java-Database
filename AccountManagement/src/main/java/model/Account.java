package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_account_management")
public class Account {
	@Id
	@GeneratedValue
	@Column(name = "id")
	int id;
	@Column(name = "accountType")
	String accountType;
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "twoFA")
	String twoFA;
	@Column(name = "phonenumber")
	String phonenumber;
	@Column(name = "email")
	String email;
	@Column(name = "passMail")
	String passMail;
	
	public Account() {
	}

	public Account(String accountType, String username, String password, String twoFA, String phonenumber, String email,
			String passMail) {
		super();
		this.accountType = accountType;
		this.username = username;
		this.password = password;
		this.twoFA = twoFA;
		this.phonenumber = phonenumber;
		this.email = email;
		this.passMail = passMail;
	}

	public Account(int id, String accountType, String username, String password, String twoFA, String phonenumber,
			String email, String passMail) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.username = username;
		this.password = password;
		this.twoFA = twoFA;
		this.phonenumber = phonenumber;
		this.email = email;
		this.passMail = passMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTwoFA() {
		return twoFA;
	}

	public void setTwoFA(String twoFA) {
		this.twoFA = twoFA;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassMail() {
		return passMail;
	}

	public void setPassMail(String passMail) {
		this.passMail = passMail;
	}
	
	
}
