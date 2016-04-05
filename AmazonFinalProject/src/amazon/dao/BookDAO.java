package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import amazon.exceptions.AuthorException;
import amazon.exceptions.BookException;
import amazon.model.Author;
import amazon.model.Book;

public class BookDAO extends AbstractDAO {

	private static final String GET_ALL_BOOKS = "SELECT * FROM books";
	private static final String INSERT_NEW_BOOK_QUERY = "INSERT INTO books values(null, ?, ?, ?, ?, ?, ?, ?);";

	public List<Book> getAllBooks() {
		AuthorDAO adao = new AuthorDAO();
		Statement statement;
		
		List<Book> result = new ArrayList<Book>();
		try {
			statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(GET_ALL_BOOKS);
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
						adao.getAuthorById(rs.getInt(6)), getGenreById(rs.getInt(7)), rs.getString(8));
				result.add(book);
			}
		} catch (SQLException | BookException | AuthorException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	public void addBook(Book book) {
		AuthorDAO adao = new AuthorDAO();
		
		try {
			PreparedStatement ps = getConnection()
					.prepareStatement(INSERT_NEW_BOOK_QUERY);
			String authorName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();

			ps.setString(1, book.getTitle());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getPublishDate());
			ps.setString(4, book.getBlurb());

			if (adao.getAuthorId(authorName) != 0) {

				ps.setInt(5, adao.getAuthorId(authorName));
			}
			else {
				int newAuthorId = adao.addAuthor(new Author(book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
				ps.setInt(5, newAuthorId);
			}
			ps.setInt(6, 2);
			ps.setString(7, book.getImg());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getGenreById(int id) {
			
		String genre = "";
		
			try {
				PreparedStatement ps = getConnection().prepareStatement("SELECT genre_name FROM genres WHERE genre_id = ?");
				
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			genre = rs.getString(1);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return genre;
	}
	
	public List<Book> bookBy(String selection, String input) {
		List<Book> books = new ArrayList<>();
		AuthorDAO adao = new AuthorDAO();
		String titleQuery = "SELECT * FROM books WHERE book_title LIKE ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(titleQuery);
			ps.setString(1, "%"+input+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
						adao.getAuthorById(rs.getInt(6)), getGenreById(rs.getInt(7)), rs.getString(8));
				books.add(book);
			}
		} catch (SQLException | BookException | AuthorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
}
