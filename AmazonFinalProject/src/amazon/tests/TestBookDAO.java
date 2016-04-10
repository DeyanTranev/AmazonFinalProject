package amazon.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import amazon.dao.BookDAO;
import amazon.dao.IBookDAO;
import amazon.exceptions.BookException;
import amazon.model.Book;

public class TestBookDAO {

	@Test
	public void testGetAllBooks() {
		IBookDAO bDao = new BookDAO();
		List<Book> list = bDao.getAllBooks();
		assertNotNull(list);

	}

	@Test
	public void testGetGenreById() throws BookException {
		IBookDAO bDao = new BookDAO();
		assertNotNull(bDao.getGenreById(2));
	}
	
	@Test
	public void testGetBookBy() {
		IBookDAO bDao = new BookDAO();
		List<Book> list = bDao.bookBy("title", "harry");
		assertNotNull(list);

	}
	
	@Test
	public void testGetBookPriceById() throws BookException {
		IBookDAO bDao = new BookDAO();
		assertNotNull(bDao.getBookPriceById(5));
	}
	
	
	
	
}
