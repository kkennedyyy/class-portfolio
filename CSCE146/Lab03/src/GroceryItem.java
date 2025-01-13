//Written by Kennedy Poag
public class GroceryItem{
	//Instance Variables
	private String name;
	private double price;
	//Default Constructors
	public GroceryItem() {
		this.name = "";
		this.price = 0.0;
		//Parameterized Constructors
	}public GroceryItem(String name , double price) {
		this.name = name;
		this.price = price;
	}//Accessors/Getters
	public String getName() {
		return name;
	}public double getPrice() {
		return price;
	}//Setters/Mutators
	public void setName(String name) {
		this.name = name;
	}public void setPrice(double price) {
		this.price = price;
	}
	//toString method
	public String toString() {
		return "Grocery Item Name: " + name + " Value: "+ price;
	}//equals method to check values
	public boolean equals(GroceryItem GroceryItem2) {
		return GroceryItem2 != null && this.name.equals(GroceryItem2.getName()) && this.price == GroceryItem2.getPrice();
	}
}