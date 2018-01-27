package Adapter;

public class LoggerOther {
	
	public void traceOther(String str) {
		System.out.print("TRACE_From_Other_LOGGER: ");
		System.out.println(str);
	}

	public void debugOther(String str) {
		System.out.print("DEBUG_From_Other_LOGGER: ");
		System.out.println(str);
	}

	public void logOther(String str) {
		System.out.print("LOG_From_Other_LOGGER: ");
		System.out.println(str);
	}
}
