//Written by Kennedy Poag
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BE {
	private static final String DELIM = "\t";
	private static final int Rect_Tri = 3;
	private static final int Circle = 2;
	public static final Scanner k = new Scanner(System.in);
	//Method to read shapes from file and make binary search tree
	public static LinkedBST<Shape> readTree(String readFile, LinkedBST<Shape> game){

		int track = 1;
		try {
			Scanner fileScanner = new Scanner(new File(readFile));

			while(fileScanner.hasNext()) {
				String next = fileScanner.nextLine();
				if(next.endsWith("\t")||next.endsWith("\s")) {
					track++;
					continue;
				}
				//Split shapes from their dimensions
				String [] parse = next.split(DELIM);
				if(parse.length == Rect_Tri) {
					String name = parse[0];
					double p1 = Double.parseDouble(parse[1]);
					double p2 = Double.parseDouble(parse[2]);

					if(name.equalsIgnoreCase("rectangle")) {
						Rectangle temp = new Rectangle(name, p1, p2);
						if(!(game.search(temp))) {
							game.add(temp);
						}
					}else if(name.equalsIgnoreCase("right triangle")) {
						RightTriangle temp2 = new RightTriangle(name, p1, p2);
						if(!(game.search(temp2))) {
							game.add(temp2);
						}
					}
					else {
						System.out.println("Invalid Format At Line "+ track +": "+ next);
					}
				}else if(parse.length == Circle) {
					String name = parse[0];
					double p = Double.parseDouble(parse[1]);

					if(name.equalsIgnoreCase("Circle")) {
						Circle temp = new Circle(name, p);
						if(!(game.search(temp))) {
							game.add(temp);
						}
						else {
							System.out.println("Invalid Sequence At Line "+ track+": "+ next);
						}
					}else {
						System.out.println("Invalid Sequence At Line "+ track+": "+next);
					}
					track++;
				}
			}
			fileScanner.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Printing After Reading In-order"+ "\n");
		return game;
	}
	//Add shape to the list
	public void addShape(LinkedBST<Shape> game) {
		boolean validShape = true;
		boolean exists = false;
		boolean recLength = false;
		boolean recWidth = false;
		boolean radius = false;
		boolean triBase = false;
		boolean triHeight = false;
		do {
			System.out.println("What type of shape would you like to add?");
			String shape = k.nextLine();
			if(shape.toLowerCase().contains("rect")) {
				shape = "Rectangle";
				String lengthS = "none";
				String widthS = "none";
				while(!recLength) {
					System.out.println("What length should the rectangle be");
					lengthS = k.nextLine();
					try {
						Double length = Double.parseDouble(lengthS);
						recLength = true;
						if(length <=0) {
							System.out.println("Need to enter length greater than zero");
							recLength = false;
						}
					}catch(NumberFormatException e) {
						System.out.println("Enter decimal numbers");
						recLength = false;
					}
				}
				Double length = Double.parseDouble(lengthS);
				while(!recWidth) {	
					System.out.println("What width should the rectangle be");
					widthS = k.nextLine();
					try {
						Double width = Double.parseDouble(widthS);
						recWidth = true;
						if(width <=0) {
							System.out.println("Need to enter width greater than zero");
							recWidth = false;
						}
					}catch(NumberFormatException e) {
						System.out.println("Enter decimal numbers");
						recWidth = false;
					}
				}
				Double width = Double.parseDouble(widthS);
				Rectangle add = new Rectangle(shape, length, width);
				exists = game.search(add);
				if(!exists) {
					game.add(add);
				}
				validShape= true;
			}
			else if(shape.toLowerCase().contains("circ")) {
				shape = "Circle";
				String radiusS = "none";
				while(!radius) {
					System.out.println("What radius should the circle be?");
					radiusS = k.nextLine();
					try {
						Double radiuss = Double.parseDouble(radiusS);
						radius = true;
						if(radiuss<=0) {
							System.out.println("Need to enter radius greater than zero!");
							radius = false;
						}
					}catch(NumberFormatException e) {
						System.out.println("Enter numbers");
						radius = false;
					}
				}
				Double radiuss = Double.parseDouble(radiusS);

				Circle add = new Circle(shape, radiuss);
				exists = game.search(add);
				if(!exists) {
					game.add(add);
				}
				validShape=true;
			}
			else if(shape.toLowerCase().contains("righ")||shape.toLowerCase().contains("tri")) {
				shape = "Right Triangle";
				String baseT = "none";
				String heightT = "none";
				while(!triBase) {
					System.out.println("What base length should the triangle be?");
					baseT = k.nextLine();
					try {
						Double base = Double.parseDouble(baseT);
						triBase = true;
						if(base<=0) {
							System.out.println("Need to enter base greater than zero!");
							triBase = false;
						}
					}catch(NumberFormatException e) {
						System.out.println("Enter numbers");
						triBase = false;
					}
				}
				Double base = Double.parseDouble(baseT);

				while(!triHeight)
				{
					System.out.println("What height should the triangle be?");
					heightT = k.nextLine();
					try
					{
						Double height = Double.parseDouble(heightT);
						triHeight = true;
						if(height<=0)
						{
							System.out.println("Need to enter height greater than zero!");
							triHeight=false;
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Enter decimal numbers");
						triHeight = false;
					}
				}
				Double height = Double.parseDouble(heightT);
				RightTriangle add = new RightTriangle(shape, base, height);
				exists = game.search(add);
				if(!exists) {
					game.add(add);
				}
				validShape = true;
			}else {
				validShape = false;
				System.out.println("The input should be 'Rectangle', 'Circle', or ' Right Triangle'");
			}
		}while(!validShape);
		if(exists) {
			System.out.println("Shape already exists and wasn't added");
		}else {
			System.out.println(" Shape Added");
			System.out.println("Printing in order");
			game.printInorder();
		}
	}
	//remove shape from list method
	public void removeShape(LinkedBST<Shape> game) {
		System.out.println("What type of shape would you like to remove?");
		String shape = k.nextLine();
		boolean removed = false;

		if (shape.toLowerCase().contains("rect")) {
			boolean validL = false;
			boolean validW = false;
			String recLength = "";
			String recWidth = "";

			shape = "Rectangle";

			while (!validL) {
				System.out.println("What length was the rectangle? (Enter 'none' if not applicable)");
				recLength = k.nextLine();
				if (recLength.equalsIgnoreCase("none")) {
					validL = true;
				} else {
					try {
						Double.parseDouble(recLength);
						validL = true;
					} catch (NumberFormatException e) {
						System.out.println("Enter a valid number or 'none'");
					}
				}
			}
			Double length = null;
			if (!recLength.equalsIgnoreCase("none")) {
				length = Double.parseDouble(recLength);
			}

			while (!validW) {
				System.out.println("What width was the rectangle? (Enter 'none' if not applicable)");
				recWidth = k.nextLine();
				if (recWidth.equalsIgnoreCase("none")) {
					validW = true;
				} else {
					try {
						Double.parseDouble(recWidth);
						validW = true;
					} catch (NumberFormatException e) {
						System.out.println("Enter a valid number or 'none'");
					}
				}
			}
			Double width = null;
			if (!recWidth.equalsIgnoreCase("none")) {
				width = Double.parseDouble(recWidth);
			}

			Rectangle subtract = new Rectangle(shape, length, width);
			removed = game.search(subtract);
			if (removed)
				game.remove(subtract);
		}
		else if(shape.toLowerCase().contains("circle"))
		{
			boolean vRadius = false;
			String radiusS = "none";
			shape = "Circle";

			while(!vRadius)
			{
				System.out.println("What radius was the circle?");
				radiusS = k.nextLine();
				try
				{
					Double radius = Double.parseDouble(radiusS);
					vRadius = true;
					if(radius <= 0)
					{
						System.out.println("Need to enter radius greater than zero!");
						vRadius = false;
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Enter valid decimals");
					vRadius = false;
				}
			}
			Double radius = Double.parseDouble(radiusS);

			Circle subtract = new Circle(shape, radius);
			removed = game.search(subtract);
			if(removed) {
				game.remove(subtract);
			}
			else if(shape.toLowerCase().contains("right")||shape.toLowerCase().contains("triangle"))
			{
				boolean validBase = false;
				boolean validHeight = false;
				String baseS = "none";
				String heightS = "none";
				shape = "Right Triangle";

				while(!validBase)
				{
					System.out.println("What base length was the triangle?");
					baseS = k.nextLine();
					try
					{
						Double base = Double.parseDouble(baseS);
						validBase = true;
						if(base<=0)
						{
							System.out.println("Need to enter base greater than zero!");
							validBase = false;
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Enter valid decimals");
						validBase = false;
					}
				}
				Double base = Double.parseDouble(baseS);
				while(!validHeight)
				{
					System.out.println("What height was the triangle?");
					heightS = k.nextLine();
					try
					{
						Double height = Double.parseDouble(heightS);
						validHeight = true;
						if(height<=0)
						{
							System.out.println("Need to enter height greater than zero!");
							validHeight = false;
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Enter valid decimals");
						validHeight = false;
					}
				}
				Double height = Double.parseDouble(heightS);

				RightTriangle subtract2 = new RightTriangle(shape, base, height);
				removed = game.search(subtract2);
				if(removed) {
					game.remove(subtract2);
					System.out.println("printing in order ");
					game.printInorder();
				}else {
					System.out.println("ELEMENT NEVER FOUND");
				}
			}
		}

	}
//find max area method
	public void findMaxArea(LinkedBST<Shape> game) throws Exception
	{
		System.out.println("Finding the shape with the max area");
		Shape ret = game.findMaxInTree();
		System.out.print("The shape with the max area is...");
		if(ret instanceof Rectangle)
		{
			Rectangle rect = (Rectangle)ret;
			System.out.print(rect.toString()+"\n");
		}
		else if(ret instanceof Circle)
		{
			Circle circ = (Circle)ret;
			System.out.print(circ.toString()+"\n");
		}
		else if(ret instanceof RightTriangle)
		{
			RightTriangle right = (RightTriangle)ret;
			System.out.print(right.toString()+"\n");
		}
		else
		{
			throw new Exception("Error");
		}
		System.out.println();
	}

	//removing shapes above a certain area
	public void removeShapesAboveArea(LinkedBST<Shape> game, double maxArea)
	{
		System.out.println("Removing the shapes above the area");
		game.removeAboveArea(maxArea);
		System.out.println("printing in order ");
		game.printInorder();
	}

	//print to file method
	public void printTreeFile(LinkedBST<Shape> game, int order)
	{
		switch(order)
		{
		case 1:
			game.printPreorder();
			System.out.println();
			break;
		case 2:
			game.printInorder();
			System.out.println();
			break;
		case 3: 
			game.printPostorder();
			System.out.println();
			break;
		default:
			System.out.println("Not an option");
		}
	}
	public void print(String fileName, LinkedBST<Shape> game, String typePrint) throws IOException
	{
		if(typePrint.toLowerCase().contains("pre"))
			game.writeTreePreorder(fileName);
		else if(typePrint.toLowerCase().contains("in"))
			game.writeTreeInorder(fileName);
		else if(typePrint.toLowerCase().contains("post"))
			game.writeTreePostorder(fileName);
	}

	//finding a shape
	public boolean searchForShape(LinkedBST<Shape> game, String name) throws Exception {
		if (name.toLowerCase().contains("rect")) {
			boolean validLength = false;
			boolean validWidth = false;
			String lengthS = "none";
			String widthS = "none";

			name = "Rectangle";

			while (!validLength) {
				System.out.println("Enter the length");
				lengthS = k.nextLine();
				try {
					double length = Double.parseDouble(lengthS);
					validLength = true;
					if (length <= 0) {
						System.out.println("Need to enter length greater than zero!");
						validLength = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Enter a valid decimal value for length");
					validLength = false;
				}
			}
			double length = Double.parseDouble(lengthS);

			while (!validWidth) {
				System.out.println("Enter the width");
				widthS = k.nextLine();
				try {
					double width = Double.parseDouble(widthS);
					validWidth = true;
					if (width <= 0) {
						System.out.println("Need to enter length greater than zero!");
						validWidth = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Enter a valid decimal value for width");
					validWidth = false;
				}
			}
			double width = Double.parseDouble(widthS);

			Rectangle temp = new Rectangle(name, length, width);
			boolean ret = game.search(temp);
			return ret;
		} else if (name.toLowerCase().contains("circ")) {
			boolean validRad = false;
			String radiusS = "none";
			name = "Circle";

			while (!validRad) {
				System.out.println("Enter the radius");
				radiusS = k.nextLine();
				try {
					double radius = Double.parseDouble(radiusS);
					validRad = true;
					if (radius <= 0) {
						System.out.println("Need to enter radius greater than zero!");
						validRad = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Enter a valid decimal radius");
					validRad = false;
				}
			}
			double radius = Double.parseDouble(radiusS);

			Circle temp = new Circle(name, radius);
			boolean ret = game.search(temp);
			return ret;
		} else if (name.toLowerCase().contains("righ") || name.toLowerCase().contains("tri")) {
			boolean validBase = false;
			boolean validHeight = false;
			String baseS = "none";
			String heightS = "none";
			name = "Right Triangle";

			while (!validBase) {
				System.out.println("Enter the base");
				baseS = k.nextLine();
				try {
					double base = Double.parseDouble(baseS);
					validBase = true;
					if (base <= 0) {
						System.out.println("Need to enter base greater than zero!");
						validBase = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Enter a valid decimal base");
					validBase = false;
				}
			}
			double base = Double.parseDouble(baseS);

			while (!validHeight) {
				System.out.println("Enter the height");
				heightS = k.nextLine();
				try {
					double height = Double.parseDouble(heightS);
					validHeight = true;
					if (height <= 0) {
						System.out.println("Need to enter height greater than zero!");
						validHeight = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Enter a valid decimal height");
					validHeight = false;
				}
			}
			double height = Double.parseDouble(heightS);

			RightTriangle temp = new RightTriangle(name, base, height);
			boolean ret = game.search(temp);
			return ret;
		} else {
			throw new Exception("input and shape don't match");
		}
	}
}
