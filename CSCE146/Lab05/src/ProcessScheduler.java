//Written by Kennedy Poag
public class ProcessScheduler {
	//linked list queue to hold processes
	private LLQueue<Process> processes;
	//current process
	private Process currentProcess;
	
	public ProcessScheduler() {
		this.processes = new LLQueue<Process>();
		this.currentProcess = null;
	}
	//get method returns the current process
	public Process getCurrentProcess() {
		return this.currentProcess;
	}
	//add method, takes a parameter and adds it to the queue if not null
	public void addProcess(Process aProcess) {
		if(this.currentProcess==null) {
			this.currentProcess = aProcess;
		}else {
			this.processes.enqueue(aProcess);
		}
	}
	//runNext process, deqeueues process queue and sets it to current
	public void runNextProcess() {
		this.currentProcess = processes.dequeue();
	}
	//cancel method: current process is cancelled and replaced by first element
	public void cancelCurrentProcess() {
		if(currentProcess != null) {
			currentProcess = processes.dequeue();
		}else {
			currentProcess = null;
		}
	}
	//print all elements in process queue
	public void printProcessQueue() {
		this.processes.print();
	}

}
