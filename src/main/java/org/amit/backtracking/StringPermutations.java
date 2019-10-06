package org.amit.backtracking;

public class StringPermutations {

	public static void main(String[] args) {
		String s= "ABC";
		
		printPermutations(s, 0, s.length()-1);
	}

	private static void printPermutations(String s, int l, int r) {
		
		if(l==r)
		{
			System.out.print(s+" ");
		}
		
		for(int i=l;i<=r;i++)
		{
			
			s=swap(s, i, l);
			printPermutations(s, l+1, r);
			s=swap(s, i, l);
			
		}
		
	}

	private static String swap(String s, int i, int j) {
		char temp;
		
		char arr[]=s.toCharArray();
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		return String.valueOf(arr);
		
	}
	
}
