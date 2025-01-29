//Kennedy Poag
public class Car extends Vehicle{
	//Instance Variables
	private double mileage;
	private int passengers;
	
	//Default Constructors
	public Car() {
		super();
		this.mileage = 1.0;
		this.passengers = 1;
	}
	//Parameterized Constructor
	public Car (String manuName, int cylinders, String ownerName, double mileage, int passengers) {
		//call variables from vehicle class
		super(manuName, cylinders, ownerName);
		if(mileage>=0) {
			this.mileage = mileage;
		}else {
			this.mileage = 1.0;
		}
		if(passengers>=0) {
			this.passengers = passengers;
		}else {
			this.passengers = 1;
		}
	}
	//Getter for mileage
	public double getmileage() {
		return this.mileage;
	}
	//Setter for mileage
	public void setmileage(double mileage) {
		if(mileage>=0) {
			this.mileage = mileage;
		}
	}
	//Getter for passengers
	public double getpassengers() {
		return this.passengers;
	}
	//Setter for passengers
	public void setpassengers(int passengers) {
		if(passengers>=0) {
			this.passengers = passengers;
		}
	}
	//Use equals method to compare car and vehicle
	public boolean equals(Car Car2) {
		return super.equals(Car2)&& this.mileage == Car2.mileage && this.passengers == Car2.passengers;
	}
	//ToString method to return vehicle and car variables
	public String toString() {
		return "Manufacturer's Name: " + getmanuName() + "\n" + "Number of Cylinders: "+ getcylinders()+ "\n" + "Owner's Name: "+ getownerName()+"\n"+ "Gas Mileage "+mileage+"\n"+"Number of Passengers: "+ passengers+"\n";
	}
}