package HackerEarth;

public class PrintIntegerWithoutString {

	static int getNumber(int n) {
		double sum = 0;
		double k = 1;
		for (int i = n; 0 < i; i--) {
			double val = Math.pow(10, i - 1);
			val = val * k;
			sum = sum + val;
			k++;
		}

		return (int) sum;
	}

	public static void main(String[] args) {
		int n = 133;
		System.out.println(getNumber(n));
		;
	}
}
