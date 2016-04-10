package amazon.dao;

import amazon.exceptions.UserException;
import amazon.model.User;

public interface IUserDAO {

	/**
	 * Adds a new user to the database from a user object.
	 * @param user
	 */
	
	void addUser(User user);

	/**
	 * Gets first name from database by e-mail
	 * @param email
	 * @return
	 * @throws UserException if database query fails
	 */
	String getFirstNameByEmail(String email) throws UserException;
	
	/**
	 * Gets a user object from database by e-mail
	 * @param email
	 * @return 
	 */
	User getUserByEmail(String email);

	/**
	 * Verifies userName and password (from database)
	 * @param userEmail
	 * @param password
	 * @return true if user name and password match database entry
	 * @throws UserException
	 */
	boolean login(String userEmail, String password) throws UserException;

}