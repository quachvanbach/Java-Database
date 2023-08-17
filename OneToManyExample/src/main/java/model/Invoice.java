package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	private String itemName;
	private double quantity;
	private double price;	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Invoice() {
	}

	public Invoice(String itemName, double quantity, double price, Customer customer) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.customer = customer;
	}

	public Invoice(int invoice_id, String itemName, double quantity, double price, Customer customer) {
		this.invoice_id = invoice_id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.customer = customer;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", itemName=" + itemName + ", quantity=" + quantity + ", price="
				+ price + ", customer=" + customer + "]";
	}
}
