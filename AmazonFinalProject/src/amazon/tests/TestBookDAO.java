package amazon.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import amazon.dao.BookDAO;
import amazon.model.Book;

public class TestBookDAO {

	@Test
	public void testGetAllBooks() {
		BookDAO bDao = new BookDAO();
		
		List<Book> list = bDao.getAllBooks();
		System.out.println(list.get(1));
		
		
	}

}
