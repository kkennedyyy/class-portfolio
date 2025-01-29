//Written by Kennedy Poag
public class sheep implements Comparable<sheep> {
	//variables
	private int arrivalTime;
	private int shearTime;
	private String name;
	
	//default constructor
	public sheep()
	{
		this.arrivalTime = 0;
		this.shearTime = 0;
		this.name = "none";
	}
	//parameterized constructor 
	public sheep(int aTime, int sTime, String aName)
	{
		this.setArrivalTime(aTime);
		this.setShearTime(sTime);
		this.setName(aName);
	}
	//getter for arrival time
	public int getArrivalTime() {
		return arrivalTime;
	}
	//setter for arrival time
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	//getter for shear time
	public int getShearTime() {
		return shearTime;
	}
	//setter for shear time
	public void setShearTime(int shearTime) {
		this.shearTime = shearTime;
	}
	//getter for name
	public String getName() {
		return name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	//to string 
	public String toString()
	{
		return "Name: "+this.name+", Sheer Time: "+this.shearTime+", Arrival Time: "+this.arrivalTime;
	}
	//compare one sheep to another
	public int compareTo(sheep aSheep)
	{
		if(this.arrivalTime > aSheep.getArrivalTime())
			return 1;
		else if(this.arrivalTime < aSheep.getArrivalTime())
			return -1;
		else return 0;
	}
	
}