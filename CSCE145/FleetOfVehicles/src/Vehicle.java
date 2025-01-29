//Kennedy Poag
public class Vehicle {
	//Instance Variables
	private String manuName;
	private int cylinders;
	private String ownerName;
	
	//Default Constructor
	public Vehicle() {
		this.manuName = "none";
		this.cylinders = 6;
		this.ownerName = "none";
	}
	//Parameterized constructor
	public Vehicle (String manuName, int cylinders, String ownerName) {
		//use if-else to set values back to default if the if-statement isnt true
		if(manuName != null) {
			this.manuName = manuName;
		}else {
			this.manuName = "none";
		}if(cylinders > 0) {
			this.cylinders = cylinders;
		}else {
			this.cylinders = 6;
		}if(ownerName != null) {
			this.ownerName = ownerName;
		}else {
			this.ownerName = "none";
		}
	}
	
	//getter for manufacturing name
	public String getmanuName() {
		return this.manuName;
	}
	//setter for manufacturing name
	public void setmanuName(String manuName) {
		if(manuName != null) {
			this.manuName = manuName;
		}
		
	}
	//getter  for cylinders
	public int getcylinders() {
		return this.cylinders;
	}
	//setter for cylinders 
	public void setcylinders(int cylinders) {
		if (cylinders>0) {
			this.cylinders = cylinders;
		}
	}
	//getter for owner name
	public String getownerName() {
		return this.ownerName;
	}
	//setter for owner name
	public void setownerName(String ownerName) {
		if(ownerName != null) {
			this.ownerName = ownerName;
		}
	}
	//use equals method to compare the user's input 
	public boolean equals(Vehicle Vehicle2) {
		return this.manuName.equals(Vehicle2.getmanuName())&& this.cylinders == Vehicle2.getcylinders();
	}
	//String method to display the user's info at the end
	public String toString () {
		return "Manufacturer's Name: " + getmanuName() + "\n" + "Number of Cylinders: "+ getcylinders()+ "\n" + "Owner's Name: "+ getownerName()+"\n";
	}

}
