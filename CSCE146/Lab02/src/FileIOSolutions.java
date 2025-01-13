//Written by Kennedy Poag
import java.io.*;
import java.util.Scanner;

public class FileIOSolutions {

	public static final String DELIM = " ";
	public static void pastTense (String readName, String outputName) {		
		try {
			//Use scanner and writer so the method can read/print file input
			Scanner fileScanner = new Scanner(new File(readName));
			PrintWriter writer = new PrintWriter(new FileWriter(outputName));

			while(fileScanner.hasNextLine()) {
				//print file on different lines and split it
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				
				//use for loop to change every "is" in the file to was
				for(int i=0; i<splitLines.length;i++) {
					if(splitLines[i].equalsIgnoreCase("is")) {
						splitLines[i]= "was";
					}//write contents to file & console
					writer.println(splitLines[i]);
					System.out.println(splitLines[i]);
				}

			}writer.close();
			fileScanner.close();	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static final String DELIM1 = "\t";
	//method that takes file name and return total volume
	public static double totalTubeVolume(String readName2) {
		Scanner fileScanner2;
		double totalVol = 0.0;
		try {
			//scan file for tubes
			fileScanner2 = new Scanner(new File(readName2));
			while(fileScanner2.hasNextLine()) {
				//split file base on its volume and radius
				String tubeLine = fileScanner2.nextLine();
				String[] splitLine2 = tubeLine.split(DELIM1);


				double radius = Double.parseDouble(splitLine2[1]);
				double height = Double.parseDouble(splitLine2[2]);
				double pi = Math.PI;
				//calculate volume of each tube
				double volume = ((radius*radius)*pi*height);
				//add all the volumes together
				totalVol = volume + totalVol;

			}	
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalVol;
		}
	

}
