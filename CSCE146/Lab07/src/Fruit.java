//Written by Kennedy Poag
public class Fruit implements Comparable<Fruit> {
	//instance var
	private String fruit;
	private double weight;
	//default constructors
	public Fruit() {
		this.fruit = "apple";
		this.weight = 1.0;
	}
	//parameterized constructors
	public Fruit(String fruit, double weight) {
		this.setFruit(fruit);
		this.setWeight(weight);
	}
	//setter for fruit
	public void setFruit(String fruit) {
		if(fruit!=null && fruit.equalsIgnoreCase("apple")||fruit.equalsIgnoreCase("orange")
				|| fruit.equalsIgnoreCase("banana")||fruit.equalsIgnoreCase("kiwi")||
				fruit.equalsIgnoreCase("tomato")) {
			this.fruit = fruit;
		}else {
			this.fruit = "apple";
		}
	}
	//setter for weight
	public void setWeight(double weight) {
		if(weight>0) {
			this.weight = weight;
		}else {
			this.weight = 1.0;
		}
	}
	//getter for fruit
	public String getFruit() {
		return this.fruit;
	}
	//getter for weight
	public double getWeight() {
		return this.weight;
	}
	//toString method
	public String toString() {
		return "Fruit: " + fruit + " Weight: "+ weight;
	}
	//compare two fruit objects
	public boolean equals(Fruit f) {
		return f != null && this.getFruit().equals(f.getFruit())
				&& this.getWeight()==f.getWeight();
	}
	//compare two fruit objects by weight and name
	public int compareTo(Fruit f) {
		if(this.getWeight()>f.getWeight()) {
			return 1;
		}else if (this.getWeight()<f.getWeight()) {
			return -1;
		}else if(this.getWeight()==f.getWeight()) {
			return this.getFruit().compareTo(f.getFruit());
		}else {
			return -1;
		}
	}
	

}
