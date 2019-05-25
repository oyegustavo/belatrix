package belatrix;

public class LoggerManagerImpl implements LoggerManager{
	private LogAppender _logAppender;
	private LogParameter _parameters;
	private String _logName;
	private String _fileURL;
	
	private final static String INVALID_CONFIGURATION_EXCEPTION = "Invalid configuration";
	private final static String FILE_APPENDER_EXCEPTION ="filerURL must be specified";
	
	public LoggerManagerImpl() {
		
	}
	
	public LoggerManagerImpl( LogParameter parameters) {
		_parameters=parameters;
	}

//	@Override
//	public void logMessage(String text) {
//	try {
//		redirectLog();
//		_logAppender.appendToLog(text,_parameters);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//		
//	}
	
	private void redirectLog() throws InvalidCofigurationException, FileAppenderException, AppenderException {
		if (_parameters==null || !_parameters.isLogToConsole() && 
			!_parameters.isLogToDatabase() && !_parameters.isLogToFile()) {
			throw new InvalidCofigurationException(INVALID_CONFIGURATION_EXCEPTION);
		} 
		
	
			if (Boolean.TRUE.equals(_parameters.isLogToConsole())) {
				_logAppender= new ConsoleAppender();
			}else if(Boolean.TRUE.equals(_parameters.isLogToDatabase())) {
				_logAppender= new DatabaseAppender();
			}else if(Boolean.TRUE.equals(_parameters.isLogToFile())) {
				try {
				_logAppender= new FileAppender(_fileURL);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
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

	@Override
	public void logMessage(String text) throws Exception {
		redirectLog();
		_logAppender.appendToLog(text,_parameters);
		
	}
	
	
}
