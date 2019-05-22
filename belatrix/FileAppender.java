package belatrix;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class FileAppender extends Appender implements LogAppender{
	
	private FileHandler _fh ;


	public FileAppender() {
		
	}
	public FileAppender(String fileURL) {
		
		try {
			File logFile = new File(fileURL);
	        if (!logFile.exists()) {
	            logFile.createNewFile();
	        }

			_fh= new FileHandler(fileURL);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	@Override
	public void appendToLog(String text,List<LogParameter> parameters) {
		for (LogParameter logParameter : parameters) {
			if(logParameter.isLogToFile()) {
				System.out.println("soy file appender");
				getLogger().addHandler(_fh);
				getLogger().log(Level.INFO, writeLog(logParameter, text));
			}
		}
	}
	
}
