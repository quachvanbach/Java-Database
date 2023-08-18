package viewer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CustomizeInvoice extends JFrame {
		private JPanel contentPane;
		private JTextField txtDate;
		private JTextField txtItemName;
		private JTextField txtQuantity;
		private JTextField txtPrice;
		private JLabel lblCustomerId;
		private JTextField txtCustomerId;

		public CustomizeInvoice() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 564, 272);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			txtCustomerId = new JTextField();
			txtCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCustomerId.setColumns(10);
			txtCustomerId.setBounds(151, 55, 366, 20);
			txtCustomerId.setEditable(false);
			contentPane.add(txtCustomerId);
			
			JLabel lblDate = new JLabel("Date:");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDate.setBounds(10, 89, 119, 14);
			contentPane.add(lblDate);
			
			txtDate = new JTextField();
			txtDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDate.setColumns(10);
			txtDate.setBounds(151, 86, 366, 20);
			contentPane.add(txtDate);
			
			JLabel lblItemName = new JLabel("Product name:");
			lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblItemName.setBounds(10, 120, 119, 14);
			contentPane.add(lblItemName);
			
			txtItemName = new JTextField();
			txtItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtItemName.setColumns(10);
			txtItemName.setBounds(151, 117, 366, 20);
			contentPane.add(txtItemName);
			
			JLabel lblQuantity = new JLabel("Quantity:");
			lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantity.setBounds(10, 151, 119, 14);
			contentPane.add(lblQuantity);
			
			txtQuantity = new JTextField();
			txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtQuantity.setColumns(10);
			txtQuantity.setBounds(151, 148, 366, 20);
			contentPane.add(txtQuantity);
			
			JLabel lblPrice = new JLabel("Price:");
			lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrice.setBounds(10, 182, 119, 14);
			contentPane.add(lblPrice);
			
			txtPrice = new JTextField();
			txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPrice.setColumns(10);
			txtPrice.setBounds(151, 179, 366, 20);
			contentPane.add(txtPrice);
			
			lblCustomerId = new JLabel("Customer ID:");
			lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCustomerId.setBounds(10, 58, 119, 14);
			contentPane.add(lblCustomerId);
	}

}
