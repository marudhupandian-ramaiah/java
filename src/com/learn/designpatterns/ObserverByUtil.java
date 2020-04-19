package com.learn.designpatterns;
import java.util.Observable;
import java.util.Observer;

public class ObserverByUtil {

	public static void main(String[] args) {
		
		Subject obj=new Subject("Science", 6532);
		System.out.println("Before change : "+obj.toString());
		
		obj.addObserver(new FrontEnd());
		obj.addObserver(new BackEnd());
		obj.setId(3241);
		System.out.println("After change : "+obj.toString());
	}
}

class Subject extends Observable {
	
	private String name;
	private int id;
	
	Subject(String n, int i) {
		this.name=n;
		this.id=i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers(this);
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", id=" + id + "]";
	}
}

class FrontEnd implements Observer {

	Subject s;
	
	@Override
	public void update(Observable o, Object arg) {
		s=(Subject) o;
		System.out.println("FrontEnd :"+o.toString()+"--"+s.getId());
	}
	
}

class BackEnd implements Observer {

	Subject s;
	
	@Override
	public void update(Observable o, Object arg) {
		s=(Subject) o;
		System.out.println("BackEnd :"+o.toString()+"--"+s.getId());
	}
	
}