/*
 

* Written by Kennedy Poag
 */
import java.util.Scanner;
public class Zodiac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("What is your zodiac sign?");
		System.out.println("Enter your birthday, Month followed by day as numbers.");
		// Scans the user's input from the keyboard
		Scanner monthKeyboard = new Scanner(System.in);
		//List Variables
		int m; 
		int d;
		//Declare variables to equal the User's input
		m = monthKeyboard.nextInt();
		d = monthKeyboard.nextInt();
		// Use if statement to tell user to enter a valid month if they enter anything
		//Below or more than 12, it tells user their month is invalid
		 if(m>12|m<=0) {
				System.out.println("Invalid Month!");
				//If else statement to tell the user the date is invalid if enter
				//a number less than 0 for day
		}else if (d<=0){
				System.out.println("Invalid Day!");
		}
			/*Use if statement to check if the user entered a specific number to represent
			 * the month and day of their birthday*/
			//A boolean is used since zodiac signs exist in two months, 
			//so an or expression is used since both conditions can be true
		else if((m==1 && (d>0) && d<=31) | (m==2 && d<=18 ))  {
			System.out.println("You are a Aquarius!");
		} else if ((m==2 && 19<=d && d<=29)| (m==3 && d<=20)) {
			System.out.println("You are Pisces!");
		} else if ((m==3 && 21<=d && d<=31)|(m==4 && d<=19)) {
			System.out.println("You are a Aries!");
		} else if ((m==4 && 20<=d && d<=30)|(m==5 && d<=20)) {
			System.out.println("You are a Taurus!");
		} else if ((m==5 && 21<=d && d<=31)|(m==6 && d<=20)) {
			System.out.println("You are a Gemini!");
		}else if ((m==6 && 21<=d && d<=30)|(m==7 && d<=22)) {
			System.out.println("You are a Cancer!");
		}else if ((m==7 && 23<=d && d<=31)|(m==8 && d<=22)) {
			System.out.println("You are a Leo!");
		}else if ((m==8 && 23<=d && 30>=d)|(m==9 && d<=22)) {
			System.out.println("You are a Virgo!");
		}else if ((m==9 && 23<=d && 30>=d)|(m==10 && d<=22)) {
			System.out.println("You are a Libra!");
		}else if ((m==10 && 23<=d && 31>=d)|(m==11 && d<=21)) {
			System.out.println("You are a Scorpio!");
		}else if ((m==11 && 22<=d && 30>=d)|(m==12 && d<=21)) {
			System.out.println("You are a Sagittarius!");
		}else if ((m==12 && 22<=d && 31>=d)|(m==1 && d<=19 )) {
			System.out.println("You are a Capricorn!");
			// If someone enters a num greater than 31 for day, the system prints
			//out the day is invalid
		}else if(d>=31) {
			System.out.println("Invalid Day");
		}
		 //closes keyboard so nothing can be typed
		monthKeyboard.close();

	}
}

