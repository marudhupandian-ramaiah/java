package com.learn.core;

public final class Immutable {
	final String name;
	final int id;
	
	Immutable(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}

class ImmutableTest {
	public static void main(String[] args) {
		Immutable obj1=new Immutable("A", 1);
		System.out.println("Object A:"+obj1);
	}
}