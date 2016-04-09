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

}
