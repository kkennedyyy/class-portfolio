// Written by Kennedy Poag
public class LinkedList <T>{
	//Create  our linked list
    private class ListNode{
        T data;
        ListNode link;

        public ListNode(T aData, ListNode aLink){
            data = aData;
            link = aLink;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public LinkedList(){
        head = current = previous = null;
    }
//Method adds data to our linked list
    public void add(T aData){
        ListNode newNode = new ListNode(aData, null);
        if(head==null)
        {
            head = current = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.link != null)
            temp = temp.link;
        temp.link = newNode;
    }

    public void addAfterCurrent(T aData){
        if(current == null)
            return;
        ListNode newNode = new ListNode(aData,current.link);
        current.link = newNode;
    }

    public T getCurrent(){
        if(current == null)
            return null;
        return current.data;
    }

    public void setCurrent(T aData){
        if(aData == null||current==null)
            return;
        current.data = aData;
    }

    public void goToNext(){
        if(current == null)
            return;
        previous = current;
        current = current.link;
    }

    public void reset(){
        current = head;
        previous = null;
    }

    public boolean hasMore(){
        return current != null;
    }

    public void removeCurrent()
    {
        if(current == head)
        {
            head = head.link;
            current = head;
        }
        else
        {
            previous.link = current.link;
            current = current.link;
        }
    }
    public T getAt(int index){
        if(index<0||index>=this.getSize())
            return null;
        ListNode temp = head;
        for(int i=0;i<index;i++)
            temp = temp.link;
        return temp.data;
    }
    //Iterates through the list
    public void print(){
        ListNode temp = head;
        int numGames =0;
        while(temp!=null)
        {
            numGames++;
            System.out.print(numGames+" ");
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
//Get size of list, regardless of the file the user inserts
    public int getSize(){
        if(head==null)
            return 0;
        int size = 0;
        current = head;
        while(current!=null)
        {
            size++;
            current = current.link;
        }
        return size;
    }
}