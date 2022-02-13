package com.learn.core;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(2);
		System.out.println("Array list with dumplicates : " + arrayList.toString());

		Set<Integer> set = new LinkedHashSet<>(arrayList);
		System.out.println("Set without duplicates : " + set.toString());

		arrayList.clear();
		arrayList.addAll(set);
		System.out.println("ArrayList without duplicates : " + arrayList.toString());

	}

}
