package model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.AppController;
import viewer.AppView;
import viewer.CustomView;

public class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	public JButton button;
	private AppView appView;
//	private CustomerTableModel customerTableModel = new CustomerTableModel();
	
	public ButtonCellEditor(AppView appView) {
		this.appView = appView;
		button = new JButton();
//		 Xử lý sự kiện khi nút được nhấn
		button.addActionListener(new AppController(appView) {		
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