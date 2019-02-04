package Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

// Object that is too expensive to directly create each time
abstract class Shape implements Cloneable {
	private String id;
	protected String type;

	public String getType() {
		return type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	abstract void draw();

	public Shape clone() {
		Shape clone = null;
		try {
			clone =(Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
// Implementations of that object: Rectangle, Square, Circle
class Rectangle extends Shape {
	public Rectangle() {
		type = "Rectangle";
	}
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

class Square extends Shape {
	public Square() {
		type = "Square";
	}
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}

class Circle extends Shape {
	public Circle() {
		type = "Circle";
	}
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
// Registry/Cache of the expensive objects 
class ShapeCache {
	private static final Map<String, Shape> shapeMap = new HashMap<>();

	public static Shape getShape(String shapeName) {
		return shapeMap.get(shapeName).clone();
	}
	// for each shape run database query and create shape - shapeMap.put(shapeKey, shape);
	// for example, we are adding three shapes
	public static void loadCache() {
		Shape circle = new Circle();
		circle.setId("Circle");
		shapeMap.put(circle.getId(), circle);

		Shape square = new Square();
		square.setId("Square");
		shapeMap.put(square.getId(), square);

		Shape rectangle = new Rectangle();
		rectangle.setId("Rectangle");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}

public class PrototypeDemo {
	public static void main(String[] args) {
		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("Circle");
		clonedShape.setId("Big Red Circle");
		System.out.println(clonedShape+">> Shape : " + clonedShape.getType()+", "+clonedShape.getId());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("Circle");
		clonedShape2.setId("Small Green Circle, like a Dot");
		System.out.println(clonedShape2+">> Shape : " + clonedShape2.getType()+", "+clonedShape2.getId());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("Rectangle");
		System.out.println("Shape : " + clonedShape3.getType());
	}
}
