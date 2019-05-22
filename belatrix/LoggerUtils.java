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
	
	public LoggerUtils(LogParameter parameter, String text) {
		_text=text;
		_parameter=parameter;
	}
	
	private String getFormattedDate() {
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
		_fullText.append(getLevel());
		_fullText.append("  ");
		_fullText.append(getFormattedDate());
		_fullText.append("  ");
		_fullText.append(_text);
		return _fullText.toString();
	}
	
	private StringBuffer getLevel()
	{
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

}
