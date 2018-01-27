package Adapter;

public class LoggerImpl implements Logger {

	@Override
	public void trace(String str) {
		System.out.print("TRACE: ");
		System.out.println(str);
	}

	@Override
	public void debug(String str) {
		System.out.print("DEBUG: ");
		System.out.println(str);
	}

	@Override
	public void log(String str) {
		System.out.print("LOG: ");
		System.out.println(str);
	}

}
