package com.learn.core;

public class JoinOrder {
	
	public static void main(String args[]) {
		
		Task t1 = new Task(1,10,"t1");
		Task t2 = new Task(11,20,"t2");
		Task t3 = new Task(21,30,"t3");
		Task t4 = new Task(31,40,"t4");
	
		
		try {
			t1.start();
			t1.join();
			
			t2.start();		
			t2.join();
			
			t3.start();		
			t3.join();
			
			t4.start();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static class Task extends Thread {
		
		int x;
		int y;
		String name;
		
		Task(int x,int y, String name) {
			this.x=x;
			this.y=y;	
			this.name=name;
		}
		
		@Override
		public void run() {
			System.out.println(name+" started");
				for(int i=x;i<=y;i++) {
					System.out.println("value:"+i);
				}

			System.out.println(name+" completed");
		}
		
	}

}




