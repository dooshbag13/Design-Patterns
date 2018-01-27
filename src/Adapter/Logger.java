package Adapter;

public interface Logger {
	
	void trace(String str);
	void debug(String str);
	void log(String str);
	
	static Logger create() {
		return new LoggerOther_Adapter();  
//		return new LoggerImpl();
	}
}
