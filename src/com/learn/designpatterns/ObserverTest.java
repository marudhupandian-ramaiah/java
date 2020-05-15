package com.learn.designpatterns;

import java.util.ArrayList;

public class Observer {

	public static void main(String[] args) {
		Loan l=new Loan("Persoanl",13.5f);
		l.addObserver(new NewsPaper());
		l.addObserver(new TV());
		l.addObserver(new Wallposters());
		
		l.setRate(9.8f);
	}
}

interface Observer {
	public void update(float rate);
}

interface Observable {
	public void addObserver(Observer o);
	public void deleteObserver(Observer o);
	public void notifyObservers();
}

class Loan implements Observable {

	private ArrayList<Observer> observer=new ArrayList<Observer>();
	private String type;
	private float rate;
	
	Loan(String type, float rate) {
		this.type=type;
		this.rate=rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
		notifyObservers();
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observer.add(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		observer.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
		for(Observer o:observer) {
			o.update(rate);
		}
	}
	
}

class NewsPaper implements Observer {

	@Override
	public void update(float rate) {
		System.out.println("NewsPapaer updated with rate : "+rate);
	}
}

class TV implements Observer {

	@Override
	public void update(float rate) {
		System.out.println("TV updated with rate : "+rate);
	}
}

class Wallposters implements Observer {

	@Override
	public void update(float rate) {
		System.out.println("Wallposters updated with rate : "+rate);
	}
}