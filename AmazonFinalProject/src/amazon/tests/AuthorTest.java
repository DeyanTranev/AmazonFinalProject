package amazon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import amazon.dao.AuthorDAO;
import amazon.dao.IAuthorDAO;
import amazon.exceptions.AuthorException;

public class AuthorTest {

	@Test
	public void testGetAuthorById() throws AuthorException {
		IAuthorDAO authDAO = new AuthorDAO();
		assertNotNull(authDAO.getAuthorById(1));
		
	}
	
	@Test
	public void testGetAllAuthors() {
		IAuthorDAO authDAO = new AuthorDAO();
		assertNotNull(authDAO.getAllAuthors());
	}
	
	@Test
	public void testGetAuthorId() {
		IAuthorDAO authDAO = new AuthorDAO();
		assertNotNull(authDAO.getAuthorId("Stephen King"));
	}

}
