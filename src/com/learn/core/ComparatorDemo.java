package com.learn.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {

		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(3, "Peter", 5000));
		empList.add(new Emp(6, "Joel", 3000));
		empList.add(new Emp(1, "Karen", 6000));
		empList.add(new Emp(2, "Haul", 2000));
		empList.add(new Emp(5, "Cath", 4000));
		empList.add(new Emp(8, "John", 7000));
		empList.add(new Emp(4, "Mat", 1000));
		empList.add(new Emp(7, "Alex", 8000));

		System.out.println("before sort : " + empList.toString());

		Comparator<Emp> usingId = Comparator.comparing(Emp::getId);
		Collections.sort(empList, usingId);
		System.out.println("sort with id: " + empList.toString());

		Comparator<Emp> usingName = Comparator.comparing(Emp::getName);
		Collections.sort(empList, usingName);
		System.out.println("sort with name: " + empList.toString());

		Comparator<Emp> groupIdSalary = Comparator.comparing(Emp::getId).thenComparing(Emp::getSalary);
		Collections.sort(empList, groupIdSalary);
		System.out.println("sort with id and salary: " + empList.toString());

		empList.sort(usingId.reversed());
		System.out.println("after reverse : " + empList.toString());

		Comparator<Emp> tmpComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

	}

}

class Emp {

	private int id;
	private String name;
	private int salary;

	public Emp(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
