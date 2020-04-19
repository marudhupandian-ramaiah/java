package com.learn.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachTest {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int x=0;x<5;x++)
			list.add(x);
		
		//Using iterator
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()) {
			System.out.println("Using Iterator:"+itr.next());
			//list.add(7);
		}
		
		//Anonymous class
		list.forEach(new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println("Anaonymous class:"+t);
			}
		});
		
		//Using individual class
		MyConsumer consumer=new MyConsumer();
		list.forEach(consumer);
		
		//Using lamda expression
		list.forEach(item -> System.out.println("Lamda expression:"+item));
		
		
		list.forEach(System.out::println);
	}

}

class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("Individual class:"+t);
	}
	
}
