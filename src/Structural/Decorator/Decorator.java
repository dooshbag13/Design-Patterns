package Structural.Decorator;

public abstract class Decorator implements GraphicalComponent {

	private GraphicalComponent next;
	
	public Decorator(GraphicalComponent next) {
		this.next = next;
	}
	
	@Override
	public void paint() {
		this.next.paint();
	}

	@Override
	public GraphicalComponent addContent(String content) {  
		return this.next.addContent(content);
	}

}
