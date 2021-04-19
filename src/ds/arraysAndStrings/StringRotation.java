package ds.arraysAndStrings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.  Given two strings, s1 and s2,
 * write code to check if s2 is a rotation of s1 using only one call to isSubstring 
 * (e.g., "watterbottle" is a rotation of "erbottlewat").
 */
public class StringRotation {
	
	// also official
	private static boolean isRotation(String s1, String s2) {
		int len = s1.length(); 
		/* check that s1 and s2 are equal length and not empty */
		if(len == s2.length() && len > 0) {
			String s1s1  = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	private static boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}
}
