//Written by Kennedy Poag
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class VideoGameFrontEnd {
//Establish our collection/in file and the out/results file
    public static final String InFile = "Collection.txt";
    public static final String OutFile = "Results.txt";
    //All files the user may insert, each line should be seperated by \t
    public static final String DELIM = "\t";
    public static LinkedList<VideoGame> vidGames = new LinkedList<VideoGame>();
    public static LinkedList<VideoGame> results = new LinkedList<VideoGame>();
    public static final Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
    	//Use boolean so user can reuse the database runner if needed
        boolean run = true;
        while(run){
        	//Call on userInput so they can enter their choice
            int input = userInput();
            switch(input){
            //Call on each method based on the user's input
                case 1:
                    vidGames = loadDatabase();
                    break;
                case 2:
                    results = searchDatabase(InFile, vidGames, results);
                    break;
                case 3: 
                    printConsole(results);
                    break;
                case 4: 
                    printFile(OutFile, results);
                    break;
                case 5:
                    break;
                case 0:
                	System.out.println("Thanks for using!");
                    run = false;
                    break;
            }
        }
    }

    public static int userInput(){
    	//set checkinput to false and input to a number other than 0-5
        boolean checkInput = false;
        int input = -1;
        while(!checkInput){
            boolean checkInt = true;
            boolean inRange = true;
            
            System.out.println("Welcome to the Video Game Database!\n "
            		+ "Enter 1 to load the video game database\n"
            		+ "Enter 2 to search the database\n"
            		+ "Enter 3 to print current results to the console\n"
            		+ "Enter 4 to print current results to file\n"
            		+ "Enter 5 to print all videogames to console\n"
            		+ "Enter 0 to quit");
           

            String choice = keyboard.nextLine();
            //Checks to see if user enters an integer, if not the boolean is check boolean is set to false
            try {
            	input = Integer.parseInt(choice);

            }catch(NumberFormatException e) {
            	System.out.println("Invalid format, that is not an integer");
                checkInt = false;
            }//If the user enters anything less than 0 or over 5, their input is inavlid
            if(checkInt && input!=0 && input!=1 && input!=2 && input!=3 && input!=4 && input!=5){
                System.out.println(input+ " is not valid, try again");
                inRange = false;
            }if(inRange && checkInt) {
            	checkInput = true;
            }
 
        }//Returns the user's choice
        return input;
    }

    public static LinkedList<VideoGame> loadDatabase() throws IOException{
        boolean retrieved = false;
        String userinput=null;
        while(!retrieved){
            System.out.println("Enter the name of your file");
            System.out.println("File format: first word lowercase, second word is uppercase followed by .txt");
            System.out.println("Example: gameCollection.txt");
            userinput = keyboard.nextLine();
            
            if(userinput.equals("")) {
            	retrieved = true;
            	continue;
            }
            File f = new File(userinput);
            //checks to see if file exists
            if(!(f.exists() && f.isFile())){
                System.out.println("File couldn't be found");
                retrieved=false;
              continue;
            }
            retrieved = true;
            if(userinput.equals("")) {
            	userinput = InFile;
            }
            //creates game database if file exists and is a file
        }createDatabase(userinput, vidGames);
    return vidGames;
    
    }

    public static LinkedList<VideoGame> searchDatabase(String fileName, LinkedList<VideoGame> vidGames, LinkedList<VideoGame> results){
        System.out.println("Enter the title of the game or'*' for all");
        String name = keyboard.nextLine();
        System.out.println("Enter the name of the console or '*' for all");
        String console = keyboard.nextLine();
        VideoGame find = new VideoGame(name,console);
        //Call on find match method to look for games off users input and returns the results
        results = findMatch(find, name, console, results, vidGames);
        return results;
    }

    public static void createDatabase(String fileName, LinkedList<VideoGame> games) throws IOException{
        try{
            BufferedReader readFile = new BufferedReader(new FileReader(new File(fileName)));
            int position = 0;
            //use for loop and create position variable so the loop can reiterate through the list to split the game titles and console type
            for(String line = readFile.readLine();line!=null;line=readFile.readLine()){
                position++;
                if(line!=""){   
                    String[] parts = line.split(DELIM);
                    if(parts.length==2){
                        String name = parts[0];
                        String console = parts[1];
                        //this is where we add each game title and each console to the name and console instance variables from VideoGame class
                        VideoGame temp = new VideoGame(name,console);
                        //call on add method in LinkedList class
                        games.add(temp);
                    }
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("File read");
    }
//print results to console
    public static void printConsole(LinkedList<VideoGame> results)
    {
    	System.out.println(results);
    }

    public static void printFile(String fileName, LinkedList<VideoGame> results) throws IOException{
    	//user can enter the name of their output file
        System.out.println("Enter the file name of your output file");
        String printFileName = keyboard.nextLine();
        if(printFileName.equalsIgnoreCase(""))
        	//set that name to the out file
            printFileName = OutFile;

        System.out.println("Would you like to append? True or false?");
        String append = keyboard.nextLine();
        if(append.equalsIgnoreCase("true"))
        	//we ask the user if they'll like to append the results to their outfile
            appendToFile(printFileName, results);
        else if(append.equalsIgnoreCase("false"))
        	//this just write the results to file;
            printToFile(printFileName, results);
    }

    public static void printToFile(String fileName, LinkedList<VideoGame> results){
        System.out.println("Adding to file");
        try{
        	//actually prints the user's results to file and resets everytime so it prints to an empty file
            PrintWriter output = new PrintWriter(new FileOutputStream(fileName));
            int length = results.getSize();
            VideoGame temp = new VideoGame();
            results.reset();
            for(int i=0;i<length;i++){
                temp = (VideoGame) results.getCurrent();
                output.println(temp.toString());
                results.goToNext();
            }
            output.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
    }
    
    public static void appendToFile(String fileName, LinkedList<VideoGame> results) throws IOException{
        System.out.println("Appending to file");
        results.print();
        try{
            FileWriter fwriter = new FileWriter(fileName,true);
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            PrintWriter output = new PrintWriter(bwriter);
            
            int length = results.getSize();
            VideoGame temp = new VideoGame();
            results.reset();
            for(int i=0;i<length;i++)
            {
                temp = (VideoGame) results.getCurrent();
                output.println(temp.toString());
                results.goToNext();
            }
            output.close();
  
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
    }
    public static LinkedList<VideoGame> findMatch(VideoGame other, String name, String console,LinkedList<VideoGame> results, LinkedList<VideoGame> vidGames)
    {
        LinkedList<VideoGame> copyResults = new LinkedList<>();
        int indices = vidGames.getSize();
        //use getAt method inside a for loop so the code can reiterate through the list to check for a match
        for(int i=0;i<indices;i++)
        {
            VideoGame temp = (VideoGame) vidGames.getAt(i);
            //Use multiple if/else statements for specific conditions based on the user's input
            //Within the statements, the code calls the toString method to combine the name and console again in order to be copied as the original
            if(name.equals("*")&&console.equals("*"))
            {
                VideoGame ret = new VideoGame(temp.getName(),temp.getConsole());
                System.out.println(ret.toString());
                copyResults.add(ret);
            }
           
            else if(name.equals("*"))
            {
                if(temp.containsConsole(other))
                {
                    VideoGame ret = new VideoGame(temp.getName(),temp.getConsole());
                    System.out.println(ret.toString());
                    copyResults.add(ret);
                }
            }
            
            else if(console.equals("*"))
            {
                if(temp.containsName(other))
                {
                    VideoGame ret = new VideoGame(temp.getName(),temp.getConsole());
                    System.out.println(ret.toString());
                    copyResults.add(ret);
                }
            }
          
            else
            {
                if(temp.containsName(other)&&temp.containsConsole(other))
                {
                    VideoGame ret = new VideoGame(temp.getName(),temp.getConsole());
                    System.out.println(ret.toString());
                    copyResults.add(ret);
                }
            }
        }//If nothing is found, the code tells the user
        if(copyResults.getSize()==0)
            System.out.println("No results found");
        return copyResults;
    }
}
