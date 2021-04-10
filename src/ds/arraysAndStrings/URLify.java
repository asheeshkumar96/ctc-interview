package ds.arraysAndStrings;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space
 * at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If 
 * implementing in Java, please use a character array so that you can perform this operation in place.)
 * Example
 * Input: "Mr John Smith    ", 13
 * Output:"Mr%20John%20Smith", 13
 */
public class URLify {
	
	// official
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, i = 0;
		for(i = 0; i < trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		int index = trueLength + spaceCount * 2;
		if(trueLength < str.length) {
			str[trueLength] = '\0'; // End array
		}
		
		for(i = trueLength - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}

	public static void main(String[] args) {
		char[] chars = "I am John    ".toCharArray();
		System.out.println(new String(chars));
		replaceSpaces(chars, 9);
		System.out.println(new String(chars));
	}
}
