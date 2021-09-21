package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class ConversionOfficial {
	
	private static final Logger logger = Util.getLogger(ConversionOfficial.class.getName());
	
	private static int bitSwapRequiredV1(int a, int b) {
		int count = 0; 
		for(int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	
	// Rather than simply shifting c( as in V1)  repeatedly while checking 
	// the least significant bit, we can continuously flip the least significant bit and count how long it takes c  to 
	// reach 0. The operation c  =  c  &  ( c  - 1) will clear the least significant bit in c
	private static int bitSwapRequiredV2(int a, int b) {
		int count = 0; 
		for(int c = a ^ b; c != 0; c = c & (c - 1) ) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int num1 = 29;
		int num2 = 15;
		int count = bitSwapRequiredV1(num1, num2);
		logger.log(Level.INFO, "required flips={0}", count);
		count = bitSwapRequiredV2(num1, num2);
		logger.log(Level.INFO, "required flips={0}", count);
	}
}
