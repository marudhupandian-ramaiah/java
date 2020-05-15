package com.learn.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Threads that are printing the numbers in sequence order
 */
public class ThreadCounter {

	private static AtomicInteger counter = new AtomicInteger(0);
	private static int maxNo = 7;
	private static int noOfThreads = 3;

	public static void main(String[] args) {

		// Make no of thread with tasks
		for (int i = 0; i < noOfThreads; i++) {
			new Thread(new CountTask(i)).start();
		}

	}

	private static class CountTask implements Runnable {

		private final int position;

		public CountTask(int position) {
			this.position = position;
		}

		@Override
		public void run() {

			// All values starts with 0. So used max-1.
			while (counter.get() < (maxNo - 1)) {

				// Check whether Counter value % no of threads equals to thread's position
				if (counter.get() % noOfThreads == position) {
					System.out.println("#" + position + "--" + Thread.currentThread().getName() + "--"
							+ counter.incrementAndGet());
				}
			}
		}

	}

}
