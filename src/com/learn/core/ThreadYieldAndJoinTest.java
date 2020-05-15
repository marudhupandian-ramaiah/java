package com.learn.core;

/**
 * 
 * Yield - Stops currently running thread and let other threads to run.
 * 
 * Join - Let current Thread complete its task and then execute.
 *
 */
public class ThreadYieldAndJoinTest {

	public static void main(String[] args) throws InterruptedException {

		// Producer with less priority and consumer with high priority
		// Thread with high priority expected to complete its run first
		System.out.println("************* Without yield ****************");
		withoutYield();

		Thread.sleep(1000);
		System.out.println("************* With Yield ****************");

		// Producer thread to give control to Consumer and consumer to producer.
		// Current thread will give control to other threads to run
		withYield();

		Thread.sleep(1000);
		System.out.println("************* Without Join ****************");

		// All thread run in parallel without join
		withoutJoin();

		Thread.sleep(1000);
		System.out.println("************* With Join ****************");

		// Join let the thread complete its work on which its called
		withJoin();

	}

	/**
	 * t1 and t2 will run in parallel
	 */
	private static void withoutJoin() {

		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Doing Thread-1 task");
				try {
					System.out.println("Thread-1 sleeps");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Done with Thread-1 task");
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				System.out.println("Doing Thread-2 task");
			}
		};

		t1.start();
		t2.start();

	}

	/**
	 * t1 will finish first and then given chance to t2 as join is called on t1 ie
	 * when join called on particular thread it will let other threads wait until it
	 * finishes it work
	 * 
	 * @throws InterruptedException
	 */
	private static void withJoin() throws InterruptedException {

		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Doing Thread-1 task");
				try {
					System.out.println("Thread-1 sleeps");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Done with Thread-1 task");
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				System.out.println("Doing Thread-2 task");
			}
		};

		t1.start();
		t1.join();
		t2.start();

	}

	/**
	 * High priority thread, ie t1 will complete all its 5 iterations first Then t2
	 * will continue the process
	 */
	public static void withoutYield() {

		Thread t1 = new Thread() {
			public void run() {
				for (int x = 0; x < 5; x++) {
					System.out.println("Produced item : " + x);
				}
			}
		};
		t1.setPriority(Thread.MAX_PRIORITY);

		Thread t2 = new Thread() {
			public void run() {
				for (int x = 0; x < 5; x++) {
					System.out.println("Consumed item : " + x);
				}
			}
		};
		t2.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();

	}

	/**
	 * t1 starts and then gives control to t2. t2 then gives back to t1.
	 */
	public static void withYield() {

		Thread t1 = new Thread() {
			public void run() {
				for (int x = 0; x < 5; x++) {
					System.out.println("Produced item : " + x);
					Thread.yield();
				}
			}
		};
		t1.setPriority(Thread.MAX_PRIORITY);

		Thread t2 = new Thread() {
			public void run() {
				for (int x = 0; x < 5; x++) {
					System.out.println("Consumed item : " + x);
					Thread.yield();
				}
			}
		};
		t2.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();

	}
}