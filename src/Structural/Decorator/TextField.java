package Structural.Decorator;

import java.util.LinkedList;
import java.util.List;

public class TextField implements GraphicalComponent {

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
