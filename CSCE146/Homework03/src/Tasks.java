//Written by Kennedy Poag

public class Tasks {
//Instance variables
	private String task;
	private int priority;
	public Tasks() {
		//set variables to default
		this.task = "none";
		this.priority = 4;
	}
	//parameterized constructor
	public Tasks(String task, int priority) {
		this.setTask(task);
		this.setPriority(priority);
	}
	//sets method for task
	public void setTask(String task) {
		if(task!=null) {
			this.task=task;
		}else {
			this.task = "none";
		}
	}
	//sets method for priority
	public void setPriority(int priority){
		if(priority >= 0 && priority<=5) {
			this.priority=priority;
		}else {
			this.priority= 4;
		}
	}
	//getter method for task
	public String getTask(){
		return this.task;
	}
	//getter method for priority
	public int getPriority(){
		return this.priority;
	}
	//toString method to show task and priority
	public String toString(){
		return task +"\t"+ priority;
	}

}
