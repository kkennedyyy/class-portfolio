//Written by Kennedy Poag
import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//Get the length/width of matrix 1 from the user's keyboard 
		Scanner k = new Scanner(System.in);
		int lengthOne = k.nextInt();
		int widthOne = k.nextInt();
		//Create the first matrix to equal the size of the user input
		int [][] matriceOne = new int [lengthOne][widthOne];
		int [][]sumMatrice = new int[lengthOne][widthOne];
		
		System.out.println("Welcome to the matrix addition program!");
		System.out.println("Enter the length and width of the first matrix");
		//Use nested for loop so the user can input a component in the matrix
		for (int i =0; i<lengthOne;i++) {
			for (int j=0; j<widthOne;j++) {
				System.out.println("Enter a value at index "+ i +" "+ j);
				matriceOne[i][j] = k.nextInt();

			}
		}
		System.out.println("Enter the length and width of the second matrix");
		//Get dimensions of second matrix so it can be compared to the first dimensions
		int lengthTwo = k.nextInt();
		int widthTwo = k.nextInt();
		int [][] matriceTwo = new int [lengthTwo][widthTwo];
		//Use if statement to make sure the dimensions of both matrices are equal
		if ((lengthOne==lengthTwo)&&(widthOne==widthTwo)) {
			//Use nested for loop so the user can input a component in the matrix
			for (int i = 0; i<lengthTwo; i++) {
				for( int j=0; j<widthTwo;j++) {
					System.out.println("Enter a value at index "+ i + " "+ j);
					matriceTwo[i][j]=k.nextInt();
				}
			}//Use another nested for loop to display the components in the matrices in the right format
			for (int i=0;i<lengthOne; i++) {
				for(int j=0; j<widthOne; j++) {
					System.out.print(matriceOne[i][j]+" ");
				}
				System.out.println();

			}System.out.println("+");

			for (int i=0;i<lengthTwo; i++) {
				for(int j=0; j<widthTwo; j++) {
					System.out.print(matriceTwo[i][j] + " ");
				}
				System.out.println();
			}System.out.println("=");
			//Nested for loop adds the correct the matrices together in the same position
			for (int i=0;i<lengthTwo; i++) {
				for(int j=0; j<widthTwo; j++) {
					sumMatrice[i][j] = matriceOne[i][j]+ matriceTwo[i][j];
					System.out.print(sumMatrice[i][j] + " ");
				}
				System.out.println();
			}
			//The matrices dimensions aren't equal, the program informs the user and closes the keyboard
		}else {
			System.out.println("Inavlid Size! These cannot be added");
			k.close();
		}

	}


}	




