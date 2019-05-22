package belatrix;

public class LogParameter {
	private boolean _isLogToDatabase;
	private boolean _isLogToFile;
	private boolean _isLogToConsole;
	private boolean _isWarning;
	private boolean _isMessage;
	private boolean _isError;
	
	public LogParameter() {
		
	}
	
	public LogParameter(boolean isLogToDatabase,boolean isLogToFile,boolean isLogToConsole, boolean isWarning, boolean isMessage, boolean isError) {
		_isLogToDatabase= isLogToDatabase;
		_isLogToFile= isLogToFile;
		_isLogToConsole= isLogToConsole;
		_isWarning=isWarning;
		_isMessage=isMessage;
		_isError=isError;
	}
	
	public boolean isWarning() {
		return _isWarning;
	}
	public void setIsWarning(boolean isWarning) {
		this._isWarning = isWarning;
	}
	public boolean isMessage() {
		return _isMessage;
	}
	public void setIsMessage(boolean isMessage) {
		this._isMessage = isMessage;
	}
	public boolean isError() {
		return _isError;
	}
	public void setIsError(boolean isError) {
		this._isError = isError;
	}

	public boolean isLogToDatabase() {
		return _isLogToDatabase;
	}

	public void setIsLogToDatabase(boolean _isLogToDatabase) {
		this._isLogToDatabase = _isLogToDatabase;
	}

	public boolean isLogToConsole() {
		return _isLogToConsole;
	}

	public void setIsLogToConsole(boolean _isLogToConsole) {
		this._isLogToConsole = _isLogToConsole;
	}

	public boolean isLogToFile() {
		return _isLogToFile;
	}

	public void setIsLogToFile(boolean _isLogToFile) {
		this._isLogToFile = _isLogToFile;
	}
	
}
