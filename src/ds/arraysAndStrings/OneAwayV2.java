package ds.arraysAndStrings;

public class OneAwayV2 {
	
	private static boolean oneEditAway(String first, String second) {
		/* Length checks */
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		/* Get shorter and longer string */
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0; 
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found. */
				if(foundDifference) return false;
				foundDifference = true;
				
				if(s1.length() == s2.length()) { // on replace, move shorter pointer
					index1++;
				}
			} else {
				index1++; // if matching, move shorter shorter pointer
			}
			index2++; // always move pointer for longer string
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(oneEditAway("pale", "ple"));
		System.out.println(oneEditAway("pales", "pale"));
		System.out.println(oneEditAway("pale", "bale"));
		System.out.println(oneEditAway("pale", "bake"));
	
	}
}
