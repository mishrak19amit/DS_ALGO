package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class ShoesPair {
	static int getPair(int arr[], int n) {
		int count=0;
		Map<Integer,Integer> hashvalue= new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(hashvalue.containsKey(arr[i]))
			{
				hashvalue.put(arr[i], hashvalue.get(arr[i])+1);
			}
			else {
				hashvalue.put(arr[i], 1);
			}
		}
		
		
		for(int key: hashvalue.keySet())
		{
			int value=hashvalue.get(key);
			count+=value/2;
		}
		
		return count;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println(getPair(arr, 9));
	}
}
