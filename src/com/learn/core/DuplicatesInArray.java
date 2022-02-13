package com.learn.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatesInArray {

	public static void main(String[] args) {
	
		// input
		Integer arr[] = new Integer[] { 1, 2, 3, 1, 4, 5, 7, 8, 4, 9, 2 };

		// using set
		Set<Integer> set = new HashSet<>(Arrays.asList(arr));	
		
		// using stream
		List<Integer> usingStream=Arrays.asList(arr).stream().distinct().collect(Collectors.toList());
		
		// using map
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> uniqueList = new ArrayList<>();
		List<Integer> duplicateList = new ArrayList<>();
		for(Integer element : arr) {
			if(map.containsKey(element)) {
				map.put(element, map.get(element)+1);
				duplicateList.add(element);
			} else {
				map.put(element, 1);
				uniqueList.add(element);
			}
		}
		
		System.out.println("input array : "+Arrays.toString(arr));
		System.out.println("unique elements using HashSet : "+set.toString());
		System.out.println("unique elements using Streams : "+usingStream.toString());
		System.out.println("unique elements using Map : "+uniqueList.toString());
		System.out.println("duplicates found using Map : "+duplicateList.toString());
		
	
	}

}
