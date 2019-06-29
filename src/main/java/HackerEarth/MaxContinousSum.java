package HackerEarth;

import java.util.ArrayList;
import java.util.List;

public class MaxContinousSum {

	// Getting maximum value from the sumArray
	public static int gettingMax(int arr[]) {
		int max = Integer.MIN_VALUE;

		for (int a : arr) {
			if (max < a) {
				max = a;
			}
		}
		return max;
	}

	public static int maxSubArray(List<Integer> list) {
		int res = 0;

		int sumArr[] = new int[list.size()];

		if (0 < list.size()) {
			sumArr[0] = list.get(0);
		}

		// setting value
		for (int i = 1; i < list.size(); i++) {
			if (0 < list.get(i) + sumArr[i - 1] && list.get(i) < list.get(i) + sumArr[i - 1]) {
				sumArr[i] = list.get(i) + sumArr[i - 1];
			} else {
				sumArr[i] = list.get(i);
			}
		}

		res = gettingMax(sumArr);

		return res;
	}

	public static List<Integer> getListFromarray(int arr[]) {
		List<Integer> list = new ArrayList<Integer>();
		for (int a : arr) {
			list.add(a);
		}
		return list;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		List<Integer> list = getListFromarray(arr);

		System.out.println("max sub contigous sub array: " + maxSubArray(list));
	}

}
