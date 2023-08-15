package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	private String accountType;
	private String username;
	private String password;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
	@JoinColumn(name = "protect_id")
	private AccountProtection accountProtection;

	public Account() {
	}

	public Account(String accountType, String username, String password, AccountProtection accountProtection) {
		this.accountType = accountType;
		this.username = username;
		this.password = password;
		this.accountProtection = accountProtection;
	}

	public Account(int accountId, String accountType, String username, String password, AccountProtection accountProtection) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.username = username;
		this.password = password;
		this.accountProtection = accountProtection;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public AccountProtection getAccountProtection() {
		return accountProtection;
	}

	public void setAccountProtection(AccountProtection accountProtection) {
		this.accountProtection = accountProtection;
	}

	@Override
	public String toString() {
		return "Account [id=" + accountId + ", accountType=" + accountType + ", username=" + username + ", password="
				+ password + ", accountProtection=" + accountProtection + "]";
	}

}
