package org.amit.Stack;

import java.util.Stack;

public class solvePostfixExpression {

	static void solveExpression(String exp)
	{
		Stack<Integer> sc= new Stack<Integer>();
		
		for (int i=0;i<exp.length();i++)
		{  char a=exp.charAt(i);
			
			if(Character.isDigit(a))
			{
				sc.push(a-'0');
			}
			else {
				int x=sc.pop();
				int y=sc.pop();
				int val=evalucate(x,y,a);
				sc.push(val);
			}
			
		}
		
		System.out.println(sc.pop());
	}
	
	private static int evalucate(int x, int y, char a) {
		// TODO Auto-generated method stub
		switch(a) {
		case '+':
			return x+y;
		
		case '-':
			return y-x;
		case '*':
			return x*y;
		case '/':
			return y/x;
		default:
			return 0;
		}
		
	}

	public static void main(String[] args) {
		String exp="231*+9-";
		solveExpression(exp);
	}
}
