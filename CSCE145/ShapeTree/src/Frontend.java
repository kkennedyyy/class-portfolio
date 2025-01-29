//Written by Kennedy Poag
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Frontend {
    public static LinkedBST<Shape> shapeBST = new LinkedBST<Shape>();//Binary search tree for shape
    private static final String IN = "shapeFile.txt"; // Input file
    private static final String OUT = "output.txt"; //Output File
    public static final BE backEnd = new BE(); //backend
    private static final Scanner k = new Scanner(System.in); //Keyboard scanner

    public static void main(String[] args) throws Exception {
        boolean play = true;
        while (play) {
            int input = getChoice(); //get user choice
            switch (input) {
                case 1:
                	//read shapes from file
                    readFromFile();
                    break;
                case 2:
                	//print tree to console
                    printTreeConsole();
                    break;
                case 3:
                	//add a shape
                    backEnd.addShape(shapeBST);
                    break;
                case 4:
                	//remove a shape
                    backEnd.removeShape(shapeBST);
                    break;
                case 5:
                	//search for a shape
                    searchForShape();
                    break;
                case 6:
                	//find the ,ax area
                    backEnd.findMaxArea(shapeBST);
                    break;
                case 7:
                	//remove shapes above specific area
                    removeShapesAboveArea();
                    break;
                case 8:
                	//print shape tree to file
                    printTreeFile();
                    break;
                case 0:
                	//Leave program
                    play = false;
                    break;
                default:
                    System.out.println("Inhave input");
            }
        }
    }
//get user choice method
    public static int getChoice() {
        boolean have = false;
        int input = -15;
        System.out.println("Welcome to the Shape Tree!");
        while (!have) {
            boolean isDigit = true;
            boolean haveOption = true;
            System.out.println("Enter 1 To Read a Shape Tree from a File.");
            System.out.println("Enter 2 To Print a Tree Traversal to the Console.");
            System.out.println("Enter 3 To Add a Shape.");
            System.out.println("Enter 4 To Remove a Shape.");
            System.out.println("Enter 5 To Search for a Shape.");
            System.out.println("Enter 6 To Find the Shape with the Max Area.");
            System.out.println("Enter 7 To Remove All Shapes Greater than an Area.");
            System.out.println("Enter 8 To Print Shape Tree to File.");
            System.out.println("Enter 0 To Quit.");
            String inputS = k.nextLine();
            try {
                input = Integer.parseInt(inputS);
            } catch (NumberFormatException e) {
                System.out.println("That is not an integer of digits");
                isDigit = false;
            }
            if (isDigit && (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6
                    || input == 7 || input == 8 || input == 0))) {
                haveOption = false;
            }if (isDigit && !haveOption) {
                System.out.println("input must be 1, 2, 3, 4, 5, 6, 7, 8, 9");
            }if (isDigit && haveOption) {
                have = true;
        }}
        return input;
    }

//read shapes from file
    public static void readFromFile() {
        boolean have = false;
        String inFile = IN;
        while (!have) {
            System.out.println("Enter the file's name or x for default");
            inFile = k.nextLine();
            if (inFile.equalsIgnoreCase("x") || inFile.equalsIgnoreCase("")) {
                inFile = IN;
                have = true;
                break;
            }
            File file = new File(inFile);
            if (!(file.exists() && file.isFile())) {
                System.out.println("File Not Found");
                have = false;
                continue;
            }
            have = true;
        }
        shapeBST = BE.readTree(inFile, shapeBST);
        shapeBST.printInorder();
        System.out.println();
    }

//print tree to console method
    public static void printTreeConsole() {
        int order = getTraversal();
        backEnd.printTreeFile(shapeBST, order);
    }
//get traversal method
    public static int getTraversal() {
        boolean have = false;
        int input = -15;
        while (!have) {
            boolean isDigit = true;
            boolean haveOption = true;

            System.out.println("Which traversal?");
            System.out.println("Enter 1 for Pre-order");
            System.out.println("Enter 2 for In-order");
            System.out.println("Enter 3 for Post-order");

            String orderS = k.nextLine();

            try {
                input = Integer.parseInt(orderS);
            } catch (NumberFormatException e) {
                System.out.println("That is not an integer of digits");
                isDigit = false;
            }
            
            if (isDigit && (!(input == 1 || input == 2 || input == 3))) {
                haveOption = false;
            } if (isDigit && !haveOption) {
                System.out.println("input must be 1, 2, or 3");
            }if (isDigit && haveOption) {
                have = true;
        }}
        return input;
    }

    public static void printTreeFile() throws IOException 
    {
        boolean have = false;
        String fileName = OUT;
        while (!have) 
        {
            System.out.println("Enter the file's name or x for default");
            fileName = k.nextLine();
            if (fileName.equalsIgnoreCase("x") || fileName.equalsIgnoreCase("")) {
                fileName = OUT;
                have = true;
                break;
            }
            File f = new File(fileName);
            f.createNewFile();
            have = true;
        }

        String printType = getOrder();

        backEnd.print(fileName, shapeBST, printType);
    }
//get order choice method
    public static String getOrder() {
        boolean have = false;
        String printType = "";
        while (!have) 
        {
            System.out.println("Enter whichever to print: preorder, inorder, or postorder");
            printType = k.nextLine();

            if (printType.equalsIgnoreCase("preorder") || printType.equalsIgnoreCase("inorder")
                    || printType.equalsIgnoreCase("postorder"))
                have = true;
            else
                System.out.println("Choose one: preorder, inorder, postorder");
        }
        return printType;
    }
//searching method
    public static void searchForShape() throws Exception 
    {
        boolean ishaveName = false;
        String name = "none";
        while(!ishaveName)
        {
            System.out.println("Enter the shape name");
            name = k.nextLine();
            if(!(name.toUpperCase().contains("RECT")||name.toUpperCase().contains("CIRC")||
                name.toUpperCase().contains("RIGH")||name.toUpperCase().contains("TRI")))
            {
                System.out.println("Error, Try Agaian");
                ishaveName = false;
            }
            else
                ishaveName = true;
        }
        boolean ret = backEnd.searchForShape(shapeBST, name);
        System.out.println("Found that guy: " + ret + "\n");
    }
//remove shapes from above area method
    public static void removeShapesAboveArea() 
    {
        boolean haveDouble = false;
        String maxAreaS="10000.0";
        Double maxArea = 10000.0; 
        while(!haveDouble)
        {
            System.out.println("Enter the maximum area");
            maxAreaS = k.nextLine();
            try{
                maxArea = Double.parseDouble(maxAreaS);
                haveDouble=true;
                if(maxArea<=0)
                {
                    System.out.println("Area must be above 0");
                    haveDouble = false;
                }
            }catch(NumberFormatException e)
            {
                System.out.println("Enter a decimal value for max area");
                haveDouble = false;
            }
        }
        maxArea = Double.parseDouble(maxAreaS);
        backEnd.removeShapesAboveArea(shapeBST, maxArea);
    }
}