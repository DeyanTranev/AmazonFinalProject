package amazon.dao;

import amazon.model.Address;

public interface IAddressDAO {
	/**
	 * Adds a new address to the database from an address object
	 * @param address
	 * @return the new address id (generated key)
	 */
	int addAddress(Address address);
	
	/**
	 * Gets an address object from database by id
	 * @param id
	 * @return
	 */
	Address getAddressById(int id);

}