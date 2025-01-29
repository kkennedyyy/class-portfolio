/*
 * Written by Kennedy Poag
 */
import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("What is your name?");
		Scanner keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
		System.out.println("Greetings! " +name);
		System.out.println("How many cats do you have?");
		int numberOfCats = keyboard.nextInt();
		System.out.println("How does one live with "+numberOfCats + "cats?");

	}

}
