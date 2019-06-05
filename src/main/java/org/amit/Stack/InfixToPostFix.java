package org.amit.Stack;

import java.util.Stack;

public class InfixToPostFix {

	static void infixToPostfix(String exp) {
		Stack<Character> sc = new Stack<Character>();
		String result = new String("");
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				result = result + c;
			}

			else if (c == '(')
				sc.push('(');
			else if (c == ')') {
				while (!sc.isEmpty() && sc.peek() != '(')
					result = result + sc.pop();
				if (!sc.isEmpty() && sc.peek() != '(')
					System.out.println("Invalid Expression!");
				else {
					sc.pop();
				}
			} else {
				while (!sc.isEmpty() && prec(c) <= prec(sc.peek()))
					result = result + sc.pop();
				sc.push(c);
			}

		}
		while(!sc.isEmpty())
			result=result+sc.pop();
		System.out.println(result);
	}

	static int prec(Character c) {
		switch (c) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}

	}

	public static void main(String[] args) {

		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		infixToPostfix(exp);

	}
}
