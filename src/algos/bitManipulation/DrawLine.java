package algos.bitManipulation;

import java.util.logging.Logger;

import code.library.Util;

public class DrawLine {
	
	private static final Logger logger = Util.getLogger(DrawLine.class.getName());
	
	private static void drawLineNaive(byte[] screen, int width, int x1, int x2, int y) {
		int startOffset = x1 % 8;
		int firstFullByte = x1 / 8;
		
	}

	public static void main(String[] args) {
		logger.info("Draw Line");
	}
}
