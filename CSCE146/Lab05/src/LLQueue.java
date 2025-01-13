//Written by Kennedy Poag
//takes generic type (T)
public class LLQueue <T> implements QueueI<T> {
	private class ListNode{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	public LLQueue() {
		head = tail = null;
	}
	//enqueue method: takes generic data and adds to end of queue
	public void enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	//dequeue method: removes and returns first element's data if not empty
	public T dequeue() {
		if(head == null) {
			return null;
		}else {
			T ret = head.data;
			head = head.link;
			return ret;
		}
	}
	//peek method: returns first element's data
	public T peek() {
		if(head == null) {
			return null;
		}else {
			return head.data;
		}
	}
	//Print method: prints entire queue
	public void print() {
		for(ListNode temp = head; temp!= null; temp = temp.link) {
			System.out.println(temp.data);
		}
	}
	

}
