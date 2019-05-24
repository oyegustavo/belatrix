package belatrix;

import java.util.logging.Logger;

public class Appender {
	private LoggerUtils _loggerUtils;
	private Logger _logger; 
	private String _logName;
	private final static String APPENDER_EXCEPTION = "Text must be specified to be logged";
	
	public Appender() {
		_loggerUtils =  new LoggerUtils();
		_logger = Logger.getLogger(_logName +" "+ _loggerUtils.getFormattedDate()); 
	}
	
	public String writeLog(LogParameter logParameter, String text) throws Exception {
		if (text==null || text.isEmpty()) {
			throw new AppenderException(APPENDER_EXCEPTION);
		}
		StringBuffer logLine = new StringBuffer();
		_loggerUtils.setParameter(logParameter);
		_loggerUtils.setText(text.trim());
		logLine.append(_loggerUtils.getLogLine());
		System.out.println(logLine);
		return logLine.toString();
	}

	public Logger getLogger() {
		return _logger;
	}

	public void setLogger(Logger _logger) {
		this._logger = _logger;
	}

	public String getLogName() {
		return _logName;
	}

	public void setLogName(String _logName) {
		this._logName = _logName;
	}
}
