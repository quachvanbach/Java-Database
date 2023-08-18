package viewer;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.Controller;
import dao.CustomerDAO;
import dao.InvoiceDAO;
import model.AppModel;
import model.ButtonCellEditor;
import model.Customer;
import model.CustomerTableModel;
import model.Invoice;
import model.InvoiceTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Hibernate;

import java.awt.Component;

public class AppView extends JFrame {

	private CustomerTableModel customerTableModel = new CustomerTableModel();
	private InvoiceTableModel invoiceTableModel = new InvoiceTableModel();
	private CustomerDAO customerDAO = new CustomerDAO();
	private InvoiceDAO invoiceDao = new InvoiceDAO();
	CustomizeCustomer customizeCustomer = new CustomizeCustomer();
	CustomizeInvoice customizeInvoice = new CustomizeInvoice();
	AppModel appModel = new AppModel();
	private ButtonCellEditor buttonCellEditor = new ButtonCellEditor(this);
	private Customer customer;
	private Invoice invoice;
	private JPanel contentPane;
	private JTable table = new JTable();
	private JButton btnAdd;

	public AppView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		ActionListener action = new Controller(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem menuItem_back = new JMenuItem("Back");
		menuItem_back.addActionListener(action);
//		menuItem_back.disable();
		menuBar.add(menuItem_back);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		refreshtable();

		btnAdd = new JButton("Add Customer");
		btnAdd.addActionListener(action);
		btnAdd.setBounds(10, 303, 89, 23);
		contentPane.add(btnAdd);

		table.getColumnModel().getColumn(5).setCellRenderer(buttonCellEditor);
		table.getColumnModel().getColumn(5).setCellEditor(buttonCellEditor);
		table.setBounds(0, 0, 1, 1);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(384, 11, 539, 415);
		contentPane.add(scrollPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnAdd, scrollPane, table}));
	}

	public void refreshtable() {
		List<Customer> customers = customerDAO.selectAll();
		customerTableModel.setData(customers);
		customerTableModel.fireTableDataChanged();
		table.setModel(customerTableModel);
		table.getColumnModel().getColumn(5).setCellRenderer(buttonCellEditor);
		table.getColumnModel().getColumn(5).setCellEditor(buttonCellEditor);
		table.setBounds(0, 0, 1, 1);
	}

	public void showInvoicesInformation() {
		customer = new Customer();
		int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "");
		customer.setId(id);
		List<Invoice> invoices = appModel.getInvoiceByCustomer(customer);
		invoiceTableModel.setInvoices(invoices);
		table.setModel(invoiceTableModel);
	}

	public void goBack() {
		refreshtable();
	}

//	private Customer getCustomerInfo() {
//		return Customer.builder()
//		.fullName(txtCustomerName.getText())
//		.phonenumber(txtPhonenumber.getText())
//		.email(txtEmail.getText())
//		.address(txtAddress.getText())
//		.build();
//	}
	
	public void addCustomer() {
//		customer = getCustomerInfo();
//		customerDAO.insert(customer);
//		refreshtable();
        Point topLeft = getLocationOnScreen();
        customizeCustomer.setLocation(topLeft.x + getWidth() - customizeCustomer.getWidth(), topLeft.y);
        customizeCustomer.setVisible(true);
		customizeCustomer.setVisible(true);
	}
}
