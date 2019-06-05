package org.amit.dynamic;

public class LongestIncreasingSubsequence {

	static int lis(int arr[], int n) {

		int max = 0;
		if (n == 0 || n == 1)
			return 1;

		int lis[] = new int[n];
		for (int k = 0; k < n; k++)
			lis[k] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}

		for (int i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];
		return max;

	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}
}
