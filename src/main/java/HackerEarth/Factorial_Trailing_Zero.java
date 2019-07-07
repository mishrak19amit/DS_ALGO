package HackerEarth;

import java.math.BigInteger;

public class Factorial_Trailing_Zero {

	public static void main(String[] args) {

		int n = 125;
		int count2=0;
		int count5=0;
		
		for(int i=2;i<=n;i++) {
			count2+=getFactor(i,2);
			count5+=getFactor(i,5);
		}
		
		System.out.println(count2+" "+count5);
		
		int trailingZero=Math.min(count2, count5);
		
		System.out.println("Total Number of Trailing Zero: "+ trailingZero);
		
		String fact = factorial(n);
		System.out.println("Factorial is " + fact);

		
	}
	
	static int getFactor(int n, int k)
	{  int count=0;
		while(k<=n) {
		
			if(n%k==0) {
				count++;
				n=n/k;
			}
			else {
				break;
			}
			
				
			
		}
		
		return count;
	}

	public static String factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}
}
