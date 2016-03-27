package amazon.abstracts;

import java.sql.Connection;

import amazon.connection.DBConnection;

public abstract class AbstractDAO {
	
	private Connection connection;
	
	public AbstractDAO() {
		this.connection = DBConnection.getInstance().getConnection();
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
