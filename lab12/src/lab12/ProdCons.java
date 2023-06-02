package lab12;

public class ProdCons {
	private Buffer buffer;
	private Producer[] producer;
	private Consumer[] consumer;
	
	public ProdCons() // constructor
	{
		this.buffer = new Buffer(5);
		this.producer = new Producer[2]; 
		this.consumer = new Consumer[2];
		Producer p0 = new Producer(this.buffer); Producer p1 = new Producer(this.buffer);
		Consumer c0 = new Consumer(this.buffer); Consumer c1 = new Consumer(this.buffer);
		this.producer[0] = p0; this.producer[1] = p1;
		this.consumer[0] = c0; this.consumer[1] = c1;
	}
	
	private class Producer extends Thread {
		private final Buffer buffer;
		// constructor
		public Producer(Buffer buffer) {this.buffer = buffer;}
		// add random number by buffer size
		public synchronized void produce() throws InterruptedException
		{
			for (int i = 0; i < this.buffer.getSize(); ++i)
			{
				this.buffer.add(Math.random() * 100);
			}
		}
		public void run() // run produce method
		{
			try
			{
				this.produce();
			} catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private class Consumer extends Thread {
		private final Buffer buffer;
		// constructor
		public Consumer(Buffer buffer) {this.buffer = buffer;}
		// remove data by buffer size
		public synchronized void consume() throws InterruptedException
		{
			for (int i = this.buffer.getSize(); i > 0; --i)
			{
				this.buffer.remove();
			}
		}
		public void run() // run consume method
		{
			try
			{
				this.consume();
			} catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	void startThread() // start all thread saved in array
	{
		for (Producer p : this.producer) {p.start();}
		for (Consumer c : this.consumer) {c.start();}
	}
}
