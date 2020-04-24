package school.cesar.ppcd.av1.ex1.client;

import java.net.Socket;


public class SharedCounterClient {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("127.0.0.1", 8888);
		Thread thread = new Thread(new SharedCounterClientRunnable(client));
		thread.start();
		thread.join();
	}
}
