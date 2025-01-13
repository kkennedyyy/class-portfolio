//Kennedy Poag
public class WordHelper {
	//Vowel method
	public static String[] sortByVowels(String[] words ) {
		String[] sorted = new String[words.length];
		int index = 0; 
		int vowelCount = 0;
		while (index < words.length) {
			//for loop goes through list once
			for ( int i=0; i <words.length; i++) {
				String word = words[i];
				int numVow = 0;
				for (int j =0; j < word.length();j++) {
					//goes through each letter in the word
					char letter = word.charAt(j);
					if(letter == 'a' ||letter == 'e'||letter == 'i'||letter == 'o'||letter == 'u'||letter == 'y') {
						numVow++;
					}
				}//Sorts words by vowel count
				if(numVow == vowelCount) {
					sorted[index] = word;
					index++;
				}
			}vowelCount++;
		}
		
		return sorted;}	
	//Consonants method
	public static String[] sortByConsonants(String[]words) {
		String[] sorted = new String[words.length];
		int index =0;
		int conCount =0;
		while (index <words.length) {
			//for loop goes through list once
			for (int i=0; i<words.length;i++) {
				String word = words[i];
				int numCon = 0;
				for (int j=0;j< word.length();j++) {
					///goes through each letter in the word
					char letter = word.charAt(j);
					if(letter != 'a' ||letter != 'e'||letter != 'i'||letter != 'o'||letter != 'u'||letter != 'y') {
						numCon++;
					}//Sorts words by number of consonants
				}if (numCon == conCount) {
					sorted[index] = word;
					index++;
				}
			}conCount++;
		}
	return sorted;}
	//Length method
	public static String[] sortByLength(String[]words) {
		String[] sorted = new String[words.length];
		int index =0;
		int lengthCount =0;
		while (index <words.length) {
			//For loop goes through list once
			for (int i=0; i<words.length;i++) {
				int word = words[i].length();
				//Add word to list based off length
				if(word == lengthCount) {
					sorted[index] = words[i];
					index++;
				}
			}lengthCount++;
		}
		return sorted;}
	
}




