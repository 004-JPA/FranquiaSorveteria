package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
	public static Connection conn = null;
	
	public DBManager() {

	}

	public static Connection getConnection() {
		
		if(conn == null) {
			Properties connProps = new Properties();
			connProps.setProperty("user","dev");
			connProps.setProperty("password", "admin-dev");
			connProps.setProperty("useSSL","false");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FranquiasSorvete", connProps);
			} catch (SQLException e) {
				throw new RuntimeException("Unexpected Error: " + e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("Unexpected Error: " + e.getMessage());
			}
		}
	}

}