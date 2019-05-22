package belatrix;

import java.util.List;

public interface LogAppender {
	public void appendToLog(String message, List<LogParameter> parameters);
}
