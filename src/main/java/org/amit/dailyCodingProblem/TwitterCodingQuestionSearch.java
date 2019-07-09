package org.amit.dailyCodingProblem;

class TrieNode {
	TrieNode[] childerenNode = new TrieNode[26];
	boolean leafNode;

	public TrieNode() {
		leafNode = false;

		for (int i = 0; i < 26; i++)
			childerenNode[i] = null;

	}
}

public class TwitterCodingQuestionSearch {

	static TrieNode root;

	public static void main(String[] args) {

		root = new TrieNode();

		String[] strArr = new String[] { "dog", "deer", "deal" };

		String qstr = "de";
		for (String s : strArr) {

			insertKey(s);

		}

		searchStr(qstr);

	}

	private static void searchStr(String qstr) {

		TrieNode crawl = root;

		for (int i = 0; i < qstr.length(); i++) {
			int index = qstr.charAt(i) - 'a';

			crawl = crawl.childerenNode[index];
		}

		printKeyWords(crawl, qstr, 0);

	}

	private static void printKeyWords(TrieNode crawl, String qStr, int count) {

		if (crawl.leafNode == true) {
			System.out.println(qStr);
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (crawl.childerenNode[i] != null) {
				qStr = clean(qStr, crawl.childerenNode, i);
				int b = i + 'a';
				char a = (char) b;
				qStr += a;

				printKeyWords(crawl.childerenNode[i], qStr, count++);

			}

		}

	}

	private static String clean(String qStr, TrieNode[] childerenNode, int i) {
		for (int j = 0; j < i; j++) {
			if (childerenNode[j] != null)
				qStr = qStr.substring(0, qStr.length() - 1);
		}

		return qStr;

	}

	private static void insertKey(String s) {
		int index;

		TrieNode pCrawl = root;

		for (int i = 0; i < s.length(); i++) {

			index = s.charAt(i) - 'a';
			if (pCrawl.childerenNode[index] == null) {
				pCrawl.childerenNode[index] = new TrieNode();
			}

			pCrawl = pCrawl.childerenNode[index];

		}

		pCrawl.leafNode = true;

	}

}
