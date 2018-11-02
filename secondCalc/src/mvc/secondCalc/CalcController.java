package mvc.secondCalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import mvc.secondCalc.view.*;

public class CalcController {

	private Input input = new Input();
	
	@FXML
	public Label firstLabel;

	@FXML
	public Label secondLabel;

	@FXML
	public void numbButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		input.appendNumber(clickedButton.getText());
		firstLabel.setText(input.getValue());
	};
	
	@FXML
	public void signButtonAction(ActionEvent event) {
		
		Button clickedButton = (Button) event.getSource();
		input.appendSign(clickedButton.getText());
		firstLabel.setText(input.getValue());
	};

	@FXML
	public void zeroButtonAction(ActionEvent event) {
		
		Button clickedButton = (Button) event.getSource();
		input.appendZero(clickedButton.getText());
		firstLabel.setText(input.getValue());
	};
	
	@FXML
	public void dotButtonAction(ActionEvent event) {
		
		Button clickedButton = (Button) event.getSource();
		input.appendDot(clickedButton.getText());
		firstLabel.setText(input.getValue());
	};
	
	@FXML
	public void sqrtButtonAction() {

		input.sqrt();
		String res = JShellComputing.getResult(input.getValue());
		input.clean();
		firstLabel.setText(input.getValue());
		secondLabel.setText(res);
	};
	
	@FXML
	public void squareButtonAction() {

		input.square();
		String res = JShellComputing.getResult(input.getValue());
		input.clean();
		firstLabel.setText(input.getValue());
		secondLabel.setText(res);
	};
	
	@FXML
	public void logButtonAction() {

		input.log();
		String res = JShellComputing.getResult(input.getValue());
		input.clean();
		firstLabel.setText(input.getValue());
		secondLabel.setText(res);
	};
	
	@FXML 
	public void backspaceButtonAction() {
		
		input.backspace();
		firstLabel.setText(input.getValue());
	}
	
	@FXML
	public void equalsButtonAction() {
		
		String res = JShellComputing.getResult(input.getValue());
		secondLabel.setText(res);
		input.clean();
		firstLabel.setText(input.getValue());
	};
	
	@FXML
	public void memoryButtonAction() {

		input.setValue(secondLabel.getText());
		firstLabel.setText(input.getValue());
	};

}
