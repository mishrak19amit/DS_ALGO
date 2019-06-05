package HackerRank;

public class CountingVelly {
	static int countingValleys(int n, String s) {
		int count = 0;
		int arr[] = new int[n + 1];
		arr[0] = 0;
		for (int i = 0; i < n; i++) {
			arr[i + 1] = arr[i] + getvalue(s.charAt(i));
		}

		for (int i = 1; i < arr.length;i++) {
			if(arr[i]<0)
			{
				while(arr[i]!=0)
					i++;
				count+=1;
			}
		}

		return count;
	}

	static int getvalue(char c) {
		switch (c) {
		case 'U':
			return 1;
		case 'D':
			return -1;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		String s = "UDDDUDUUDU";
		int n=s.length();
		System.out.println(countingValleys(n, s));
	}
}
