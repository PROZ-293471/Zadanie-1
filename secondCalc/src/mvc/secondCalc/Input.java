package mvc.secondCalc;

import java.util.HashMap;

public class Input {

	private String value = "0";
	private Boolean signFlag = false;
	private Boolean dotFlag = false;
	private Boolean cleanFlag = true;

	public Boolean getSignFlag() {
		return signFlag;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String str) {
		value = str;
		cleanFlag = false;
		checkDot();
	}

	public void appendNumber(String str) {

		if (cleanFlag == true) {
			value = str;
			cleanFlag = false;
		} else {
			value += str;
		}
		signFlag = false;
	}

	public void appendZero(String str) {

		if (cleanFlag != true) {
			appendNumber(str);
		}
	}

	public void appendSign(String str) {

		if (signFlag == true) {
			value = value.substring(0, value.length() - 1);
			if (dotFlag == false) {
				value += ".0";
				dotFlag = true;
			}
			value += str;
		} else {
			if (cleanFlag == true) {
				value = "0" + str;
				cleanFlag = false;
				signFlag = true;
			} else {
				if (dotFlag == false) {
					value += ".0";
					dotFlag = true;
				}
				value += str;
				signFlag = true;
			}
		}
		if (!str.equals(".")) {
			dotFlag = false;
		}
	}

	public void appendDot(String str) throws MyException {

		if (dotFlag == true) {
			throw new MyException("Second dot in a number!");
		} else {
			System.out.println(dotFlag);
			dotFlag = true;
			appendSign(str);
			System.out.println(dotFlag);
		}
	}

	public void sqrt() {
		if (signFlag == true) {
			value = value.substring(0, value.length() - 1);
		}
		value = "sqrt(" + value + ")";
	}

	public void square() {
		if (signFlag == true) {
			value = value.substring(0, value.length() - 1);
		}
		value = "square(" + value + ")";
	}

	public void log() {
		if (signFlag == true) {
			value = value.substring(0, value.length() - 1);
		}
		value = "log(" + value + ")";
	}

	public void backspace() {
		if (value.length() == 1) {
			clean();
		} else {
			value = value.substring(0, value.length() - 1);
			checkDot();
		}
	}

	public void clean() {

		value = "0";
		cleanFlag = true;
	}

	public void checkDot() {

		if (value.contains(".") == true) {
			dotFlag = true;
		} else {
			dotFlag = false;
		}
	}

}