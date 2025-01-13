import java.util.Scanner;
//Written by Kennedy Poag

public class BinaryChanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Find the value and total of two 4-digit binary numbers");
		System.out.println("Print two four digit binary numbers on two different lines");
		//Retrieve data from the user's keyboard and declare them as strings
		Scanner binaryKeyboard = new Scanner(System.in);
		String decimalVal = binaryKeyboard.nextLine();
		String decimalVal2 = binaryKeyboard.nextLine();
		//Set each number in the binary number's index to a new string var
		String b0 = decimalVal.charAt(0)+"";
		String b1 = decimalVal.charAt(1)+"";
		String b2 = decimalVal.charAt(2)+"";
		String b3 = decimalVal.charAt(3)+"";
		//Change the string to integers so they can be multiplied later
		int d0 = Integer.parseInt(b0);
		int d1 = Integer.parseInt(b1);
		int d2 = Integer.parseInt(b2);
		int d3 = Integer.parseInt(b3);
		String b4 = decimalVal2.charAt(0)+"";
		String b5 = decimalVal2.charAt(1)+"";
		String b6 = decimalVal2.charAt(2)+"";
		String b7 = decimalVal2.charAt(3)+"";
		int d4 = Integer.parseInt(b4);
		int d5 = Integer.parseInt(b5);
		int d6 = Integer.parseInt(b6);
		int d7 = Integer.parseInt(b7);
		//multiply each number by base 2 value and set it as a new variable
		int num1 = d0*2*2*2 + d1*2*2 + d2*2 + d3*1;
		//display decimal value of binary number
		System.out.println(decimalVal + " equals " + num1);
		int num2 =  d4*2*2*2 + d5*2*2 + d6*2 + d7*1;
		System.out.println(decimalVal2 + " equals " + num2);
		//Add the two decimal values together
		int total = num1 + num2; 
		
		//Display the total of the two decimal values
		System.out.println("Added together their value equals "+ total);
		//close keyboard to prevent anything from being entered 
		binaryKeyboard.close();
	}

}
