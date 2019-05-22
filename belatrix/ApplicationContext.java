package belatrix;

public class ApplicationContext {
	
	static LogParameter _parameters;
	public static void main(String[] args) {

		loadTestingData();
		LoggerManager loggerManager = new LoggerManagerImpl();
		loggerManager.setLogName("MyLog");
		loggerManager.setParameters(_parameters);
		loggerManager.setFileURL("/home/gus/Documents/test.txt");
		loggerManager.logMessage("GUS");

	}
	
	static public void loadTestingData() {
		
		_parameters = new LogParameter();
		_parameters.setIsLogToFile(true);
		_parameters.setIsError(true);
	
	}
	
}
