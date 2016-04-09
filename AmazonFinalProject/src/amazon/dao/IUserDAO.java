package amazon.dao;

import amazon.exceptions.UserException;
import amazon.model.User;

public interface IUserDAO {

	void addUser(User user);

	String getFirstNameByEmail(String email) throws UserException;

	boolean login(String userEmail, String password) throws UserException;

}