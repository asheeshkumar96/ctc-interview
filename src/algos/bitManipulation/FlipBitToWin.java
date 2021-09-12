package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class FlipBitToWin {

	private static final Logger logger = Util.getLogger(FlipBitToWin.class.getName());

	private static int lengthOfLongestSequencesOfOnesAfterFlipping(int num) {
		if(~num == 0) {
			return Integer.BYTES * 8;
		}
		
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		while (num != 0) {
			if((num & 1) == 1) { // current bit is a 1
				currentLength++;
			} else { // Current bit is a 0
				// update to 0(if next bit is 0) or current length(if next bit is 1).
				previousLength = (num & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			num >>>= 1;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		logger.info("Flip Bit to Win");
		int number = 1775;
		logger.log(Level.INFO, "{0}", lengthOfLongestSequencesOfOnesAfterFlipping(number));
	}
}
