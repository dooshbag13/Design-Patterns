package Adapter;

public class LoggerOther_Adapter implements Logger {

	private LoggerOther logger = new LoggerOther();
	
	@Override
	public void trace(String str) {
		logger.traceOther(str);
	}

	@Override
	public void debug(String str) {
		logger.debugOther(str);
	}

	@Override
	public void log(String str) {
		logger.logOther(str);
	}

}
