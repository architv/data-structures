package Stacks;

public class StackSpan {
	
	public static int[] stackSpan(int[] input) {
		
		Stack2 s = new Stack2();
		int[] span = new int[input.length - 1];
		s.push(input[0], 0);
		
		for (int i = 1; i < input.length; i++) {
			int spanCount = 0;
			while (!s.isEmpty()) {
				
				if (input[i] < s.top()[0]) {
					spanCount = i - s.top()[1];
					s.push(input[i], i);
					break;
				} else {
					s.pop();
				}
			}
			if (s.isEmpty()) {
				s.push(input[i], i);
				span[i - 1] = -50;
			} else {
				span[i - 1] = spanCount;
			}
		}
		return span;
	}

	public static void main(String[] args) {
		int arr[] = stackSpan(new int[] {10, 8, 9, 12, 8, 7, 4, 11});
		for (int i : arr) {
			System.out.println(i);
		}
		
//		Stack2 s = new Stack2();
//		s.push(1, 0);
//		s.push(2, 1);
//		s.push(3, 2);
//		System.out.println(s.top()[0] + ":" + s.pop()[1]);
//		System.out.println(s.top()[0] + ":" + s.pop()[1]);
	}

}
