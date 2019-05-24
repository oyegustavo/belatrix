package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import belatrix.Appender;
import belatrix.LogParameter;

public class AppenderTest {

	public Appender appender = new Appender();
	public LogParameter _parameters;
	public String _text;
	
	@Test
	public void writeLogTest() {
		
		try {
			loadMockData();
			assertNotNull(appender.writeLog(_parameters, _text));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadMockData() {
		
		_parameters = new LogParameter();
		_parameters.setIsLogToFile(true);
		_parameters.setIsError(true);
		_text="hola";
	
	}

}
