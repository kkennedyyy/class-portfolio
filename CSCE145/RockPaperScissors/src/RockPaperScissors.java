import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {

    public static void main(String[] args) {
    	//Scan keyboard for user input and create random var for the computer to randomize between rock, paper, or scissors
        Scanner k = new Scanner(System.in);
        Random r = new Random();
        //Use boolean for the while statement so the game can be reset if needed
        boolean start = true;

        while (start) {
        	//Declare and set the score to zero of both teams
            int playerScore = 0;
            int computerScore = 0;
            System.out.println("Wanna Play Rock, Paper, Scissors? Whoever gets 2/3 points wins!");
            //Use for loop to run 3 rounds of the game

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter Rock, Paper, or Scissors");
                //get the users input and create a string variable
                String answer = k.nextLine().toLowerCase();
                //Randomize the computer to choose between the index 0-2
                int computerChoice = r.nextInt(3);
                String computerChoiceString = "";
               //Create computer choice string to convert the number to a string to be displayed later
                if (computerChoice == 0) {
                	computerChoiceString = "Rock";
                }else if (computerChoice ==1) {
                	computerChoiceString = "Paper";
                }else if (computerChoice ==2) {
                	computerChoiceString = "Scissors";
                }
                	

             //Use if statement to continue the program if the user enters a choice correctly
                if (answer.equals("rock") || answer.equals("paper") || answer.equals("scissors")) {
                	//Use multiple and/or statements for when the player wins and display the combination and gives the player a point
                    if ((answer.equals("rock") && computerChoice == 2) ||
                            (answer.equals("paper") && computerChoice == 0) ||
                            (answer.equals("scissors") && computerChoice == 1)) {
                    	System.out.println(answer + " vs " + computerChoiceString + " "+ answer + " Wins");
                        System.out.println("Player Wins!");
                        playerScore++;
                    	//Use multiple and/or statements for when the computer wins and display the combination and gives the computer a point
                    } else if ((answer.equals("rock") && computerChoice == 1) ||
                            (answer.equals("paper") && computerChoice == 2) ||
                            (answer.equals("scissors") && computerChoice == 0)) {
                    	System.out.println(answer + " vs " + computerChoiceString + ", "+ computerChoiceString + " Wins");
                        computerScore++;
                    } else {
                    	//Else if the user and computer choice is the same, display that theres a tie and no points are rewarded
                    	System.out.println(answer + " vs " + computerChoiceString);
                        System.out.println("Tie! No points are rewarded");
                    }
                } else {
                	//If the user inputs an invalid input, inform them and give the computer a point
                    System.out.println("Invalid choice! Computer receives a point");
                    computerScore++;
                }
            }
            //If else statement to display the winner after 3 rounds

            if (computerScore > playerScore) {
                System.out.println("Computer wins with " + computerScore + " points!");
            } else {
                System.out.println("Player wins with " + playerScore + " points!");
            }
            // Ask user if they want to play again if yes, the game restarts by closing the keyboard and setting start to false.
            System.out.println("Do you want to play again? (Yes/No)");
            String playAgain = k.nextLine().toLowerCase();
            if (playAgain.equals("no")) {
                start = false;
                k.close();
                System.out.println("Thanks for playing");
            }
        }
    }
}
