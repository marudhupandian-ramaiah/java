package com.learn.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListStringToInteger {

	public static void main(String[] args) {

		List<String> arrayList = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

		List<Integer> convertedOne = arrayList.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		System.out.println("After conversion :" + convertedOne.toString());

	}

}
