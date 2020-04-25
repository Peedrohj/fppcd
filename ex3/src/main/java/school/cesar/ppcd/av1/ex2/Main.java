package school.cesar.ppcd.av1.ex2;

public class Main {
	public static void main(String[] args) {
		FakeLongTask fakeLongTask = new FakeLongTask();
		Thread threadFakeLongTask = new Thread(fakeLongTask);
		threadFakeLongTask.start();

		synchronized (threadFakeLongTask) {
			try {
				System.out.println("waiting...");
				threadFakeLongTask.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("done!");
		}
	}
}
