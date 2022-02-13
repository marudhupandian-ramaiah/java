package com.learn.core;

public class JoinTest {
	
	public static void main(String args[]) {
		
		Thread t1 = new Thread( new Task(), "t1");
		Thread t2 = new Thread( new Task(), "t2");
		
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+" started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		System.out.println(Thread.currentThread().getName()+" completed");
	}
	
}