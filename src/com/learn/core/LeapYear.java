package com.learn.core;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {


		System.out.println("Enter the year : ");
		@SuppressWarnings("resource")
		int year = (new Scanner(System.in)).nextInt();
		
		isLeapYear(year);

	}
	
	static void isLeapYear(int year) {
		
		if(year%400==0 || (year%4==0 && year%100!=0)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
	}

}
