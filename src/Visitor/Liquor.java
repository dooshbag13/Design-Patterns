package Visitor;

public class Liquor implements Visitable {
	
	private double price;
	
	public Liquor(double value) {
		this.price = value;
	}
	
	@Override
	public double calculate(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public double getPrice() {
		return this.price;
	}

}
