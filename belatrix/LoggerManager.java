package belatrix;

import java.util.List;

public interface LoggerManager {
	public void logMessage(String message);
	public void setLogName(String logName);
	public void setParameters(List<LogParameter> _parameters);
	public void setFileURL(String _fileURL);
}
