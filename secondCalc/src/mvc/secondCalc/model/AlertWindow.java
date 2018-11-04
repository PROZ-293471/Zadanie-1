package mvc.secondCalc.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertWindow {

	public static void showAlert(String str){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(str);
		alert.setContentText(str);
		alert.showAndWait();
	}
}
