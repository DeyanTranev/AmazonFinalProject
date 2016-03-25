package amazon.model;

import amazon.exceptions.UserException;

public class Address {

	private int id;
	private String street;
	private int number;
	private City city;
	
	public Address() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) throws UserException {
		if(street != null && street.equals("")) {
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) throws UserException {
		if(city != null) {
		this.city = city;
		}
		else {
			throw new UserException("Invalid city!");
		}
	}
	
	
}
