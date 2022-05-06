package concurrency.demo;

import java.util.concurrent.Semaphore;

public class SemaphoreRunner {

	public static void main(String[] args) {

		// no. of permits allowed into critical section or object's monitor
		Semaphore semaphore = new Semaphore(1);

		// run the task with 4 threads and only one thread will be running at a time
		for (int i = 0; i < 4; i++) {
			new Thread(new SemaphoreTask(semaphore, "semaphore-thread-" + i)).start();
		}

	}

}

class SemaphoreTask implements Runnable {

	Semaphore semaphore;
	String name;

	SemaphoreTask(Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		this.name = name;

	}

	@Override
	public void run() {

		try {

			// Get the lock for critical section
			semaphore.acquire();
			System.out.println(
					"Permit acquired by  : " + name + ", No. of permits available : " + semaphore.availablePermits());

			Thread.sleep(10000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			// Release the lock
			semaphore.release();
			System.out.println("Permit released by : " + name);

		}

	}

}
