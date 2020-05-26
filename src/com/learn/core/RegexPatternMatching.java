package com.learn.core;

import java.util.regex.Pattern;

/**
 * 
 * Match patterns using java.util.regex package
 *
 */
public class RegexPatternMatching {

	public static void main(String[] args) {

		// Pattern
		String regex = ".*hi.*";

		// Input string
		String input = "hellohihello";

		// Way 1
		System.out.println("Way 1 : Match status : " + Pattern.matches(regex, input));

		// Way 2
		System.out.println("Way 2 : Match status : " + Pattern.compile(regex).matcher(input).matches());

	}
}
