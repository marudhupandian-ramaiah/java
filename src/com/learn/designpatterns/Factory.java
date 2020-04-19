package com.ericsson.dp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factory {
	
	private Factory( ) {
	}
	
	public static Factory getFactory( ) {
		Factory obj=new Factory();
		return obj;
	}
}

class FactoryTest {
	public static void main(String[] args) {
		
		//Trying to validate threads from pool were taken out for processing without any order
		ExecutorService service=Executors.newFixedThreadPool(10);
		for(int x=0;x<20;x++) {
			service.execute(new MyRunnable());
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
			Factory obj=Factory.getFactory();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--Factory obj ref :"+obj);
	}
	
}
