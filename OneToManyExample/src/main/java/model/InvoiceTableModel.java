package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.CustomerDAO;

public class InvoiceTableModel extends AbstractTableModel {
	private List<Invoice> invoices;
	private String[] columnNames = { "ID", "Purchase date", "Item name", "Quantity", "Price", "Total amount",
			"Customer ID" };
	private CustomerDAO customerDao = new CustomerDAO();

	public InvoiceTableModel() {
		invoices = new ArrayList<Invoice>();
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
		fireTableDataChanged();

	}

	@Override
	public int getRowCount() {
		return invoices.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Invoice invoice = invoices.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return invoice.getInvoice_id();
		case 1:
			return invoice.getDate();
		case 2:
			return invoice.getItemName();
		case 3:
			return invoice.getQuantity();
		case 4:
			return invoice.getPrice();
		case 5:
			return invoice.getPrice() * invoice.getPrice();
		case 6:
			return invoice.getCustomer();

		default:
			return null;
		}
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		return columnIndex == 6; // Chỉ cột kiểu nút là có thể sửa
//	}
}
