//Written by Kennedy Poag
import java.util.Scanner;
import java.io.*;
public class organizedRobot {
	//size of board
	public static final int SIZE = 10;
	//declaring variables for the board and commands
	private char board[][];
	private LLQueue<String> commands;
	
	//constructor
	public organizedRobot(){
		board = new char[SIZE][SIZE];
		commands = new LLQueue<String>();
	}
	//Make the board from reading file
	public void makeBoard(String aFile){
		try{
			//checks to see if file exists
			File file = new File(aFile);
			if(!file.exists()) {
				System.out.println("File not found: "+ aFile);
				return;
				}
			Scanner fileScanner = new Scanner(new File(aFile));
			while(fileScanner.hasNextLine()){
				//read each character on each line on the board
				for(int i=0;i<board.length;i++){
					String fileLine = fileScanner.nextLine();
					for(int j=0;j<board[i].length;j++){
						char boardSpot = fileLine.charAt(j);
						board[i][j] = boardSpot;
					}
				}
			}
			//sets robot starting position
			board[0][0] = 'O';
			fileScanner.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//print the board
	public void printBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
	//check if the robot is in bounds of the board
	public boolean bounds(int i, int k, char board[][]){
		if(i>=0 && i<SIZE && k<SIZE && k>=0 && board[i][k] == '_')
			return true;
		else{
			System.out.println("CRASH!");
			return false;
		}
	}
	//moves robot based on commands from file
	public void moveWithCommands(String aName){
		//represents location of robot on x,y plane
		int x = 0;
		int y = 0;
		
		try{
			System.out.println("Simulation Begin");
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()){
				String command = fileScanner.nextLine();
				commands.enqueue(command);
				System.out.println("----------\n"+commands.peek()+"\n----------");
				if(commands.peek().equals("Move Up")){
					//moves robot up by subtracting from the y-axis
					if(bounds(y-1, x, board)){
						board[y][x] = '_';
						board[y-1][x] = 'O';
						y--;
						printBoard();
						commands.dequeue();
					}
				}
				//moves robot down by adding to the y-axis
				else if(commands.peek().equals("Move Down")){
					if(bounds(y+1, x, board)){
						board[y][x] = '_';
						board[y+1][x] = 'O';
						y++;
						printBoard();
						commands.dequeue();
					}
				}//moves robot left by subtracting from x-axis
				else if(commands.peek().equals("Move Left")){
					if(bounds(y, x-1, board)){
						board[y][x] = '_';
						board[y][x-1] = 'O';
						x--;
						printBoard();
						commands.dequeue();
					}
				}//moves robot right by adding from x-axis
				else if(commands.peek().equals("Move Right")){
					if(bounds(y, x+1, board)){
						board[y][x] = '_';
						board[y][x+1] = 'O';
						x++;
						printBoard();
						commands.dequeue();
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}