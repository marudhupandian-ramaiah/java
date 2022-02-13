package com.learn.core;

import java.util.Arrays;
import java.util.List;

public class MoveMaxRepeatedElementToArrayLast {

	public static void main(String[] args) {

		Integer[] arr = { 4, 5, 6, 4, 5, 6, 1, 6, 2 };

		List<Integer> list = Arrays.asList(arr);

		list.stream().distinct().forEach(System.out::println);

		int indexFilled = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 6) {

				arr[indexFilled] = arr[i];
				indexFilled++;
			}
		}

		while (indexFilled < arr.length) {

			arr[indexFilled] = 6;
			indexFilled++;

		}
		System.out.println(Arrays.toString(arr));

	}

}
