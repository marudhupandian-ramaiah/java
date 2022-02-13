package com.learn.core;

public class StringReverse {

	public static void main(String[] args) {

		String str = "Hello msg from software developer";
		System.out.println("input string :"+str);
		str = reverseRecursively(str);
		System.out.println("reversed string :"+str);
	}
	
	private static String reverseRecursively(String input) {
		
		if(input.length()<2) {
			System.out.println("returned input is :"+input);
			return input;
		}
		
		System.out.println("substring before recursive call :"+input.substring(1)+"--char at 0 :"+input.charAt(0));
		return reverseRecursively(input.substring(1))+input.charAt(0);
		
	}

}
