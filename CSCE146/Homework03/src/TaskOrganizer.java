//Written by Kennedy Poag
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskOrganizer {
	public static final String DELIM = "\t";
	//create inFile for user input and OutFile for text file of tasks
	public static final String InFile = "";
	public static final String OutFile = "Results.text";
	//array for organize tasks
	public static GenLL<Tasks>[] organizedTasks;
	public static final Scanner keyboard = new Scanner(System.in);
	//size of array
	public static final int SIZE = 5;
	//constructor to initialize TaskOrganizer
	public TaskOrganizer(){
		organizedTasks = new GenLL[SIZE];
		for(int i=0; i<organizedTasks.length;i++) {
			organizedTasks[i] = new GenLL<>();
		}
	}


	//read file the user inputs
	public void read(){
		//make sure any existing files are cleared
		for(int i=0; i<organizedTasks.length;i++) {
			for(int j =0; j<organizedTasks[i].getSize();j++) {
				organizedTasks[i].reset();
				organizedTasks[i].removeCurrent();
			}
		}
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		try {
			Scanner fileScanner = new Scanner (new File(fileName));
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String [] splitLine = line.split(DELIM);
				if(splitLine.length == 2) {
					String task = splitLine[1];
					int priority = Integer.parseInt(splitLine[0]);
					Tasks newTask = new Tasks(task, priority);
					organizedTasks[priority].add(newTask);
				}
			}fileScanner.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		//sorts task based on priority
		for(int i=0; i< organizedTasks.length; i++) {
			sort(organizedTasks[i]);
		}

	}
	


	//write tasks to output file
	public static void writeFile(){
		System.out.println("Enter the name of your output file");
		String printName = keyboard.nextLine();
		try(PrintWriter output = new PrintWriter(new FileOutputStream(printName))){
			for(int i=0; i<organizedTasks.length; i++) {
				organizedTasks[i].reset();
				while(organizedTasks[i].hasMore()) {
					output.println(organizedTasks[i].getCurrent().getPriority()+"\t"+organizedTasks[i].getCurrent().getTask());
					organizedTasks[i].goToNext();
				}
			}
			printName = OutFile;
			output.close();
		}catch (Exception e) {

		}

	}
	//print all tasks to console
	public static void printAll() {
		for(int i=0; i< organizedTasks.length; i++) {
			System.out.println("Priority "+ i + " tasks: "+ organizedTasks[i].getSize());
			organizedTasks[i].print();		
			}
	}
//remove task from list
	public static void removeTask() {
		//user enters task and priority
		System.out.println("Enter the task's priority (0-4)");
		int taskP = keyboard.nextInt();
		 keyboard.nextLine();
		System.out.println("Enter the task's action");
		String taskA = keyboard.nextLine();
		//checks if array of tasks has more
		organizedTasks[taskP].reset();
		while (organizedTasks[taskP].hasMore())
		{
			if (organizedTasks[taskP].getCurrent().getTask().compareTo(taskA)==0)
			{
				organizedTasks[taskP].removeCurrent();
				break;
			}
			organizedTasks[taskP].goToNext();
		}
	}

	//add task method
	public static void addTask() {
		//user enters task priority and task
		System.out.println("Enter the task's priority (0-4)");
		int taskP = keyboard.nextInt();
		System.out.println("Enter the task's action");
		String taskA = keyboard.nextLine() + keyboard.nextLine();
		//checks to see if task is already added
		for(int i=0; i<organizedTasks[taskP].getSize(); i++) {
			if(taskA.equals(organizedTasks[taskP].getAt(i).getTask())) {
				System.out.println("This task already exists");
				return;
			}
		}
		Tasks newTask = new Tasks(taskA, taskP);
		organizedTasks[taskP].add(newTask);
		sort(organizedTasks[taskP]);

	}
	//sorts tasks 
	public static void sort(GenLL<Tasks> genLL) {
		String temp;
		for(int i=0; i<genLL.getSize(); i++) {
			for(int j=i+1; j< genLL.getSize(); j++) {
				if(genLL.getAt(j).getTask().compareTo(genLL.getAt(j-1).getTask())< 0) {
					temp = genLL.getAt(j-1).getTask();
					genLL.getAt(j-1).setTask(genLL.getAt(j).getTask());
					genLL.getAt(j).setTask(temp);
				}
			}
		}
	}

}