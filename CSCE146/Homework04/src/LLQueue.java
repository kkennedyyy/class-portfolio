//Written by Kennedy Poag
public class LLQueue <T> implements QueueInterface<T>{
	private class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink){
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	public LLQueue(){
		head = tail = null;
	}
	//add element to end of queue
	public void enqueue(T aData){
		ListNode newNode = new ListNode(aData, null);
		if(head == null){
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	//remove and return first element from queue
	public T dequeue(){
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}
	//view the first element in a queue
	public T peek(){
		if(head == null)
			return null;
		return head.data;
	}
	//print all elements in the queue
	public void print(){
		for(ListNode temp = head;temp!=null;temp = temp.link)
			System.out.println(temp.data);
	}
}