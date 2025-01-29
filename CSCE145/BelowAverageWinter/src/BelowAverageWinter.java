//Written by Kennedy Poag
//Get user input of temps for 10 days
//Store in an array
//Find the average temp of the 10 days
//Print the number of days
//Print the temps that were below average
import java.util.Scanner;
public class BelowAverageWinter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the below average temperature tester program");
		
		Scanner k = new Scanner(System.in);
		
		int size = 10;
		float sum = 0;
		//Declare the tempList and user input as a float so it can accept decimals
		float[] tempList = new float[size];
		int [] dayList = new int[size];
		int day = 0;
		//Use for loop to add the user's input to the templist and keep track of the day
		for (int i=0; i < 10; i++) {
			day++;
			System.out.println("Enter the temperature for day " + day);
			float ui = k.nextFloat();
			tempList[i] = ui;
			dayList[i] = day;
		} k.close();
	// Use for loop so the whole tempList can be added and set to the sum
		for (int i=0; i <tempList.length; i++) {
			sum += tempList[i];

		}		
		//Declare the avg.temp as a float in case user enters decimal
		float averageTemp = sum/tempList.length;

		System.out.println("The average temperature was: " + averageTemp);
		System.out.println("The days that were below average was:"); 
// Use for loop to check the temps below the average temp and display them to user
		for (int i=0; i<tempList.length; i++) {
			if (tempList[i]<averageTemp) {
				System.out.println("Day " + dayList[i] +" with "+ tempList[i]);
			}
		}
		
	}

}
