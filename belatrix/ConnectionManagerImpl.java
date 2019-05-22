package belatrix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class ConnectionManagerImpl implements ConnectionManager{
	
	
	public ConnectionManagerImpl() {
	}

	@Override
	public Connection getConnection(Map dbParams) {
		Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));

        try {
			connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
			        + ":" + dbParams.get("portNumber") + "/", connectionProps);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
