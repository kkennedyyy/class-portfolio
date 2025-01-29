//Written by Kennedy Poag
import java.util.Scanner;
import java.io.*;

public class SheepFE {
	
	public static void main(String[] args) {
		
		try{
			//Greeting
			System.out.println("Welcome to the Sheep Shearing Scheduler!");
			String File;
			Scanner k = new Scanner(System.in);
			//Get file
			System.out.print("Enter File Name:) ");
			File = k.nextLine();
			MinHeap Sheep = new MinHeap();
			Scanner fileScanner = new Scanner(new File(File));
			while(fileScanner.hasNext()){
				String aName = fileScanner.next();
				int sTime = fileScanner.nextInt();
				int aTime = fileScanner.nextInt();
				Sheep.insert(new sheep(aTime,sTime,aName));
			}
			System.out.println("");
			Sheep.heapSort();
			Sheep.printHeap();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}