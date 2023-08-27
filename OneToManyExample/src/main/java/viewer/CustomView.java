package viewer;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AppController;
import dao.CustomerDAO;
import dao.InvoiceDAO;
import model.AppModel;
import model.Customer;
import model.Invoice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class CustomView extends JFrame {
	CustomerDAO customerDAO = new CustomerDAO();
	InvoiceDAO invoiceDAO = new InvoiceDAO();
	AppModel appModel = new AppModel();
	private AppView appView;
	private Customer customer;
	private Invoice invoice;
	private JPanel contentPane;
	private JTextField txtCustomerName;
	private JTextField txtPhonenumber;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtDate;
	private JTextField txtItemName;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	public JPanel panel_2;
	public Container panel_1;
	private JTextField txtId;
	private JTextField txtInvoiceId;
	private JButton btnAddCustomer;
	public JButton btnEditCustomer;
	private JButton btnDeleteCustomer;
	private JLabel lblId;
	private JLabel lblInvoiceList;
	public JComboBox<Invoice> cbInvoiceList;
	private JLabel lblHeader2;
	private JLabel lblDate;
	private JLabel lblItemName;
	private JLabel lblQuantity;
	private JLabel lblPrice;
	private JButton btnDeleteInvoice;
	private JLabel lblInvoiceId;
	private JButton btnEditInvoice;
	private JButton btnAddInvoice;
	private JLabel lblCustomerList;
	private JComboBox<Customer> cbCustomerList;

	public CustomView(AppView appView) {
		this.appView = appView;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(578, 663);
//		setBounds(1435, 259, 578, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AppController action = new AppController(appView, this);

		JLabel lblHeader1 = new JLabel("Customer information");
		lblHeader1.setFont(new Font("UVN Thoi Nay Nang", Font.ITALIC, 16));
		lblHeader1.setBounds(169, 18, 160, 23);

		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(35, 92, 103, 17);

		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(173, 86, 350, 23);

		JLabel lblPhonenumber = new JLabel("Phonenumber:");
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhonenumber.setBounds(35, 129, 92, 17);

		txtPhonenumber = new JTextField();
		txtPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhonenumber.setColumns(10);
		txtPhonenumber.setBounds(173, 122, 350, 23);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(35, 164, 36, 17);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 158, 350, 23);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(35, 199, 53, 17);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(173, 194, 350, 23);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 558, 315);
		panel_1.setLayout(null);
		panel_1.add(lblHeader1);
		panel_1.add(lblCustomerName);
		panel_1.add(txtCustomerName);
		panel_1.add(lblPhonenumber);
		panel_1.add(txtPhonenumber);
		panel_1.add(lblEmail);
		panel_1.add(txtEmail);
		panel_1.add(lblAddress);
		panel_1.add(txtAddress);
		contentPane.add(panel_1);

		btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddCustomer.addActionListener(action);
		btnAddCustomer.setBounds(46, 269, 124, 23);
		panel_1.add(btnAddCustomer);

		btnEditCustomer = new JButton("Edit customer");
		btnEditCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditCustomer.setBounds(216, 269, 124, 23);
		btnEditCustomer.addActionListener(action);
		panel_1.add(btnEditCustomer);

		btnDeleteCustomer = new JButton("Delete customer");
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteCustomer.setBounds(386, 269, 124, 23);
		btnDeleteCustomer.addActionListener(action);
		panel_1.add(btnDeleteCustomer);

		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(35, 59, 103, 17);
		panel_1.add(lblId);

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setColumns(10);
		txtId.setBounds(173, 55, 350, 23);
		txtId.setEditable(false);
		panel_1.add(txtId);

		lblInvoiceList = new JLabel("Invoice list:");
		lblInvoiceList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoiceList.setBounds(35, 234, 103, 17);
		panel_1.add(lblInvoiceList);

		cbInvoiceList = new JComboBox<Invoice>();
		cbInvoiceList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice = (Invoice) cbInvoiceList.getSelectedItem();
				readInvoiceInformation(invoice);
			}
		});
		cbInvoiceList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbInvoiceList.setBounds(173, 231, 347, 22);
		panel_1.add(cbInvoiceList);

		lblHeader2 = new JLabel("Invoice information");
		lblHeader2.setBounds(169, 18, 142, 23);
		lblHeader2.setFont(new Font("UVN Thoi Nay Nang", Font.ITALIC, 16));

		lblDate = new JLabel("Date:");
		lblDate.setBounds(35, 94, 34, 17);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtDate = new JTextField();
		txtDate.setBounds(173, 91, 350, 23);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblItemName = new JLabel("Product name:");
		lblItemName.setBounds(38, 129, 92, 17);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtItemName = new JTextField();
		txtItemName.setBounds(173, 126, 350, 23);
		txtItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtItemName.setColumns(10);

		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(35, 164, 58, 17);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtQuantity = new JTextField();
		txtQuantity.setBounds(173, 161, 350, 23);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantity.setColumns(10);

		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(35, 199, 34, 17);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtPrice = new JTextField();
		txtPrice.setBounds(173, 196, 350, 23);
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBounds(10, 337, 558, 315);
		panel_2.setLayout(null);
		panel_2.add(lblHeader2);
		panel_2.add(lblDate);
		panel_2.add(txtDate);
		panel_2.add(lblItemName);
		panel_2.add(txtItemName);
		panel_2.add(lblQuantity);
		panel_2.add(txtQuantity);
		panel_2.add(lblPrice);
		panel_2.add(txtPrice);
		panel_2.add(lblHeader2);
		panel_2.add(lblHeader2);
		contentPane.add(panel_2);

		btnAddInvoice = new JButton("Add invoice");
		btnAddInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddInvoice.setBounds(46, 269, 124, 23);
		btnAddInvoice.addActionListener(action);
		panel_2.add(btnAddInvoice);

		btnEditInvoice = new JButton("Edit invoice");
		btnEditInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditInvoice.setBounds(216, 269, 124, 23);
		btnEditInvoice.addActionListener(action);
		panel_2.add(btnEditInvoice);

		btnDeleteInvoice = new JButton("Delete invoice");
		btnDeleteInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteInvoice.setBounds(386, 269, 124, 23);
		btnDeleteInvoice.addActionListener(action);
		panel_2.add(btnDeleteInvoice);

		lblInvoiceId = new JLabel("ID:");
		lblInvoiceId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoiceId.setBounds(35, 59, 34, 17);
		panel_2.add(lblInvoiceId);

		txtInvoiceId = new JTextField();
		txtInvoiceId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInvoiceId.setBounds(173, 56, 350, 23);
		txtInvoiceId.setEditable(false);
		panel_2.add(txtInvoiceId);

		lblCustomerList = new JLabel("Customer list:");
		lblCustomerList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerList.setBounds(35, 234, 103, 17);
		panel_2.add(lblCustomerList);

		cbCustomerList = new JComboBox<Customer>();
		cbCustomerList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCustomerList.setBounds(173, 231, 347, 22);
		panel_2.add(cbCustomerList);

		initializable();
	}

	public void initializable() {
		List<Customer> customerList = customerDAO.selectAll();
		System.out.println("size: " + customerList.size());
		for (Customer customer : customerList) {
			System.out.println("Customer: ----------" + customer);
			cbCustomerList.addItem(customer);
			;
		}

	}

	public Customer getInputCustomer() {
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		int itemCount = cbInvoiceList.getItemCount();
		for (int i = 0; i < itemCount; i++) {
			Invoice invoice = cbInvoiceList.getItemAt(i);
			invoiceList.add(invoice);
		}
		customer = Customer.builder().fullName(txtCustomerName.getText())
				.phonenumber(txtPhonenumber.getText()).email(txtEmail.getText()).address(txtAddress.getText()).build();
		if (!txtId.getText().equals("")) {
			customer.setId(Integer.parseInt(txtId.getText()));
		}

		return customer;

	}

	public void clearCustomerInput() {
		txtCustomerName.getText();
		txtPhonenumber.getText();
		txtEmail.getText();
		txtAddress.getText();
	}

	public void readCustomerInformation(Customer customer) {
		txtId.setText(customer.getId() + "");
		txtCustomerName.setText(customer.getFullName() + "");
		txtPhonenumber.setText(customer.getPhonenumber() + "");
		txtEmail.setText(customer.getEmail() + "");
		txtAddress.setText(customer.getAddress() + "");
		List<Invoice> invoices = appModel.getInvoiceByCustomer(customer);
		for (Invoice invoice : invoices) {
			cbInvoiceList.addItem(invoice);
		}
	}

	public void readInvoiceInformation(Invoice invoice) {
		customer = appView.selectedCustomer();
		txtInvoiceId.setText(invoice.getInvoice_id() + "");
		txtDate.setText(invoice.getDate() + "");
		txtItemName.setText(invoice.getItemName());
		txtQuantity.setText(invoice.getInvoice_id() + "");
		txtPrice.setText(invoice.getPrice() + "");
		cbCustomerList.setSelectedItem(customer);
	}

	public Invoice getInputInvoice() {
		customer = new Customer();
		if (cbCustomerList.getSelectedIndex() == -1 && txtId != null) {
			customer.setId(Integer.parseInt(txtId.getText()));
		} else if (cbCustomerList.getSelectedIndex() != -1 && txtId == null) {
			customer = (Customer) cbCustomerList.getSelectedItem();
		} else if (cbCustomerList.getSelectedIndex() == -1 && txtId == null) {
			JOptionPane.showMessageDialog(appView, "Select a customer to add invoices!");
		} else if (cbCustomerList.getSelectedIndex() == -1 && txtId == null)
			invoice = Invoice.builder().date(Date.valueOf(txtDate.getText())).itemName(txtItemName.getText())
					.quantity(Double.parseDouble(txtQuantity.getText())).price(Double.parseDouble(txtPrice.getText()))
					.customer(customerDAO.selectById(customer)).build();
		if (!txtInvoiceId.getText().equals("")) {
			invoice.setInvoice_id(Integer.parseInt(txtInvoiceId.getText()));
		}
		return invoice;
	}

	public void setDisableInput() {
		txtCustomerName.setEditable(false);
		txtPhonenumber.setEditable(false);
		txtEmail.setEditable(false);
		txtAddress.setEditable(false);
	}

	public boolean checkEmptyInput() {
		if (txtDate != null || txtItemName != null || txtQuantity != null || txtPrice != null) {
			return false;
		} else {
			return true;
		}
	}

	public void setEmptyInput() {
		if (txtCustomerName.isEditable()) {
			txtId.setText(null);
			txtCustomerName.setText("");
			txtPhonenumber.setText("");
			txtEmail.setText("");
			txtAddress.setText("");
			txtDate.setText("");
			txtItemName.setText("");
			txtQuantity.setText("");
			txtPrice.setText("");
			cbInvoiceList.removeAllItems();
		} else {
			txtDate.setText("");
			txtItemName.setText("");
			txtQuantity.setText("");
			txtPrice.setText("");
		}
	}

	public void addCustomer() {
		if (!txtCustomerName.getText().equals("") && !txtPhonenumber.getText().equals("")) {
			System.out.println("customer name" + txtCustomerName.getText());
			customer = getInputCustomer();
			customerDAO.insert(customer);
			appView.refreshtable();
		} else {
			JOptionPane.showMessageDialog(appView, "Enter customer information");
		}
	}

	public void editCustomer() {
		if (appView.table.getSelectedRow() != -1) {
			customer = customerDAO.selectById(appView.selectedCustomer());
			readCustomerInformation(customer);
			btnEditCustomer.setText("Save customer");
		} else {
			JOptionPane.showMessageDialog(appView, "Select a customer to edit!");
		}
	}

	public void saveCustomer() {
		try {
			customerDAO.update(getInputCustomer());
			appView.refreshtable();
			setEmptyInput();
			btnEditCustomer.setText("Edit customer");
		} catch (Throwable ex) {
			JOptionPane.showMessageDialog(appView, "Select a customer to edit!");
			btnEditCustomer.setText("Edit customer");
		}
	}

	public void deleteCustomer() {
		if (appView.table.getSelectedRow() != -1) {
			customerDAO.delete(appView.selectedCustomer());
			appView.refreshtable();
			setEmptyInput();
		} else {
			JOptionPane.showMessageDialog(appView, "Select a customer delete!");
		}
	}

	public void addInvoice() {
		if (!txtId.getText().equals("")) {
			readCustomerInformation(appView.selectedCustomer());
			invoice = getInputInvoice();
			invoiceDAO.insert(invoice);
			setDisableInput();
			cbCustomerList.setSelectedItem(appView.selectedCustomer());
		} else if (appView.checkSelectedRow()) {
			customer = getInputCustomer();
			invoice = getInputInvoice();
			invoice.setCustomer(customer);
			invoiceDAO.insert(invoice);
			cbCustomerList.setSelectedItem(appView.selectedCustomer());
		} else if (cbCustomerList.getSelectedIndex() != -1) {
			customer = (Customer) cbCustomerList.getSelectedItem();
			invoice = getInputInvoice();
			invoice.setCustomer(customer);
			invoiceDAO.insert(invoice);

		} else {
			JOptionPane.showMessageDialog(appView, "Select a customer to add invoices!");
		}
	}

	public void editInvoice() {
		// TODO Auto-generated method stub

	}

	public void saveInvoice() {
		// TODO Auto-generated method stub

	}

	public void deleteInvoice() {
		// TODO Auto-generated method stub

	}
}
