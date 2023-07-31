package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	private String Author_id;
	private String name;
	private Date doteOfBirth;

	public Author() {

	}

	public String getAuthor_id() {
		return Author_id;
	}

	public void setAuthor_id(String author_id) {
		Author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoteOfBirth() {
		return doteOfBirth;
	}

	public void setDoteOfBirth(Date doteOfBirth) {
		this.doteOfBirth = doteOfBirth;
	}

	public Author(String author_id, String name, Date doteOfBirth) {
		super();
		Author_id = author_id;
		this.name = name;
		this.doteOfBirth = doteOfBirth;
	}

	@Override
	public String toString() {
		return "Author [Author_id=" + Author_id + ", name=" + name + ", doteOfBirth=" + doteOfBirth + "]";
	}

}
