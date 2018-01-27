package Decorator;

public class ScrollBarDecorator extends Decorator{

	public ScrollBarDecorator(GraphicalComponent next) {
		super(next);
	}
	
	@Override
	public void paint() {
		
		System.out.println("<RENDERING Scroll Bar>");
		
		super.paint();
	} 

}
