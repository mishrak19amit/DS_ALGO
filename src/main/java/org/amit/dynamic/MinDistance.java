package org.amit.dynamic;

public class MinDistance {
	
	static int minDis(int a, int b, int c) {
		if(a<b&&a<c) return a;
		if(b<a&& b<c) return b;
		else
			return c;
	}
	
	public static int getMinDistance(String s1, String s2, int n, int m){
		
		if(m==0) return n;
		
		if(n==0) return m;
		
		if(s1.charAt(n-1)==s2.charAt(m-1))
			return getMinDistance(s1, s2, n-1, m-1);
		
		return 1+minDis(getMinDistance(s1, s2, n-1, m), getMinDistance(s1, s2, n, m-1), getMinDistance(s1, s2, n-1, m-1));
		
	}

	public static void main(String[] args) {

		String s1="sunday";
		String s2="saturday";
		
		int dis=getMinDistance(s1,s2,s1.length(),s2.length());
		
		System.out.println(dis);
	}
}
