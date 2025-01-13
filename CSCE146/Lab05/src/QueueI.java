//Written by Kennedy Poag
public interface QueueI<T> {
	//enqueue method, takes parameter returns nothing
	public void enqueue(T aData);
	//dequeue method no parameters, returns generic type
	public T dequeue();
	//peek method no parameters, returns generic type
	public T peek();
	//print method no parameters returns nothing
	public void print();

}
