package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomerTableModel extends AbstractTableModel {
	private List<Customer> data;
	private final String[] columnNames = new String[] { "ID", "Fullname", "Phonenumber", "Email", "Address",
			"Invoice" };

	public CustomerTableModel() {
		data = new ArrayList<Customer>();
	}

	public void setCustomers(List<Customer> data) {
		this.data = data;
	}

	public void addrow(Customer customer) {
		data.add(customer);
		fireTableDataChanged(); // Dùng thông báo sự thay đổi dữ liệu
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return customer.getId();
		case 1:
			return customer.getFullName();
		case 2:
			return customer.getPhonenumber();
		case 3:
			return customer.getEmail();
		case 4:
			return customer.getAddress();
		case 5:
			return "Have " + customer.getInvoices().size() + " invoices"; // Giá trị kiểu nút

		default:
			return null;
		}
	}

	public Customer getCustomerAt(int rowIndex) {
		Customer customer = data.get(rowIndex);
		return customer;

	}

//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		return columnIndex == 5; // Chỉ cột kiểu nút là có thể sửa
//	}
}
