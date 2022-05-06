package concurrency.demo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunner {

	public static void main(String[] args) {

		// Latch set with 3
		CountDownLatch latch = new CountDownLatch(3);

		// 3 threads will be running the tasks
		for (int i = 0; i < 3; i++) {
			new Thread(new LatchTask(latch, "latch-thread-" + i)).start();
		}

		try {

			System.out.println("Waiting on latch");

			// wait will let the mail thread wait until count down to 0
			latch.await();

			System.out.println("Wait on latch completed");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class LatchTask implements Runnable {

	CountDownLatch latch;
	String name;

	LatchTask(CountDownLatch latch, String name) {

		this.latch = latch;
		this.name = name;

	}

	@Override
	public void run() {

		try {

			Thread.sleep(5000);

			// reduce the latch count by 1
			latch.countDown();

			System.out.println("Latch count down by " + name);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
