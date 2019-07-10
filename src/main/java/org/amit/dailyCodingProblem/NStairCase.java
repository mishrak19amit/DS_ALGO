package org.amit.dailyCodingProblem;

public class NStairCase {

	public static void main(String[] args) {
		int n=1;
		
		System.out.println(getPossibleWay(n,1,2));
		
	}

	private static int getPossibleWay(int n, int i, int j) {
		if(n==0) return 0;
		
		return getPossibleWayUtil(n, i, j);
		
	}

	private static int getPossibleWayUtil(int n, int i, int j) {
		if(n<0) return 0;
		if(n==0) return 1;
		return getPossibleWayUtil(n-i, i, j)+getPossibleWayUtil(n-j, i, j);
		
	}
	
}
