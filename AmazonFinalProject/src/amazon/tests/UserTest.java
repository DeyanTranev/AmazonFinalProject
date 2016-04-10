package amazon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import amazon.dao.IUserDAO;
import amazon.dao.UserDAO;
import amazon.exceptions.UserException;
import amazon.model.Address;
import amazon.model.User;

public class UserTest {

//	@Test
//	public void testAddUser() {
//		IUserDAO uDAO = new UserDAO();
//		Address address;
//		try {
//			address = new Address("Test41", 567, "Topolovor");
//			uDAO.addUser(new User("Iest41", "test41", "Test41@gmail.com", "1234560", "1234560", address, "41"));
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test
	public void testGetFirstNameByEmail() throws UserException {
		IUserDAO udao = new UserDAO();
		assertNotNull(udao.getFirstNameByEmail("test17@t.com"));
	}
	
	@Test
	public void testGetUserByEmail() throws UserException {
		IUserDAO udao = new UserDAO();
		assertNotNull(udao.getUserByEmail("test17@t.com"));
	}


}
