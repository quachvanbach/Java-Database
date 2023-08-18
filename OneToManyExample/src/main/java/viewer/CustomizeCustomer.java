package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CustomizeCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerName;
	private JTextField txtPhonenumber;
	private JTextField txtEmail;
	private JTextField txtAddress;

	public CustomizeCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(10, 56, 119, 14);
		contentPane.add(lblCustomerName);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(151, 53, 366, 20);
		contentPane.add(txtCustomerName);
		
		JLabel lblPhonenumber = new JLabel("Phonenumber:");
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhonenumber.setBounds(10, 87, 119, 14);
		contentPane.add(lblPhonenumber);
		
		txtPhonenumber = new JTextField();
		txtPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhonenumber.setColumns(10);
		txtPhonenumber.setBounds(151, 84, 366, 20);
		contentPane.add(txtPhonenumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 118, 119, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(151, 115, 366, 20);
		contentPane.add(txtEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 149, 119, 14);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(151, 146, 366, 20);
		contentPane.add(txtAddress);
		
		JLabel lblNewLabel = new JLabel("Enter customer information into the blank fields below:");
		lblNewLabel.setFont(new Font("UVN Thoi Nay Nang", Font.ITALIC, 16));
		lblNewLabel.setBounds(74, 11, 406, 34);
		contentPane.add(lblNewLabel);
	}
}
