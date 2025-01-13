//Written by Kennedy Poag
public class GenLL<T> {
	//inner class to represent node of linked list
	private class ListNode{
		T data;
		ListNode link;
		//constructor for node
		public ListNode(T aData, ListNode aLink){
			this.data = aData;
			this.link = aLink;
		}
		
	}//references placement in list
	private ListNode head;	//head = beginning of list
	private ListNode tail; // tail = end of list
	private ListNode current; // current node
	private ListNode prev; //previous node
	private int size;// size of linked list
	//constructor for linked list
	public GenLL(){
		head = tail = prev = null;
		this.size =0;
	}
	//method add a new node to the end of the linked list
	public void add(T aData) {
		ListNode newNode = new ListNode(aData,null);
		if(head==null) {
			head = current = newNode;
			this.size =1;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
		this.size++;
	}
	//print elements of linked list
	public void print() {
		ListNode current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.link;
		}
	}
	//get size of list
	 public int getSize(){
	        return this.size;
	    }
	 //remove nodes from linked list
	 public boolean remove(Tasks taskRemove) {
		  current = head;
		  prev = null;
		 
		 while(current != null) {
			 if(taskRemove.equals(current.data)) {
				 if(prev == null) {
					 head = current.link;
					 if(head == null) {
						 tail = null;
					 }
				 }else {
					 prev.link = current.link;
					 if(current == tail) {
						 tail = prev;
					 }
				 }
				 return true;
			 }
			 prev = current;
			 current = current.link;
		 }
		return false;
	 }
	 //move to next node
	 public void goToNext(){
	        if(current == null)
	            return;
	        prev = current;
	        current = current.link;
	    }
	 //get current node
	 public T getCurrent(){
	        if(current == null)
	            return null;
	        return current.data;
	    }
	 //set current node
	 public void setCurrent (T aData) {
		 if(current != null && aData != null) {
			 current.data = aData;
		 }
	 }
	 //reset current and previous nodes
	 public void reset() {
		 current = head;
		 prev = null;
	 }
	 //check if theres more nodes 
	 public boolean hasMore() {
		 return current != null;
	 }
	 //add a new node after current
	 public void addAfterCurrent (T aData) {
		 if(current == null) {
			 return;
		 }
		 ListNode newNode = new ListNode(aData, current.link);
		 current.link = newNode;
		 this.size++;
	 }
	 //remove current node
	 public void removeCurrent() {
		 if(current == head) {
			 head = head.link;
			 current = head;
			 this.size = 0;
		 }else {
			 prev.link = current.link;
			 current = current.link;
			 this.size --;
		 }
	 }
	 //get data at specific index
	 public T getAt(int i) {
		 if(i<0 || i>= size) {
			 return null;
		 }
		 ListNode temp = head;
		 for(int j=0; j<i; j++) {
			 temp = temp.link;
		 }return temp.data;
	 }
	 //sets data at specific index
	 public void setAt(int index, T aData) {
		 if(index < 0|| index>= size|| aData == null) {
			 return;
		 }
		 ListNode temp = head;
		 for(int i=0; i<index; i++) {
			 temp = temp.link;
		 }
		 temp.data = aData;
	 }
	
	
}
