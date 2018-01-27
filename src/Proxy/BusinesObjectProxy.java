package Proxy;

public class BusinesObjectProxy implements BusinesObject {

	private BusinesObject target;

	public BusinesObjectProxy(BusinesObject target) {
		this.target = target;
	}
	
	@Override
	public void sayHi() {
		System.out.println("In Proxy Object BEFORE CALL REAL..");
		this.target.sayHi();
		System.out.println("In Proxy Object COMPLETED CALL REAL..");
	}

}
