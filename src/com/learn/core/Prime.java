package com.learn.core;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		int number= Integer.MAX_VALUE;
		
		while(number!=0) {
			number = scanner.nextInt();
			
			findPrime(number);
		}

	}
	
	static void findPrime(int number) {
		
		boolean isPrime=true;
		int sqrt = (int)Math.sqrt(number)+1;
		
		for(int i=2;i<sqrt;i++) {
			
			if(number%i==0) {
				isPrime=false;
				System.out.println(number+" is not a prime");
			} 
		}
		
		if(isPrime)
			System.out.println(number+" is a prime number");
	}

}
