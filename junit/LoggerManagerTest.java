package junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import belatrix.AppenderException;
import belatrix.FileAppenderException;
import belatrix.InvalidCofigurationException;
import belatrix.LogParameter;
import belatrix.LoggerManager;
import belatrix.LoggerManagerImpl;

public class LoggerManagerTest {
	
	LoggerManager _loggerManager;
	public LogParameter _parameters;
	public String _text;
	final static String FILE_APPENDER_EXCEPTION = "fileURL must be specified";
	final static String INVALID_CONFIGURATION_EXCEPTION = "Invalid configuration";
	final static String APPENDER_EXCEPTION = "Text must be specified to be logged";

	
	@Rule
	public ExpectedException fileAppenderException = ExpectedException.none();
	  @Test
	  public void throwsFileAppenderExceptionIfFileURLISsNull() throws Exception {
		  fileAppenderException.expect(FileAppenderException.class);
		  fileAppenderException.expectMessage(FILE_APPENDER_EXCEPTION);
		  loadMockDataNoFileURLTest();
		  _loggerManager.logMessage(_text);
	  }
	  
	@Rule
	public ExpectedException invalidConfigurationException = ExpectedException.none();
		@Test
		public void throwsInvalidConfigurationExceptionIfParametersNull() throws Exception {
			  invalidConfigurationException.expect(InvalidCofigurationException.class);
			  invalidConfigurationException.expectMessage(INVALID_CONFIGURATION_EXCEPTION);
			  loadMockDataNoParametersTest();
			  _loggerManager.logMessage(_text);
    }
		
	@Rule
	public ExpectedException appenderException = ExpectedException.none();
		@Test
		public void throwsappenderExceptionIfTextNull() throws Exception {
			appenderException.expect(AppenderException.class);
			appenderException.expectMessage(APPENDER_EXCEPTION);
			loadMockDataNoTextTest();
			_loggerManager.logMessage(null);
	 }
	

	public void loadMockDataNoFileURLTest() {
		
		_parameters = new LogParameter();
		_parameters.setIsLogToFile(true);
		_parameters.setIsError(true);
		_text="hola";
		
		_loggerManager = new LoggerManagerImpl();
		_loggerManager.setLogName("MyLog");
		_loggerManager.setParameters(_parameters);
		
	}
	
	public void loadMockDataNoParametersTest() {
		
		
		_loggerManager = new LoggerManagerImpl();
		_loggerManager.setLogName("MyLog");
		
	}
	public void loadMockDataNoTextTest() {
		
		_parameters = new LogParameter();
		_parameters.setIsLogToFile(true);
		_parameters.setIsError(true);
		
		_loggerManager = new LoggerManagerImpl();
		_loggerManager.setLogName("MyLog");
		_loggerManager.setParameters(_parameters);
		_loggerManager.setFileURL("test.txt");
		
	}
}
