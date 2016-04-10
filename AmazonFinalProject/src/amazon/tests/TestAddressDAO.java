package amazon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import amazon.dao.AddressDAO;
import amazon.dao.IAddressDAO;

public class TestAddressDAO {

	@Test
	public void testGetAddressById() {
		IAddressDAO adao = new AddressDAO();
		assertNotNull(adao.getAddressById(4));
	}
	


}
