package mvc.secondCalc;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;

public class JShellComputing {

	static JShell jshell = JShell.create();

	public JShellComputing() {
	}

	static public String getResult(String equation) {

		String result = "Failed to compute";

		jshell.eval("private double sqrt(double x) { if(x<0){AlertWindow.showAlert(\"Failed to compute!\");}else{return Math.sqrt(x);} }");
		jshell.eval("private double square(double x) {return Math.pow(x, 2.0);}");
		jshell.eval("private double log(double x) {return Math.log10(x);}");
		{

			List<SnippetEvent> events = jshell.eval(equation);
			for (SnippetEvent e : events) {
				if (e.causeSnippet() == null) {
					switch (e.status()) {
					case VALID:
						if (e.value() != null) {
							result = e.value();
						}
						break;
					default:
						AlertWindow.showAlert("Failed to compute!");
					}
				}
			}

		}
		return result;

	};
}
