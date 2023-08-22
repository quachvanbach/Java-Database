package model;

import java.awt.Component;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "invoice")
public class Invoice {
	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	@Column(name = "date")
	private Date date;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "quantity")
	private double quantity;
	@Column(name = "price")
	private double price;
	@Column(name = "total_amount")
	private double totalAmount = quantity * price;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Invoice(Date date, String itemName, double quantity, double price, Customer customer) {
		super();
		this.date = date;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.customer = customer;
	}
}
