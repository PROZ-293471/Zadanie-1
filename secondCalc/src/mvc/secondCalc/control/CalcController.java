package mvc.secondCalc.control;

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
import mvc.secondCalc.model.Input;
import mvc.secondCalc.model.JShellComputing;
import mvc.secondCalc.model.MyException;
import mvc.secondCalc.view.*;

/**
 * 
 * @author Rafal
 *
 *         Controller class. Methods in this class are merged with the buttons
 *         and fields created in FXML file.
 */

public class CalcController {

	/*
	 * Creating an instance of "Input" class - managing the user input
	 * 
	 */
	private Input input = new Input();

	/*
	 * Two Labels used in calculator view
	 */
	@SuppressWarnings("exports")
	@FXML
	public Label firstLabel;

	@SuppressWarnings("exports")
	@FXML
	public Label secondLabel;

	/*
	 * Method merged with number buttons
	 */
	@FXML
	public void numbButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		input.appendNumber(clickedButton.getText());
		firstLabel.setText(input.getFirstValue());
		secondLabel.setText(input.getSecondValue());
	};

	/*
	 * Method merged with zero button
	 */
	@FXML
	public void zeroButtonAction(ActionEvent event) {

	
	};
	
	/*
	 * Method merged with plus/minus/division/multiplication sign buttons
	 */
	@FXML
	public void signButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		input.appendSign(clickedButton.getText());
		firstLabel.setText(input.getFirstValue());
		secondLabel.setText(input.getSecondValue());
	};

	/*
	 * Method merged with dot button
	 */
	@FXML
	public void dotButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		try {
			input.appendDot(clickedButton.getText());
			firstLabel.setText(input.getFirstValue());
			secondLabel.setText(input.getSecondValue());
		} catch (MyException e) {
			e.showAlertWindow();
		}

	};

	/*
	 * Method merged with sqrt button
	 */
	@FXML
	public void sqrtButtonAction() {


	};

	/*
	 * Method merged with square button
	 */
	@FXML
	public void squareButtonAction(ActionEvent event) {
		
		Button clickedButton = (Button) event.getSource();
		input.specialSign(clickedButton.getText());
	};

	/*
	 * Method merged with log button
	 */
	@FXML
	public void logButtonAction() {

	};

	/*
	 * Method merged with backspace button
	 */
	@FXML
	public void backspaceButtonAction() {

		;
	}

	/*
	 * Method merged with equals button
	 */
	@FXML
	public void equalsButtonAction() throws MyException {

		input.equals();
		firstLabel.setText(input.getFirstValue());
		secondLabel.setText(input.getSecondValue());
		
	};
	
	/*
	 * Method merged with memory button
	 */
	@FXML
	public void memoryButtonAction() {

		
	}

}
