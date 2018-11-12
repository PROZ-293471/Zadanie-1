/**
 * The secondCalc is the project for PROZ (event-driving programming) subject.
 * It has to be written using module architecture with the use of  MVC 
 * (Model-View-Controller) architectural pattern. View should be built with 
 * help of JavaFX, and FXML files managed with Scene Builder. Operations should
 * be done by JShell API and dedicated JRE should be created.
 * 
 * @author Rafal
 * @version 1.0
 * @since 2018-10-21
 */

package mvc.secondCalc.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvc.secondCalc.control.CalcController;

public class Main extends Application {

	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/mvc/secondCalc/view/Calc.fxml"));

		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

}
