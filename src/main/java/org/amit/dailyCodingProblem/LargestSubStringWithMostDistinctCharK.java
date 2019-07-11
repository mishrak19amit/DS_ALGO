package org.amit.dailyCodingProblem;

import java.util.HashSet;
import java.util.Set;

public class LargestSubStringWithMostDistinctCharK {

	private static String maxSubString = "";

	public static void main(String[] args) {
		String s = "abcbaaaacb";
		int k = 2;

		getLargestSubWithKDistinctChar(s, k);
		System.out.println(maxSubString);

	}

	private static void getLargestSubWithKDistinctChar(String s, int k) {

		if (s.length() == 0)
			return;
		if (isCharCountisK(s, k)) {
			if(maxSubString.length()<s.length()) {
				maxSubString = s;
			}
			
		}

		getLargestSubWithKDistinctChar(s.substring(0, s.length() - 1), k);
		getLargestSubWithKDistinctChar(s.substring(1, s.length()), k);

	}

	private static boolean isCharCountisK(String s, int k) {

		Set<Character> setChar = new HashSet<>();

		for (char c : s.toCharArray()) {
			setChar.add(c);
		}

		return (setChar.size() == k);

	}

}
