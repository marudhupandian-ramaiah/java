package com.ericsson.dp;

enum SingleEnum {
	instance;
	
	public void printMsg() {
		System.out.println("Enum");
	}
}

public class SingletonEnum {
	public static void main(String[] args) {
		SingleEnum.instance.printMsg();
		
		System.out.println("Object reference :"+SingleEnum.instance.hashCode());
	}
}