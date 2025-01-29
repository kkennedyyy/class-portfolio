//Written by Kennedy Poag
import java.util.Scanner;

public class Sort{
	//Set max array size to 100 
	public static final int SIZE = 100;
	public static void main(String[] args) {
		//boolean used to restart program
		Boolean exit = false;
		while(!exit) {	
			Scanner k = new Scanner(System.in);
			CountSort [] sorts = new CountSort[SIZE];
			System.out.println("Enter any number of strings and I will sort by SORT's");
			System.out.println("Once you're done entering sentences enter 'quit'");
			String input = "";
			int count =0;
			//use while loop for user's input until they type quit
			while(count < SIZE) {
				input = k.nextLine();
				if(input.equalsIgnoreCase("quit")) {
					break;
				}
				sorts[count] = new CountSort(input);
				count++;			
			}
			//call mergeSort method to sort user's input
			mergeSort(sorts);
			System.out.println("Sort SORTED :)");
			//print sorted array
			for(CountSort s : sorts) {
				if(s == null) {
					break;
				}System.out.println(s.getWord());
			}

			System.out.println("Would you like to sort more Strings?");
			String choice = k.nextLine();
			if(choice.equalsIgnoreCase("no")) {
				System.out.println("Thanks for using!");
				exit = true;
				break;
			}
			exit = false;
		}
	}
	//mergesort array
	public static void mergeSort(CountSort[] sortArray) {
		//checks if array is less than 2
		int size = sortArray.length;
		if(size < 2) {
			return;
		}
		//create two sub-arrays
		int middle = size/2;
		int L = middle;
		int R = size-middle;
		CountSort[] left = new CountSort[L];
		CountSort[] right = new CountSort[R];
		//use for loop to reiterate through each subarray
		for(int i=0; i<middle;i++) {
			left[i] = sortArray[i];
		}for(int i=middle;i<size;i++) {
			right[i-middle]=sortArray[i];
		}
		//merges sorted subarrays
		mergeSort(left);
		mergeSort(right);
		merge(left, right, sortArray);
	}
	//merge left/right array until one
	public static void merge(CountSort[] left, CountSort[] right, CountSort[] a) {
		int L = left.length;
		int R = right.length;
		int i =0;
		int j=0;
		int k =0;
		//use while loop to compare elements in each sub-array
		while(i< L && j < R) {
			if(left[i] == null|| right[j] == null) {
				break;
			}
			if(left[i].getNumSorts() <= right[j].getNumSorts()) {
				a[k] = left[i];
				i++;
				k++;
			}else {
				a[k] = right[j];
				j++;
				k++;
			}
		}while(i<L) {
			a[k] = left[i];
			i++;
			k++;
		}
		while(j< R) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
}