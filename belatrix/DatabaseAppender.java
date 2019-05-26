package belatrix;

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
	public void appendToLog(String text,LogParameter parameters) throws Exception {
	
			if(parameters.isLogToDatabase()) {
				try {
					writeLog(parameters, text);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				
			}
	}
	
	private void saveLog() {
//		Statement stmt = _connectionManager.getConnection(_dbParamsMap).createStatement();
	}

}
