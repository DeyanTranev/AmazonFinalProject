package amazon.model;



import amazon.exceptions.UserException;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private String rePassword;
	private Address address;
	private String salt;
	
	public User() {
		
	}
	
	

	public User(String firstName, String lastName, String eMail, String password, Address address) throws UserException {
		
		setFirstName(firstName);
		setLastName(lastName);
		seteMail(eMail);
		setPassword(password);
		setAddress(address);
	}



	public User(String firstName, String lastName, String eMail, String password, String rePassword,
			Address address, String salt) throws UserException {
		setFirstName(firstName);
		setLastName(lastName);
		seteMail(eMail);
		
		if(password.equals(rePassword)) {
			setPassword(password);
		}
		else {
			System.err.println("--------------------------------------- Invalid pass!!!!!!!!!");
			throw new UserException("Invalid Mail or Password!");
		}
		setAddress(address);
		setSalt(salt);
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
		if (firstName != null && !firstName.trim().isEmpty()) {
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
		if (lastName != null && !lastName.trim().isEmpty()) {
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
		if (eMail != null && !eMail.trim().isEmpty()) {
			this.eMail = eMail;
		}
		else {
			throw new UserException("Invalid e-mail address!");
		}
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UserException {
		if (password != null && !password.trim().isEmpty()) {
			this.password = password;
		}
		else {
			throw new UserException("Invalid password!");
		}
		
	}


	public String getRePassword() {
		return rePassword;
	}


	public void setRePassword(String rePassword) throws UserException {
		if (rePassword != null && !rePassword.trim().isEmpty()) {
			this.rePassword = rePassword;
		}
		else {
			throw new UserException("Invalid password!");
		}
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) throws UserException {
		if(address != null) {
			this.address = address;
		}
		else {
			throw new UserException("Address can't be null!");
		}
	}
	
	

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("first name: " + getFirstName() + "\n");
		sb.append("last name: " + getLastName() + "\n");
		sb.append("e-mail: " + geteMail() + "\n");
		sb.append("address: " + getAddress() + "\n");
		return sb.toString();
	}

	
	
}
