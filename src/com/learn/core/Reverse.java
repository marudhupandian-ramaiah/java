package com.learn.core;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		
		System.out.println("enter input :");
		String text = (new Scanner(System.in)).next();
		String reverse = "";
		
		for(int x=text.length()-1;x>=0;x--) {	
			reverse = reverse + text.charAt(x);		
		}
		System.out.println("reversed string :"+reverse);
	}

}
