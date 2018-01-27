package Composite;

public class Multiplier implements Expression {

	private double left;
	private double right;

	public Multiplier(Expression left, Expression right) {
		this.left = left.getValue();
		this.right = right.getValue();
	}

	@Override
	public double getValue() {
		return left * right;
	}

}
