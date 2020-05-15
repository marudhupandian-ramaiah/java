package com.learn.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Write comparator for custom class for both ascending and descending order
 *
 */
public class ComparatorWithOrder {

	public static void main(String[] args) {

		Student s1 = new Student("X", 1000, "IT");
		Student s2 = new Student("A", 9000, "BM");
		Student s3 = new Student("T", 4000, "CS");
		Student s4 = new Student("C", 6000, "MC");

		List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

		System.out.println("\n\n############### Using id ##############");
		System.out.println("------ Descending Order -------");
		// Sort in descending order
		Collections.sort(studentList, new StudentComparator());
		System.out.println(studentList.toString());

		// Ascending order
		Collections.reverse(studentList);
		System.out.println("------ Ascending Order -------");
		System.out.println(studentList.toString());

		System.out.println("\n\n############### Using department ##############");
		System.out.println("------ Descending Order -------");
		// Sort in descending order using java 8 lambda
		Collections.sort(studentList, (a, b) -> b.getDepartment().compareTo(a.getDepartment()));
		System.out.println(studentList.toString());

		// Ascending order
		Collections.reverse(studentList);
		System.out.println("------ Ascending Order -------");
		System.out.println(studentList.toString());

	}

}

class Student {

	private String name;
	private Integer id;
	private String department;

	public Student(String name, Integer id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", department=" + department + "]";
	}

}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
