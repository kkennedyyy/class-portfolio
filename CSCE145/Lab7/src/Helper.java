import java.util.Scanner;
// public class helper to access the methods
public class Helper {
	
	
	//for loop method takes one parameter
	public static void forLoop(int s) {
		//access user's keyboard
		Scanner k = new Scanner(System.in);
		//int s is the size of the list
		int [] size = new int[s];
		for (int i=0; i<s; i++) {
			//use for loop to put the user's input inside the list to store
			System.out.println("Enter a number to store");
			size[i]=k.nextInt();
		}
		//set sum to zero
		int sum = 0;
		//use for loop to access each number to be added together
		for (int i=0; i<s; i++) {
			int num = size[i];
			sum += num;
		}
		//displays the sum of the list
		System.out.println("Sum of the values in the array: "+ sum);
	}
	
	
	//Whileloop method doesnt take any parameters
	public static void whileLoop() {
		//use scanner to get user input
		Scanner keyboard = new Scanner(System.in);
		int sum = 0;
		int num;
		//use do while loop to tell the user to enter as many numbers
		do {
			System.out.println("Enter a number, enter 0 to stop");
			num = keyboard.nextInt();
			//all the values will be added together
			sum+= num;
			//Use while to display the sum if the user inserts zero
		}while (num !=0);
		System.out.println("Sum of the values entered: "+ sum);
	}
	
	
	//ifStatements method takes two parameters
	public static void ifStatements(int x, int y) {
		//if x>y then the code displays x is greater
		if (x>y) {
			System.out.println("X is greater than Y");
			//Else if x=y then the code displays they're equal
		}else if(x==y) {
			System.out.println("X equal to Y");
			//Else if x<y then the code displays y is greater
		}else if (x<y) {
			System.out.println("X is less than Y");
		}
	}

}
