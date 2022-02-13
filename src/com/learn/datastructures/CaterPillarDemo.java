package com.learn.core;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class CaterPillarDemo {

	public static void main(String[] args) {

		int noOfLeaves = 10;
		int jumpingPattern[] = { 2, 3, 4 };
		BitSet leaves = new BitSet(10);
		Set<Integer> eatenList = new HashSet<>();
		Set<Integer> unEatenList = new HashSet<>();

		for (int arr : jumpingPattern) {
			System.out.println("cater pillar jumping pattern " + arr);

			for (int x = 1; x <= noOfLeaves; x++) {

				if (x % arr == 0) {
					System.out.println("cater pillar sits at index " + x);
					leaves.set(x);
					eatenList.add(x);

				}
			}
			//System.out.println(eatenList.toString());

		}

		System.out.println("Consolidated locations used by cater pillar to sit : " + leaves.toString());

		int uneaten = noOfLeaves - eatenList.size();
		System.out.println("total leaves : " + noOfLeaves + " , eaten leaves : " + eatenList.size()
				+ " , uneaten leaves : " + uneaten);

		int index = 1;
		for (int y = 1; y <= uneaten; y++) {
			index = leaves.nextClearBit(index);
			unEatenList.add(index++);
		}
		
		System.out.println("un eaten leaves : "+unEatenList.toString());

	}

}
