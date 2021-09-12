package algos.bitManipulation;

import java.util.logging.Level;
import java.util.logging.Logger;

import code.library.Util;

public class BinaryToString {
	
	private static final Logger LOGGER = Util.getLogger(BinaryToString.class.getName());
	
	private static final String ERROR = "Error";
	
	private static String printBinary(double num, int atMostBits) {
		if(isNotNumWithinRange(num) || atMostBits < 1) {
			return ERROR;
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append('.');
		while (num > 0) {
			// setting a limit of 32 chars
			if(binary.length() >= atMostBits) {
				return ERROR;
			}
			
			double update = num * 2;
			if(update >= 1) {
				binary.append(1);
				num = update - 1;
			} else {
				binary.append(0);
				num = update;
			}
		}
		return binary.toString();
	}
	
	private static boolean isNotNumWithinRange(double num) {
		return num >= 1 || num <= 0;
	}
	
	private static String printBinaryV2(double num, int atMostBits) {
		if(isNotNumWithinRange(num) || atMostBits < 1) {
			return ERROR;
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append('.');
		double frac = 0.5;
		while (num > 0) {
			if(binary.length() >= atMostBits) {
				return ERROR;
			}
			
			if(num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}

	public static void main(String[] args) {
		double num = 0.72;
		int atMostBits = 60;
		LOGGER.log(Level.INFO, "{0}", printBinary(num, atMostBits));
		LOGGER.log(Level.INFO, "{0}", printBinaryV2(num, atMostBits));
	}

}
