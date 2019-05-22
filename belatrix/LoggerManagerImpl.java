package belatrix;

import java.util.List;

public class LoggerManagerImpl implements LoggerManager{
	private LogAppender _logAppender;
	private List<LogParameter> _parameters;
	private String _logName;
	private String _fileURL;
	
	public LoggerManagerImpl() {
		
	}
	
	public LoggerManagerImpl( List<LogParameter> parameters) {
		_parameters=parameters;
	}

	@Override
	public void logMessage(String text) {
	
		redirectLog();
		_logAppender.appendToLog(text,_parameters);
	}
	
	private void redirectLog() {
		for (LogParameter parameter : _parameters) {
				if (Boolean.TRUE.equals(parameter.isLogToConsole())) {
					_logAppender= new ConsoleAppender();
				}else if(Boolean.TRUE.equals(parameter.isLogToDatabase())) {
					_logAppender= new DatabaseAppender();
				}else if(Boolean.TRUE.equals(parameter.isLogToFile())) {
					_logAppender= new FileAppender(_fileURL);
				}
		}
	}

	@Override
	public void setParameters(List<LogParameter> _parameters) {
		this._parameters = _parameters;
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
