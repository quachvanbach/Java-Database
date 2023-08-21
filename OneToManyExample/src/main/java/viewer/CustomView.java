package viewer;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CustomerDAO;
import model.Customer;
import model.Invoice;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Date;

import javax.swing.JSeparator;
import javax.swing.JButton;

public class CustomView extends JFrame {
	CustomerDAO customerDAO = new CustomerDAO();
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

	public CustomView(AppView appview) {
		this.appView = appview;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(578, 522);
//		setBounds(1435, 259, 578, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(10, 56, 119, 14);
		contentPane.add(lblCustomerName);

		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(151, 53, 389, 20);
		contentPane.add(txtCustomerName);

		JLabel lblPhonenumber = new JLabel("Phonenumber:");
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhonenumber.setBounds(10, 87, 119, 14);
		contentPane.add(lblPhonenumber);

		txtPhonenumber = new JTextField();
		txtPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhonenumber.setColumns(10);
		txtPhonenumber.setBounds(151, 84, 389, 20);
		contentPane.add(txtPhonenumber);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 118, 119, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(151, 115, 389, 20);
		contentPane.add(txtEmail);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 149, 119, 14);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(151, 146, 389, 20);
		contentPane.add(txtAddress);

		JLabel lblHeader1 = new JLabel("Customer information");
		lblHeader1.setFont(new Font("UVN Thoi Nay Nang", Font.ITALIC, 16));
		lblHeader1.setBounds(151, 11, 171, 34);
		contentPane.add(lblHeader1);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(10, 296, 119, 14);
		contentPane.add(lblDate);

		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDate.setBounds(151, 293, 389, 20);
		contentPane.add(txtDate);

		JLabel lblItemName = new JLabel("Product name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemName.setBounds(10, 327, 119, 14);
		contentPane.add(lblItemName);

		txtItemName = new JTextField();
		txtItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtItemName.setColumns(10);
		txtItemName.setBounds(151, 324, 389, 20);
		contentPane.add(txtItemName);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(10, 358, 119, 14);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(151, 355, 389, 20);
		contentPane.add(txtQuantity);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(10, 389, 119, 14);
		contentPane.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(151, 386, 389, 20);
		contentPane.add(txtPrice);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 235, 530, 2);
		contentPane.add(separator);

		JLabel lblHeader2 = new JLabel("Invoice information");
		lblHeader2.setFont(new Font("UVN Thoi Nay Nang", Font.ITALIC, 16));
		lblHeader2.setBounds(151, 248, 171, 34);
		contentPane.add(lblHeader2);

		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddCustomer.setBounds(10, 177, 132, 23);

		contentPane.add(btnAddCustomer);

		JButton btnEditCustomer = new JButton("Edit Customer");
		btnEditCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditCustomer.setBounds(198, 177, 132, 23);

		contentPane.add(btnEditCustomer);

		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteCustomer.setBounds(408, 177, 132, 23);

		contentPane.add(btnDeleteCustomer);

		JButton btnAddInvoice = new JButton("Add Invoice");
		btnAddInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddInvoice.setBounds(10, 428, 132, 23);

		contentPane.add(btnAddInvoice);

		JButton btnEditInvoice = new JButton("Edit Invoice");
		btnEditInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditInvoice.setBounds(198, 428, 132, 23);

		contentPane.add(btnEditInvoice);

		JButton btnDeleteInvoice = new JButton("Delete Invoice");
		btnDeleteInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteInvoice.setBounds(408, 428, 132, 23);

		contentPane.add(btnDeleteInvoice);
	}

	public Customer getInputCustomer() {
		return Customer.builder() .fullName(txtCustomerName.getText()).phonenumber(txtPhonenumber.getText())
				.email(txtEmail.getText()).address(txtAddress.getText()).build();
	}

	public void clearCustomerInput() {
		txtCustomerName.getText();
		txtPhonenumber.getText();
		txtEmail.getText();
		txtAddress.getText();
	}

	public void readCustomerInfomation(Customer customer) {
		txtCustomerName.setText(customer.getFullName() + "");
		txtPhonenumber.setText(customer.getPhonenumber() + "");
		txtEmail.setText(customer.getEmail() + "");
		txtAddress.setText(customer.getAddress() + "");
	}

	public Invoice getInputInvoice() {
		System.out.println(txtDate.getText());
		return Invoice.builder().date(Date.valueOf(txtDate.getText())).itemName(txtItemName.getText())
				.quantity(Double.parseDouble(txtQuantity.getText())).price(Double.parseDouble(txtPrice.getText()))
				.build();
	}

	public void forbitEditng() {
		txtCustomerName.setEditable(false);
		txtPhonenumber.setEditable(false);
		txtEmail.setEditable(false);
		txtAddress.setEditable(false);
	}
}
