package ds.arraysAndStrings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the 
 * string aabcccccaaa would become a2b1c5a3.  If the compressed string would not become smaller than the original string,
 * your method should return the original string.  You can assume the string has only uppercase and lowercase letters(a-z).
 *
 */
public class StringCompressionPractice {
	
	private static String compressString(String str) {
		if(str == null || str.length() <= 2) {
			return str;
		}
		
		StringBuilder sb = new StringBuilder();
		int compressedStringLength = 0;
		for(int i = 0; i < str.length() - 1; i++) {
			int charCount = 1; 
			while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				charCount++;
				i++;
			}
			sb.append(str.charAt(i)).append(charCount);
			compressedStringLength += 2;
		}
		return compressedStringLength > str.length() ? str : sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
	}
	
}
