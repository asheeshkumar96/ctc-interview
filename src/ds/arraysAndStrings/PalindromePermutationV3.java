package ds.arraysAndStrings;

public class PalindromePermutationV3 {
	
	private static boolean isPermutationOfPalindrome(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	private static int createBitVector(String phrase) {
		int bitVector = 0;
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
	
	private static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if( a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	/* Toggle the ith bit in the integer */
	private static int toggle(int bitVector, int index) {
		if(index < 0) return bitVector;
		
		int mask = 1 << index;
		if((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}
	
	/*
	 * Check that exactly one bit is set by substracting one from the integer and ANDing it with original integer.
	 */
	private static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("Tact Coa"));
	}
}
