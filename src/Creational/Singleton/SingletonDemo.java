package Creational.Singleton;

class SingletonClassDemo {
    private static volatile SingletonClassDemo instance = null;
 
    private SingletonClassDemo() { }
 
    public static SingletonClassDemo getInstance() {
        if (instance == null) {
            synchronized(SingletonClassDemo.class) {
                if (instance == null) {
                    instance = new SingletonClassDemo();
                }
            }
        }
        return instance;
    }
}

class SingletonBillPughDemo {
    private SingletonBillPughDemo() { }
 
    private static class Lazyholder {
        private static final SingletonBillPughDemo INSTANCE = new SingletonBillPughDemo();
    }
 
    public static SingletonBillPughDemo getInstance() {
        return Lazyholder.INSTANCE;
    }
}


public class SingletonDemo {
	public static void main(String[] args) {
	}
}
