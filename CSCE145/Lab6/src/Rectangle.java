//Written by Kennedy Poag

public class Rectangle {
//Instance Variables
	private double length;
	private double height;
	
	//set length and height
	public Rectangle (){
		this.length = 0;
		this.height = 0;
	}
	//Parameterized Constructor
	public Rectangle(double length, double height) {
		this.length = length;
		this.height=height;
	}
	//Getter 
	public double getLength() {
		return length;
	}
	public double getHeight() {
		return height;
	}
	//Setter
	public void setLength(double length) {
		this.length=length;
	}
	public void setHeight(double height) {
		this.height=height;
	}
	//Calculate area of Rectangle
	public double area() {
		double inside = length * height;
		return inside;
	}//Return area of Rectangle
	public String toString() {
		return "The are of the Rectangle is: "+ area();
	}
	//See if Rectangles are equals
	public boolean equals(Rectangle Rectangle2) {
		
		return this.length == Rectangle2.getLength()&&this.height == Rectangle2.getHeight();
		
	}
}
	

