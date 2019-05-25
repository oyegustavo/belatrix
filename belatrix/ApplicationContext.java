package belatrix;

public class ApplicationContext {
	
	static LogParameter _parameters;
	public static void main(String[] args) {

//		loadTestingData();
		LoggerManager loggerManager = new LoggerManagerImpl();
		loadTestingData();
		loggerManager.setLogName("MyLog");
		loggerManager.setParameters(_parameters);
		loggerManager.setFileURL("/home/gus/Documents/test2.txt");
//		loggerManager.setFileURL("");
		try {
			loggerManager.logMessage("  f aas  ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	
	static public void loadTestingData() {
		
		_parameters = new LogParameter();
		_parameters.setIsLogToFile(true);
		_parameters.setIsError(true);
	
	}
	
}
