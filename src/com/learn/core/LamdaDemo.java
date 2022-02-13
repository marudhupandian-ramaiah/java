package com.learn.core;


public class LamdaDemo {
	
	public static void main(String[] args) {
		
		
		// Anonymous class
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Hello from run method of anonymous class");
				
			}
			
		};
		
		Thread t = new Thread(r);
		t.start();
		
		// Lambda expression		
		Runnable s = () -> {
		
			System.out.println("Hello from run method of lambda");
			
		};
		
		Thread q = new Thread(s);
		q.start();
		
	}

}


