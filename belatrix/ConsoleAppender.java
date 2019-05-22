package belatrix;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class ConsoleAppender extends Appender implements LogAppender{
	private ConsoleHandler _ch = new ConsoleHandler();

	@Override
	public void appendToLog(String text, List<LogParameter> parameters) {
		for (LogParameter logParameter : parameters) {
			if(logParameter.isLogToConsole()) {
				System.out.println("soy console appender");
				getLogger().addHandler(_ch);
				getLogger().log(Level.INFO, writeLog(logParameter, text));
				writeLog(logParameter, text);
			}
		}
		
	}

}
