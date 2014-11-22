package miscellaneous;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class Miscellaneous {
	
	public static int rotatedArray(int[] input) {
		
		int min = input[0];
		int k = 0;
		
		for (int i = 1; i < input.length; i++) {
			if (input[i] < min) {
				min = input[i];
				k = i;
			}
		}
		return k;
	}
	
	private static int palindromeSubstringsHelper(String input, String stringSoFar) {
		
		if (input.length() == 0) {
			// check for palindrome
			for (int i = 0; i < stringSoFar.length()/2; i++) {
				if (stringSoFar.charAt(i) != stringSoFar.charAt(stringSoFar.length() - 1 - i)) {
					return 0;
				}
			}
			return 1;
		}
		
		int count = 0;
		
		count += palindromeSubstringsHelper(input.substring(1), stringSoFar + input.charAt(0));
		count += palindromeSubstringsHelper(input.substring(1), stringSoFar);
		
		return count;
	}
	
	// function to return the count of substrings that are palindrome in a string
	public static int palindromeSubstrings(String input) {
		return palindromeSubstringsHelper(input, "");
	}

	// function to print all the possible codes for a number
	public static void codeString(int codeNumber) {
		codeStringHelper(codeNumber + "", "", "");
	}
	
	private static void codeStringHelper(String input, String smallerInput, String output) {
		
		output += mapNumbersToAlphabets(smallerInput);
		
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		codeStringHelper(input.substring(1), String.valueOf(input.charAt(0)), output);
		
		if (input.length() > 1) {
			codeStringHelper(input.substring(2), String.valueOf(input.charAt(0))  + 
					String.valueOf(input.charAt(1)), output);
		}
	}
	
	private static String mapNumbersToAlphabets(String input) {
		
		if (input.length() == 0) {
			return "";
		}
		
		char output = (char)('a' + Integer.parseInt(input) - 1);
		return String.valueOf(output);
	}

	public static String longestSubstring(String input) {
		
		int substringStartIndex = 0;
		String longestSubstring = new String();
		char[] twoChars = new char[2];
		int secondCharIndex = 0;
		
		twoChars[0] = input.charAt(0);
		
		for (int i = 1; i < input.length(); i++) {
			
			if (input.charAt(i) != twoChars[0] && twoChars[1] == '\u0000') {
				twoChars[1] = input.charAt(i);
				secondCharIndex = i;
			} 
			
			else if (input.charAt(i) != twoChars[0] && input.charAt(i) != twoChars[1]) {
				
				int count = i - substringStartIndex;
				
				if (count > longestSubstring.length()) {
					longestSubstring = input.substring(substringStartIndex, i);
				}
				
				substringStartIndex = secondCharIndex;
				twoChars[0] = input.charAt(substringStartIndex);
				twoChars[1] = '\u0000';
			}
		}
		return longestSubstring;
	}
	
	public static int stepProblemIterative(int noOfSteps) {
		
		if (noOfSteps == 0) {
			return 0;
		}
		
		int first = 1;
		int second = 2;
		int third = 4;
		
		if (noOfSteps == 1) {
			return first;
		}
		
		if (noOfSteps == 2) {
			return second;
		}
		
		if (noOfSteps == 3) {
			return third;
		}
		
		int sum = 0;
		
		for (int i = 4; i < noOfSteps; i++) {
			sum += first + second + third;
			first = second;
			second = third;
			third = sum;
		}
		
		return first + second + third;
	}
	
	public static int maximumWalk (int[] inputArray1, int[] inputArray2) {
		
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		int i = 0;
		int j = 0;
		
		while (i < inputArray1.length && j < inputArray2.length) {
			
			if (inputArray1[i] < inputArray2[j]) {
				sum1 += inputArray1[i];
				i++;
			}
			else if (inputArray1[i] > inputArray2[j]) {
				sum2 += inputArray2[j];
				j++;
			}
			else {
				sum1 += inputArray1[i];
				sum2 += inputArray2[j];
				if (sum1 > sum2) {
					sum += sum1;
				} else {
					sum += sum2;
				}
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
		}
		
		for (int m = i; m < inputArray1.length; m++) {
			sum1 += inputArray1[m];
		}
		
		for (int m = j; m < inputArray2.length; m++) {
			sum2 += inputArray2[m];
		}
		
		if (sum1 > sum2) {
			sum += sum1;
		} else {
			sum += sum2;
		}
		
		return sum;
	}
	
//	public static int random5() {
//		return random7()
//	}
	
	public static int compressedStringLength (ArrayList<String> strings, ArrayList<Integer> numbers, int endIndex) {
		int totalLength = 0;
		for (int i = 0; i <= endIndex; i++) {
			totalLength = (totalLength + strings.get(i).length()) * numbers.get(i);
		}
		return totalLength;
	}
	
	// takes as input a string array, integer array, endIndex and an index and returns the character at that index
	public static char getiTHIndexInCompressedStringHelper (ArrayList<String> strings,
			ArrayList<Integer> numbers, int index, int endIndex) {
		if (endIndex == 0) {
//			int totalStringLength = compressedStringLength(strings, numbers, endIndex);
			int newIndex = index % strings.get(0).length();
			return strings.get(0).charAt(newIndex);
		}
		
		int totalStringLength = compressedStringLength(strings, numbers, endIndex);
		int lengthOfEachSection = totalStringLength / numbers.get(endIndex);
		
		int numberOfSectionsBefore = index / lengthOfEachSection;
		
		int newIndex = index - numberOfSectionsBefore * lengthOfEachSection;
		
		int leftPartLength = lengthOfEachSection - strings.get(endIndex).length();
		
		if (newIndex >= leftPartLength) {
//			int indexInSmallString = strings.get(endIndex).length(); 
			return strings.get(endIndex).charAt(newIndex - leftPartLength);
		}
		
		return getiTHIndexInCompressedStringHelper(strings, numbers, newIndex, endIndex - 1);
	}
	
	
	public static void parseString (String input, int index) {
//		String currentString;
//		boolean isLastInt = false;
//		
//		ArrayList<String> cu
	}
	
	public static void main(String[] args) {
//		int[] input = {3,4,5,6,7,1,2};
//		System.out.println(rotatedArray(input));
//		System.out.println(palindromeSubstrings("abba"));
//		codeString(123);
//		System.out.println(longestSubstring("aaaabbcccccdddeeeeff"));
//		int[] input1 = {2,4,6,8,10,12,13,16,18,21};
//		int[] input2 = {1,4,5,7,8,11,13,19,20};
//		
//		System.out.println(maximumWalk(input1, input2));
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		System.out.println(getiTHIndexInCompressedStringHelper(strings, numbers,83, strings.size() - 1));
//		System.out.println(compressedStringLength(strings, numbers, strings.size() - 1));
	}

}
