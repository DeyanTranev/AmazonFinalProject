package amazon.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection conInstance;
	private static Connection connection;

	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazonfinalproject?useSSL=false", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnection getInstance() {
		synchronized (DBConnection.class) {
			if(conInstance == null) {
				conInstance = new DBConnection();
			}
		}
		return conInstance;
	}
	
	public Connection getConnection() {
		return connection;
	}

}
