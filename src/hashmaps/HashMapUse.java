package hashmaps;

import java.util.HashMap;

public class HashMapUse {

	public static Integer[] removeDuplicates (int[] input) {
		
		HashMap<Integer, Boolean> unique = new HashMap<Integer, Boolean>();
		
		for (int i = 0; i < input.length; i++) {
			if (!unique.containsKey(input[i])) {
				unique.put(input[i], true);
			}
		}
		return unique.keySet().toArray(new Integer[0]);
	}
	
	public static void intersection (int[] inputOne, int[] inputTwo) {
		HashMap<Integer, Boolean> intersect = new HashMap<Integer, Boolean>();
		
		for (int i = 0; i < inputOne.length; i++) {
			intersect.put(inputOne[i], true);
		}
		
		for (int i = 0; i < inputTwo.length; i++) {
			if (intersect.containsKey(inputTwo[i])) {
				System.out.println(inputTwo[i]);
			}
		}
	}
	
	public static void pairsOfSumZero (int[] inputOne, int[] inputTwo) {
		HashMap<Integer, Boolean> sumZero = new HashMap<Integer, Boolean>();
		
		for (int i = 0; i < inputOne.length; i++) {
			sumZero.put(inputOne[i], true);
		}
		
		for (int i = 0; i < inputTwo.length; i++) {
			if (sumZero.containsKey(-inputTwo[i])) {
				System.out.println("(" + -inputTwo[i] + ", " + inputTwo[i] + ")");
				sumZero.remove(-inputTwo[i]);
			}
		}
	}
	 
	public static void fourElementsSumZero (int[] input) {
		
		HashMap<Integer, PairsOfSum> pairs = new HashMap<Integer, PairsOfSum>();
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				int pairSum = input[i] + input[j];
				PairsOfSum indexes = new PairsOfSum();
				indexes.first = i;
				indexes.second = j;
				pairs.put(pairSum, indexes);
			}
		}
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				int pairSum = input[i] + input[j];
				if (pairs.containsKey(-pairSum) && pairs.get(-pairSum).first > j &&
						pairs.get(-pairSum).second > pairs.get(-pairSum).first) {
					System.out.println(input[i] + " " + input[j] + " " + input[pairs.get(-pairSum).first]
							+ " " + input[pairs.get(-pairSum).second]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		Integer[] output = removeDuplicates(new int[] {1,2,3,4,4,5,6,1,11,9,2,2,5,-1,-6,1});
		
//		intersection(new int[] {10,12,2,3,7,11}, new int[] {12,3,4,6,11,13});
//		for (int i : output) {
//			System.out.println(i);
//		}
//		pairsOfSumZero(new int[] {2,5,-3,-4}, new int[] {1,-5,-2,7});
		fourElementsSumZero(new int[] {-5,-4,-3,0,1,2,3});
	}

}
