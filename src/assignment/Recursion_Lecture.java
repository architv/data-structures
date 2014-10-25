package assignment;

import java.util.Scanner;


public class Recursion_Lecture {
	
	// takes as input two integer arrays a and b and merges them
	private static int[] merge (int a[], int b[]) {
		
		int c[] = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int index = 0;
		
		while (i < a.length && j < b.length) {
		
			if (a[i] < b[j]) 
				c[index++] = a[i++];
	
			else if (a[i] > b[j])
				c[index++] = b[j++];
			
			else {
				c[index++] = a[i++];
				j++;
			}
		
		}
		
		for (int k = i; k < a.length; k++)
			c[index++] = a[k];
		
		for (int k = j; k < b.length; k++)
			c[index++] = b[k];
		
		return c;
	}
	
	// helper function for mergesort
	// takes as input an integer array, startindex and endindex and sorts the array from
	// startindex to endindex
	private static int[] mergeSortHelper(int input[], int startIndex, int endIndex) {
		
		if (startIndex == endIndex) {
			int c[] = new int[1];
			c[0] = input[startIndex];
			return c;
		}
		
		else {
			
			int middle = (startIndex + endIndex) / 2;
			int a[] = mergeSortHelper(input, startIndex, middle);
			int b[] = mergeSortHelper(input, middle + 1, endIndex);
			int c[] = merge(a, b);
			return c;
		}
	}
	
	// calculates the factorial of an integer n
	private static int fact(int n) {
		if (n == 0)
			return 1;
		
		return n*fact(n - 1);
	}
	
	// helper function for numberOfNumbersWithoutRepetiton()
	// takes as input an integer array and startindex and return the count of numbers
	// greater than the given number with same set of digits
	private static int numberOfNumbersWithoutRepetitonHelper(int[] input, int startIndex) {
		
		if (startIndex == input.length - 1) {
			return 0;
		}
		
		int count = numberOfNumbersWithoutRepetitonHelper(input, startIndex + 1);
		
		for (int i = startIndex + 1; i < input.length; i++) {
			
			if (input[i] > input[startIndex]) {
				count += fact(input.length - 1 -startIndex);
			}
		}
		
		return count;
	}
	
	// Takes as input an integer array and an index.
	// Creates a frequency array from the input array starting from index
	private static int[] setFrequency(int[] input, int index) {
		
		int[] out = new int[10];
		
		for (int i = index; i < input.length; i++)
			out[input[i]]++;
		
		return out;	
	}
	
	// Helper function for numberOfNumbersWithRepetiton()
	// Takes as input an integer array and startindex and return the count of numbers
	// greater than the given number with same set of digits. Repetition of digits is allowed
	private static int numberOfNumbersWithRepetitonHelper(int[] input, int startIndex) {
		if (startIndex == input.length - 1) {
			return 0;
		}
		
		int count = 0;
//		int count = numberOfNumbersRepeated(input, startIndex + 1);
		
		int[] freq = setFrequency(input, startIndex);
		
		for (int i = startIndex + 1; i < input.length; i++) {
			
			if (input[i] > input[startIndex]) {
				int newCount = fact(input.length - 1 - startIndex);
				
				for (int j = 0; j < freq.length; j++) {
					newCount /= fact(freq[j]);
				}
				count += newCount;
			}
		}
		count += numberOfNumbersWithRepetitonHelper(input, startIndex + 1);
		return count;	
	}
	
	// Helper function for numberOfSubsets()
	// Takes as input a string, stringSoFar and an integer k and returns the number
	// of subsets of string which sum to k.
	private static int numberOfSubsetsHelper(String input, String stringSoFar, int k) {
		
		int count = 0;
		if (input.length() == 0) {
			int sum = 0;
			int a[] = new int[stringSoFar.length()];
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(stringSoFar.charAt(i) + "");
				sum += a[i];
			}
			
			if (sum == k)
				return 1;	
			
			return 0;
		}
		
		char charToBeFixed = input.charAt(0);
		count += numberOfSubsetsHelper(input.substring(1), stringSoFar + charToBeFixed, k);
		count += numberOfSubsetsHelper(input.substring(1), stringSoFar, k);
		return count;
	}
	
	//Takes an input 1-D array and sorts it
	
	public static void mergeSort(int[] inputArray){
		
		int[] sortedArray = mergeSortHelper(inputArray, 0, inputArray.length - 1);
		
		for (int i : sortedArray) {
			System.out.println(i);
		}
		
	}
	
	// Takes 2-D array as an input an returns elements of array in the spiral order
	
	public static int[] spiralPrint(int[][] inputArray){
		int numRows = inputArray.length;
		
		if (numRows == 0)
			return null;
		
		int numCols = inputArray[0].length;
		
		int[] spiralArray = new int[numRows * numCols];
		
		int rowStart = 0;
		int rowEnd = numRows - 1;
		int colStart = 0;
		int colEnd = numCols - 1;
		int index = 0;
		
		while (rowStart <= rowEnd) {
			
			for (int j = colStart; j <= colEnd; j++) {
//				System.out.print(inputArray[rowStart][j]);
				spiralArray[index++] = inputArray[rowStart][j];
			}
			
			rowStart++;
			
			for (int i = rowStart; i <= rowEnd; i++) {
//				System.out.print(inputArray[i][colEnd]);
				spiralArray[index++] = inputArray[i][colEnd];
			}
			
			colEnd--;
			
			for (int j = colEnd; j >= colStart; j--) {
//				System.out.print(inputArray[rowEnd][j]);
				spiralArray[index++] = inputArray[rowEnd][j];
			}
			
			rowEnd--;
			
			for (int i = rowEnd; i >= rowStart; i--){
//				System.out.print(inputArray[i][colStart]);
				spiralArray[index++] = inputArray[i][colStart];
			}
			
			colStart++;
		}
		return spiralArray;
	}
	
	// Takes input array and returns number of uniquely-indexed pairs with zero sum 
	
	public static int zeroSumPairs(int[] inputArray){
		
		int[] input = mergeSortHelper(inputArray, 0, inputArray.length - 1);
		
		int i = 0;
		int j = input.length - 1;
		int count = 0;
		
		while (i < j) {
			
			if (input[i] + input[j] < 0) {
				i++;
			}
			
			else if (input[i] + input[j] > 0) {
				j--;
			}
			
			else {
				count++;
				i++;
				j--;
			}	
		}
		return count;
	}
	
	// Takes string as an input and returns how many numbers are greater than the input.
	// All characters in input will be unique.
	
	public static int numberOfNumbersWithoutRepetiton(String input){
		
		int[] stringToInteger = new int[input.length()];
		
		for (int i = 0; i < stringToInteger.length; i++) {
			stringToInteger[i] = Integer.parseInt("" + input.charAt(i));
		}
		
		return numberOfNumbersWithoutRepetitonHelper(stringToInteger, 0);
	}
	
	// Takes string as an input and returns how many numbers are greater than the input.
	// Characters in input can be repeated.
		
	public static int numberOfNumbersWithRepetiton(String input){
		int[] stringToInteger = new int[input.length()];
		
		for (int i = 0; i < stringToInteger.length; i++) {
			stringToInteger[i] = Integer.parseInt("" + input.charAt(i));
		}
		
		return numberOfNumbersWithRepetitonHelper(stringToInteger, 0);
	}
	
	// Takes string as an input and reverses the words in the string
	
	public static String reverseWords(String input){
		
		String str = "";
		int endIndex = input.length();
		for (int i = input.length() - 1; i > 0; i--) {
			
			if (input.charAt(i) == ' ')  {
				str = str + input.substring(i + 1, endIndex) + " ";
				endIndex = i;
			}	
		}
		
		str = str + input.substring(0, endIndex);
		
		return str;
	}
	
	// Takes input array and returns number of uniquely-indexed triplets with zero sum 
	
	public static int zeroSumTriplets(int[] inputArray){
		int[] input = mergeSortHelper(inputArray, 0, inputArray.length - 1);
		
		int count = 0;
		
		for (int k = 0; k < input.length/2; k++) {
			int sum = -input[k];
			int i = 0;
			int j = input.length - 1;
			
			while (i < j) {
				
				if (i == k) {
					i++;
					continue;
				}
				
				if (j == k) {
					j--;
					continue;
				}
					
				if (input[i] + input[j] < sum) {
					i++;
				}
				
				else if (input[i] + input[j] > sum) {
					j--;
				}
				
				else {
					count++;
					i++;
					j--;
				}	
			}
		}
		return count;
	}

	// Takes input array and find number of uniquely-indexed subsets with sum as k
	public static int numberOfSubsets(int[] inputArray, int k){
		
		String arrayToString = "";
		for (int i = 0; i < inputArray.length; i++) {
			arrayToString += Integer.toString(inputArray[i]);
		}
		
		return numberOfSubsetsHelper(arrayToString, "", k);		
	}
	
	// Takes 2 input arrays and returns their sum in another array 
	
	public static int[] sumOfArrays(int[] inputArray1,int[] inputArray2){
		
		int carry = 0;
		
		int[] outputArray = new int[inputArray1.length + 1];
		
		for (int i = inputArray1.length - 1; i >= 0; i--) {
			
			int sum = inputArray1[i] + inputArray2[i] + carry;
			
			if (sum >= 10) {
				carry = sum / 10;
				outputArray[i + 1] = sum % 10;
			} else {
				outputArray[i + 1] = sum;
				carry  = 0;
			}
		}
		
		outputArray[0] = carry;
		
		return outputArray;
		
	}
	
	// Takes string as an input and returns the longest substring with at most 2 unique characters in it.
	
	public static String longestSubstring(String input){
		/* write your code here */
		
		return null;
		
	}
	
	public static int[] getUserInput() {
		
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter the size of array");
		int n = console.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Please enter the array");
		for (int i = 0; i < n; i++) {
			a[i] = console.nextInt();
		}
		
		return a;
	}
	
	public static void main(String[] args){
//		int[] inputArray1 = getUserInput();
//		int[] inputArray2 = getUserInput();
//		
//		int[] c = sumOfArrays(inputArray1, inputArray2);
//		for (int i : c) {
//			System.out.println(i);
//		}
		
//		System.out.println(zeroSumPairs(new int[] {-5,0,0,5,7}));
//		System.out.println(numberOfNumbersWithoutRepetiton("3124"));
//		System.out.println(numberOfNumbersWithRepetiton("3123"));
//		System.out.println(reverseWords("this is archit"));
		System.out.println(zeroSumTriplets(new int[] {0,9,-5,14,2,7,-7,17}));
//		System.out.println(numberOfSubsets(new int[] {1,2,3,4}, 5));
		
//		for (int i : spiralPrint(new int[][] {{1,2,3},{4,5,6},{7,8,9}})) {
//			System.out.println(i);
//		}
		
	}

}
