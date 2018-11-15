package mvc.secondCalc.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author Rafal
 * Managing the view of the alert window.
 *
 */
public class AlertWindow {

	/**
	 * Displaying the alert window with an appropriate message.
	 * @param str the text that is to be displayed in the alert window.
	 * 
	 */
	public static void showAlert(String str){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(str);
		alert.setContentText(str);
		alert.showAndWait();
	}
}
