package com.learn.core;

public class OddEvenThreadsWithWait {

	public static void main(String[] args) {
		
	    Workers worker = new Workers();
			
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		},"Odd");
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			
		},"Even");
		
		t1.start();
		t2.start();
		
	}
	
	static class Workers {
		
	   int counter=1;
		
		public void printOdd() throws InterruptedException {
			
			synchronized(this) {	
				
				while(counter<10) {
					
					while(counter%2==0) {
						this.wait();
					}
					
					System.out.println(Thread.currentThread().getName()+"-"+counter++);
					this.notify();
				}
			}
	
		}
		
		public void printEven() throws InterruptedException {
			
			synchronized(this) {
				
				while(counter<10) {
				
					while(counter%2==1) {
						this.wait();
					}
					
					System.out.println(Thread.currentThread().getName()+"-"+counter++);
					this.notify();
				}
				
			}
			
			
		}
		
	}

}



