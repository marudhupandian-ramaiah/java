package com.learn.core;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesesDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter expression with parantheses to validate : ");
		String inputExpr = scanner.nextLine();

		System.out.println("Is expression balanced ? " + isBalanced(inputExpr));

	}

	static boolean isBalanced(String exp) {

		Stack<Character> stack = new Stack<>();

		for (char x = 0; x < exp.length(); x++) {

			char inputChar = exp.charAt(x);

			if (inputChar == '(' || inputChar == '[' || inputChar == '{') {

				stack.push(inputChar);
			}

			if (inputChar == ')' || inputChar == ']' || inputChar == '}') {

				if (stack.isEmpty()) {
					return false;
				}

				char topChar = stack.peek();

				if (inputChar == ')' && topChar == '(' || inputChar == ']' && topChar == '['
						|| inputChar == '}' && topChar == '{') {
					stack.pop();
				}
			}
		}
		return stack.isEmpty() ? true : false;
	}

}
