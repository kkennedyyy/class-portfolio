//Written by Kennedy Poag
public class Shape implements Comparable<Shape> {

	private String name;
// Default constructor sets name
	public Shape() {
		this.name = "null";
	}
	//parameterized constructor 
	public Shape(String name) {
		this.setName(name);
	}
	//setter for name
	public void setName(String name) {
		if(name!=null) {
			this.name = name;
		}
	}
	//getter for name
	public String getName() {
		return this.name;
	}
	//String of shape object
	public String toString() {
		return "Name: "+ this.name;
	}
	//return string for file output
	public String toFile() {
		return this.name;
	}
	//check shape equals
	public boolean equals(Shape other) {
		return other != null && this.getName().equals(other.getName());
	}
	@Override
	//compare shape
	public int compareTo(Shape o) {
		// TODO Auto-generated method stub
		double thisArea=-1;
		double oArea=-1;
		if(o!=null)
		{
			//calculates area based on type of this shape
			if(this instanceof Rectangle)
			{
				Rectangle thisR = (Rectangle)this;
				thisArea = thisR.getArea();
			} 
			else if(this instanceof Circle)
			{
				Circle thisR = (Circle)this;
				thisArea = thisR.getArea();
			}
			else if(this instanceof RightTriangle)
			{
				RightTriangle thisR = (RightTriangle)this;
				thisArea = thisR.getArea();
			}
// calculate area based on type of other shape
			if(o instanceof Rectangle)
			{
				Rectangle othR = (Rectangle)o;
				oArea = othR.getArea();
			} 
			else if(o instanceof Circle)
			{
				Circle othR = (Circle)o;
				oArea = othR.getArea();
			}
			else if(o instanceof RightTriangle)
			{
				RightTriangle othR = (RightTriangle)o;
				oArea = othR.getArea();
			}
		}
//compares areas
		if(thisArea>=0 && oArea>=0) {
			if(thisArea > oArea) {
				return 1;
			}else if(thisArea < oArea) {
				return -1;
			}else {
				return (this.getName().compareTo(o.getName()));
			}
		}
		//return default value
		return 2000;
	}
}
