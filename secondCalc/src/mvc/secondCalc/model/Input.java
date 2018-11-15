package mvc.secondCalc.model;

/**
 * @author Rafal
 * 
 *         Class in which the input strings are managed to be in an appropriate
 *         form to be computed and displayed on the screen.
 *
 */
public class Input {

	/**
	 * Actual number that can be modified by a user.
	 */
	private String actualNumber = "0";
	
	/**
	 * Whole equation with signs, that cannot be modified by a user.
	 */
	private String equation = "0";

	/**
	 * Flag communicating whether it is a new number.
	 */
	private Boolean newNumber = false;
	
	/**
	 * Flag communicating whether it is the beginning of the new equation.
	 */
	private Boolean clear = true;

	/**
	 * Checking if in the actual number there is already a dot.
	 * 
	 * @return True if the dot is in the actual number, false if not.
	 */
	private boolean checkDot() {
		return actualNumber.contains(".");
	}

	/**
	 * Formats the equation.
	 * 
	 * @param str name used in formation.
	 * @throws MyException if there is no equation.
	 */
	private void specialSign(String str) throws MyException {
		if (clear == true) {
			throw new MyException("You have to type a number or use Memory!");
		}
		try {
			actualNumber = JShellComputing.getResult(str + "(" + equation + ")");
		} catch (MyException e) {
			e.showAlertWindow();
		}
		equation = actualNumber;
		actualNumber = "0";
		newNumber = true;
		clear = true;
	}

	/**
	 * @return The actually written number.
	 */
	public String getActualNumber() {
		return actualNumber;
	}

	/**
	 * @return The actual equation.
	 */
	public String getSecondValue() {
		return equation;
	}

	/**
	 * Checks the conditions and adds the number in an appropriate way.
	 * 
	 * @param str a number that is to be added.
	 */
	public void appendNumber(String str) {

		body: {
			// case equation is 0 and user types 0
			if (equation.equals("0") && str.equals("0")||actualNumber.equals("0") && str.equals("0")) {
				break body;
			}
			//case it is the first typed number other than 0
			if (clear == true && !str.equals("0")) {
				actualNumber = str;
				equation = str;
				clear = false;
				break body;
			}
			//standard case
			if (newNumber == false) {
				actualNumber += str;
				equation += str;
				break body;
			}
			//case new number - after sign
			actualNumber = str;
			equation += str;

		}
		// now number is on last position
		newNumber = false;
	}

	/**
	 * Checks the conditions and adds the sign to the equation in an appropriate way
	 * and begins the new actual number .
	 * 
	 * @param str sign that is to be added.
	 * @throws MyException if it is the beginning of the new equation.
	 */
	public void appendSign(String str) throws MyException {

		if (clear == true) {
			throw new MyException("You have to type a number or use Memory!");
		}

		// standard case - adding sign after number
		if (newNumber == false) {

			// Making the number double format
			if (checkDot() == false) {
				equation += ".0";
			}
			if (equation.endsWith(".")) {
				equation += "0";
			}

			// calculating the temporary value
			equation += str;
			newNumber = true;
		}

		// sign was already added - changing the existing sign into the new one
		else {
			equation = equation.substring(0, equation.length() - 1) + str;
		}

	}

	/**
	 * Checks if the dot isn't already in the actual number and adds it.
	 * 
	 * @throws MyException if there is already one dot in the number.
	 */
	public void appendDot() throws MyException {

		// dot was already in the actual number
		if (checkDot() == true) {
			throw new MyException("Second dot in a number!");
		}

		// standard case - dot used for the first time
		else {
			actualNumber += ".";
			equation += ".";
		}
	}

	/**
	 * Computes the equation using JShellComputing class. Sets the result, flags and
	 * deletes actual number.
	 */
	public void equals() {
		try {
			actualNumber = JShellComputing.getResult(equation);
		} catch (MyException e) {
			e.showAlertWindow();
		}
		// writing the result as the beginning of the new equation
		equation = actualNumber;
		actualNumber = "0";
		newNumber = true;
		clear = true;

	}

	/**
	 * Formats the equation for the JShell "sqrt" method.
	 * 
	 * @throws MyException if there is no equation.
	 */
	public void sqrt() throws MyException {
		specialSign("sqrt");
	}

	/**
	 * Formats the equation for the JShell "log" method.
	 * 
	 * @throws MyException if there is no equation.
	 */
	public void log() throws MyException {
		specialSign("log");
	}

	/**
	 * Formats the equation for the JShell "square" method.
	 * 
	 * @throws MyException if there is no equation.
	 */
	public void square() throws MyException {
		specialSign("square");
	}

	/**
	 * Formats the equation for the JShell "factorial" method.
	 * 
	 * @throws MyException if there is no equation.
	 */
	public void factorial() throws MyException {
		specialSign("fac");
	}

	/**
	 * Deletes the last sign in the actual number and equation.
	 */
	public void backspace() {

		// managing the bound of backspace
		if (actualNumber.length() == 1) {
			actualNumber = "0";

			// clearing the equation
			if (equation.length() == 1) {
				equation = "0";
				clearAll();
			} else {

				if (newNumber == false) {
					equation = equation.substring(0, equation.length() - 1);
					newNumber = true;
				}
			}

		}
		// standard case - backspacing the number
		else {
			equation = equation.substring(0, equation.length() - 1);
			actualNumber = actualNumber.substring(0, actualNumber.length() - 1);
		}
	}

	/**
	 * Clears all fields and sets all flags in default positions.
	 */
	public void clearAll() {
		actualNumber = "0";
		equation = "0";
		actualNumber = "0";
		newNumber = false;
		clear = true;
	}

	/**
	 * Sets the value of the equation to the actual number.
	 */
	public void memory() {
		if (clear == true) {
			actualNumber = equation;
			
			//case M was used and only 0 was typed before
			if (!equation.equals("0")) {
				clear = false;
				newNumber = false;
			}
		}
	}

}