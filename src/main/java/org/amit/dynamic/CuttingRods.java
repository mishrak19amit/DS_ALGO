package org.amit.dynamic;

import java.util.HashMap;
import java.util.Map;

public class CuttingRods {
	static int cutRod(int arr[], int size) {
		if(size<=0)
			return 0;
		int maxvalue=Integer.MIN_VALUE;
		for(int i=0;i<size;i++)
		{
		maxvalue= Math.max(maxvalue, arr[i]+cutRod(arr, size-i-1))	;
		}
		
		return maxvalue;
	}
	public static void main(String[] args) {
		
		Map<Integer, Integer> hashvalue=new HashMap<Integer, Integer>();
		int arr[] = new int[] { 5, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));

	}
}
