package org.amit.Stack;

import java.util.Stack;

public class InfixToPostfixExp {

	public static int prec(char c) {
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

	public static String convertInfinxToPostfix(String exp) {
		String res = "";
		Stack<Character> sc = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c))
				res += c;
			else if (c == '(') {
				sc.push(c);
			} else if (c == ')') {
				while (!sc.isEmpty() && sc.peek() != '(')
					res += sc.pop();
				if (sc.isEmpty())
					return "Invalid expression";
				else
					sc.pop();

			} else {
				while (!sc.isEmpty() && prec(c) <= prec(sc.peek())) {
					res += sc.pop();
				}
				sc.push(c);

			}
		}
		
		while(!sc.isEmpty())
			res+=sc.pop();

		return res;
	}

	public static void main(String[] args) {

		String exp = "a+b(c^d-e)^(f+g*h)-i";
		System.out.println(convertInfinxToPostfix(exp));

	}
}
