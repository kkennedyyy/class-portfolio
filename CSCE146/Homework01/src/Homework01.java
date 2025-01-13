import java.util.Scanner;
import java.io.*;
import java.util.random.*;

public class Homework01 {
    private Prize[] prize;
    public static final String DELIM = "\t";
    public static final int prizesChosen = 5;

    public Homework01() {
        init(prizeAmount);
    }

    public static void main(String[] args) {
        Prize[] allPrizes = new Prize[prizeAmount];
        Prize[] chosenPrizes = new Prize[prizesChosen];
        System.out.println("Welcome to the showcase shwo down!");
        System.out.println("Your prizes are: " );
        for (Prize p: chosenPrizes) {
        	System.out.println(p.getName());
        }
        readPrizeList("prizeList.txt");
      
    }


    public void readPrizeList(String name) {
        try {
            Scanner fileScanner = new Scanner(new File(name));
            int count = 0;
            while (fileScanner.hasNextLine() && count < prizeAmount) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(DELIM);
                if (parts.length == 2) {
                    String prizeName = parts[0];
                    double prizePrice = Double.parseDouble(parts[1]);
                    prize[count] = new Prize(prizeName, prizePrice);
                    count++;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    