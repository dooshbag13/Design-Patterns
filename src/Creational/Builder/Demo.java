package Creational.Builder;
class Robot {
	private String robotHead;
	private String robotBody;

	public void setRobotHead(String head) {
		robotHead = head;
	}
	public String getRobotHead(){ 
		return robotHead; 
	}
	public void setRobotBody(String robotBody) {
		this.robotBody = robotBody;
	}
	public String getRobotBody(){ 
		return robotBody; 
	}
}

interface RobotBuilder {
	public void buildRobotHead();
	public void buildRobotBody();
	public Robot getRobot();
}

class OldRobotBuilder implements RobotBuilder {
	private Robot robot;
	
	public OldRobotBuilder() {
		this.robot = new Robot();
	}
	@Override
	public void buildRobotHead() {
		robot.setRobotHead("Tin Head");
	}
	@Override
	public void buildRobotBody() {
		robot.setRobotBody("Rusty Body");
	}
	@Override
	public Robot getRobot() {
		return this.robot;
	}
} 

class RobotEngineer {
	private RobotBuilder robotBuilder;
	
	public RobotEngineer(RobotBuilder robotBuilder){
		this.robotBuilder = robotBuilder;
	}
	public void makeRobot() {
		this.robotBuilder.buildRobotHead();
		this.robotBuilder.buildRobotBody();
	}
	public Robot getRobot(){
		return this.robotBuilder.getRobot();
	}
}

public class Demo {
	public static void main(String[] args) {
		
		RobotBuilder oldStyleRobot = new OldRobotBuilder();  // Design Blueprint
		RobotEngineer robotEngineer = new RobotEngineer(oldStyleRobot); // "Director" class uses Blueprint
		
		robotEngineer.makeRobot();
		
		Robot firstRobot = robotEngineer.getRobot();
		
		System.out.println("Robot Built");
		System.out.println("Robot Head Type: " + firstRobot.getRobotHead());
		System.out.println("Robot Body Type: " + firstRobot.getRobotBody());
	}
}
