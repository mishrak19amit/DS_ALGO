package HackerEarth;

public class StripeMinMissingPositiveNumber {

	public static int getMinPositiveNumber(int arr[]) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int minPosNum = 0;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]<min)
				min=arr[i];
			
			if(max<arr[i])
				max=arr[i];
			
		}
		
		System.out.println(min+" "+max);
		
		if(min<0)
			min=0;
		if(max-min==1)
			minPosNum=max+1;
		else
			minPosNum=min+1;

		for (int i = 0; i < arr.length; i++) {
			

		}

		return minPosNum;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 3, 4, -1, 1 };
		System.out.println(getMinPositiveNumber(arr));

	}
}
