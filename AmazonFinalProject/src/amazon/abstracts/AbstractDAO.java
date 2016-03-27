package amazon.abstracts;

import java.sql.Connection;

import amazon.connection.DBConnection;

public abstract class AbstractDAO {
	
	private Connection conncetion;
	
	public AbstractDAO() {
		this.conncetion = DBConnection.getInstance().getConnection();
	}
	
	public Connection getConnection() {
		return this.conncetion;
	}

}
