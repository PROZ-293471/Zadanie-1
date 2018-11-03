package mvc.secondCalc.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;

public class JShellComputing {

	static JShell jshell = JShell.create();

	public JShellComputing() {
	}

	static public String getResult(String equation) throws MyException {

		String result = equation;

		jshell.eval(
				"private double sqrt(double x) { if(x<0){AlertWindow.showAlert(\"Failed to compute!\");}else{return Math.sqrt(x);} }");
		jshell.eval("private double square(double x) {return Math.pow(x, 2.0);}");
		jshell.eval("private double log(double x) {if(x>0){return Math.log10(x);}else{return 0;}}");
		{

			List<SnippetEvent> events = jshell.eval(equation);
			for (SnippetEvent s : events) {
				if (s.causeSnippet() == null) {
					if (s.value() != null) {
						result = s.value();
					}
					break;
				}

			}
		}

		try {
			Double.parseDouble(result);
		} catch (NumberFormatException e) {
			throw new MyException("Cannot compute!");
		}

		return result;

	};
}
