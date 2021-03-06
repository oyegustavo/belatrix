package belatrix;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class FileAppender extends Appender implements LogAppender{
	
	private FileHandler _fh ;
	private static final String FILE_APPENDER_EXCEPTION = "fileURL must be specified";


	public FileAppender() {
		
	}
	public FileAppender(String fileURL)throws FileAppenderException {
		if (fileURL==null || fileURL.isEmpty()) {
			throw new FileAppenderException(FILE_APPENDER_EXCEPTION);
		}
		
		try {
			File logFile = new File(fileURL);
	        if (!logFile.exists()) {
	            logFile.createNewFile();
	        }

			_fh= new FileHandler(fileURL);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void appendToLog(String text,LogParameter parameters) throws Exception {
			if(parameters.isLogToFile()) {
				getLogger().addHandler(_fh);
				try {
					getLogger().log(Level.INFO, writeLog(parameters, text));
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
	}
	
}
