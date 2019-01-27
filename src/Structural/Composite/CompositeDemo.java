package Structural.Composite;

interface Expression {
	double getValue();
}

class Constant implements Expression {
	private final double value;

	public Constant(double value) {
		this.value = value;
	}
	@Override
	public double getValue() {
		return this.value;
	}
}

class Divider implements Expression {
	private Expression left;
	private Expression right;

	public Divider(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public double getValue() {
		return left.getValue() / right.getValue();
	}
}

class Multiplier implements Expression {
	private Expression left;
	private Expression right;

	public Multiplier(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public double getValue() {
		return left.getValue() * right.getValue();
	}
}

class Subtractor implements Expression {
	private Expression left;
	private Expression right;

	public Subtractor(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public double getValue() {
		return left.getValue() - right.getValue();
	}
}

class Adder implements Expression {
	private Expression left;
	private Expression right;

	public Adder(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public double getValue() {
		return left.getValue() + right.getValue();
	}
}

public class CompositeDemo {
	public static void main(String[] args) {
		Expression a = new Constant(3.5);
		Expression b = new Constant(6.5);
		Expression c = new Constant(10);
		
		Expression summ = new Adder(a, b);
		Expression sub = new Subtractor(b, a);
		
		Expression div = new Divider(summ, sub);
		
		Expression mul = new Multiplier(div, c);
		
		System.out.println(mul.getValue());
	}
}
