package belatrix;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class ConsoleAppender extends Appender implements LogAppender{
	private ConsoleHandler _ch = new ConsoleHandler();

	@Override
	public void appendToLog(String text, LogParameter parameters) {
			if(parameters.isLogToConsole()) {
				System.out.println("soy console appender");
				getLogger().addHandler(_ch);
				getLogger().log(Level.INFO, writeLog(parameters, text));
				writeLog(parameters, text);
			}
	}

}
