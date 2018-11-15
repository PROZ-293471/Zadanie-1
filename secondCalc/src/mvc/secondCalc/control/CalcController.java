package mvc.secondCalc.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mvc.secondCalc.model.Input;
import mvc.secondCalc.model.MyException;

/**
 * Controller class. Methods in this class are merged with the buttons
 * and fields created in FXML file.
 * @author Rafal
 *
 */

public class CalcController {

	/**
	 * Label in which currently written number is visible.
	 */
	@SuppressWarnings("exports")
	@FXML
	public Label firstLabel;

	/**
	 * Label in which the currently written equation or the result is visible.
	 */
	@SuppressWarnings("exports")
	@FXML
	public Label secondLabel;

	/**
	 * Object used to manage the user input.
	 */
	private Input input = new Input();

	/**
	 * Updates the both labels with the actual values of input. Used in the methods
	 * merged with buttons.
	 */

	private void update() {
		firstLabel.setText(input.getActualNumber());
		secondLabel.setText(input.getEquation());
	}

	/**
	 * Method merged with numbers buttons - adds the next sign to the current number
	 * - uses the "appendNumber" method of input and updating the labels
	 * 
	 * @param event object of the class ActionEvent used to get text from the
	 *              clicked button
	 */
	@FXML
	public void numbButtonAction(ActionEvent event) {

		Button clickedButton = (Button) event.getSource();
		input.appendNumber(clickedButton.getText());
		update();
	};

	/**
	 * Method merged with signs buttons - adds the sign or changing the current one
	 * or displays the Alert window if exception is caught - uses the "appendSign"
	 * method of input and updates the labels
	 * 
	 * @param event object of the class ActionEvent used to get text from the
	 *              clicked button
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

	/**
	 * Method merged with "=" button - computes the equation or displays the Alert
	 * window if exception is caught - uses the "equals" method of input and updates
	 * the labels
	 */
	@FXML
	public void equalsButtonAction() {

		input.equals();
		update();

	};

	/**
	 * Method merged with "." button - adds dot or displays the Alert window if
	 * there is already a dot in the number - uses the "appendDot" method of input
	 * and updates the labels
	 * 
	 */
	@FXML
	public void dotButtonAction() {

		try {
			input.appendDot();
			update();
		} catch (MyException e) {
			e.showAlertWindow();
		}

	};

	/**
	 * Method merged with "M" button - sets the result value to the actual number
	 * label - uses the "memory" method of input and updates the labels
	 */
	@FXML
	public void memoryButtonAction() {

		input.memory();
		update();

	};

	/**
	 * Method merged with "Backspace" button - deletes the last sign in the
	 * currently written number - uses the "backspace" method of input and updates
	 * the labels
	 */
	@FXML
	public void backspaceButtonAction() {

		input.backspace();
		update();
	}

	/**
	 * Method merged with "CE" button - clears both labels - uses the "clearAll"
	 * method of input and updates the labels
	 */
	@FXML
	public void clearButtonAction() {

		input.clearAll();
		update();

	};

	/**
	 * Method merged with "sqrt" button - computes the square root of the equation
	 * or displays the Alert window if exception is caught - uses the "equals"
	 * method of input and updates the labels
	 */
	@FXML
	public void sqrtButtonAction() {

		try {
			input.sqrt();
		} catch (MyException e) {
			e.showAlertWindow();
		}
		update();
	}

	/**
	 * Method merged with "square" button - computes the square of the equation or
	 * displays the Alert window if exception is caught - uses the "equals" method
	 * of input and updates the labels
	 */
	@FXML
	public void squareButtonAction() {

		try {
			input.square();
		} catch (MyException e) {
			e.showAlertWindow();
		}
		update();
	}

	/**
	 * Method merged with "log" button - computes the decimal logarithm or displays
	 * the Alert window if exception is caught - uses the "equals" method of input
	 * and updates the labels
	 */
	@FXML
	public void logButtonAction() {

		try {
			input.log();
		} catch (MyException e) {
			e.showAlertWindow();
		}
		update();
	};

	/**
	 * Method merged with "x!" button - computes the factorial or displays the Alert
	 * window if exception is caught - uses the "factorial" method of input and
	 * updates the labels
	 */
	@FXML
	public void factorialButtonAction() {

		try {
			input.factorial();
		} catch (MyException e) {
			e.showAlertWindow();
		}
		update();
	};

}
