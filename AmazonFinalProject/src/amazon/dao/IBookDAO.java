package amazon.dao;

import java.util.List;

import amazon.exceptions.BookException;
import amazon.model.Book;

public interface IBookDAO {

	/**
	 * Gets all books from Database
	 */
	List<Book> getAllBooks();
	
	/**
	 * Adds a new book in the Database
	 * @param book object
	 */
	void addBook(Book book);
	
	/**
	 * Gets the book genre by primary key (used as foreign key in the books table)
	 * @param id 
	 * @return the genre name 
	 * @throws BookException 
	 */
	String getGenreById(int id) throws BookException;
	
	/**
	 * Gets the price of a book from database by book id.
	 * @param id
	 * @return book price
	 */
	double getBookPriceById(int id);

	/**
	 * Factory method - returns books based on user input and selection
	 * @param selection - (search by title, genre or author)
	 * @param input - string from user 
	 * @return a list of books based on the search parameters above
	 */
	List<Book> bookBy(String selection, String input);

	/**
	 * Gets a book object from database by book id.
	 * @param id
	 * @return
	 */
	Book getBookById(int id);
	/**
	 * Returns string query based on selection parameter
	 * @param selection 
	 * @return
	 */
	String getSearchParam(String selection);

}