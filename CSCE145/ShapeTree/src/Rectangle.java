//Written by Kenendy Poag
public class Rectangle extends Shape {
	//Instance Variables
	private double L;
	private double W;
	private double area;
// Default Constructor
	public Rectangle(){
		super();
		this.L=0;
		this.W=0;
		this.area=this.L*this.W;
	}
	// Parameterized constructor
	public Rectangle(String name, double L, double W){
		super(name);
		this.setL(L);
		this.setW(W);
		this.setArea();
	}
//Setter for length
	public void setL(double L){
		if(L>=0)
			this.L=L;
		else
			this.L=0;
	}
//setter for width
	public void setW(double W){
		if(W>=0)
			this.W=W;
		else
			this.W=0;
	}
//getter for length
	public double getL(){
		return this.L;
	}
//getter for width
	public double getW(){
		return this.W;
	}
//setter for area
	public void setArea(){
		if(this.L>0 && this.W>0)
			this.area=this.L*this.W;
		else
			this.area=0;
	}
//getter for area
	public double getArea(){
		return this.area;
	}
//string representation
	public String toString(){
		return super.toString()+"\t"+"L: "+this.L+"\t"+"W: "+this.W+
				"\t"+"Area: "+this.area;
	}

	public String toFile(){
		return super.toFile()+"\t"+this.L+"\t"+this.W+
				"\n";
	}
	public boolean equals(Rectangle other){
		return other!=null && super.equals(other) && this.getL()==other.getL() && 
				this.getW()==other.getW();
	}
}