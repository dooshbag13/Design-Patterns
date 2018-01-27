package Adapter;

public class Demo {

	public static void main(String[] args) {
		//Factory method to choose which Logger type to implement
		Logger logger = Logger.create();
		
		logger.debug("Some DEBUG message");
		logger.trace("Some TRACE message");
		logger.log("Some LOG message");
	}

}
