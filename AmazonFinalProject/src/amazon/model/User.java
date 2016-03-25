package amazon.model;

import amazon.exceptions.UserException;

public class User {

	private int id;
	private String userName;
	private String eMail;
	private String password;
	private Address address;
	
	public User() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) throws UserException {
		if(userName != null && !userName.equals("")) {
		this.userName = userName;
		}
		else {
			throw new UserException("Invalid user name!");
		}
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) throws UserException {
		if(eMail != null && !eMail.equals("")) {
		this.eMail = eMail;
		}
		throw new UserException("Invalid e-mail address!");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws UserException {
		if(password != null && !password.equals("")) {
		this.password = password;
		}
		throw new UserException("Invalid password!");
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) throws UserException {
		if(address != null) {
		this.address = address;
		}
		else {
			throw new UserException("Invalid Address!");
		}
	}
	
	
}
