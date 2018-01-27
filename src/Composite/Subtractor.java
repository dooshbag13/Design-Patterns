package Composite;

public class Subtractor implements Expression {

	private double left;
	private double right;

	public Subtractor(Expression left, Expression right) {
		this.left = left.getValue();
		this.right = right.getValue();
	}

	@Override
	public double getValue() {
		return left - right;
	}

}
