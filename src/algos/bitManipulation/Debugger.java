package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class Debugger {

	private static final Logger logger = Util.getLogger(Debugger.class.getName());

	private static void logTheValues(int num) {
		logger.log(Level.INFO, "num={0}", num);
		logger.log(Level.INFO, "num-1={0}", num - 1);
		logger.log(Level.INFO, "num&(num - 1)={0}", num & (num - 1));
	}

	public static void main(String[] args) {
		// experimenting
		int num = 4;
		logTheValues(num);
		num = 3;
		logTheValues(num);
		num = 2;
		logTheValues(num);
		num = 1;
		logTheValues(num);
		num = 15;
		logTheValues(num);
		num = 16;
		logTheValues(num);
	}
}
