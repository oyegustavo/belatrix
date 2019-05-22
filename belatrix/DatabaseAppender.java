package belatrix;

import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class DatabaseAppender extends Appender implements LogAppender{
	
	private ConnectionManager _connectionManager;
	private Map _dbParamsMap;
	
	public DatabaseAppender() {
	}
	
	public DatabaseAppender(Map dbParamsMap) {
		_dbParamsMap=dbParamsMap;
		_connectionManager = new ConnectionManagerImpl();
	}

	@Override
	public void appendToLog(String text,List<LogParameter> parameters) {
	
		for (LogParameter logParameter : parameters) {
			if(logParameter.isLogToDatabase()) {
				System.out.println("soy database appender");
				writeLog(logParameter, text);
			}
		}
	}
	
	private void saveLog() {
//		Statement stmt = _connectionManager.getConnection(_dbParamsMap).createStatement();
	}

}
