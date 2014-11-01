package maps;

import java.util.Arrays;

public class MapUse {

	public static void main(String[] args) {
		Map<String, Boolean> testMap = new Map<String, Boolean>();
//		testMap.put(2, true);
//		testMap.put(3, false);
//		testMap.put(4, true);
//		
//		for (int i = 0; i < 40; i++) {
//			testMap.put(i, true);
////			if(testMap.containsKey(i)) {
////				System.out.println(i);
////			}
//		}
		testMap.put("hi", true);
		testMap.put("hello", false);
		testMap.put("world", true);
		
		Object[] testArray = testMap.keys();
		String[] stringArray = Arrays.copyOf(testArray, testArray.length, String[].class);
		for (String s : stringArray) {
			System.out.println(s);
		}
		
		Object[] newTestArray = testMap.values();
		Boolean[] booleanArray = Arrays.copyOf(newTestArray, newTestArray.length, Boolean[].class);
		for (Boolean s : booleanArray) {
			System.out.println(s);
		}
	}

}
