package Proxy;

public interface BusinesObject {

	 void sayHi();

	 static BusinesObject create() {
		return new BusinesObjectProxy(new BusinesObjectImplementation());
	}

}