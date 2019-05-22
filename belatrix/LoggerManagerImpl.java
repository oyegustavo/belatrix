package belatrix;

public class LoggerManagerImpl implements LoggerManager{
	private LogAppender _logAppender;
	private LogParameter _parameters;
	private String _logName;
	private String _fileURL;
	
	public LoggerManagerImpl() {
		
	}
	
	public LoggerManagerImpl( LogParameter parameters) {
		_parameters=parameters;
	}

	@Override
	public void logMessage(String text) {
	
		redirectLog();
		_logAppender.appendToLog(text,_parameters);
	}
	
	private void redirectLog() {
				if (Boolean.TRUE.equals(_parameters.isLogToConsole())) {
					_logAppender= new ConsoleAppender();
				}else if(Boolean.TRUE.equals(_parameters.isLogToDatabase())) {
					_logAppender= new DatabaseAppender();
				}else if(Boolean.TRUE.equals(_parameters.isLogToFile())) {
					_logAppender= new FileAppender(_fileURL);
				}
	}

	@Override
	public void setParameters(LogParameter parameters) {
		this._parameters = parameters;
	}

	@Override
	public void setLogName(String _logName) {
		this._logName = _logName;
	}
	
	public String getLogName() {
		return _logName;
	}

	public String getFileURL() {
		return _fileURL;
	}

	public void setFileURL(String _fileURL) {
		this._fileURL = _fileURL;
	}
	
	

}
