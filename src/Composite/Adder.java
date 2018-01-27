package Composite;

public class Adder implements Expression {

	private double left;
	private double right;

	public Adder(Expression left, Expression right) {
		this.left = left.getValue();
		this.right = right.getValue();
	}

	@Override
	public double getValue() {
		return left + right;
	}

}
