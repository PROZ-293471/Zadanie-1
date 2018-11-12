package mvc.secondCalc.model;

public class Input {

	private String actualNumber = "0";
	private String equation = "0";
	private String cumulatedValue = "0";

	private Boolean newNumber = false; //
	private Boolean minus = false;
	private Boolean clear = true;

	public String getActualNumber() {
		return actualNumber;
	}

	public String getSecondValue() {
		return equation;
	}

	public String getCumulatedValue() {
		return cumulatedValue;
	}


	private boolean checkDot() {
		return actualNumber.contains(".");
	}

	public void appendNumber(String str) {
		
		
		if(clear == true && !str.equals("0")) {
			actualNumber = str;
			equation = str;	
			clear = false;
		}else {
			if(newNumber==false) {
				actualNumber += str;
				equation += str;
			}else {
			actualNumber = str;
			equation += str;
			}	
		}

		// now number is on last position
		newNumber = false;
	}

	public void appendSign(String str) throws MyException {
		
		if(clear == true) {
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

	public void appendDot(String str) throws MyException {

		// dot was already in the actual number
		if (checkDot() == true) {
			throw new MyException("Second dot in a number!");
		}

		// standard case - dot used for the first time
		else {
			actualNumber += str;
			equation += str;
		}
	}

	public void equals() throws MyException {
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

	private void specialSign(String str) throws MyException {
		if(clear == true) {
			throw new MyException("You have to type a number or use Memory!");
		}
		try {
			actualNumber = JShellComputing.getResult(str+"(" + equation + ")");
		} catch (MyException e) {
			e.showAlertWindow();
		}
		equation = actualNumber;
		actualNumber = "0";
		newNumber = true;
		clear = true;
	}

	public void sqrt() throws MyException {
		specialSign("sqrt");
	}

	public void log() throws MyException {
		specialSign("log");
	}

	public void square() throws MyException {
		specialSign("square");
	}
	
	public void factorial() throws MyException {
		specialSign("fac");
	}

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
	
	public void memory() {
		if(clear==true) {
		actualNumber = equation;
		
		if(!equation.equals("0")) {
		clear = false;
		newNumber = false;
		}
		}
	}

	public void clearAll() {
		actualNumber = "0";
		equation = "0";
		actualNumber = "0";
		newNumber = false;
		clear = true;
	}

}