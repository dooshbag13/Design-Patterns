package Composite;

public class Divider implements Expression {

	private double left;
	private double right;

	public Divider(Expression left, Expression right) {
		this.left = left.getValue();
		this.right = right.getValue();
	}

	@Override
	public double getValue() {
		return left / right;
	}

}
