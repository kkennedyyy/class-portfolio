//Written by Kennedy Poag
public class OrderScheduler {
	//Store orders based on priority
	MinHeap<Order> orders = new MinHeap<Order>();
	
	private Order currentOrder; //current order
	private int currentMinute; //current minute for order
	private int totalOrders; //total order
	private double summedWaitTimes; //total wait time
	
	//add order to heap of orders
	public void addOrder(Order aOrder) {
		this.totalOrders++;
		if(currentOrder==null) {
			this.currentOrder = aOrder;
		}else {
			this.orders.add(aOrder);
		}
		
	}
	//add a minute to order
	public void advanceOneMinute() {
		currentMinute++;
		this.currentOrder.cookForOneMinute();
		if(this.currentOrder.isDone()) {
			int waitTime = this.currentMinute - this.currentOrder.getArriveTime();
			this.summedWaitTimes += waitTime;
			this.currentOrder = orders.remove();
		}
	}
	//check if order is done
	public boolean isDone() {
		if(this.currentOrder == null) {
			return true;
		}else {
			return false;
		}
	}
	//get average waiting time
	public double getAverageWaitingTime() {
		return this.summedWaitTimes/this.totalOrders;
	}
	//return current order
	public Order getCurrentOrder() {
		return this.currentOrder;
	}
	

}
