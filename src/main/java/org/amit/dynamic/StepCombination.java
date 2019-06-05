package org.amit.dynamic;

public class StepCombination {

	static int printCountRec(int dis) {

		int count[] = new int[dis + 1];
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;
		for (int i = 3; i <= dis; i++)
			count[i] = count[i - 1] + count[i - 2] + count[i - 3];

		return count[dis];
	}

	public static void main(String[] args) {
		int dist = 4;
		System.out.println(printCountRec(dist));
	}
}
