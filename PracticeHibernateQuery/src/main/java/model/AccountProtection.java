package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_protection")
public class AccountProtection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "protect_id")
	private int protectId;
	private String twoFA;
	private String fullName;
	private String email;
	private String passmail;
	
	@OneToOne(mappedBy = "accountProtection")
	private Account account;
	
	public AccountProtection() {
	}

	public AccountProtection(String twoFA, String fullName, String email, String passmail) {
		super();
		this.twoFA = twoFA;
		this.fullName = fullName;
		this.email = email;
		this.passmail = passmail;
	}

	public AccountProtection(int protectId, String twoFA, String fullName, String email, String passmail) {

		this.protectId = protectId;
		this.twoFA = twoFA;
		this.fullName = fullName;
		this.email = email;
		this.passmail = passmail;
	}

	public int getProtectId() {
		return protectId;
	}

	public void setProtectId(int protectId) {
		this.protectId = protectId;
	}

	public String getTwoFA() {
		return twoFA;
	}

	public void setTwoFA(String twoFA) {
		this.twoFA = twoFA;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassmail() {
		return passmail;
	}

	public void setPassmail(String passmail) {
		this.passmail = passmail;
	}

	@Override
	public String toString() {
		return "AccountProtection [protectId=" + protectId + ", twoFA=" + twoFA + ", fullName=" + fullName + ", email="
				+ email + ", passmail=" + passmail + "]";
	}



}
