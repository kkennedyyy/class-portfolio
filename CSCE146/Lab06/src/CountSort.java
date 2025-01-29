//Written by Kennedy Poag

//Class for counting the times "SORT" is in a string given by the user
public class CountSort{
	private int numSorts; // variable to store amount of times "SORT" is found
	private String word; // variable to store the input word
	
	//Constructor 
	public CountSort(String aWord) {
		this.word = aWord; //set word to input
		this.numSorts = 0; //set sorts to zero
		this.countSorts(aWord); //call count sorts method to count how many times "SORT" is found
	}
	//method to return number of "SORTS"
	public int getNumSorts() {
		return this.numSorts;
	}
	//method to return input word
	public String getWord() {
		return this.word;
	}
	//method to count sorts from user input
	public void countSorts(String aWord) {
		//if input is null return without counting
		if(aWord == null) { 
			return;
		}
		//change input to upper case
		aWord = aWord.toUpperCase();
		//use for loop to reiterate through the characters to search for SORT
		for(int i=0; i<aWord.length()-3;i++) {
			if(aWord.charAt(i) =='S'&& 
					aWord.charAt(i+1)=='O'&&
					aWord.charAt(i+2)=='R'&&
					aWord.charAt(i+3)=='T') {
				//increment count if "SORT" is found
						this.numSorts++;
				
			}
		}
	}
}