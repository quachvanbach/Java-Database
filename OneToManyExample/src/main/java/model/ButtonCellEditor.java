package model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.Controller;
import viewer.AppView;

public class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	private JButton button;
	private Object view;
	private CustomerTableModel customerTableModel = new CustomerTableModel();
	
	public ButtonCellEditor(AppView view) {
		this.view = view;
		button = new JButton("Click Me");
//		 Xử lý sự kiện khi nút được nhấn
		button.addActionListener(new Controller(view) {
			
		});
	}

	@Override
	public Object getCellEditorValue() {
		return null; // Không cần trả về giá trị gì
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return button;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return button;
	}
}