package dp;

public class MaxSubArray {
	
	public static int maxSubArrayOptimal (int[] input) {
		int maxSoFar = 0;
		int previousSum = input[0];
		
		if (previousSum > maxSoFar) {
			maxSoFar = previousSum;
		}
		
		for (int i = 1; i < input.length; i++) {
			int currentSum = Math.max(input[i] + previousSum, input[i]);
			previousSum = currentSum;
			if (currentSum > maxSoFar) {
				maxSoFar = currentSum;
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArrayOptimal(new int[] {0,1,-2,-3,5,8}));
	}

}
