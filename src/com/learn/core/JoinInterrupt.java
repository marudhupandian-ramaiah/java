package com.learn.core;

public class JoinInterrupt {
	
	public static void main(String args[]) {
		
		Thread t1 = new Thread( new Task(), "t1");
		Thread t2 = new Thread( new Task(), "t2");
		Thread t3 = new Thread( new Task(), "t3");
		
		t2.start();
		
		try {
			
			// interrupt wont happen as t2 task will be completed before 6000 ms
			t2.join(6000);
			t2.interrupt();
			System.out.println(t2.getName()+" interrupted ? "+t2.isInterrupted());
			
			
			// interrupt will happen as t3 task cant get over by 1000 ms
			t1.start();
			t3.start();
			t3.join(1000);
			t3.interrupt();
			System.out.println(t3.getName()+" interrupted ? "+t3.isInterrupted());
	
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			
			System.out.println(Thread.currentThread().getName()+" started");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			System.out.println(Thread.currentThread().getName()+" completed");
		}
		
	}

}

