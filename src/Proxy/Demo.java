package Proxy;

public class Demo {

	public static void main(String[] args) {
		
		BusinesObject obj = BusinesObject.create(); // OR other factory method to mask proxy usage

		obj.sayHi();
		
	}

}
