package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class InvoiceTableModel extends AbstractTableModel {
	private List<Invoice> invoices;
	private String[] columnNames = { "ID", "Item name", "Quantity", "Price" };

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
		case 1: return invoice.getItemName();
		case 2: return invoice.getQuantity();
		case 3: return invoice.getPrice();

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

	public List<Invoice> getInvoices() {
		return invoices;
	}
}
