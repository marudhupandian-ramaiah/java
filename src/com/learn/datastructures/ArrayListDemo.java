package com.learn.core;

import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {

		MyList<Integer> list = new MyList<>(5);
		list.add(1);
		list.add(2);
		
		System.out.println("get index 1:"+list.get(1));
		
		list.add(3);
		list.add(4);

		System.out.println("size 1 :" + list.size());

		list.add(5);
		list.add(6);
		list.add(7);

		System.out.println("get index 4:"+list.get(4));
		System.out.println("size 2:" + list.size());

		list.remove(4);
		list.remove(7);

		System.out.println("size 3:" + list.size());

		list.remove(8);
		list.remove(9);
		list.remove(10);
		
		System.out.println("get index 2:"+list.get(2));
		
		System.out.println("size 4:"+list.size());
	
		
	}

}

class MyList<E> {

	private final static int default_capacity = 10;
	private Object[] elements;
	private int currentSize = 0;

	MyList() {
		elements = new Object[default_capacity];
		System.out.println("initialize --> size 10");
	}

	MyList(int initialSize) {

		elements = new Object[(initialSize > 0) ? initialSize : default_capacity];
		
		System.out.println("initialize -->" + initialSize);

	}

	// add
	public void add(E element) {

		if (currentSize == elements.length) {
			resizeMyList();
		}

		elements[currentSize++] = element;
		System.out.println("add -->" + Arrays.toString(elements));

	}

	// get
	public E get(int index) {

		if (index < 0 || index > currentSize)
			throw new ArrayIndexOutOfBoundsException();

		return (E) elements[index];
	}

	// remove
	public void remove(int index) {

		if(index<0 || index>elements.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		for (int x = index; x < currentSize-1; x++) {
			elements[x] = elements[x + 1];
		}
		elements[currentSize-1]=null;
		currentSize--;

		System.out.println("remove -->" + Arrays.toString(elements));

	}

	// size
	public int size() {
		return elements.length;
	}

	// ensure capacity
	private void resizeMyList() {

		int newSize = currentSize + (currentSize >> 1);
		elements = Arrays.copyOf(elements, newSize);

		System.out.println(
				"current size : " + currentSize + ", max capacity : " + newSize + ", list size : " + elements.length);
	}

}
