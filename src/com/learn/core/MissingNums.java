package com.learn.core;

import java.util.BitSet;

public class MissingNums {
	public static void main(String[] args) {
		int[] dataArr= {1,2,3,4,6,7,8,9};
		int n=9;
	
		//UsingBitSet
		printMissingNo(dataArr,n);
		
		
	}
	
	private static void printMissingNo(int[] arr,int n) {
		int missingNoCnt=n-arr.length;
		BitSet bitSet=new BitSet(n);
		
		for(int a:arr) {
			bitSet.set(a-1);
		}
		
		int lastMissingIndex=0;
		for(int i=0;i<missingNoCnt;i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println("bit : "+lastMissingIndex+"-value : "+(++lastMissingIndex));
		}
	}
}
