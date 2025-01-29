//Written by Kennedy Poag
public class Circle extends Shape{
	//Instance variables
	private double radius;
	private double area;
	//Default Constructor
	public Circle() {
		super();
		this.radius =0;
		this.area=Math.PI*Math.pow(this.radius,  2);
	}
	//Parameterized Constructor
	public Circle(String name, double radius) {
		super(name);
		this.setRadius(radius);
		this.setArea();
	}
	//setter for radius
	public void setRadius(double radius) {
		if(radius>=0) {
			this.radius = radius;
		}else {
			this.radius=0;
		}
	}
	//getter for radius
	public double getRadius() {
		return this.radius;
	}
	//setter for area
	public void setArea() {
		if(this.radius>0) {
			this.area = Math.PI*Math.pow(this.radius, 2);
		}else {
			this.area = 0;
		}
	}
	//getter for area
	public double getArea() {
		return this.area;
	}
	//return circle string
	public String toString() {
		return super.toString()+"\t"+"Radius: "+ this.radius+"\t"+"Area: "+this.area;
	}
	//create string for output file
	public String toFile() {
		return super.toFile()+ "\t"+this.radius+"\n";
	}
	//check equality to another circle
	public boolean equals(Circle other) {
		return other != null && super.equals(other)&& this.getRadius()==other.getRadius();
	}
	

}
