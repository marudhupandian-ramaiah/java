package com.learn;

/**
 * 
 * Deadlock occurs when two or more threads waiting for each other to release
 * the shared resources they are holding. Here t1 locks sharedObject1 and
 * waiting for sharedObject2. At the same time t2 locks sharedObject2 before t1
 * does and waiting for t1 to release sharedObject1.
 * 
 * Note : To solve deadlock access shared resources in sequence order. For
 * example t1 access sharedObject1 first and sharedObject2 next. t2 also should
 * follow same sequence.
 *
 */
public class DeadLock {

	static String sharedObject1 = "object-1";
	static String sharedObject2 = "object-2";

	public static void main(String[] args) {

		// t1 locks sharedObject1 and then try to lock sharedObject2
		Thread t1 = new Thread() {

			public void run() {

				synchronized (sharedObject1) {
					System.out.println(Thread.currentThread().getName() + "-Locked object 1");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (sharedObject2) {
						System.out.println(Thread.currentThread().getName() + "-Going to lock object 2");
					}
				}

			}
		};

		// t2 locks sharedObject2 and then tries for sharedObject1
		Thread t2 = new Thread() {
			public void run() {

				synchronized (sharedObject2) {
					System.out.println(Thread.currentThread().getName() + "-Locked object 2");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (sharedObject1) {
						System.out.println(Thread.currentThread().getName() + "-Going to lock object 1");
					}
				}

			}
		};

		t1.start();
		t2.start();
	}
}
