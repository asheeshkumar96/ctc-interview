package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class NextNumberArith {

	private static Logger logger = Util.getLogger(NextNumberArith.class.getName());
	
	private static int getNextArith(int num) {
		int c = num;
		int countZeros = 0;
		int countOnes = 0;
		while (((c & 1) == 0) && (c != 0)) {
			countZeros++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			countOnes++;
			c >>= 1;
		}
		
		return num + (1 << countZeros) + (1 << (countOnes - 1)) - 1;
	}
	
	private static int getPrevArith(int num) {
		int c = num;
		int countZeros = 0;
		int countOnes = 0;
		while (((c & 1) == 0) && (c != 0)) {
			countZeros++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			countOnes++;
			c >>= 1;
		}
		
		return num - (1 << countOnes) - (1 << (countZeros - 1)) + 1;
	}
	
	public static void main(String[] args) {
		int num = 13948;
		int nextNum = getNextArith(num);
		int prevNum = getPrevArith(num);
		logger.log(Level.INFO, "\tnum=" + num + " ->" + Integer.toBinaryString(num));
		logger.log(Level.INFO, "\n\tnextNum=" + nextNum + " ->" + Integer.toBinaryString(nextNum));
		logger.log(Level.INFO, "prevNum=" + prevNum + " ->" + Integer.toBinaryString(prevNum));
	}
}
