package org.amit.greedyAlgo;

public class MinCastPath {
	
	static int getMin(int a, int b, int c)
	{
		if(a<b)
			return a<c?a:c;
		else 
			return b<c?b:c;
	}
	
	static int minCost(int arr[][], int a, int b)
	{
		if(a<0||b<0)
			return Integer.MAX_VALUE;
		
		if(a==0&&b==0)
			return arr[a][b];
		return arr[a][b] + getMin(minCost(arr, a-1, b),minCost(arr, a-1, b-1),minCost(arr, a, b-1));
	}
	
	public static void main(String[] args) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 2, 2));
	}
}
