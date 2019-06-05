package org.amit.DS_ALGO;

public class TwoIntMultiplication {

	public static void main(String[] args) {
		int a = 75;
		int b = 75;

		int lena = getLen(a);
		int lenb = getLen(b);

		int arra[] = getArray(a, lena);
		int arrb[] = getArray(b, lenb);
		int maxcol = Math.max(lena, lenb);
		int arr[][] = new int[2][maxcol];
		arr[0] = arra;
		arr[1] = arrb;
		System.out.println("Getting Multiplication step for multiply: ");
		System.out.println();
		boolean once = true;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println("");
			if (once) {
				System.out.println("X");
				once = false;
			}

		}
		for (int i = 0; i < (lena + lenb) * 2; i++)
			System.out.print("-");
		System.out.println();

		int resultarr[][] = getMultiplicationProcess(arr, lena, lenb);
		int arrsum[] = getSum(resultarr, lena, lenb);

		printArray(resultarr, arrsum);

		System.out.println();
		for (int i = 0; i < (lena + lenb) * 2 + 2; i++)
			System.out.print("=");
		System.out.println();
		System.out.println("Enjoy the code!");
	}

	static int[][] getMultiplicationProcess(int[][] arr, int lena, int lenb) {
		int resultarr[][] = new int[lenb][lena + lenb];
		int k = 0;
		for (int i = arr[1].length - 1; 0 <= i; i--) {
			int rem = 0;
			for (int j = arr[0].length - 1; 0 <= j; j--) {
				int mul = arr[0][j] * arr[1][i] + rem;
				rem = (mul) / 10;
				mul = mul % 10;
				resultarr[k][i + j + 1] = mul;
				if (j == 0)
					resultarr[k][i + j] = rem;

			}
			k++;
		}

		return resultarr;
	}

	static int[] getSum(int[][] resultarr, int lena, int lenb) {
		int arrsum[] = new int[lena + lenb];
		int rem = 0;
		for (int i = resultarr[0].length - 1; 0 <= i; i--) {

			int sum = 0;
			for (int j = 0; j <= resultarr.length - 1; j++) {
				sum = sum + resultarr[j][i];
			}
			sum = sum + rem;
			rem = sum / 10;
			sum = sum % 10;
			arrsum[i] = sum;
		}

		return arrsum;
	}

	static void printArray(int[][] arr, int arrsum[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0)
					System.out.print("x" + " ");
				else
					System.out.print(arr[i][j] + " ");
			}

			System.out.println();
		}
		for (int i = 0; i < (arrsum.length) * 2; i++)
			System.out.print("-");
		System.out.println();
		for (int i = 0; i < arrsum.length; i++)
			System.out.print(arrsum[i] + " ");

	}

	static int getLen(int x) {
		int count = 0;
		if (x == 0)
			return 1;
		while (x != 0) {
			x = x / 10;
			count++;
		}
		return count;
	}

	static int[] getArray(int x, int a) {
		int[] arr = new int[a];
		if (x == 0) {
			arr[0] = 0;
			return arr;
		}
		int i = 0;
		while (x != 0) {
			arr[i] = x % 10;
			x = x / 10;
			i++;

		}
		arr = reverseArray(arr);
		return arr;
	}

	static int[] reverseArray(int[] arr) {
		int[] arrreverse = new int[arr.length];
		int i = 0;
		int j = arr.length - 1;

		while(i<j)
		{
			int temp=arr[j];
			arrreverse[j]=arr[i];
			arrreverse[i]=temp;
			i++;
			j--;
		}

		return arrreverse;
	}
	
}
