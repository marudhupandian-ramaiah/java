package com.ericsson.dp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Singleton implements Serializable, Cloneable {

	//private static final long serialVersionUID=1L;
	private static Singleton obj;
	
	private Singleton() {
		if(obj!=null)
			try {
				throw new InstantiationError("New object not allowed");
			} catch (InstantiationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//broken code
	/*protected Object clone() throws CloneNotSupportedException {
			return super.clone();
	}*/
	
	//throw exception
	/*protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}*/
	
	//return obj
	protected Object clone() throws CloneNotSupportedException {
		return obj;
	}
	
	public static Singleton getSingleton() {
		if(obj==null) {
			synchronized (Singleton.class) {
				if(obj==null) {
					obj=new Singleton();
				}
			}
		}
		return obj;
	}
	
	protected Object readResolve() {
		return obj;
	}
}

class SingletonTest {

	public static void main(String[] args) {
		
		//To check same reference on continuous requests
		for(int x=0;x<10;x++) {
			Singleton obj=Singleton.getSingleton();
			System.out.println("Singleton object ref :"+obj+"--hashcode:"+obj.hashCode());
		}
		
		//Break Singleton using Reflection
		Constructor[] cons=Singleton.class.getDeclaredConstructors();
		for(Constructor con:cons) {
			try {
				con.setAccessible(true);
				Singleton obj=Singleton.getSingleton();
				Singleton obj1=(Singleton) con.newInstance();
				System.out.println("Hashcode before and after refelection:"+obj.hashCode()+"--"+obj1.hashCode());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Break singleton using serialization
		try {
			Singleton outObj=Singleton.getSingleton();
			
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("output.txt"));
			out.writeObject(outObj);
			out.close();
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("output.txt"));
			Singleton inObj=(Singleton) in.readObject();
			in.close();
			
			System.out.println("Hashcode while write : "+outObj.hashCode()+",while write : "+inObj.hashCode());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		
		
		//Break singleton using clone
		Singleton o=Singleton.getSingleton();
		try {
			Singleton d=(Singleton) o.clone();
			System.out.println("Cloning : hashcode of objects :"+o.hashCode()+","+d.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
