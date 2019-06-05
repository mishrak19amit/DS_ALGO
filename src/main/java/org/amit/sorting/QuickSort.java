package org.amit.sorting;

public class QuickSort {

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	void sort(int arr[], int l, int r) {

		if (l < r) {
			int partition = getPartitioned(arr, l, r);
			sort(arr, l, partition - 1);
			sort(arr, partition + 1, r);
		}

	}

	void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	int getPartitioned(int arr[], int l, int r) {
		int partiton = l - 1;

		int pivot = arr[r];
		int i = 0;
		for (i = l; i < r; i++) {
			if (arr[i] < pivot) {
				partiton++;
				swap(arr, i, partiton);
			}

		}
		partiton++;
		swap(arr, i, partiton);
		return partiton;
	}

	public static void main(String[] args) {

		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		int a = (int) Math.round(6.14); // 3
		int b = (int) Math.round(6.99); // 4
		int c = (int) Math.round(6.5);

		System.out.println(a);

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArray(arr);
	}
}
