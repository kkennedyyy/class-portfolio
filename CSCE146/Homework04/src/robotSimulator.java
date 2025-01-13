//Written by Kennedy Poag
import java.io.File;
import java.util.Scanner;
public class robotSimulator {
//scanner for user input
	public static Scanner keyboard = new Scanner(System.in);
	//instance of organizedRobbot class
	public static organizedRobot orgRobot = new organizedRobot();
	public static void main(String[] args) {
		boolean quit = false;
		//uses boolean for user choice to quit or play
		while(!quit){
			System.out.println("Welcome to the Robot Simulator");
			//read board file and print board
			readboardFile();
			orgRobot.printBoard();
			System.out.println("----------");
			//read command file and execute through robot
			readcommandFile();
			System.out.println("Simulation end");
			System.out.println("To quit type \"quit\". To continue press ENTER");
			String choice = keyboard.nextLine();
			//see if the user wants to quit
			if(choice.equalsIgnoreCase("quit")){
				//ends code
				System.out.println("Goodbye");
				quit = true;
				break;
			}
			//resets
			quit = false;
		}

	}
	//uses makeBoard method to read the board file from the user
	public static void readboardFile(){
		System.out.println("Enter a file for the board");
		String fileName = keyboard.nextLine();
		orgRobot.makeBoard(fileName);
	}
	//uses movewithcommands method to read command file and execute through the robot
	public static void readcommandFile(){
		System.out.println("Enter a file for the robot commands");
		String fileName = keyboard.nextLine();
		orgRobot.moveWithCommands(fileName);
	}


}