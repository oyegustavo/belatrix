package belatrix;

public interface LoggerManager {
	public void logMessage(String message);
	public void setLogName(String logName);
	public void setParameters(LogParameter parameters);
	public void setFileURL(String _fileURL);
}
