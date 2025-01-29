//Written by Kennedy Poag
import java.util.Scanner;

public class CalculatorTester {
	public static void main(String[] args) {
		//Use while statement to allow user to reuse calculator 
		boolean useAgain = true;
		while (useAgain) {
			//Get user input from keyboard and ask them to enter two numbers
			Scanner k = new Scanner(System.in);
			System.out.println("Enter 2 numbers, press enter after each");
			int one = k.nextInt();
			int two = k.nextInt();
			//Ask user what operation they want to use
			System.out.println("What operation do you want to use on your numbers?");
			System.out.println("1. Addition"); 
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			//Get user choice as a number
			int choice = k.nextInt();
			//Call class name to retrieve operation methods
			CalculatorTester calculator = new CalculatorTester();
			//use if else statements to perform user's operation based on their number choice
			if (choice ==1) {
				//display sum by calling the addition method
				int result = calculator.addition(one,two);
				System.out.println(one+" + "+ two +" "+"="+" "+result);
			}else if (choice ==2) {
				//display difference by calling the subtraction method
				int result = calculator.subtraction(one,two);
				System.out.println(one+" - "+ two +" "+"="+" "+result);
			}else if (choice ==3) {
				//display product by calling multiplication method
				int result = calculator.multiplication(one,two);
				System.out.println(one+" * "+ two +" "+"="+" "+result);
			}else if (choice ==4) {
				//display quotient by calling division method
				int result = calculator.division(one,two);
				System.out.println(one+" ÷ "+ two +" "+"="+" "+result);
			}else if (choice >= 5) {
				//if the user inputs a value equal or larger to 5, the keyboard closes and tells user the input is invalid and stops the loop
				System.out.println("Invalid input");
				k.close();
				break;
			}
			System.out.println("Would you like to use again?");
			String answer = k.next().toLowerCase();
			//Ask user if they want to play again and closes keyboard and stops the loop
			if (answer.equals("no")) {
				System.out.println("Thanks for using the calculator!");
				useAgain = false;
				k.close();
			}
		}

	}//operation methods used to be called in the class 

	// addition method by getting the user's numbers, adding them, and then returning the sum
	public int addition(int one, int two) {
		System.out.println("You selected Addition");
		int sum = one + two;
		return sum;
	}
	// subtraction method by getting the user's number, subtracting them, and then returning the difference
	public int subtraction(int one, int two) {
		System.out.println("You chose subtraction");
		int difference = one - two;
		return difference;
	}
	//division method by getting the user's number, dividing them, and then returning the quotient 
	public int division(int one, int two) {
		System.out.println("You chose division");
		int quotient = one/two;
		return quotient;
		// multiplication method by getting the user's number, multiplying them, and then returning the product
	}public int multiplication(int one, int two) {
		System.out.println("You chose multiplication");
		int product = one*two;
		return product;
	}


}
