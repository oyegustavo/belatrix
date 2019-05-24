package junit;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import belatrix.FileAppenderException;
import belatrix.LogParameter;
import belatrix.LoggerManager;
import belatrix.LoggerManagerImpl;

public class LoggerManagerTest {
	
	LoggerManager _loggerManager;
	public LogParameter _parameters;
	public String _text;

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//		assertThat(_loggerManager.logMessage("  f aas  "), is(equalTo(null)));
//	}
	
//	@Test(expected = Exception.class) 
//    public void testDataNoFileURLException() throws Exception { 
//		loadMockDataNoFileURLExceptionTest();
//		_loggerManager.logMessage(_text);
//    }
	
//	@Test
//    public void testDataNoFileURLException() { 
//        try {
//    		loadMockDataNoFileURLExceptionTest();
//    		_loggerManager.logMessage(_text);
//            fail("Expected an Exception to be thrown");
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("test.txt (No such file or directory)"));
//        }
//                 
//    }
//	
	@Rule
	  public ExpectedException exception = ExpectedException.none();

	  @Test
	  public void throwsFileAppenderExceptionIfFileURLISsNull() {
	    exception.expect(FileAppenderException.class);
	    exception.expectMessage("fileURL must be specified");
	    loadMockDataNoFileURLExceptionTest();
	    _loggerManager.logMessage(_text);
	  }



	public void loadMockDataNoFileURLExceptionTest() {
		
		_parameters = new LogParameter();
		_parameters.setIsLogToFile(true);
		_parameters.setIsError(true);
		_text="hola";
		
		_loggerManager = new LoggerManagerImpl();
		_loggerManager.setLogName("MyLog");
		_loggerManager.setParameters(_parameters);
//		_loggerManager.setFileURL("/home/gus/Documents/test2.txt");
		
		

	
	}
}
