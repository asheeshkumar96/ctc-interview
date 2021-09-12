package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class NextNumber {

	private static final Logger logger = Util.getLogger(NextNumber.class.getName());

	private static int getNext(int num) {
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

		// ERROR: if n == 11_11_11_11_11_11_11_11_00_00_00_00_00_00_00_0 or like this
		// then there is no bigger number
		if (countZeros + countOnes == 31 || countZeros + countOnes == 0) {
			return -1;
		}

		int position = countZeros + countOnes;
		num |= (1 << position); // flip rightmost non-trailing zero
		num &= ~((1 << position) - 1); // clear all bits to the right of position
		num |= (1 << (countOnes - 1)) - 1; // insert (c1-1) ones on the right

		return num;
	}

	private static int getPrev(int num) {
		int c = num;
		int countZeros = 0;
		int countOnes = 0;
		while ((c & 1) == 1) {
			countOnes++;
			c >>= 1;
		}

		if (c == 0)
			return -1;

		while (((c & 1) == 0) && (c != 0)) {
			countZeros++;
			c >>= 1;
		}

		int position = countZeros + countOnes; // position of rightmost non-trailing one
		num &= ((~0) << (position + 1)); // clears bit p onwards

		int mask = (1 << (countOnes + 1)) - 1;// sequence of (c1 + 1) ones
		num |= mask << (countZeros - 1);

		return num;
	}

	public static void main(String[] args) {
		int num = 13948;
		int nextNum = getNext(num);
		int prevNum = getPrev(num);
		logger.log(Level.INFO, "\tnum=" + num + " ->" + Integer.toBinaryString(num));
		logger.log(Level.INFO, "\n\tnextNum=" + nextNum + " ->" + Integer.toBinaryString(nextNum));
		logger.log(Level.INFO, "prevNum=" + prevNum + " ->" + Integer.toBinaryString(prevNum));
	}
}
