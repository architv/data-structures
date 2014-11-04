package textprocessing;

public class TextProcessing {
	
	public static int findSubstring(String largeString, String toBeFound) {
		
		int startIndex = -1;
		int size = 0;
		// traverse over the string
		// see
		for (int i = 0; i < largeString.length(); i++) {
			startIndex = i;
			for (int j = 0; i < toBeFound.length(); j++) {
				if (toBeFound.charAt(j) == largeString.charAt(startIndex + j)) {
					size++;
				} else {
					size = 0;
					break;
				}
			}
			
			if (size >= toBeFound.length()) {
				break;
			}
		}
		
		return startIndex;
	}
	
	public static int editDistanceDP (String s1, String s2) {
		
		int dpStrorage[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 0; i < s1.length(); i++) {
			dpStrorage[i][0] = i;
		}
		
		for (int j = 0; j < s1.length(); j++) {
			dpStrorage[0][j] = j;
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				char charOne = s1.charAt(s1.length() - i);
				char charTwo = s2.charAt(s2.length() - j);
				
				if (charOne == charTwo) {
					dpStrorage[i][j] = dpStrorage[i - 1][j - 1];
				} else {
					int option1 = dpStrorage[i][j - 1];
					int option2 = dpStrorage[i - 1][j];
					int option3 = dpStrorage[i - 1][j - 1];
					
					dpStrorage[i][j] = 1 + Math.min(option1, Math.min(option2, option3));
				}
			}
		}
		return dpStrorage[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
//		System.out.println(findSubstring("ab", "bab"));
		System.out.println(editDistanceDP("ab", "ba"));

	}

}
