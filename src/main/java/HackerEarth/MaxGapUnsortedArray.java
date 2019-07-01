package HackerEarth;

public class MaxGapUnsortedArray {

	public static int getMaxGap(int arr[]) {
		int gap = 0;

		if (arr.length < 2)
			return 0;

		return gap;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 10, 5 };
		System.out.println("max Gap: " + getMaxGap(arr));
	}
}
