package belatrix;

public class LogParameter {
	private Boolean _isLogToDatabase;
	private Boolean _isLogToFile;
	private Boolean _isLogToConsole;
	private Boolean _isWarning;
	private Boolean _isMessage;
	private Boolean _isError;
	
	public LogParameter(Boolean isLogToDatabase,Boolean isLogToFile,Boolean isLogToConsole, Boolean isWarning, Boolean isMessage, Boolean isError) {
		_isLogToDatabase= isLogToDatabase;
		_isLogToFile= isLogToFile;
		_isLogToConsole= isLogToConsole;
		_isWarning=isWarning;
		_isMessage=isMessage;
		_isError=isError;
	}
	
	public Boolean isWarning() {
		return _isWarning;
	}
	public void setIsWarning(Boolean isWarning) {
		this._isWarning = isWarning;
	}
	public Boolean isMessage() {
		return _isMessage;
	}
	public void setIsMessage(Boolean isMessage) {
		this._isMessage = isMessage;
	}
	public Boolean isError() {
		return _isError;
	}
	public void setIsError(Boolean isError) {
		this._isError = isError;
	}

	public Boolean isLogToDatabase() {
		return _isLogToDatabase;
	}

	public void setIsLogToDatabase(Boolean _isLogToDatabase) {
		this._isLogToDatabase = _isLogToDatabase;
	}

	public Boolean isLogToConsole() {
		return _isLogToConsole;
	}

	public void setIsLogToConsole(Boolean _isLogToConsole) {
		this._isLogToConsole = _isLogToConsole;
	}

	public Boolean isLogToFile() {
		return _isLogToFile;
	}

	public void setIsLogToFile(Boolean _isLogToFile) {
		this._isLogToFile = _isLogToFile;
	}
	
}
