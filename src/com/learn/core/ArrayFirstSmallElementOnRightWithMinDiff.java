package com.learn.core;

public class ArrayFirstSmallElementOnRightWithMinDiff {

	public static void main(String[] args) {

		int[] array = { 13, 7, 6, 12 };

		int small = 0;
		boolean isSmallFound = false;
		int diff = 0;
		int min = 0;

		for (int x = 0; x < array.length; x++) {

			isSmallFound = false;
			small = array[x];

			for (int j = x + 1; j < array.length; j++) {

				if (array[j] < array[x]) {

					diff = array[x] - array[j];

					if (diff < min) {
						small = array[j];
						isSmallFound = true;
						break;
					} else
						min = diff;

				}
			}

			if (!isSmallFound) {
				small = -1;
			}

			System.out.println(array[x] + "-small element : " + small);

		}

	}

}
