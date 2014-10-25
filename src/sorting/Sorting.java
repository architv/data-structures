package sorting;

public class Sorting {
	
	// function which takes an input integer array and returns the sorted array using bucket sort
	public static int[] bucketSort (int[] input) {
		return null;
	}
	
	private static int partition(int[] input, int startIndex, int endIndex) {
		int pivotElement = input[startIndex];
		int pivotIndex = startIndex;
		
		for (int i = startIndex; i < endIndex; i++) {
			if (input[i] < pivotElement) {
				pivotIndex++;
			}
		}
		
		int temp = input[pivotIndex];
		input[pivotIndex] = input[startIndex];
		input[startIndex] = temp;
		
		int i = startIndex;
		int j = endIndex;
		
		while (i < pivotIndex && j > pivotElement) {
			if (input[j] < input[pivotIndex]) {
				int temp1 = input[j];
				input[j] = input[i];
				input[i] = temp1;
				i++;
			} else {
				j--;
			}
		}
		
		return pivotIndex;
	}
	
	private static void quickSortHelper (int[] input, int startIndex, int endIndex) {
		
		if (startIndex >= endIndex) {
			return;
		}
		
		int pivotIndex = partition(input, startIndex, endIndex);
		quickSortHelper(input, startIndex, pivotIndex - 1);
		quickSortHelper(input, pivotIndex + 1, endIndex);
	}
	
	// function which takes an input integer array and returns the sorted array using quick sort
	public static void quickSort (int[] input) {
		quickSortHelper (input, 0, input.length - 1);
	}
	
	public static void main(String[] args) {
		int a[] = {-11,-12,3,6,2,8};
		quickSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

}
