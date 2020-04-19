package com.learn.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Object> sharedQ=new LinkedBlockingDeque<>();
		
		Thread p=new Thread(new Producer(sharedQ));
		Thread c=new Thread(new Consumer(sharedQ));
		
		p.start();
		c.start();
		
		try {
			Thread.sleep(10000);
			//sharedQ.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {
	
	private final BlockingQueue<Object> prodQ;
	
	Producer(BlockingQueue<Object> p) {
		prodQ=p;
	}
	
	public void run() {
		
		for(int i=0;i<6;i++) {
			try {
				prodQ.put(i);
				System.out.println("Produced : " +i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	
	private final BlockingQueue<Object> consQ;
	
	Consumer(BlockingQueue<Object> c) {
		consQ=c;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Consumed : " +consQ.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}