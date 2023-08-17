package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class CustomerTableModel extends AbstractTableModel {
	private List<Customer> data;
	private final String[] columnNames = new String[] { "ID", "Fullname", "Phonenumber", "Invoice"};

	public CustomerTableModel() {
		data = new ArrayList<Customer>();
	}

	public void setData(List<Customer> data) {
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
			return customer.getInvoices();
	
		default:
			return null;
		}
	}
}
