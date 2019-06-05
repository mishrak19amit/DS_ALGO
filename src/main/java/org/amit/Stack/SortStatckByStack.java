package org.amit.Stack;

import java.util.Stack;

public class SortStatckByStack {

	static void sortStack(Stack<Integer>sc) {
		if(!sc.isEmpty())
		{
			int x=sc.pop();
			sortStack(sc);
			pushSorted(x, sc);
		}
		
		
	}
	
	static void printstak(Stack<Integer>sc)
	{
		while(!sc.isEmpty()) {
			System.out.println(sc.pop());
		}
	}
	
	static void pushSorted(int x, Stack<Integer>sc )
	{
		if(sc.isEmpty()||sc.peek()<=x)
			sc.push(x);
		else {
			int p=sc.pop();
			pushSorted(x, sc);
			sc.push(p);
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
		//printstak(sc);
		sortStack(sc);
		System.out.println("");
		printstak(sc);
	}
}
