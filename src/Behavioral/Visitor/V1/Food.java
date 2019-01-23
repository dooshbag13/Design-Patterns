package Behavioral.Visitor.V1;

public class Food implements Visitable {
	
	private double price;
	
	Food(double value){
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
