package org.amit.greedyAlgo;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoins {

	static int deno[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
	static int n = deno.length;

	static int minCoin = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int n = 93;
		System.out.print("Following is minimal number of change for " + n + ": ");
		findMin(n);
	}

	private static void findMin(int n) {

		List<Integer> resList = new ArrayList<Integer>();

		for (int i = deno.length - 1; 0 <= i; i--) {

			while (0 <= n && deno[i] <= n) {
				n -= deno[i];
				resList.add(deno[i]);
			}
		}

		for (Integer val : resList) {
			System.out.print(val + " ");
		}

	}

}
