package amazon.dao;

import java.util.List;

import amazon.model.Book;

public interface IBookDAO {

	List<Book> getAllBooks();

	void addBook(Book book);

	String getGenreById(int id);
	
	double getBookPriceById(int id);

	List<Book> bookBy(String selection, String input);

	Book getBookById(int id);

	String getSearchParam(String selection);

}