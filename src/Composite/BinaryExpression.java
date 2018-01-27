package Composite;

abstract public class BinaryExpression implements Expression {

	protected double left;
	protected double right;

	public BinaryExpression(Expression left, Expression right) {
		this.left = left.getValue();
		this.right = right.getValue();
	} 

}
