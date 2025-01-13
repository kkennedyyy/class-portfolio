//Written by Kennedy Poag
public class DoubleDoubleLL<T> {
	//Internal class to represent node in the doubly linked list
	private class ListNode{
		//Data stored in the node
		double data;	
		//refers to the next and previous node
		ListNode next;
		ListNode prev;
		//constructor
		public ListNode(double aData, ListNode aNode, ListNode bNode) {
			data = aData;
			next = aNode;
			prev = bNode;
		}
	}
	//used to refer to specific placement within the node
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private ListNode tail;
	
	//constructor to make sure doubly linked list is empty
	public DoubleDoubleLL() {
		head = current = previous = null;
	}
	
	//add node of given data to end of the list
	public void add(double aData) {
		ListNode newNode = new ListNode(aData, null, null);
		//but if the head is empty, we add it to the beginning
		if(head ==null) {
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp != null && temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		tail = newNode;
		newNode.prev = temp;
	}
	//add node after the current reference
	public void addAfterCurrent(double aData) {
		//however if current is empty, nothing is added
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aData, current.next, current);
		current.next = newNode;
		if(current.next==null) {
			tail = current;
		}
	}
	//searches the node for the parameter
	public void remove(double aData) {
		reset();
		while(hasAnother()) {
			//removes the data if found
			if(aData == current.data) {
				removeCurrent();
			} 
			gotoNext();
		}
	}
	//method goes through the node and checks for current
	public void removeCurrent() {
		if(current == head) {
			head = current.next;
			current = current.next;
		}if(current != null && previous == null && current != head) {
			previous = current.prev;
			previous.next = current.next;
			current = current.next;
					return;
		}if(current == tail) {
			current = current.prev;
			tail = current;
			current.next = null;
		}
	}
	//Moves current to the head of the node
	public void reset() {
		current = head;
		current.next = head.next;
		current.prev = null;
	}
	// moves current node forward by one node
	public void gotoNext() {
		//does nothing if current is empty
		if(current ==null) {
			return;}
		current.prev = current;
		current = current.next;
	}
	//moves current node back by one node
	public void gotoPrev() {
		if(current != null) {
			current.next = current;
			current = current.prev;
			if(current == head) {
				current.prev = null;
			}else {
				current.prev = previous.prev;
			}
		}
	}
	//moves current node to the tail/end of list
	public void gotoEnd() {
		current = tail;
		current.prev = tail.prev;
		current.next = null;
	}
	//checks if current node is empty
	public boolean hasMore() {
		if(current != null) {
			return true;
		}else {
			return false;
		}
	}
	//checks if current node has another node after
	public boolean hasAnother() {
		return current.next != null;
	}
	//retrieves current value
	public double getCurrent() {
		if(current == null) {
			return 0;
		}
		return current.data;
	}
	//takes in new data and sets that as current
	public void setCurrent(double aData) {
		if(current == null) {
			return;
		}current.data = aData;
	}
	//print data from list
	public void print() {
		//place is equal to head 
		ListNode placeholder = head;
		//use while loop to print data of list and set place to 
		//place.next to retrieve next value until head is empty
		while(placeholder!= null) {
			System.out.println(placeholder.data);
			placeholder = placeholder.next;
		}
	}
	//takes in parameter and returns true if list contains data
	public boolean contains(double aData) {
		if(head != null) {
			ListNode placeholder = head;
			while(placeholder != null) {
				if(placeholder.data == aData) {
					return true;
				}
				placeholder = placeholder.next;
			}
			return false;
		}
		else {
			return false;
		}
	}
	

}
