package org.amit.dynamic;

public class MaxIncreasingSum {
	static int maxSumIS(int arr[], int n) {
		int maxval = 0;
		int maxvalar[] = new int[n];
		for (int i = 0; i < n; i++) {
			maxvalar[i] = arr[i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] <= arr[i] && maxvalar[i] < maxvalar[j] + arr[i])
					maxvalar[i] = maxvalar[j] + arr[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (maxval < maxvalar[i])
				maxval = maxvalar[i];
		}

		return maxval;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 7, 7, 7, 7, 9, 8, 10 };
		int n = arr.length;
		System.out.println("Sum of maximum sum " + "increasing subsequence is " + maxSumIS(arr, n));
	}
}
