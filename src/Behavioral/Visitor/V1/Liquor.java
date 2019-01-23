package Behavioral.Visitor.V1;

public class Liquor implements Visitable {
	
	private double price;
	
	public Liquor(double value) {
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