package ds.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 *
 */
public class CheckPermutation {
	
	/**
	 * Solution 1: 
	 */
	private static boolean permutation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		return sort(s1).equals(sort(s2));
	}
	
	private static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	/**
	 * Solution 2
	 * definition of a permutation - two words with the same character counts
	 */
	private static boolean permutationUsingCounts(String s1, String s2) { 
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int[] letters = new int[128]; // assumption
		char[] chars = s1.toCharArray();
		for(char c : chars) { // count number of each char in s1
			letters[c]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			int c = (int) s2.charAt(i);
			letters[c]--;
			if(letters[c] < 0) { // ***** very important *****
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Solution 3, based on Solution 2
	 * simultaneous iteration of both strings, insertion, deletion and updation of char counts.
	 */
	private static boolean permutationUsingFrequencyCounts(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		Map<Character, Integer> freqMap = new HashMap<>();
		for(int i = 0; i < s1.length(); i++) {
			freqMap.put(s1.charAt(i), freqMap.getOrDefault(s1.charAt(i), 0) + 1);
			if(freqMap.get(s1.charAt(i)) == 0) {
				freqMap.remove(s1.charAt(i));
			}
			
			freqMap.put(s2.charAt(i), freqMap.getOrDefault(s2.charAt(i), 0) - 1);
			
			if(freqMap.get(s2.charAt(i)) == 0) {
				freqMap.remove(s2.charAt(i));
			}
		}
		
		return freqMap.size() == 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(permutation("abc", "bca"));
		
		System.out.println(permutationUsingCounts("abc", "bca"));
		
		System.out.println(permutationUsingFrequencyCounts("abc", "bca"));
	}
}
