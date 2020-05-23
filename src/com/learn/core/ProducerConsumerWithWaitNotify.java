package com.learn.core;

import java.util.Vector;

/**
 * 
 * Producer consumer problem using wait and notify
 *
 */
public class ProducerConsumerWithWaitNotify {

	public static void main(String[] args) {

		// Queue size
		int sharedElementSize = 5;

		// Shared object
		Vector<Integer> sharedElement = new Vector<>();

		// Create producer and consumer threads
		Thread producerThread = new Thread(new ProducerTask(sharedElement, sharedElementSize));
		Thread consumerThread = new Thread(new ConsumerTask(sharedElement));

		producerThread.start();
		consumerThread.start();

	}

}

/*
 * Producer
 */
class ProducerTask implements Runnable {

	private Vector<Integer> sharedElement = null;
	private int size = 0;

	ProducerTask(Vector<Integer> sharedElement, int size) {
		this.sharedElement = sharedElement;
		this.size = size;
	}

	@Override
	public void run() {
		// produce at most 8 items
		for (int num = 1; num <= 8; num++) {
			produce(num);
		}
	}

	private void produce(int number) {

		// Wait when queue is full
		while (size == sharedElement.size()) {
			synchronized (sharedElement) {
				System.out.println("Shared queue is full. Waiting for element to be consumed.");
				try {
					sharedElement.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		// Produce item when queue is no more full
		synchronized (sharedElement) {
			sharedElement.add(number);
			System.out.println("Produced element : " + number + ", Queue size : " + sharedElement.size());

			// Notify other threads for consuming those produced elements
			sharedElement.notifyAll();
		}
	}
}

/*
 * Consumer
 */
class ConsumerTask implements Runnable {

	private Vector<Integer> sharedElement = null;

	ConsumerTask(Vector<Integer> sharedElement) {
		this.sharedElement = sharedElement;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// Give sometime for producer to produce elements as both the threads started at
				// same time
				Thread.sleep(50);

				// Start consuming
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() {

		// Wait when queue is empty as there are no elements to consume
		while (sharedElement.isEmpty()) {
			synchronized (sharedElement) {
				System.out.println("Shared queue is empty. Waiting for element to be produced.");
				try {
					sharedElement.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		synchronized (sharedElement) {

			// Consume element
			System.out.println(
					"Consumed element : " + sharedElement.remove(0) + ", Queue size : " + sharedElement.size());

			// Notify when element got consumed
			sharedElement.notifyAll();

		}
	}
}
