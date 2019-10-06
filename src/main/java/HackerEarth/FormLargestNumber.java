package HackerEarth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormLargestNumber {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();

		// output should be 6054854654
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		printLargest(arr);
	}

	private static void printLargest(List<String> arr) {

		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;

				return s1.compareTo(s2) > 0 ? -1 : 1;
			}

		});
		
		for(String s: arr) {
			System.out.print(s+"");
		}

	}

}
