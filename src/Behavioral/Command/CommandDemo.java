package Behavioral.Command;


class Switch {
	public void receiveAndExecute(Command command) {
		command.execute();
	}
}

class Light {
	public void on() {
		System.out.println("Light switched On");
	}

	public void off() {
		System.out.println("Light switched Off");
	}
}


class OnCommand implements Command {
	private final Light light;
	
	public OnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}


class OffCommand implements Command {
	private final Light light;

	public OffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.off();
	}
}

interface Command {
	void execute();
}


public class CommandDemo {
	public static void main(String[] args) {
		
		Light light = new Light();
		
		Command onCommand = new OnCommand(light);
		Command offCommand = new OffCommand(light);
		
		Switch lightSwitch = new Switch();
		
		lightSwitch.receiveAndExecute(onCommand);
		lightSwitch.receiveAndExecute(offCommand);
	}
}
