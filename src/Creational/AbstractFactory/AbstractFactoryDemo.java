package Creational.AbstractFactory;

interface Shape {
	void draw();
}

class RoundedRectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside RoundedRectangle::draw() method.");
	}
}
class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
class RoundedSquare implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside RoundedSquare::draw() method.");
	}
}
class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}


abstract class AbstractFactory {
	private static final AbstractFactory rounded = new RoundedShapeFactory();
	private static final AbstractFactory edge = new ShapeFactory();
	
	public static AbstractFactory getFactory(boolean isRounded) {
		if (isRounded) {
			return rounded;
		} else {
			return edge;
		}
	}
	abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory {
	@Override
	public Shape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}

class RoundedShapeFactory extends AbstractFactory {
	@Override
	public Shape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new RoundedRectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new RoundedSquare();
		}
		return null;
	}
}
 

public class AbstractFactoryDemo {
	public static void main(String[] args) {
		// get edge shape factory
		AbstractFactory shapeFactory = AbstractFactory.getFactory(false);
		Shape shape1 = shapeFactory.getShape("RECTANGLE");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape2.draw();

		// get rounded shape factory
		AbstractFactory shapeFactory1 = AbstractFactory.getFactory(true);
		Shape shape3 = shapeFactory1.getShape("RECTANGLE");
		shape3.draw();
		Shape shape4 = shapeFactory1.getShape("SQUARE");
		shape4.draw();
	}
}
