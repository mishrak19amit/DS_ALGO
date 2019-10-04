package HackerEarth;

public class Power_Of_Two_Integer {

	public static void main(String[] args) {

		int n=25;
		
		double sqrt=Math.sqrt(n);
		if(sqrt*sqrt==n)
			System.out.println("True");
		else
			System.out.println("False");
	}
}
