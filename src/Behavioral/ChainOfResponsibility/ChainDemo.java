package Behavioral.ChainOfResponsibility;

enum RequestType {
	CONFERENCE, PURCHASE;
}

class Request {
	private RequestType requestType;
	private double amount;
	
	public Request(RequestType requestType, double amount) {
		this.requestType = requestType;
		this.amount = amount;
	}
	
	public RequestType getRequestType() {
		return requestType;
	}

	public double getAmount() {
		return amount;
	}
}

abstract class Handler {
	protected Handler successor;
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	public abstract void handleRequest(Request request);
}

class Director extends Handler{
	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.CONFERENCE){
			System.out.println("Directors can approve conferences");
		}else {
			successor.handleRequest(request);
		}
	}
}

class VP extends Handler{
	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.PURCHASE) {
			if(request.getAmount() < 1500) {
				System.out.println("VP's can approve purchase below 1500");
			}else {
				successor.handleRequest(request);
			}
		}
	}
}

class CEO extends Handler{
	@Override
	public void handleRequest(Request request) {
		System.out.println("CEO's can approve anything they want");
	}
}


public class ChainDemo {

	public static void main(String[] args) {
		Handler bryan = new Director();
		Handler crystal = new VP();
		Handler jeff = new CEO();
		
		bryan.setSuccessor(crystal);
		crystal.setSuccessor(jeff);
		
		Request request = new Request(RequestType.CONFERENCE, 500);
		bryan.handleRequest(request);
		
		request = new Request(RequestType.PURCHASE, 1000);
		bryan.handleRequest(request);
		
		request = new Request(RequestType.PURCHASE, 2000);
		bryan.handleRequest(request);
	}
}
