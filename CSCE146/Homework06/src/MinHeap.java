//Written by Kennedy Poag 
public class MinHeap{ 
	public static final int SIZE = 128; //Max size
	private sheep[] heap; //Array of sheep
	private int lastIndex;
	//Default constructor
	public MinHeap(){
		init(SIZE);
	}
	//Parameterized Constructor 
	public MinHeap(int size){
		init(size);
	}
	private void init(int size) {
		if(size>0) {
			heap = new sheep[size];
		}
		lastIndex = 0;
	}
	//Insert method
	public void insert(sheep aSheep){
		if(lastIndex >= heap.length){
			System.out.println("Sorry, Max Size Reach");
			return;
		}
		heap[lastIndex] = aSheep;
		bubbleUp();
		lastIndex++;
	}
	//bubbleUp: element to right position
	public void bubbleUp(){
		int index = this.lastIndex;
		while(index>0 && heap[(index-1)/2].compareTo(heap[index])<0){
			
			sheep temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	//peek method: returns root
	public sheep peek(){
		if(heap == null)
			return null;
		return heap[0];
	}
	//remove method 
	public sheep remove(){
		if(lastIndex <= 0) {
			return null;
		}sheep ret = peek();
		
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex-1] = null;
		lastIndex--;
		bubbleDown();
		return ret;
	}
	//bubbleDown element to right position
	public void bubbleDown(){
		int index = 0;
		while(index*2+1 < lastIndex){
			int smallIndex = index*2+1;
			if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2])>0){
				smallIndex = index*2+2;
			}
			if(heap[index].compareTo(heap[smallIndex])>0)
			{
				sheep temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else
				break;
			index = smallIndex;
		}
	}
	//prints everything in heap
	public void printHeap(){
		for(sheep wool : heap){
			if(wool == null) {
			break;
			}System.out.println(wool.toString());
		}
	}
	//sorts heap
	public void heapSort(){
		for(int i = lastIndex;i>0;i--) {
			System.out.println(this.remove());
		}
		

	}
	public boolean isEmpty(){
		if(heap[0] == null) {
			return true;
		}
		return false;
	}
	
	
} 