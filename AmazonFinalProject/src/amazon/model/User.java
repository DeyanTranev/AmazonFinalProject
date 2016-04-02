package amazon.model;

import amazon.exceptions.UserException;

public class User {

	

	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private Address address;


	public User(String firstName, String lastName, String eMail, String password, String repPassword, Address address) throws UserException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		
		if(password.equals(repPassword)) {
			this.password = password;
		}
		else {
			throw new UserException("Invalid Mail or Password!");
		}
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws UserException {
		if (firstName != null && !firstName.equals("")) {
			this.firstName = firstName;
		} 
		else {
			throw new UserException("Invalid first name!");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws UserException {
		if (firstName !=null && !firstName.trim().isEmpty()) {
			this.lastName = lastName;
		}
		else {
			throw new UserException("Invalid last name!");
		}
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) throws UserException {
		if (eMail != null && !eMail.equals("")) {
			this.eMail = eMail;
		}
		throw new UserException("Invalid e-mail address!");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UserException {
		if (password != null && !password.equals("")) {
			this.password = password;
		}
		throw new UserException("Invalid password!");
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) throws UserException {
		if (address != null) {
			this.address = address;
		} else {
			throw new UserException("Invalid Address!");
		}
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail
				+ ", password=" + password + ", address=" + address + "]";
	}
	
}
