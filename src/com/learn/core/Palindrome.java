package com.learn.core;

import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter input");
		int input = scanner.nextInt();
		
		checkIfPalindrome(input);

	}

	private static void checkIfPalindrome(int input) {

		int palindrome = input;
		int reverse = 0;
		
		while(palindrome!=0) {
			
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
			
		}
		
		if(reverse == input) {
			System.out.println("palindrome");
		} else {
			System.out.println("not plaindrome");
		}
		
	}

}
