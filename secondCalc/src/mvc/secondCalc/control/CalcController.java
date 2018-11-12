package mvc.secondCalc.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mvc.secondCalc.model.Input;
import mvc.secondCalc.model.MyException;

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
	
	private void update() {
		firstLabel.setText(input.getActualNumber());
		secondLabel.setText(input.getSecondValue());
	}

	/*
	 * Method merged with number buttons
	 */
	@FXML
	public void numbButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		input.appendNumber(clickedButton.getText());
		update();
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
		try {
			input.appendSign(clickedButton.getText());
		} catch (MyException e) {
			e.showAlertWindow();
		}
		update();
	};

	/*
	 * Method merged with dot button
	 */
	@FXML
	public void dotButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		try {
			input.appendDot(clickedButton.getText());
			update();
		} catch (MyException e) {
			e.showAlertWindow();
		}

	};

	/*
	 * Method merged with sqrt button
	 */
	@FXML
	public void sqrtButtonAction() {

		try {
			input.sqrt();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.showAlertWindow();
		}
		update();
	};

	/*
	 * Method merged with square button
	 */
	@FXML
	public void squareButtonAction(ActionEvent event) {
		
		try {
			input.square();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.showAlertWindow();
		}
		update();
	};

	/*
	 * Method merged with log button
	 */
	@FXML
	public void logButtonAction() {

		try {
			input.log();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.showAlertWindow();
		}
		update();
	};
	
	/*
	 * Method merged with log button
	 */
	@FXML
	public void factorialButtonAction() {

		try {
			input.factorial();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.showAlertWindow();
		}
		update();
	};

	/*
	 * Method merged with backspace button
	 */
	@FXML
	public void backspaceButtonAction() {

		input.backspace();
		update();
	}
	
	@FXML
	public void clearButtonAction() {
		
		input.clearAll();
		update();
		
	}

	/*
	 * Method merged with equals button
	 */
	@FXML
	public void equalsButtonAction() throws MyException {

		input.equals();
		update();
		
	};
	
	/*
	 * Method merged with memory button
	 */
	@FXML
	public void memoryButtonAction() {

		input.memory();
		update();
		
	}

}
