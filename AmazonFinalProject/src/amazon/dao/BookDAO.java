package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import amazon.abstracts.AbstractDAO;
import amazon.exceptions.BookException;
import amazon.model.Author;
import amazon.model.Book;

public class BookDAO extends AbstractDAO {

	private static final String INSERT_NEW_BOOK_QUERY = "INSERT INTO books values(null, ?, ?, ?, ?, ?, ?);";

	public List<Book> getAllBooks() {

		AuthorDAO adao = new AuthorDAO();
		Statement statement;
		int id = 0;
		List<Book> result = new ArrayList<Book>();
		try {
			statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM books");
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
						new Author("Petyr", "Nedelchev"), "Drama");
				result.add(book);
			}
		} catch (SQLException | BookException e) {
			// TODO Auto-generated catch block
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

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
