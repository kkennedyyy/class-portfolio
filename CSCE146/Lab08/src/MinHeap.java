//Written by Kennedy Poag
public class MinHeap <T extends Comparable<T>> {
	private T[] heap; //Array to store heap elements
	private int size; // current size of the heap
	public static final int DEFSIZE = 128; //default size of the heap
	
	//default constructor
	public MinHeap() {
		init(DEFSIZE);
	}
	//constructor initialize heap with given size
	public MinHeap(int aSize) {
		init(aSize);
	}
	private void init(int aSize) {
		if(aSize <= 0) {
			init(DEFSIZE);
			return;
		}
		heap = (T[])(new Comparable[aSize]);
		size = 0;
	}
	//add method for heap
	public void add(T aData) {
		if(heap[heap.length-1] != null) {
			return;
		}
		heap[size] = aData;
		bubbleUp();
		size++;
	}
	//bubbleup heap property
	public void bubbleUp() {
		int index = size;
		int parentIndex = (index-1)/2;
		Order parent = (Order) heap[(parentIndex)];
		Order child = (Order) heap[index];
		while(index > 0 && parent.compareTo(child)>0) {
			T temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}

	}
	//remove and returns min from heap
	public T remove() {
		if(size ==0) {
			return null;
		}
		T ret = heap[0];
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		bubbleDown();
		return ret;
	}
	//bubbledown heap property
	private void bubbleDown() {
		int index = 0;
		while(index*2+1 < size) {
			int smallIndex = index*2+1;
			Order leftChild = (Order)heap[index*2+1];
			Order rightChild = (Order)heap[index*2+2];
			
			if(index*2+2 < size && leftChild.compareTo(rightChild)>0) {
				smallIndex = index*2+2;
			}
			Order smallOrder = (Order)heap[smallIndex];
			Order peak = (Order)heap[index];
			
			if(peak.compareTo(smallOrder)>0) {
				T temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}else {
				break;
			}index = size;
		}
	}
	//print elements of heap
	public void print() {
		for(T h: heap) {
			if(h == null) {
				break;
			}
			System.out.println(h);
		}
	}
	//sort array using heap sorting alg
	public void heapSort(T[] array) {
		if(array == null) {
			return;
		}
		MinHeap<T> mHeap = new MinHeap<T>(array.length);
		for(int i=0; i<array.length; i++) {
			mHeap.add(array[i]);
		}for(int i=0; i<array.length; i++) {
			array[i] = mHeap.remove();
		}
	}

}
