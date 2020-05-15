package com.learn.core;

/**
* Inner class can access private, protected, public, default, static members of outer class 
* Whereas static inner class can access only static members of outer class. 
**/
public class NestedClassExample {

	public static void main(String[] args) {

		/**********************
		 * Access Inner Class Method
		 ******************************/
		// create object of outer class and then inner class
		OuterClass.InnerClass innerObj = new OuterClass().new InnerClass();

		// access inner class method using inner class object
		innerObj.printValuesFromOuterClass();

		/*******************
		 * Access Static Inner Class Method
		 **************************/
		// create object of outer class
		OuterClass.StaticInnerClass staticInnerObj = new OuterClass.StaticInnerClass();

		// access inner class static method
		staticInnerObj.printValuesFromOuterClass();

	}

}

class OuterClass {

	// outer class variables
	private String outer_private_type = "private type variable of outer class";
	static int outer_static_type = 99;

	class InnerClass {

		// access outer class variables
		private String inner_private_type = outer_private_type;
		int inner_static_type = outer_static_type;

		// print values of outer class variables by setting into inner class
		void printValuesFromOuterClass() {

			System.out.println("inner-class -----> private type : " + inner_private_type + "," + "static type : "
					+ inner_static_type);

		}
	}

	static class StaticInnerClass {

		// access outer class variables
		int inner_static_type = outer_static_type;

		// print outer class variables
		void printValuesFromOuterClass() {

			System.out.println("static-inner-class -----> static type : " + inner_static_type);
		}
	}

}
