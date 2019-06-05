package org.amit.greedyAlgo;

public class MinPlatform {

	static int findPlatform(int arr[], int dep[], int n) {
		int maxplat=0;
		int check[]= new int[n];
		for(int i=0;i<n;i++)
			check[i]=1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=i;j++)
				if(arr[i]<dep[j])
					check[i]++;
				else
					check[i]--;
		}
		
		for(int i=0;i<n;i++)
		{
			if(maxplat<check[i])
				maxplat=check[i];
		}
		return maxplat;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100,1110, 1500, 1800,1900,2100 };
		int dep[] = { 910, 1200, 1120, 1130,1140, 1900, 2000,2100,2200 };
		int n = arr.length;
		System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
	}
}
