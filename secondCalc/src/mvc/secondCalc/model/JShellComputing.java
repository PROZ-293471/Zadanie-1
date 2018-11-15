package mvc.secondCalc.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;

/**
 * 
 * @author Rafal
 *
 *         Class with the static method used to make any calculations. Special
 *         operations: sqrt, square, factorial are also provided.
 *
 */

public class JShellComputing {
	
	/**
	 * JShell - REPL used to compute equations
	 */
	static JShell jshell = JShell.create();

	/**
	 * Returns the result as a String of the equation provided as a String. If the
	 * equation is invalid the Exception is thrown and the result is set as 0.
	 * 
	 * @param equation  String with the equation that is to be computed
	 * @return result  the computed result or 0 in case of exception
	 * @throws MyException  My own exception.
	 */

	static public String getResult(String equation) throws MyException {

		// adding special operations
		String result = equation;
		jshell.eval(
				"private double sqrt(double x) { return Math.sqrt(x);}");
		jshell.eval("private double square(double x) {return Math.pow(x, 2.0);}");
		jshell.eval("private double log(double x) {if(x>0){return Math.log10(x);}else{return 0;}}");
		jshell.eval("private double fac(double n) {if (n == 0) return 1; else return n*fac(n-1);}");

		// Proceeding the calculations
		List<SnippetEvent> events = jshell.eval(equation);
		for (SnippetEvent s : events) {
			if (s.causeSnippet() == null) {
				if (s.value() != null) {
					result = s.value();
				}
			}

		}
		// Checking if the result is a Double case not throwing an exception.

		try{Double.parseDouble(result);}
		catch(Exception e){
			throw new MyException("Unable to compute!");
		}
		if(result.equals("Infinity")||result.equals("NaN")) {
			throw new MyException("Unable to compute!");
		}
		return result;

	};
}
