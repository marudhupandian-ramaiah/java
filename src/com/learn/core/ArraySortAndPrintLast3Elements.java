package com.learn.core;

import java.util.Arrays;

public class ArraySortAndPrintLast3Elements {

	public static void main(String[] args) {
		
		int[] arr = {20,10,14,11,17,16};
		
		Arrays.sort(arr);
		
		int size = arr.length;
		System.out.println("array : "+Arrays.toString(arr));
		System.out.println("top 3 : "+arr[size-1]+","+arr[size-2]+","+arr[size-3]);

	}

}
