package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class Conversion {
	
	private static final Logger logger = Util.getLogger(Conversion.class.getName());
	
	private static int bitMismatchCount(int num1, int num2) {
		int numberWithDifferingBits = num1 ^ num2;
		int count = 0;
		while (numberWithDifferingBits > 0) {
			if( (numberWithDifferingBits & 1) == 1) {
				count++;
			}
			numberWithDifferingBits = numberWithDifferingBits >> 1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		int num1 = 29;
		int num2 = 15;
		int count = bitMismatchCount(num1, num2);
		logger.log(Level.INFO, "required flips={0}", count);
	}
}
