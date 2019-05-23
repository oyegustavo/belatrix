package belatrix;

import java.text.DateFormat;
import java.util.Date;

public class LoggerUtils {
	
	private StringBuffer _fullText ;
	private String _text;
	private LogParameter _parameter;
	private final static String ERROR ="error";
	private final static String MESSAGE ="message";
	private final static String WARNING ="warning";
	
	public LoggerUtils() {
		
	}
	
	public LoggerUtils(LogParameter parameter, String text) {
		_text=text;
		_parameter=parameter;
	}
	
	public String getFormattedDate() {
		Date today;
		String dateOut;
		DateFormat dateFormatter;

		dateFormatter = DateFormat.getDateInstance(DateFormat.LONG );
		today = new Date();
		dateOut = dateFormatter.format(today);

		return dateOut;
	}
	
	public String getLogLine() {
		_fullText = new StringBuffer();
		try {
			_fullText.append(getLevel());
			_fullText.append("  ");
			_fullText.append(getFormattedDate());
			_fullText.append("  ");
			_fullText.append(_text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _fullText.toString();
	}
	
	private StringBuffer getLevel() throws Exception {
		if (!_parameter.isError() && !_parameter.isMessage() && !_parameter.isWarning()) {
			throw new Exception("Error or Warning or Message must be specified");
		} 
	
		StringBuffer level = new StringBuffer();
		if (_parameter.isError()) {
			level.append(ERROR);
		}else if(_parameter.isMessage()) {
			level.append(MESSAGE);
			
		}else if(_parameter.isWarning()) {
			level.append(WARNING);
		}
		return level;
	}

	public String getText() {
		return _text;
	}

	public void setText(String _text) {
		this._text = _text;
	}

	public LogParameter getParameter() {
		return _parameter;
	}

	public void setParameter(LogParameter _parameter) {
		this._parameter = _parameter;
	}
	
	

}
