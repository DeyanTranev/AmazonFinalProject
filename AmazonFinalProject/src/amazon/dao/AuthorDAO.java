package amazon.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import amazon.exceptions.AuthorException;
import amazon.model.Author;

public class AuthorDAO extends AbstractDAO {
	
	private static final String ADD_AUTHOR_QUERY = "INSERT into authors values(null, ?, ?);";

	public List<Author> getAllAuthors() {
		
		Statement statement;
		
		List<Author> authors = new ArrayList<Author>();
		
		try {
			statement = getConnection().createStatement();
			
			ResultSet rSet = statement.executeQuery("Select * from authors");
			
			while(rSet.next()) {
				Author author = new Author(rSet.getInt(1), rSet.getString(2), rSet.getString(3));
				authors.add(author);
			}
			return authors;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public int getAuthorId(String name) {
		
		String[] names = name.split(" "); 
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT author_id FROM authors where first_name=? AND last_name = ?");
			ps.setString(1, names[0]);
			ps.setString(2, names[1]);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public Author getAuthorById(int id) throws AuthorException {
		Author author=null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM authors WHERE author_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				author = new Author(rs.getString(2), rs.getString(3));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new AuthorException("Author with id "+ id +" not found!", ex);
		}
		return author;
	}
	
	public int addAuthor(Author author) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(ADD_AUTHOR_QUERY, 
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getLastName());
			
			ps.executeUpdate();
			
			ResultSet generatedId = ps.getGeneratedKeys();
			generatedId.next();
			return generatedId.getInt(1);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return 0;
	}

}
