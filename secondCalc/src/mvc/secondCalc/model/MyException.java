package mvc.secondCalc.model;

public class MyException extends Exception{

	String alert;
	
	public MyException(String str){
		alert = str;
	}
	
	public void showAlertWindow() {
		AlertWindow.showAlert(alert);
	}
	
}
 