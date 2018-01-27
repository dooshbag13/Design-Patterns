package Visitor;

public class Tobacco implements Visitable {
	
	private double price;
	
	public Tobacco(double value) {
		this.price = value;
	}
	
	@Override
	public double calculate(Visitor visitor) {
		return visitor.calculate(this);
	}
	
	public double getPrice() {
		return this.price;
	}

}
