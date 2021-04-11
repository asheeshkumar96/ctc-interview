package ds.arraysAndStrings;

public class StringCompressionV3 {
	
	private static String compress(String str) {
		int finalLength = countCompress(str);
		if(finalLength >= str.length()) return str;
		
		StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
		int countConsecutive = 0; 
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If the next character is different than current, append this char to result. */
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		
		return compressed.toString();
	}
	
	private static int countCompress(String str) {
		int compressedLength = 0; 
		int countConsecutive = 0;
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, increase the length */
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}
}
