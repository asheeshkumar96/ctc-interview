package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class PairwiseSwap {
	
	private static Logger logger = Util.getLogger(PairwiseSwap.class.getName());
	
	// What is the difference between logical right shift and arithmetic right shift
	// Ans. There are two types of right shift operators. The arithmetic right shift essentially divides by two. The logical 
	// right shift does what we would visually see as shifting the bits. This is best seen on a negative number.
	// In a logical right shift we shift the bits and put a 0 in the most significant bit.
	// It is indicated with a >>> operator. 
	// In an arithmetic shift, we shift values to the right but fill in the new bits with the
	// value of the sign bit. This has the effect of (roughly) dividing by 2. It is indicated by 
	// a >> operator. 
	private static int swapOddEvenBitsIn32Bit(int num) {
		return ( (num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
	}

	public static void main(String[] args) {
		int num = 10;
		int newNumberAfterSwapping = swapOddEvenBitsIn32Bit(num);
		logger.log(Level.INFO, "new number after swapping={0}", newNumberAfterSwapping);
		
		num = 16;
		newNumberAfterSwapping = swapOddEvenBitsIn32Bit(num);
		logger.log(Level.INFO, "new number after swapping={0}", newNumberAfterSwapping);
	}
}
