package com.learn.core;

public class LinkedListDemo<E> {

	private Node head;
	private Node tail;
	
	public static void main(String[] args) {

		LinkedListDemo<Integer> list = new LinkedListDemo<>();
		
		// add data
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		// get at index 2 and 0
		list.get(2);
		list.get(0);
		
		// print list
		list.print();
		
		// size of list
		list.size();
		
		// remove
		list.remove(2);
		list.size();
		list.print();
		
		list.add(5);
		list.add(6);
		list.remove(4);
		
		//post removal
		list.size();
		list.print();
		
		list.reverse();
		
	}
	
	// add
	public void add(E data) {
		
		Node newNode = new Node(data);
		
		if(head==null) {
			
			head = newNode;
			tail = newNode;
			
		} else {
			tail.next=newNode;
			tail = newNode;
		}
	
	}
	
	// get
	public void get(int index) {
		
		if(index < 0) {
			return;
		}
		
		Node currentNode = head;
		
		for(int i=0;i<index;i++) {
			currentNode = currentNode.next;
		}
		System.out.println("value at position "+index+" is "+currentNode.data);
		
	}
	
	public void reverse() {
		
		Node currentNode = head;
		Node prevNode=null;
		
		while(currentNode!=null) {	
			prevNode=currentNode;
			prevNode.next=null;
			currentNode = currentNode.next;
			prevNode.next=currentNode;
			currentNode.next=prevNode;
			
		}
		print();
	}
	
	// size
	public void size() {
		
		Node currentNode = head;
		int count=0;
		
		while(currentNode!=null) {
			count++;
			currentNode=currentNode.next;
		}
		
		System.out.println("size of list : "+count);
	}
	
	// remove
	public void remove(int index) {
		
		Node currentNode = head;
		Node prevNode = null;
		 
		for(int j=0;j<index;j++) {
			
			prevNode = currentNode;
			currentNode = currentNode.next;
			
		}
		System.out.println("value removed at index "+index+" is "+currentNode.data);
		prevNode.next=currentNode.next;
		
	}
	
	// print
	public void print() {
		
		Node currentNode = head;
		
		if(head==null) {
			System.out.println("list is empty");
			return;
		}
		
		System.out.println("list data as below,");
		while(currentNode!=null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
		
	}	

}

class Node<E> {
	
	E data;
	Node<E> next;
	
	Node(E data) {
		this.data=data;
		this.next=null;
		
	}
		
}

