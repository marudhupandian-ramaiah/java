package com.learn.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 * Asynch sample using CompletableFuture
 *
 */
public class CompletableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "hello").thenApply(str -> str.toUpperCase());

		System.out.println("Result : " + cf.get());

	}

}
