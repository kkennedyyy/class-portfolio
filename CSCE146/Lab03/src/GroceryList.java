//Written by Kennedy Poag

//GroceryList class extends from grocery item
public class GroceryList<T extends GroceryItem> {
	private class ListNode {
		//Create instance variables
		T item;
		ListNode link;
		
		public ListNode(T aItem, ListNode aLink) {
			item = aItem;
			link = aLink;
		}		
	}
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	public GroceryList() {
		head = null;
		current = previous = head;
	}
	//Create methods
	public void gotoNext() {
		if(current == null) {
			return;
		}previous = current;
		current = current.link;
	}
	//collects current item
	public T getCurrent() {
		if(current == null) {
			return null;
		}
		return current.item;
	}
	//Sets input as current item
	public void setCurrent(T aItem) {
		if(aItem == null || current == null) {
			return;
		}
			current.item = aItem;	
	}
	//Add an item based on input
	public void addItem(T aItem) {
		ListNode newNode = new ListNode(aItem, null);
		if(head == null) {
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	public void addItemAfterCurrent(T aItem) {
		if(current == null) {
			return;
		}ListNode newNode = new ListNode(aItem, current.link);
		current.link = newNode;
	}
	public void removeCurrent() {
		if(current ==head) {
			head = head.link;
			current = head;
		}else {
			previous.link = current.link;
			current = current.link;
		}
	}public void showList() {
		ListNode temp = head;
		while(temp!=null) {
			System.out.println(temp.item);
			temp = temp.link;
		}
		//Checks if list contains a specific item by using a while loop
	}public boolean contains (GroceryItem findItem) {
		ListNode temp = head;
		while(temp!= null) {
			if( temp.item.equals(findItem)) {
				return true;
			}temp = temp.link;
		}return false;
	}//calculates total cost of grocery list
	public double totalCost() {
		double total = 0.0;
		ListNode temp = head;
		while(temp != null) {
			if(temp.item instanceof GroceryItem) {
				total+= ((GroceryItem) temp.item).getPrice();
			}temp = temp.link;
		}return total;
	}

}
