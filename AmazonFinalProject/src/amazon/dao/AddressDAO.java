package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import amazon.model.Address;

public class AddressDAO extends AbstractDAO implements IAddressDAO {
	
	private static final String ADD_ADDRESS_QUERY = "INSERT INTO addresses VALUES (null, ?, ?, ?)";
	private static final String ADD_CITY = "INSERT INTO cities VALUES (null, ?)";

	private int addCity(String city) {
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(ADD_CITY, PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, city);
			
			ps.executeUpdate();
			
			ResultSet rSet = ps.getGeneratedKeys();
			rSet.next();
			
			return rSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see amazon.dao.IAddressDAO#addAddress(amazon.model.Address)
	 */
	@Override
	public int addAddress(Address address) {
		
		int cityId = addCity(address.getCity());
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(ADD_ADDRESS_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, address.getStreet());
			ps.setInt(2, address.getNumber());
			ps.setInt(3, cityId);
			
			ps.executeUpdate();
			
			ResultSet rSet = ps.getGeneratedKeys();
			rSet.next();
			
			return rSet.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
