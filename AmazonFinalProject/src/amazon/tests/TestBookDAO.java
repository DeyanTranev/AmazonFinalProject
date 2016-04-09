package amazon.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import amazon.dao.BookDAO;
import amazon.dao.IBookDAO;
import amazon.model.Book;

public class TestBookDAO {

	@Test
	public void testGetAllBooks() {
		IBookDAO bDao = new BookDAO();
		
		List<Book> list = bDao.getAllBooks();
		System.out.println(list.get(1));

	}

	@Test
	public void testGetGenreById() {
		IBookDAO bDao = new BookDAO();
		System.out.println(bDao.getGenreById(3));
		
		
	}
	
}
