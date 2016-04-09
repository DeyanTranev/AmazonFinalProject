package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import amazon.exceptions.AuthorException;
import amazon.exceptions.BookException;
import amazon.model.Author;
import amazon.model.Book;

public class BookDAO extends AbstractDAO implements IBookDAO {

	private static final String GET_BOOK_BY_ID_QUERY = "SELECT * FROM books WHERE book_id=?";
	private static final String SEARCH_BOOKS_BY_GENRE = "SELECT * FROM books b join genres g on (b.genre_id=g.genre_id) WHERE g.genre_name LIKE ?;";
	private static final String SEARCH_BOOKS_BY_TITLE = "SELECT * FROM books WHERE book_title LIKE ?";
	private static final String SEARCH_BOOKS_BY_AUTHOR = "SELECT * FROM  books b join authors a ON (a.author_id = b.author_id) WHERE concat(a.first_name,' ',a.last_name) LIKE ?;";
	private static final String GET_ALL_BOOKS = "SELECT * FROM books";
	private static final String INSERT_NEW_BOOK_QUERY = "INSERT INTO books values(null, ?, ?, ?, ?, ?, ?, ?);";

	/* (non-Javadoc)
	 * @see amazon.dao.IBookDAO#getAllBooks()
	 */
	@Override
	public List<Book> getAllBooks() {
		IAuthorDAO adao = new AuthorDAO();
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

	/* (non-Javadoc)
	 * @see amazon.dao.IBookDAO#addBook(amazon.model.Book)
	 */
	@Override
	public void addBook(Book book) {
		IAuthorDAO adao = new AuthorDAO();

		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT_NEW_BOOK_QUERY);
			String authorName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();

			ps.setString(1, book.getTitle());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getPublishDate());
			ps.setString(4, book.getBlurb());

			if (adao.getAuthorId(authorName) != 0) {

				ps.setInt(5, adao.getAuthorId(authorName));
			} else {
				int newAuthorId = adao
						.addAuthor(new Author(book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
				ps.setInt(5, newAuthorId);
			}
			ps.setInt(6, 2);
			ps.setString(7, book.getImg());

			ps.executeUpdate();
		} catch (SQLException | AuthorException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see amazon.dao.IBookDAO#getGenreById(int)
	 */
	@Override
	public String getGenreById(int id) {

		String genre = "";

		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT genre_name FROM genres WHERE genre_id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();
			genre = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return genre;

	}

	/* (non-Javadoc)
	 * @see amazon.dao.IBookDAO#bookBy(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Book> bookBy(String selection, String input) {
		List<Book> books = new ArrayList<>();
		IAuthorDAO adao = new AuthorDAO();
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(getSearchParam(selection));
			ps.setString(1, "%" + input + "%");
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
	
	/* (non-Javadoc)
	 * @see amazon.dao.IBookDAO#getBookById(int)
	 */
	@Override
	public Book getBookById(int id) {
		Book book = null;
		IAuthorDAO adao = new AuthorDAO();
		try {
			PreparedStatement ps = getConnection().prepareStatement(GET_BOOK_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			book = new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
					adao.getAuthorById(rs.getInt(6)), getGenreById(rs.getInt(7)), rs.getString(8));
			
		} catch (SQLException | BookException | AuthorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
		
	}
	public double getBookPriceById(int id) {
		double price = 0.0;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT price FROM books WHERE book_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			price = rs.getDouble(1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return price;
	}
	
	/* (non-Javadoc)
	 * @see amazon.dao.IBookDAO#getSearchParam(java.lang.String)
	 */
	@Override
	public String getSearchParam(String selection) {
		
		String select = "";
		
		switch (selection) {
		case "author":
			select = SEARCH_BOOKS_BY_AUTHOR;
			break;
			
		case "title":
			select = SEARCH_BOOKS_BY_TITLE;
			break;
			
		case "genre":
			select = SEARCH_BOOKS_BY_GENRE;
			break;

		}
		
		
		return select;
	}

}
