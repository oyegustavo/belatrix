package belatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ApplicationContext {
	
	static List<LogParameter> _parameters ;
	public static void main(String[] args) {
		
		loadTestingData();
		LoggerManager loggerManager = new LoggerManagerImpl();
		loggerManager.setLogName("MyLog");
		loggerManager.setParameters(_parameters);
		loggerManager.setFileURL("/home/gus/Documents/test.txt");
		loggerManager.logMessage("GUS");

	}
	
	static public void loadTestingData() {
		_parameters= new ArrayList<LogParameter>();
		_parameters.add(new LogParameter(true, false, false, false, false, true));
		_parameters.add(new LogParameter(false, true, false, false, true, false));
		_parameters.add(new LogParameter(false, false, true, true, false, false));
	}
	
}
