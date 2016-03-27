package amazon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import amazon.abstracts.AbstractDAO;

import amazon.model.Book;

public class BookDAO extends AbstractDAO {
	
	public List<Book> getAllBooks() {
		
		Statement statement;
		List<Book> result= new ArrayList<Book>();
		try {
			statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}
}
