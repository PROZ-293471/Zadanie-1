package mvc.secondCalc;

public class MyException extends Exception{

	String alert;
	
	MyException(String str){
		alert = str;
	}
	
	public void showAlertWindow() {
		AlertWindow.showAlert(alert);
	}
	
}
 