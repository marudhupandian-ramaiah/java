package concurrency.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunner {

	public static void main(String[] args) {

		// barrier set with 3
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {

				System.out.println("All threads reached barrier.");
			}

		});

		// 3 threads will be running the tasks
		for (int i = 0; i < 3; i++) {
			new Thread(new BarrierTask(barrier, "barrier-thread-" + i)).start();
		}

	}
}

class BarrierTask implements Runnable {

	CyclicBarrier barrier;
	String name;

	BarrierTask(CyclicBarrier barrier, String name) {

		this.barrier = barrier;
		this.name = name;

	}

	@Override
	public void run() {

		try {

			System.out.println("waiting on barrier : " + name);
			Thread.sleep(1000);

			// waiting on barrier
			barrier.await();

		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
