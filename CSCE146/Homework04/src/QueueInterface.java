//Written by Kennedy Poag
public interface QueueInterface<T> {
	public T dequeue();
	public void enqueue(T aData);
	public T peek();
	public void print();

}
