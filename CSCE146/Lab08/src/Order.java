//Written by Kennedy Poag
public class Order implements Comparable <Order> {
	//Instance Variables
	private String customer;
	private String Food;
	private int cookTime;
	private int arriveTime;
	private int cookTimeL;
	
	//Set to default Constructor
	public Order() {
		customer = "none";
		Food = "none";
		cookTime = 1;
		arriveTime = 0;
		cookTimeL = cookTime;
	}
	//Parameterized Constructors
	public Order(String customer, String Food, int cookTime, int arriveTime) {
		this.setCustomer(customer);
		this.setFood(Food);
		this.setCookTime(cookTime);
		this.setArriveTime(arriveTime);
	}
	//setter for customer
	public void setCustomer(String customer) {
		if(customer!=null) {
			this.customer = customer;
		}else {
			this.customer = "none";
		}
	}
	//getter for customer
	public String getCustomer() {
		return this.customer;
	}
	//setter for food
	public void setFood(String Food) {
		if(Food!=null) {
			this.Food = Food;
		}else {
			this.Food = "none";
		}
	}
	//getter for food
	public String getFood() {
		return this.Food;
	}
	//setter for cook time
	public void setCookTime(int cookTime) {
		if(cookTime>0) {
			this.cookTime = cookTime;
			this.cookTimeL = cookTime;
		}else {
			this.cookTime =1;
		}
	}
	//getter for cook time
	public int getCookTime() {
		return this.cookTime;
	}
	//setter for arrival time
	public void setArriveTime(int arriveTime) {
		if(arriveTime>0) {
			this.arriveTime = arriveTime;
		}else {
			this.arriveTime = 0;
		}
	}
	//getter for arrival time
	public int getArriveTime() {
		return this.arriveTime;
	}
	//to string method return name, order, and cook time left
	public String toString() {
		return "Customer: "+ this.customer + ", Order: "+ this.Food + ", Cooking Time Left: "+ this.cookTimeL; 
	}
	//compareTo method
	public int compareTo(Order other) {
		if(other == null) {
			return -1;
		}
		if(this.getCookTime()>other.getCookTime()) {
			return 1;
		}else if(this.getCookTime()>other.getCookTime()) {
			return -1;
		}else if(this.getCookTime()==other.getCookTime()) {
			return 0;
		}else {
			return -1;
		}
	}
	//cookForOneMin method
	public void cookForOneMinute() {
		this.cookTimeL -=1;
	}
	//check if food is done method
	public boolean isDone() {
		return this.cookTimeL == 0;
	}

}
