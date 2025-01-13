//Written by Kennedy Poag
public class Process {
	//create attributes
	String name;
	double time;
	//set attributes to default value
	public Process() {
		this.name = "none";
		this.time = 0.0;
		
	}
	public Process(String name, double time) {
		this.setName(name);
		this.setCompletionTime(time);
	}//setter for name
	public void setName(String name) {
		if(name!=null) {
			this.name = name;
		}else {
			this.name = "none";
		}
	}//setter for time
	public void setCompletionTime(double time) {
		//make sure time isnt 0 or less than 0
		if(time!=0.0 && time>0.0) {
			this.time = time;
		}else {
			this.time = 0.0;
		}
	}
	//getter for name
	public String getName() {
		return this.name;
	}
	//getter for time
	public double getCompletionTime() {
		return this.time;
	}
	//toString method
	public String toString() {
		return name + " Completion Time: " + time;
	}

}
