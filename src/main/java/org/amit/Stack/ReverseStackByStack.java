package org.amit.Stack;

import java.util.Stack;

public class ReverseStackByStack {

	public static void sortStack(Stack<Integer> sc) {

		if (sc.isEmpty())
			return;
		int temp = sc.pop();
		sortStack(sc);
		pushInStack(sc, temp);

	}

	public static void pushInStack(Stack<Integer> sc, int data) {

		if (sc.isEmpty() || sc.peek() <= data)
			sc.push(data);
		else {
			int temp = sc.pop();
			pushInStack(sc, data);
			sc.push(temp);
		}
	}

	static void printstak(Stack<Integer> sc) {
		Stack<Integer> scDup = sc;
		while (!scDup.isEmpty()) {
			System.out.println(scDup.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> sc = new Stack<Integer>();
		sc.push(4);
		sc.push(3);
		sc.push(10);
		sc.push(8);
		sc.push(7);
		sc.push(15);
		sc.push(14);
		sc.push(13);
		// System.out.println("");
		// printstak(sc);
		sortStack(sc);
		System.out.println("");
		printstak(sc);
	}

}
