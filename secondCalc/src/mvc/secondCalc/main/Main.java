package mvc.secondCalc.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvc.secondCalc.view.CalcController;

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
