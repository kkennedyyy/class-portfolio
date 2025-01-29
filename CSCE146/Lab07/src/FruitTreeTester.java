//Written by Kennedy Poag
import java.util.Scanner;
import java.io.File;

public class FruitTreeTester {
	//binary search tree for fruit objects
	private static final LinkedBST<Fruit> frontBST = new LinkedBST<Fruit>();
	//default input file name
	private static final String InFile = "fruitFile.txt";
	//keyboard scanner
	private static final Scanner k = new Scanner(System.in);
	//seperate weight and fruit
	private static final String DELIM = "\t";
	

	public static void main(String[] args) {
		//greet user for input
		System.out.println("Welcome to the Fruit Tree!");
		System.out.println("Please enter a Fruit File Name or d for default");
		String fileName = k.nextLine();
		if(fileName.equalsIgnoreCase("d")||fileName.equalsIgnoreCase("")) {
			//set file to default if user doesn't enter a file or press d
			fileName = InFile;
		}
		//call read file method
		readFile(fileName, frontBST);

	}
	//read fruits from file and add them to BST
	public static void readFile(String readFile, LinkedBST<Fruit> frontBST) {
		try {
			Scanner fileScan = new Scanner(new File(readFile));
			while(fileScan.hasNextLine()) {
				String next = fileScan.nextLine();
				String[] parse = next.split(DELIM);
				//splits weight and fruit from same line
				if(parse.length == 2) {
					if(parse[0]!= null) {
						String fruit = parse[0];
							double weight = Double.parseDouble(parse[1]);
							Fruit append = new Fruit(fruit, weight);
							frontBST.add(append);
						}
					}
				}
			fileScan.close();
			//once fruits are added, call all method to print to console
			allMethods(frontBST);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//performs different traversal on the BST
	public static void allMethods(LinkedBST<Fruit> frontBST) {
		System.out.println("Printing In-order traversal");
		frontBST.printInorder();
		
		System.out.println("\n"+"Printing Pre-order traversal");
		frontBST.printPreorder();
		
		System.out.println("\n"+"Printing Post-order traversal");
		frontBST.printPostorder();
		//create fruit to delete
		Fruit delete = new Fruit("Apple ",0.4859853412170728);
		System.out.println("\n"+"Deleting: "+delete.toString());
		System.out.println("Printing the In-order traversal");
		//remove the specific fruit from BST
		frontBST.remove(delete);
		frontBST.printInorder();
		
		
	}

}
