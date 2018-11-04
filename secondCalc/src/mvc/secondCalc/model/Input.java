package mvc.secondCalc.model;

public class Input {

	private String firstValue = "0";
	private String secondValue = "0";
	private String cumulatedValue = "0";
	private Boolean signFlag = false;
	private Boolean dotFlag = false;
	private Boolean cleanFlag = true;

	public String getFirstValue() {
		return firstValue;
	}

	public String getSecondValue() {
		return secondValue;
	}

	public String getCumulatedValue() {
		return cumulatedValue;
	}

	private void cleanFirstValue() {
		firstValue = "0";
		cleanFlag = true;
	}
	
	private boolean checkDot() {
		return firstValue.contains(".");
	} 

	public void appendNumber(String str) {

		if (signFlag == true) {

			cleanFirstValue();
		}

		if (cleanFlag == true) {

			firstValue = str;

			if (secondValue.equals("0")) {

				secondValue = str;
			} else {
				secondValue += str;
			}

			if (str.equals("0") == false) {

				cleanFlag = false;
			}
		} else {
			firstValue += str;
			secondValue += str;
		}

		signFlag = false;
	}

	public void appendSign(String str) {

		if (signFlag == false) {

			/*
			 * Making the number double format
			 */
			if (checkDot() == false) {
				secondValue += ".0";
			}
			if (secondValue.endsWith(".")) {
				secondValue += "0";
			}

			/*
			 * calculating the temporary value
			 */
			secondValue += str;
			signFlag = true;
		} else {
			secondValue = secondValue.substring(0, secondValue.length() - 1) + str;
		}

	}

	public void appendDot(String str) throws MyException {

		if (checkDot() == true) {
			throw new MyException("Second dot in a number!");
		} else {
			firstValue += str;
			secondValue += str;
		}
	}

	public void equals() throws MyException {
		try {
			cleanFirstValue();
			firstValue = JShellComputing.getResult(secondValue);
		} catch (MyException e) {
			e.showAlertWindow();
		}
		secondValue = firstValue;

	}
	
	public void specialSign(String str) {
		try {
			cleanFirstValue();
			firstValue = JShellComputing.getResult(str+"("+secondValue+")");
		} catch (MyException e) {
			e.showAlertWindow();
		}
		secondValue = firstValue;
	}

}