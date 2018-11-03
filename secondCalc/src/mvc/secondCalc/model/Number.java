package mvc.secondCalc.model;

public class Number {
	private String value;
	private Boolean isDouble;
	private Boolean isNull;

	private Boolean checkIfDouble() {
		return value.contains(".");
	}

	public void finishNumber() {
		if (checkIfDouble() == false) {
			value += ".0";
		} else {
			if (value.endsWith(".")) {
				value += "0";
			}
		}
	}

	public void appendValue(String str) {
		if (str.equals("0") && value == "0") {
			//some exception
		} else {

			if (str.equals(".") && checkIfDouble() == true) {
				// some exception
			} else {
				value += str;
			}
		}
	}
	
	public String getValue() {
		return value;
	}

}
