package HackerEarth;

import java.util.ArrayList;
import java.util.List;

public class SubStringDP {

	private static List<String> subStringList = new ArrayList<String>();

	public static int getSubStringCount(String s) {

		if (s.length() == 0)
			return 0;

		int len = s.length();

		if (subStringList.contains(s)) {
			return getSubStringCount(s.substring(1)) + getSubStringCount(s.substring(0, len - 1));
		} else {
			subStringList.add(s);
			System.out.println(s);
			return 1 + getSubStringCount(s.substring(1)) + getSubStringCount(s.substring(0, len - 1));
		}

	}

	public static void main(String[] args) {
		String s = "kincenvizh";
		System.out.println("Sub Strings are below: ");
		int count = getSubStringCount(s);
		System.out.println();
		System.out.println("Total number of Sub String: " + count);
		subStringList.clear();
	}

}
