package com.learn.designpatterns;
/*
 * ########################################## Template Design Pattern #################################################### 
 * Template pattern, exposes an abstract class(Game) along with template method (play).
 * Subclasses (Cricket, Football) that extends that abstract class(Game), should have its own implementation.
 * Client application (TemplateDemo), that tries to make use of those subclasses(Cricket , Football), should make a CALL
 * only through template method (play) available in abstract class (Game) which is final, that is can not be overridden.
 * ***********************************************************************************************************************
 */
public class Template {

	public static void main(String[] args) {
		
		System.out.println("#################### Template DP ###################");
		Game c=new Cricket();
		c.play();
		
		Game f=new Football();
		f.play();
	}
}

abstract class Game {
	
	//To be overridden
	abstract void initialize();
	abstract void startGame();
	abstract void stopGame();
	
	//Template method
	public final void play() {
		initialize();
		startGame();
		stopGame();
	}
}

class Cricket extends Game {

	@Override
	void initialize() {
		System.out.println("Cricket : initialize");
	}

	@Override
	void startGame() {
		System.out.println("Cricket : start play");
	}

	@Override
	void stopGame() {
		System.out.println("Cricket : stop play");
	}
}


class Football extends Game {

	@Override
	void initialize() {
		System.out.println("Football : initialize");
	}

	@Override
	void startGame() {
		System.out.println("Football : start play");
	}

	@Override
	void stopGame() {
		System.out.println("Football : stop play");
	}
}
