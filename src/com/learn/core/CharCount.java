package com.learn.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CharCount {

	public static void main(String[] args) {
		
		
		String input = "Programming";
		char[] inputArr = input.toCharArray();

		Map<Character,Integer> countMap = new HashMap<>();		
		for(char c:inputArr) {
			
			if(countMap.containsKey(c)) {
				countMap.put(c, countMap.get(c)+1);
			} else {
				countMap.put(c, 1);
			}
			
		}
		
		System.out.println("map : "+countMap.toString());

		Set<Entry<Character,Integer>> charEntrySet = countMap.entrySet();
		for(Entry<Character,Integer> entry:charEntrySet) {
			
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
		
	}

}
