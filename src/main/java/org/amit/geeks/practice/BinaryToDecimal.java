package org.amit.geeks.practice;

public class BinaryToDecimal {
	static int printDecimle(int exp, int n) {
		if (exp <= 0)
			return 0;
		int dig = exp % 10;
		return getpower(dig, n) + printDecimle(exp / 10, n + 1);
	}

	static int getpower(int dig, int n) {
		if (dig == 0)
			return 0;
		else if (n == 0)
			return 1;
		else {
			int mul = 1;
			for (int i = 0; i < n; i++) {
				mul *= 2;
			}
			return mul;
		}
	}

	public static void main(String[] args) {
		int exp = 1000;
		System.out.println(printDecimle(exp, 0));
	}
}
