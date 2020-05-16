package com.learn.designpatterns;

/**
 * 
 * Factory patterns let you create object based on given input data as arguments
 *
 */
public class Factory {

	public static void main(String[] args) {

		// With dog
		Animal animal = AnimalFactory.getAnimal("dog");
		animal.printSound();

		// With cat
		animal = AnimalFactory.getAnimal("cat");
		animal.printSound();

	}
}

// Factory class
class AnimalFactory {

	public static Animal getAnimal(String name) {

		// crate object based on input
		if ("dog".equalsIgnoreCase(name))
			return new Dog();

		else if ("cat".equalsIgnoreCase(name))
			return new Cat();

		else
			return null;

	}

}

// abstract class
abstract class Animal {

	abstract void printSound();

}

// child classes that overrides the behaviour of parent class
class Dog extends Animal {

	@Override
	void printSound() {
		System.out.println("Dog - Bow bow");
	}

}

class Cat extends Animal {

	@Override
	void printSound() {
		System.out.println("Cat - Meow Meow");
	}

}
