package com.learn.core;

import java.util.HashSet;
import java.util.Set;

public class UniqueElementsSum {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 5, 2, 1, 3, 4, 1, 3, 2, 1 };
		int k = 6; // sum of any unique 3 elements

		Set<String> set=checkPairs(k, arr);
		System.out.println("output:"+set.toString());
		System.out.println("size:"+set.size());
		
	}

	private static Set<String> checkPairs(int k, int[] arr) {

		Set<String> set = new HashSet<>();
		for (int x = 0; x < arr.length; x++) {

			for (int y = x + 1; y < arr.length; y++) {

				for (int z = y + 1; z < arr.length; z++) {

					if (arr[x] + arr[y] + arr[z] == k) {
						set.add(arr[x] + "," + arr[y] + "," + arr[z]);
					}
				}

			}

		}
		return set;
	}

}
