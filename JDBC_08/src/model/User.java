package model;

public class User {
	private String username;
	private String password;
	private String hoVaTen;
	
	public User() {
	}

	public User(String username, String password, String hoVaTen) {
		super();
		this.username = username;
		this.password = password;
		this.hoVaTen = hoVaTen;
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

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", hoVaTen=" + hoVaTen + "]";
	}
	
	
}
