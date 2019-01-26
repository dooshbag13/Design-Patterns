package Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
	public void send(String message, Colleague colleague);
}

class ApplicationMediator implements Mediator {
	private List<Colleague> colleagues;

	public ApplicationMediator() {
		colleagues = new ArrayList<>();
	}

	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}

	public void send(String message, Colleague originator) {
		for (Colleague colleague : colleagues) {
			if (colleague != originator) {
				colleague.receive(message);
			}
		}
	}
}

abstract class Colleague {
	private Mediator mediator;
	
	public Colleague(Mediator m) {
		mediator = m;
	}
	public void send(String message) {
		mediator.send(message, this);
	}
	public Mediator getMediator() {
		return mediator;
	}
	
	public abstract void receive(String message);
}

class MobileColleague extends Colleague {
	public MobileColleague(Mediator m) {
		super(m);
	}

	public void receive(String message) {
		System.out.println("Mobile Received: " + message);
	}
}

class DesktopColleague extends Colleague {
	public DesktopColleague(Mediator m) {
		super(m);
	}

	public void receive(String message) {
		System.out.println("Desktop Received: " + message);
	}
}

public class MediatorDemo {

	public static void main(String[] args) {
		ApplicationMediator mediator = new ApplicationMediator();
		Colleague desktop = new DesktopColleague(mediator);
		Colleague mobile = new MobileColleague(mediator);
		
		mediator.addColleague(desktop);
		mediator.addColleague(mobile);
		
		desktop.send("<from Desktop> Hello World");
		mobile.send("<from Mobile> Hello");
	}

}
