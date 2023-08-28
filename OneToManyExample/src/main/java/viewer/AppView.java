package viewer;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AppController;
import dao.CustomerDAO;
import dao.InvoiceDAO;
import model.AppModel;
//import model.ButtonCellEditor;
import model.Customer;
import model.CustomerTableModel;
import model.Invoice;
import model.InvoiceTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import java.awt.Button;
import java.awt.Component;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class AppView extends JFrame {
	private CustomerTableModel customerTableModel = new CustomerTableModel();
	private InvoiceTableModel invoiceTableModel = new InvoiceTableModel();
	private CustomerDAO customerDAO = new CustomerDAO();
	private InvoiceDAO invoiceDao = new InvoiceDAO();
	CustomView customView = new CustomView(this);
	AppModel appModel = new AppModel();
	private Customer customer;
	private Invoice invoice;
	private JPanel contentPane;
	public JTable table = new JTable();
	public JButton btnShowOption;
	private JPanel panel_1;
	private JButton btnCancel;

	public AppView() {
		setTitle(
				"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(931, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		ActionListener appAction = new AppController(this, customView);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // Double-click
					int row = table.rowAtPoint(e.getPoint());
					if (row >= 0) {
						if (table.getColumnName(1).equals("Fullname")) {
							customView.showSelectedCustomer(selectedCustomer());
						} else {
							customView.showSelectedInvoice(selectedInvoice());
							customView.showSelectedCustomer(appModel.getCustomerByInvoice(selectedInvoice()));
							customView.disableEditCustomer();
						}
					}
				}
			}
		});
		table.setBounds(0, 0, 1, 1);
		table.setModel(customerTableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 722, 609);
		contentPane.add(scrollPane);

		btnShowOption = new JButton("Show invoices");
		btnShowOption.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowOption.setBounds(10, 11, 143, 23);
		btnShowOption.addActionListener(appAction);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(68, 68, 68)));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(742, 10, 163, 150);
		panel_1.setLayout(null);
		panel_1.add(btnShowOption);
		contentPane.add(panel_1);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(10, 52, 143, 23);
		btnCancel.addActionListener(appAction);
		panel_1.add(btnCancel);

		refreshtable();
	}

	public void refreshtable() {
//		List<Customer> customers = customerDAO.selectAll();
//		customerTableModel.setCustomers(customers);
//
//		List<Invoice> invoices = invoiceDao.selectAll();
//		invoiceTableModel.setInvoices(invoices);

		if (btnShowOption.getText().equals("Show invoices")) {
			showCustomersInformation();
		} else {
			showInvoicesInformation();
		}

		showCustom(true, true);
	}

	public void showCustomersInformation() {
		List<Customer> customers = customerDAO.selectAll();
		customerTableModel.setCustomers(customers);
		table.setModel(customerTableModel);
		customerTableModel.fireTableDataChanged();
		btnShowOption.setText("Show invoices");
	}

	public void showInvoicesInformation() {
		if (checkSelectedRow()) {
			customer = new Customer();
			int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "");
			customer.setId(id);
			List<Invoice> invoices = appModel.getInvoiceByCustomer(customer);
			invoiceTableModel.setInvoices(invoices);

		} else {
			List<Invoice> invoices = invoiceDao.selectAll();
			invoiceTableModel.setInvoices(invoices);

		}
		table.setModel(invoiceTableModel);
		invoiceTableModel.fireTableDataChanged();
		btnShowOption.setText("Show customers");
	}

	public void showCustom(boolean bl, boolean option) {
		if (bl) {
			Point screenSize = appModel.getScreenSize();
			this.setLocation((int) ((screenSize.getX() - ((this.getWidth()) + (customView.getWidth()))) / 2),
					this.getY());
			Point customizeView = new Point(getX() + getWidth(), getY());
			customView.setLocation(customizeView);
			if (option) {
				customView.setVisible(true);
			} else {
				customView.setVisible(true);
				customView.setSize(578, 262);
//				customView.separator.setVisible(false);
				customView.panel_2.setVisible(false);
			}
		} else {
			this.setLocationRelativeTo(null);
			customView.setVisible(false);
		}
	}

	public Customer selectedCustomer() {
		int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		customer = new Customer();
		customer.setId(id);
		Customer selectedCustomer = customerDAO.selectById(customer);
		return selectedCustomer;
	}

	public Invoice selectedInvoice() {
		int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "");
		invoice = new Invoice();
		invoice.setInvoice_id(id);
		return invoiceDao.selectById(invoice);
	}

	public boolean checkSelectedRow() {
		if (table.getSelectedRow() == -1) {
			return false;
		} else {
			return true;
		}
	}
}
