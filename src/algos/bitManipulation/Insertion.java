package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class Insertion {
	
	private static Logger logger = Util.getLogger(Insertion.class.getName());
	
	private static int updateBits(int n, int m, int i, int j) {
		// create a mask to clear bits i through j in n
		// Example: i = 2, j = 4. Result should be 11100011.
		int allOnes = ~0; // will equal to all 1s
		logger.log(Level.INFO, "AllOnes:{0}", Integer.toBinaryString(allOnes));
		
		// 1s before position j, then 0s
		int left = allOnes << (j + 1);
		logger.log(Level.INFO, "1s before position j={0}", Integer.toBinaryString(left));
		
		// 1s after position i
		int right = ((1 << i) - 1);
		logger.log(Level.INFO, "1s after position i={0}", Integer.toBinaryString(right));
		
		// all 1s, except for 0s between i and j
		int mask = left | right;
		logger.log(Level.INFO, "mask={0}", Integer.toBinaryString(mask));
		
		// clear bits j through i then put m in there
		int nCleared = n & mask; // clear bits j through i
		int mShifted = m << i; // move m into correct position
		
		return nCleared | mShifted; // or them, we're done
	}

	public static void main(String[] args) {
		int n = Integer.parseInt("10000000000", 2); 
		int m = Integer.parseInt("10011", 2); 
		int i = 2;
		int j = 6;
		logger.log(Level.INFO, "Before update:{0}", Integer.toBinaryString(n));
		n = updateBits(n, m, i, j);
		logger.log(Level.INFO, "After update:{0}", Integer.toBinaryString(n));
	}

}
