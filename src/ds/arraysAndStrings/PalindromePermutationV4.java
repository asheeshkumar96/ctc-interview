package ds.arraysAndStrings;

import java.util.BitSet;

public class PalindromePermutationV4 {
	
	private static boolean isPermutationOfPalindrome(String phrase) {
		BitSet bitSet = createBitSet(phrase);
		return bitSet.isEmpty() || bitSet.cardinality() == 1;
	}
	
	private static BitSet createBitSet(String phrase) {
		BitSet bitSet = new BitSet();
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				bitSet.flip(x);
			}
		}
		return bitSet;
	}
	
	private static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("Tact Coa"));
	}
}
