package belatrix;

import java.util.logging.Logger;

public class Appender {
	private LoggerUtils _loggerUtils;
	private Logger _logger;  
	
	public Appender() {
		_logger = Logger.getLogger("MyLog"); 
	}
	
	public String writeLog(LogParameter logParameter, String text) {
		StringBuffer logLine = new StringBuffer();
		_loggerUtils=new LoggerUtils(logParameter, text);
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
	

}
