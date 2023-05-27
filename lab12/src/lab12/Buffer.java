package lab12;

public class Buffer {
	private int loc;
	private double[] data;
	
	public Buffer(int size) // constructor. initialize loc, data
	{
		this.loc = 0;
		this.data = new double[size];
		System.out.println("New Buffer");
		System.out.println(this + "\n");
	}
	public int getSize() {return this.data.length;} // return size of data
	public synchronized String toString() // return info of buffer
	{
		String toReturn = "";
		for(double d: this.data) 
		{
			toReturn += String.format("%5.2f", d)+" ";
		}
		return toReturn;
	}
	public synchronized void add(double toAdd) throws InterruptedException
	{ // add item and increment loc
		while (this.loc >= this.getSize()) // what if 'while' is replaced with 'if'? -> 
		{
			System.out.println("Buffer is full.");
			wait();
		}
		System.out.println("Adding item : " + toAdd);
		this.data[this.loc++] = toAdd;
		System.out.println(this);
		System.out.flush();
		notifyAll();
	}
	public synchronized double remove() throws InterruptedException
	{ // remove item and decrement loc
		while (this.loc <= 0)
		{
			System.out.println("Buffer is empty."); // what if 'while' is replaced with 'if'? -> index out of range could occur
			wait();
		}
		double temp = this.data[this.loc - 1];
		System.out.println("Removing item : " + temp);
		this.data[this.loc-- - 1] = 0.0;
		System.out.println(this);
		System.out.flush();
		notifyAll();
		return temp;
	}
}
