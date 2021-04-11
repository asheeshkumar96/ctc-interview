package ds.arraysAndStrings;

/**
 * Given a string, write a function to check if it is a permutation of palindrome.  A palindrome is a word or phrase
 * that is same forwards and backwords.  A permuatation is rearrangement of letters.  The palindrome does not need to 
 * be limited to just dictionary words.
 */
public class PalindromePermutationV1  {
	
	// official
	private static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	/* Check that no more than one character has an odd count */
	private static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for(int count : table) {
			if(count % 2 == 1) {
				if(foundOdd) {
					return false;
				}
				foundOdd  = true;
			}
		}
		return true;
	}
	
	/* Count how many time each character appears */
	private static int[] buildCharFrequencyTable(String word) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : word.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	
	/* Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
	 * This is case insensitive. Non-letter characters map to -1 */
	private static int getCharNumber(char c) {
		int a = Character.getNumericValue('a'); 
		// For what Character.getNumericValue(char) is used ??? It returns case insensitive value, i.e., A and a have same value
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z ) {
			return val - a;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("Tact Coa"));
	}
}
