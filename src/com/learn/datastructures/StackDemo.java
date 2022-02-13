package com.learn.core;

public class StackDemo<E> {

	Node head=null;
	
	public static void main(String[] args) {
		
		StackDemo<Integer> stack = new StackDemo<>();
		
		System.out.println("adding elements,");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.print();
		
		System.out.println("\npop elements,");
		stack.pop();
		
		stack.print();
		
		stack.size();
	}
	
	// push
	public void push(int i) {
		
		Node newNode = new Node(i);
		Node prevHead = head;
		head = newNode;
		head.next = prevHead;
	}
	
	// pop
	public void pop() {
				
		head = head.next;
		
	}
	
	// size
	public void size() {
		
		Node currentNode = head;
		int count=0;
		
		while(currentNode!=null) {
			
			count++;
			currentNode = currentNode.next;
		}
		
		System.out.println("\nstack size "+count);
		
	}
	
	// print
	public void print() {
		
		Node currentNode = head;
		
		while(currentNode!=null) {
			
			System.out.print("<-"+currentNode.data);
			currentNode = currentNode.next;
			
		}
		
	}

	class Node<E> {
		
		E data;
		Node next;
		
		Node(E data) {
			
			this.data=data;
			this.next=null;
		}
		
	}

}
