package belatrix;

import java.sql.Connection;
import java.util.Map;

public interface ConnectionManager {
	public Connection getConnection(Map dbParamsMap);

}
