//Written by Kennedy Poag

public class Triangle {

//Create instance variables
	private double length;
	private double height;
	
	//set length and height
	public Triangle (){
		this.length = 0;
		this.height = 0;
	}
	//Parameterized Constructor
	public Triangle(double length, double height) {
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
	//Setters
	public void setLength(double length) {
		this.length=length;
	}
	public void setHeight(double height) {
		this.height=height;
	}
	//Calculate area of Triangle
	public double area() {
		double inside = length * height;
		return inside*0.5;
	}//Return area of Triangle
	public String toString() {
		return "The are of the Triangle is: "+ area();
	}
	//See if Triangles are equals
	public boolean equals(Triangle Triangle2) {
		return this.length == Triangle2.getLength()&&this.height == Triangle2.getHeight();
		
	
	}
	


}
