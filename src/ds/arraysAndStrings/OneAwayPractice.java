package ds.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character, 
 * or replace a character.  Given two strings, write a function to check if they are one edits(or zero edits) away.
 * Example
 * pale, ple	-> true
 * pales, pale	-> true
 * pale, bale	-> true
 * pale, bake	-> false
 */
public class OneAwayPractice {
	
	// The solution is not good, it may be considered inefficient because
	// of space usage, when there is already a solution without space usage
	private static boolean isOneEditAway(String s1, String s2) {
		if(s1.equals(s2)) {
			return false;
		}
		
		if(Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		} else {
			Map<Character, Integer> freqMapS1 = new HashMap<>();
			for(char c : s1.toCharArray()) {
				freqMapS1.put(c, freqMapS1.getOrDefault(c, 0) + 1);
			}
			
			Map<Character, Integer> freqMapExtraCharsS2 = new HashMap<>();
			for(char c: s2.toCharArray()) {
				Integer val = freqMapS1.get(c);
				if(val == null) {
					freqMapExtraCharsS2.put(c, freqMapExtraCharsS2.getOrDefault(c, 0) + 1);
				} else {
					freqMapS1.put(c, val - 1);
					if(freqMapS1.get(c) == 0) {
						freqMapS1.remove(c);
					}
				}
			}
			int freqMapS1Sum = 0;
			for(Entry<Character, Integer> entry : freqMapS1.entrySet()) {
				freqMapS1Sum += entry.getValue();
			}
			int freqMapExtraCharsS2Sum = 0;
			for(Entry<Character, Integer> entry : freqMapExtraCharsS2.entrySet()) {
				freqMapExtraCharsS2Sum += entry.getValue();
			}
			
			//return freqMapExtraCharsS2.size() <= 1 && freqMapS1.size() <= 1; // it may not work, but don't know why it was working
			
			return freqMapS1Sum <= 1 && freqMapExtraCharsS2Sum <= 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(isOneEditAway("pale", "ple"));
		System.out.println(isOneEditAway("pales", "pale"));
		System.out.println(isOneEditAway("pale", "bale"));
		System.out.println(isOneEditAway("pale", "bake"));
	}
}
