package amazon.model;

import amazon.exceptions.UserException;

public class City {
	
	private int id;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws UserException {
		if(name != null && !name.equals("")) {
		this.name = name;
		}
		else {
			throw new UserException("Invalid city name!");
		}
	}
	
	
}
