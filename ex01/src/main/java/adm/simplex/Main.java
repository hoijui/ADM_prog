package adm.simplex;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


	public static void main(String[] args) {

		List<String> argsList = Arrays.asList(args);
		LPProblem lpProblem = parseArgs(argsList);

		if (lpProblem == null) {
			return;
		}

		try {
			lpProblem.parse();
			lpProblem.execute();
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static LPProblem parseArgs(List<String> argsList) {

		LPProblem lpProblem = null;

		boolean verbose = false;
		if (argsList.contains("--verbose")
				|| argsList.contains("-v"))
		{
			verbose = true;
		}

		if (argsList.isEmpty()
				|| argsList.contains("--help")
				|| argsList.contains("-h"))
		{
			printHelp();
		} else {

			String lpFile = argsList.get(0);
			LPReader lpReader = new LPReader(lpFile);
			lpProblem = new LPProblem(lpReader, verbose);
		}

		return lpProblem;
	}

	public static void printHelp() {

		System.out.println("<executable> -h|--help");
		System.out.println("<executable> linearProgrammingProblemFile.lp");
	}

}
