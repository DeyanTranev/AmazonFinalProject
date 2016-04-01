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
			address = new Address("Test3", 567, "Plovdiv");
			uDAO.addUser(new User("Iest3", "Test3", "Test3@gmail.com", "123456", "123456", address));
		} catch (UserException e) {
			e.printStackTrace();
		}
		
	}

}
