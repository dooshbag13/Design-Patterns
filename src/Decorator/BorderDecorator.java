package Decorator;

public class BorderDecorator extends Decorator{
	
	public BorderDecorator(GraphicalComponent next) {
		super(next);
	}
	
	@Override
	public void paint() {
		
		System.out.println("<BORDER rendering BEFORE>");
		
		super.paint();
		
		System.out.println("<BORDER rendering AFTER>");
	}
}
