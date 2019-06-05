package org.amit.dynamic;

public class LongestPalindrome {
	static int lps(char arr[], int a, int b)
	{
		if(a==b) return 1;
		if(arr[a]==arr[b]&&a+1==b) return 2;
		if(arr[a]==arr[b])
		{
			return 2+ lps(arr, a+1, b - 1);
		}
		else {
			return Math.max(lps(arr, a+1, b), lps(arr, a, b - 1));
		}
	}
	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
		int n = seq.length();
		System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1));

	}
}
