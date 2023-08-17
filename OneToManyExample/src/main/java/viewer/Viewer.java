package viewer;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Customer;
import model.CustomerTableModel;
import model.Invoice;
import model.InvoiceTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Viewer extends JFrame {

	private CustomerTableModel tableModel = new CustomerTableModel();
	private InvoiceTableModel invoiceTableModel = new InvoiceTableModel();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	public Viewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 34, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 65, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 96, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 127, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 158, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(10, 189, 46, 14);
		contentPane.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(128, 31, 227, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 62, 227, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 93, 227, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 124, 227, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 155, 227, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(128, 186, 227, 20);
		contentPane.add(textField_5);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 249, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(135, 249, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(266, 249, 89, 23);
		contentPane.add(btnNewButton_2);

		table = new JTable(tableModel);
		table.setBounds(0, 0, 1, 1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 11, 539, 415);
		scrollPane.add(table);
		contentPane.add(scrollPane);
	}

}
