package Structural.Decorator;

import java.util.LinkedList;
import java.util.List;

interface GraphicalComponent {
	public void paint();
	public GraphicalComponent addContent(String content);
}

class TextField implements GraphicalComponent {
	private List<String> lines = new LinkedList<String>();
	
	@Override
	public void paint() {
		System.out.println("<START textfield>");
		
		for(String l : this.lines) {
			System.out.println("\t"+l);
		}
		System.out.println("<END textfield>");
	}
	@Override
	public GraphicalComponent addContent(String l) {
		this.lines.add(l);
		
		if(this.lines.size() > 4) {
			return new ScrollBarDecorator(this); 
		}
		return this;
	}
}

abstract class Decorator implements GraphicalComponent {
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

class BorderDecorator extends Decorator{
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

class ScrollBarDecorator extends Decorator{
	public ScrollBarDecorator(GraphicalComponent next) {
		super(next);
	}
	@Override
	public void paint() {
		System.out.println("<RENDERING Scroll Bar>");
		super.paint();
	} 
}



public class DecoratorDemo {
	public static void main(String[] args) {
		GraphicalComponent tf = constructText();
		tf = new BorderDecorator(tf);
		tf.paint();
	}
	private static GraphicalComponent constructText() {
		GraphicalComponent tf = new TextField();
		tf = tf.addContent("first line");
		tf = tf.addContent("first line1");
		tf = tf.addContent("first line2");
		tf = tf.addContent("first line3");
		tf = tf.addContent("first line4");
		tf = tf.addContent("first line5");
		tf = tf.addContent("first line6")
		  .addContent("second line")
		  .addContent("third line")
		  .addContent("third line2")
		  .addContent("third line3")
		  .addContent("forth line");
		return tf;
	}
}
