package Visitor;

public class Food implements Visitable {
	
	private double price;
	
	Food(double value){
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
