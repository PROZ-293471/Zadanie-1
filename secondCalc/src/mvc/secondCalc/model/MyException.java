package mvc.secondCalc.model;

/**
 * 
 * @author Rafal
 *
 *Class of Exception used to control faults done by a user.
 */

public class MyException extends Exception{

	String alert;
	
	public MyException(String str){
		alert = str;
	}
	
	public void showAlertWindow() {
		AlertWindow.showAlert(alert);
	}
	
}
 