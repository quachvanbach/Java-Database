package model;

import javax.swing.JOptionPane;

public class CustomConfirmDiaglog extends JOptionPane {

	public static int showCustomConfirmDialog(String message, String title, String option1, String option2,
			int defaultOption) {
		String[] options = { option1, option2 };
		return showOptionDialog(null, message, title, YES_NO_OPTION, QUESTION_MESSAGE, null, options, defaultOption);
	}
}
