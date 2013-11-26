package adm.simplex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class LPProblem {

	private final LPReader lpReader;
	private final boolean verbose;

	public LPProblem(LPReader lpReader, boolean verbose) {

		this.lpReader = lpReader;
		this.verbose = verbose;
	}

	public void parse() throws IOException {

		try {
			lpReader.readLP();
		} catch (ParseException ex) {
			throw new IOException(ex);
		} catch (FileNotFoundException ex) {
			throw new IOException(ex);
		}
	}

	public void execute() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
