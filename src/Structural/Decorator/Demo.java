package Structural.Decorator;

public class Demo {

	public static void main(String[] args) {
		GraphicalComponent tf = constructText();
		tf = new BorderDecorator(tf);
		tf.paint();
	}

	private static GraphicalComponent constructText() {
		GraphicalComponent tf = new TextField();
		tf = tf.addContent("first line");
		tf = tf.addContent("first line1");
		tf = tf.addContent("first line2");
		tf = tf.addContent("first line3");
		tf = tf.addContent("first line4");
		tf = tf.addContent("first line5");
		tf = tf.addContent("first line6")
		  .addContent("second line")
		  .addContent("third line")
		  .addContent("third line2")
		  .addContent("third line3")
		  .addContent("forth line");
		return tf;
	}

}
