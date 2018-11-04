package mvc.secondCalc.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;

/**
 * 
 * @author Rafal
 *
 *Class with the static method used to make any calculations.
 *Special operations: sqrt, square, factorial are also provided.
 *
 */

public class JShellComputing {
	//creating a new JShell
	static JShell jshell = JShell.create();

	static public String getResult(String equation) throws MyException {

		String result = equation;
		
		/*adding special operations*/
		jshell.eval(
				"private double sqrt(double x) { if(x<0){AlertWindow.showAlert(\"Failed to compute!\");}else{return Math.sqrt(x);} }");
		jshell.eval("private double square(double x) {return Math.pow(x, 2.0);}");
		jshell.eval("private double log(double x) {if(x>0){return Math.log10(x);}else{return 0;}}");
		{

		/*Proceeding the calculations*/	
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
		/*Checking if the result is a Double
		 * case not throwing an exception. */
		try {
			Double.parseDouble(result);
		} catch (NumberFormatException e) {
			throw new MyException("Cannot compute!");
		}

		return result;

	};
}
