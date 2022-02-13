package com.learn.core;

import java.util.HashMap;
import java.util.Map;

public class ArrayRemoveDuplicatesAndKeepFirstCaseSensitive {

	public static void main(String[] args) {

		Character[] charArr = new Character[] { 'a', 'A', 'C', 'Z', 'b', 'B', 'd', 'E', 'z' };

		Map<Character, Integer> myMap = new HashMap<>();

		for (Character char1 : charArr) {

			if (myMap.get(char1) != null || myMap.get(Character.toUpperCase(char1)) != null
					|| myMap.get(Character.toLowerCase(char1)) != null) {
				// System.out.print("");
			} else {
				myMap.put(char1, 1);
				System.out.print(char1 + ",");
			}
		}

	}

}
