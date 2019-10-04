package HackerEarth;

import java.util.HashMap;
import java.util.Map;

public class StartEndIndexOfSubArrayWithSumZero {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, -2, 3, -6, 8, -8, 1, 2, 3, -1, -2, -3 };

		getStartEndIndexMaxDiff(arr);
	}

	private static void getStartEndIndexMaxDiff(int[] arr) {
		int maxLen = Integer.MIN_VALUE;
		int startInd = -1;
		int endInd = -1;
		Map<Integer, Integer> indexVal = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (indexVal.containsKey(sum)) {
				if (maxLen < (i - indexVal.get(sum))) {
					startInd = indexVal.get(sum);
					endInd = i;
					maxLen = endInd - startInd;
				}
			} else {
				indexVal.put(sum, i);
			}
		}
		startInd++;
		System.out.println(startInd + " to " + endInd+" max Len: "+ maxLen);

	}

}
