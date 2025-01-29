//Written by Kennedy Poag
public class Circle {
	//Instance variable
	private double Radius;
	
	//Default constructor setting the radius
	public Circle (){
		this.Radius = 0;
	}
	//Parameterized Constructor
	public Circle(double Radius) {
		this.Radius = Radius;
	}
	//Getter 
	public double getRadius() {
		return Radius;
	}//Setter
	public void setRadius(double Radius) {
		this.Radius=Radius;
	}
	//Calculate area of circle
	public double area() {
		double squared = Radius*Radius;
		 double area = Math.PI*squared;
		return area;
	}//Return area of circle
	public String toString() {
		return "The are of the circles is: "+ area();
	}
	//See if circles are equals
	public boolean equals(Circle circle2) {
		return this.Radius == circle2.getRadius();
		
	}
}
	