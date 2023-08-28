package viewer;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controller.AppController;
import dao.CustomerDAO;
import dao.InvoiceDAO;
import model.AppModel;
import model.CustomConfirmDiaglog;
import model.Customer;
import model.Invoice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

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
//	private JTextField txtDate;
	private JTextField txtItemName;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	public JPanel panel_2;
	public Container panel_1;
	private JTextField txtId;
	public JTextField txtInvoiceId;
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
	private JDateChooser dateChooser;

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
		cbInvoiceList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbInvoiceList.setBounds(173, 231, 347, 22);
		cbInvoiceList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                   invoice = (Invoice) cbInvoiceList.getSelectedItem();
                   showSelectedInvoice(invoice);
                }
			}
		});
		panel_1.add(cbInvoiceList);

		lblHeader2 = new JLabel("Invoice information");
		lblHeader2.setBounds(169, 18, 142, 23);
		lblHeader2.setFont(new Font("UVN Thoi Nay Nang", Font.ITALIC, 16));

		lblDate = new JLabel("Date:");
		lblDate.setBounds(35, 94, 34, 17);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
//
//		txtDate = new JTextField();
//		txtDate.setBounds(173, 91, 350, 23);
//		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		dateChooser = new JDateChooser();
		dateChooser.setBounds(173, 91, 350, 23);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateChooser.setDateFormatString("dd-MM-YYYY");

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
//		panel_2.add(txtDate);
		panel_2.add(lblItemName);
		panel_2.add(txtItemName);
		panel_2.add(lblQuantity);
		panel_2.add(txtQuantity);
		panel_2.add(lblPrice);
		panel_2.add(txtPrice);
		panel_2.add(lblHeader2);
		panel_2.add(lblHeader2);
		panel_2.add(dateChooser);
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

	private void initializable() {
		dateChooser.setDate(Calendar.getInstance().getTime());
	}

	public void addCustomer() {
		if (!txtCustomerName.getText().equals("")) {
			customerDAO.saveOrUpdate(getInputCustomer());
			appView.refreshtable();
			clearTextCustomer();
		} else {
			JOptionPane.showMessageDialog(null, "Enter customer information");
		}
	}

	public void editCustomer() {
		if (!txtId.getText().equals("")) {
			customerDAO.update(getInputCustomer());
			appView.refreshtable();
			clearTextCustomer();
		} else {
			JOptionPane.showMessageDialog(null, "Choose a customer to edit");
		}
	}

	public void deleteCustomer() {
		if (!txtId.getText().equals("")
				|| (appView.checkSelectedRow() && appView.table.getColumnName(1).equals("Fullname"))) {
			customerDAO.delete(appView.selectedCustomer());
			appView.refreshtable();
			clearTextCustomer();
		} else {
			JOptionPane.showMessageDialog(null, "Choose a customer to delete");
		}
	}

	public void addInvoice() {
		if (!checkEmpty(txtItemName) || !checkEmpty(txtQuantity) || !checkEmpty(txtPrice)) {
			invoice = getInputInvoice();
			if (!checkEmpty(txtId)) {
				customer = new Customer();
				customer.setId(Integer.parseInt(txtId.getText()));
				invoice.setCustomer(customerDAO.selectById(customer));
			} else {
				JOptionPane.showMessageDialog(null, "Choose a customer to add invoice");
			}
			invoiceDAO.saveOrUpdate(invoice);
			appView.refreshtable();
			clearTextInvoice();
		} else {
			JOptionPane.showMessageDialog(null, "Enter customer information");
		}
	}

	public void editInvoice() {
		if (!checkEmpty(txtInvoiceId)) {
			Customer selectedCustomer = new Customer();
			selectedCustomer.setId(Integer.parseInt(txtId.getText()));
			customer = customerDAO.selectById(selectedCustomer);
			invoice = getInputInvoice();
			invoice.setCustomer(customer);
			invoiceDAO.update(invoice);

			JOptionPane.showMessageDialog(null, "Successfully edited!");
			
			appView.refreshtable();
			clearTextCustomer();
		} else {
			JOptionPane.showMessageDialog(null, "Choose a customer to delete");
		}
	}

	public void saveInvoice() {
	
	}

	public void deleteInvoice() {
		if (!checkEmpty(txtInvoiceId)
				|| (appView.checkSelectedRow() && appView.table.getColumnName(1).equals("Purchase date"))) {
			invoiceDAO.delete(appView.selectedInvoice());
			appView.refreshtable();
			clearTextInvoice();
		} else {
			JOptionPane.showMessageDialog(null, "Choose a customer to delete");
		}
	}

	public Customer getInputCustomer() {
		if (checkEmpty(txtId)) {
			return Customer.builder().fullName(txtCustomerName.getText()).phonenumber(txtPhonenumber.getText())
					.email(txtEmail.getText()).address(txtAddress.getText()).build();
		} else {
			return Customer.builder().id(Integer.parseInt(txtId.getText())).fullName(txtCustomerName.getText())
					.phonenumber(txtPhonenumber.getText()).email(txtEmail.getText()).address(txtAddress.getText())
					.build();
		}
	}

	public Invoice getInputInvoice() {

		if (checkEmpty(txtInvoiceId)) {
			return Invoice.builder().date(new Date(dateChooser.getDate().getTime())).itemName(txtItemName.getText())
					.quantity(Integer.parseInt(txtQuantity.getText())).price(Integer.parseInt(txtPrice.getText()))
					.build();
		} else {
			return Invoice.builder().invoice_id(Integer.parseInt(txtInvoiceId.getText()))
					.date(new Date(dateChooser.getDate().getTime())).itemName(txtItemName.getText())
					.quantity(Integer.parseInt(txtQuantity.getText())).price(Integer.parseInt(txtPrice.getText()))
					.build();
		}

	}

	public void showSelectedCustomer(Customer customer) {
		cbInvoiceList.removeAllItems();

		txtId.setText(customer.getId() + "");
		txtCustomerName.setText(customer.getFullName());
		txtPhonenumber.setText(customer.getPhonenumber());
		txtEmail.setText(customer.getEmail());
		txtAddress.setText(customer.getAddress());

		List<Invoice> invoiceList = appModel.getInvoiceByCustomer(customer);
		invoiceList.stream().forEach(item -> cbInvoiceList.addItem(item)); // Java SE 1.8
	}

	public void showSelectedInvoice(Invoice invoice) {
		cbCustomerList.removeAllItems();

		txtInvoiceId.setText(invoice.getInvoice_id() + "");
		dateChooser.setDate(invoice.getDate());
		txtItemName.setText(invoice.getItemName());
		txtQuantity.setText(invoice.getQuantity() + "");
		txtPrice.setText(invoice.getPrice() + "");
		
		Customer customer = customerDAO.selectById(invoiceDAO.selectById(invoice).getCustomer());
		cbCustomerList.addItem(customer);

	}

	public void clearTextCustomer() {
		txtId.setText("");
		txtCustomerName.setText("");
		txtPhonenumber.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
		cbInvoiceList.removeAllItems();
	}

	public void clearTextInvoice() {
		dateChooser.setDate(Calendar.getInstance().getTime());
		txtItemName.setText("");
		txtQuantity.setText("");
		txtPrice.setText("");
		cbCustomerList.removeAllItems();
	}

	public boolean checkEmpty(JTextField jTextField) {
		if (jTextField.getText().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public void disableEditCustomer() {
		txtCustomerName.setEditable(false);
		txtPhonenumber.setEditable(false);
		txtEmail.setEditable(false);
		txtAddress.setEditable(false);
	}
}
