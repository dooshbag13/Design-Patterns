package Behavioral.State;

interface State{
	public void handleRequest();
}

class FanOffState implements State{
	private final Fan fan;
	
	public FanOffState(Fan fan) {
		this.fan = fan;
	}
	@Override
	public void handleRequest() {
		System.out.println("Turning fan on to Low");
		fan.setState(fan.getFanLowState());
	}
}

class FanLowState implements State{
	private final Fan fan;
	
	public FanLowState(Fan fan) {
		this.fan = fan;
	}
	@Override
	public void handleRequest() {
		System.out.println("Turning fan on to Medium ");
		fan.setState(fan.getFanMedState());
	}
}

class FanMedState implements State{
	private final Fan fan;
	
	public FanMedState(Fan fan) {
		this.fan = fan;
	}
	@Override
	public void handleRequest() {
		System.out.println("Turning fan on to Off");
		fan.setState(fan.getFanOffState());
	}
}

class Fan{
	private final State fanOffState;
	private final State fanLowState;
	private final State fanMedState;
	
	private State state;
	
	public Fan() {
		fanOffState = new FanOffState(this);
		fanLowState = new FanLowState(this);
		fanMedState = new FanMedState(this);
		state = fanOffState;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	public State getFanOffState() {
		return fanOffState;
	}
	public State getFanLowState() {
		return fanLowState;
	} 
	public State getFanMedState() {
		return fanMedState;
	} 
	
	public void pullChain() {
		state.handleRequest();
	}
}

public class StateDemo {
	public static void main(String[] args) {
		Fan fan = new Fan();
		fan.pullChain();
		fan.pullChain();
		fan.pullChain();
	}
}
