package com.learn.core;

public class ReachableArrayDemo {

	public static void main(String[] args) {

		int[] inputArr = { 1, 1, 2, 0, 0, 0, 2, 9 };
		System.out.println(isReachable(inputArr));

	}

	public static boolean isReachable(int[] arr) {

		int reachable = 0;
		int size = arr.length;

		for (int i = 0; i < size; i++) {

			if (reachable < i) {
				return false;
			}

			reachable = Math.max(reachable, i + arr[i]);
		}

		return true;
	}

}
