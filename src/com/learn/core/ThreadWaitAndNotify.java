package com.learn.core;

/**
 * 
 * Wait method will be letting the current thread to wait until someone calls
 * notify method on the same monitor/object/resource.
 *
 */
public class ThreadWaitAndNotify {

	public static void main(String[] args) {

		String msg = "Hello";

		// t1 will wait until t2 calls notify on msg
		Thread t1 = new Thread() {

			public void run() {

				// Lock the msg object
				synchronized (msg) {

					try {
						System.out.println(Thread.currentThread().getName() + "-- Started waiting");

						// Thread waiting for t2 to release msg object
						msg.wait();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + "-- Waiting over");
					System.out.println(Thread.currentThread().getName() + "-- Msg read is : " + msg);

				}

			}
		};

		// t2 make t1 wait by sleeping and then gives control to t1 by calling notify
		Thread t2 = new Thread() {

			public void run() {

				// Lock the msg object
				synchronized (msg) {

					try {
						System.out.println(Thread.currentThread().getName() + "-- Sleeping. Others will be waiting.");

						// Add some sleep, so that t1 will be waiting
						Thread.sleep(10000);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + "-- Notifying others");

					// Notify others (ie t1) to access msg
					msg.notify();

				}

			}
		};

		t1.start();
		t2.start();

	}

}
