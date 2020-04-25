package school.cesar.ppcd.av1.ex4;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerImpl implements ProducerConsumer {
	private final List<SomeRequest> list = new ArrayList();
	private final int size = 2;

	public void produce(final SomeRequest request) {
		synchronized (this) {
			if (this.list.size() == size) {
				try {
					wait();
				} catch (final InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				this.list.add(request);
				notify();
			}
		}
	}

	public SomeRequest consume() {
		synchronized (this) {
			if (this.list.size() == 0) {
				try {
					wait();
				} catch (final InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			notify();
			return this.list.remove(0);
		}

	}

}
