//Kennedy Poag
public class Truck extends Vehicle  {
	//Instance Variables
	private double loadCap;
	private double towCap;
	
	//Default Constructor
	public Truck() {
		super();
		this.loadCap = 1.0;
		this.towCap = 1.0;
	}
	//Parameterized constructor
	public Truck (String manuName, int cylinders, String ownerName, double loadCap, double towCap) {
		//call variables from vehicle class
		super(manuName, cylinders, ownerName);
		if (loadCap>=0) {
			this.loadCap = loadCap;
		}else {
			this.loadCap = 1.0;
		}
		if(towCap>=0) {
			this.towCap = towCap;
		}else {
			this.towCap = 1.0;
		}
	}
	//Getter for load capacity
	public double getloadCap() {
		return this.loadCap;
	}
	//Setter for load capacity
	public void setloadCap(double loadCap) {
		if(loadCap>=0) {
			this.loadCap = loadCap;
		}
	}
	//Getter for towing capacity
	public double gettowCap() {
		return this.towCap;
	}
	//Setter for towing capacity
	public void settowCap(double towCap) {
		if(towCap>=0) {
			this.towCap = towCap;
		}
	}
	//Use equals method to compare the vehicles
	public boolean equals(Truck Truck2) {
		return super.equals(Truck2)&& this.loadCap == Truck2.loadCap && this.towCap == Truck2.towCap;
	}
	//ToString method to return vehicle variables and truck variables
	public String toString() {
		return "Manufacturer's Name: " + getmanuName() + "\n" + "Number of Cylinders: "+ getcylinders()+ "\n" + "Owner's Name: "+ getownerName()+"\n"+ "Towing Capacity: "+towCap+"\n"+"Load Capacity: "+ loadCap+"\n";

	}
}
