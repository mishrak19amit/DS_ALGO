package HackerEarth;

public class FindLongestUniqeSubString {

	public static void main(String[] args) {
		String s = "ABDCDKDE";

		int len;
		len = getMaxLenUniqeSubStringUsingExtra(s);

		System.out.println(len);
	}

	private static int getMaxLenUniqeSubStringUsingExtra(String s) {
		int maxTillNow = 0;

		int arr[] = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			arr[i] = 1;
		}

		for (int i = 1; i < s.length(); i++) {
			int count=0;
			boolean flagDup=false;
			for(int j=i-1;0<=j;j--) {
				if (s.charAt(i) != s.charAt(j)) {
					arr[i]=arr[i-1]+1;
					count++;
				}
				else {
					flagDup=true;
					break;
				}
			}
			if(flagDup) {
				arr[i]=count+1;
			}
			else {
				arr[i]=arr[i-1]+1;
			}
			
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (maxTillNow < arr[i]) {
				maxTillNow = arr[i];
			}
		}
		System.out.println();

		return maxTillNow;
	}

}
