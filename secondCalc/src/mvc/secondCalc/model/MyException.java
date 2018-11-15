package mvc.secondCalc.model;

import mvc.secondCalc.view.AlertWindow;

/**
 * 
 * @author Rafal
 *
 *         Class of Exception used to control faults done by a user.
 */

public class MyException extends Exception {

	/**
	 * Specific name of the exception.
	 */
	String alert;

	public MyException(String str) {
		alert = str;
	}

	
	/**
	 * Method used to manage exceptions - displays alert window with an appropriate alert
	 */
	public void showAlertWindow() {
		AlertWindow.showAlert(alert);
	}

}
