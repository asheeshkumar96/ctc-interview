package ds.arraysAndStrings;

import java.util.BitSet;

/**
 * Implement an algorithm to determine if a string has all unique characters. What is you can not use additional data
 * structures
 *
 */
public class IsUnique {
	
	/**
	 * Is is assumed that the character set is ASCII. One solution is to create an array of boolean values, where the flag 
	 * at index i indicates whether character i in the alphabet is contained in the string.  The second time we see this 
	 * character, we can immediately return false. 
	 * We can also immediately return false if the string length exceeds the number of unique characters in the alphabet(character set).
	 * 
	 */
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128) return false;
		
		boolean[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	/**
	 * We can reduece our space uage by a factor of eight by using a bit vector. It is assumed, in the below code,
	 * that the string only uses the lowercase letters a through z.  This will allow us to use just a single int.
	 */
	public static boolean isUniqueCharsSpaceOptimized(String str) {
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if( (checker & (1 << val)) > 0 ) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	/**
	 * same as above just uses BitSet instead of int
	 */
	public static boolean isUniqueCharsUsingBitVector(String str) {
		BitSet bitSet = new BitSet(); // can also be limited to just 128 or 256 based on charset
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i)-'a';
			if(bitSet.get(val)) {
				return false;
			}
			bitSet.set(val);
		}
		return true;
	}

	/*
	 * If we can't use additional data structures, we can do the following: 
	 * 1. Compare every character of the string to every other character of the string.
	 * This will take 0( n^2) time and 0(1) space. 
	 * 2. If we are allowed to modify the input string, we could sort the string in O(n log(n)) time and then
	 * linearly check the string for neighboring characters that are identical.
	 * Careful, though: many sorting algorithms take up extra space.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(IsUnique.isUniqueChars("Is Unique"));
		System.out.println(IsUnique.isUniqueChars("abc"));
		System.out.println(IsUnique.isUniqueChars("abcc"));
		
		System.out.println("-------------------------------------");
		
		System.out.println(IsUnique.isUniqueCharsSpaceOptimized("satire"));
		System.out.println(IsUnique.isUniqueCharsSpaceOptimized("abc"));
		System.out.println(IsUnique.isUniqueCharsSpaceOptimized("abcc"));
		
		System.out.println("-------------------------------------");
		
		System.out.println(IsUnique.isUniqueCharsUsingBitVector("satire"));
		System.out.println(IsUnique.isUniqueCharsUsingBitVector("abc"));
		System.out.println(IsUnique.isUniqueCharsUsingBitVector("abcc"));
	}

}
