package amazon.model;

import amazon.exceptions.UserException;

public class Address {

	private int id;
	private String street;
	private int number;
	private String city;
	
	public Address() {
		
	}

	public Address(String street, int number, String city) throws UserException {
		setStreet(street);
		setNumber(number);
		setCity(city);
	}

	public Address(int id, String street, int number, String city) throws UserException {
		this(street, number, city);
		setId(id);
		
	}

	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) throws UserException {
		if(street != null && !street.trim().isEmpty()) {
		this.street = street;
		}
		else {
			throw new UserException("Invalid street name!");
		}
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) throws UserException {
		if(number > 0) {
		this.number = number;
		}
		else {
			throw new UserException("Invalid street number!");
			
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) throws UserException {
		if(city != null && !city.trim().isEmpty()) {
		this.city = city;
		}
		else {
			throw new UserException("Invalid city!");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + getId() + "\n");
		sb.append("streer: " + getStreet() + "\n");
		sb.append("number: " + getNumber() + "\n");
		sb.append("city: " + getCity() + "\n");
		return sb.toString();
	}
}
