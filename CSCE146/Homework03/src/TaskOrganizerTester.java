//Written by Kennedy Poag
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskOrganizerTester {

	public static void main(String[] args) throws IOException {	
		Scanner keyboard = new Scanner(System.in);
		TaskOrganizer tOrganizer = new TaskOrganizer();
		System.out.println("Welcome to the Task Organizer!");
		
	//use boolean to run code continously until user quits
	boolean run = true;
	while(run) {
		System.out.println(
				"Enter 1. To Add a Task\n"
						+ "Enter 2. To Remove a Task\n"
						+ "Enter 3. To Print Tasks To Console\n"
						+ "Enter 4. To Read from a Task File\n"
						+ "Enter 5. To Write to a Task File\n"
						+ "Enter 9. To Quit");
		//get user input for switch case
		int input = keyboard.nextInt();
		switch(input) {
		case 1:
			//call addTask method to add tasks
			tOrganizer.addTask();
			break;
		case 2:
			//call removeTask method to remove tasks
			tOrganizer.removeTask();
			break;
		case 3:
			//call printAll method to print to console
			tOrganizer.printAll();
			break;
		case 4: 
			//read file from user input
			tOrganizer.read();
			break;
		case 5:
			//call method to write to a task file
			tOrganizer.writeFile();
			break;
		case 9:	
			//sets run to false to end
			System.out.println("Thank's for using");
			run = false;
			break;
		default:
			
			System.out.println("Invalid input");
		}
		}



	}


}
