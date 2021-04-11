package ds.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutationPractice {
	
	// but it is case sensitive and also considers space
	private static boolean isPalindomePermutation(String phrase) {
		Map<Character, Integer> freqMap = new HashMap<>();
		// is remove and put costaly than iterating over hashmap
		for(char c : phrase.toCharArray()) {
			Integer val = freqMap.get(c);
			if(val == null) {
				freqMap.put(c, 1);
			} else {
				freqMap.remove(c);
			}
		}
		
		if(phrase.length()  % 2 == 0) {
			System.out.println("size is even");
			return freqMap.size() == 0;
		}
		
		if(phrase.length() % 2 == 1) {
			System.out.println("size is odd");
			return freqMap.size() == 1;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPalindomePermutation("Tact Coa"));
		System.out.println(isPalindomePermutation("tactcoa"));
	}
}
