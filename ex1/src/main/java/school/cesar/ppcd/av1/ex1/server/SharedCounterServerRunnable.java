package school.cesar.ppcd.av1.ex1.server;

import java.net.Socket;
import java.io.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SharedCounterServerRunnable implements Runnable {
	private Socket client;
	private static int counter = 0;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private Semaphore mutex = new Semaphore(1);

	public SharedCounterServerRunnable(Socket client) throws IOException {
		this.client = client;
		this.inputStream = new DataInputStream(client.getInputStream());
		this.outputStream = new DataOutputStream(client.getOutputStream());
	}

	public void incrementCounter() {
		this.counter++;
	}

	public void run() {
		// TODO Auto-generated method stub

		try {
			while (true) {
				if (inputStream.read() == 73) {
					try {
						mutex.acquire();
						this.incrementCounter();
						this.outputStream.writeInt(this.counter);
						TimeUnit.SECONDS.sleep(1);
					} finally {
						mutex.release();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
