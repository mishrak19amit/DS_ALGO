package HackerEarth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaxSubPostiveArray {

	// Getting max subset of integer with positive value
	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		ArrayList<Integer> resList;
		LinkedHashMap<Integer, Integer> lastUpdated = new LinkedHashMap<>();
		LinkedHashMap<Integer, Integer> updated = new LinkedHashMap<>();
		for (int i = 0; i < A.size(); i++) {

			if (A.get(i) < 0) {
				lastUpdated = checkBigger(lastUpdated, updated);
				updated.clear();
			} else {
				updated.put(i, A.get(i));
			}
		}

		lastUpdated = checkBigger(lastUpdated, updated);

		resList = mapToArrayLis(lastUpdated);

		return resList;
	}

	///Converting Map to ArrayList
	public static ArrayList<Integer> mapToArrayLis(Map<Integer, Integer> resultMap) {
		
		ArrayList<Integer> resList = new ArrayList<>();
		for (int key : resultMap.keySet()) {
			resList.add(resultMap.get(key));
		}

		return resList;

	}

	// Checking for bigger value
	public static LinkedHashMap<Integer, Integer> checkBigger(LinkedHashMap<Integer, Integer> lastUpdated, LinkedHashMap<Integer, Integer> updated) {

		BigInteger sumlastUpdated = getSum(lastUpdated);
		BigInteger sumUpdated = getSum(updated);

		if (sumUpdated.compareTo(sumlastUpdated) == 1) {
			lastUpdated.clear();
			lastUpdated = exchangeValue(updated);
		} else if (sumUpdated.compareTo(sumlastUpdated) == 0) {
			if (lastUpdated.size() < updated.size()) {
				lastUpdated.clear();
				lastUpdated = exchangeValue(updated);
			}
		}

		return lastUpdated;

	}

	// To discard reference issue exchanging map value to 
	public static LinkedHashMap<Integer, Integer> exchangeValue(LinkedHashMap<Integer, Integer> mavValue) {
		LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<Integer, Integer>();

		for (int key : mavValue.keySet()) {
			newMap.put(key, mavValue.get(key));
		}

		return newMap;
	}

	// Getting sum using bigInteger
	public static BigInteger getSum(Map<Integer, Integer> mapValue) {
		BigInteger sum = BigInteger.valueOf(1);
		for (int key : mapValue.keySet()) {
			sum = sum.add(BigInteger.valueOf(mapValue.get(key)));
		}

		return sum;
	}

	//Getting ArrayList from array
	public static ArrayList<Integer> getArryaListFromArray(int arr[]) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			arrayList.add(arr[i]);
		}

		return arrayList;
	}

	public static void main(String[] args) {

		// 1, 2, 5, -7, 2, 3, 1967513926,
		// 1540383426, -1303455736, -521595368
		// 756898537, -1973594324, -2038664370, -184803526, 1424268980
		int arr[] = new int[] { 18770, 40251, -5869, 72469, -8172, -52125, -98850, 11243, 25869, 41394, 26392, -9524,
				39519, -81562, 3725, 5949, 37322, 60093, -85122, 26366, 71023, -66639 };

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList = getArryaListFromArray(arr);

		ArrayList<Integer> resArrayList = maxset(arrayList);

		for (int val : resArrayList)
			System.out.print(val + " ");

	}

}
