package amazon.tests;

import static org.junit.Assert.*;

import org.junit.Test;


import amazon.dao.UserDAO;
import amazon.exceptions.UserException;
import amazon.model.Address;
import amazon.model.User;

public class UserTest {

	@Test
	public void testAddUser() {
		UserDAO uDAO = new UserDAO();
		Address address;
		try {
			address = new Address("Test40", 567, "Topolovo");
			uDAO.addUser(new User("Iest40", "test40", "Test40@gmail.com", "1234560", "1234560", address, "40"));
		} catch (UserException e) {
			e.printStackTrace();
		}
		
	}
	

}
