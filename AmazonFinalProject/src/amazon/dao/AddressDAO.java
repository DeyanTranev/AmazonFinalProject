package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import amazon.exceptions.UserException;
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
	
	public Address getAddressById(int id) {
		Address address = null;
		
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM addresses WHERE address_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			address = new Address(rs.getString(2), rs.getInt(3), getCityNameById(rs.getInt(4)));
		} catch (SQLException | UserException e) {
			
			e.printStackTrace();
		}
		return address;
	}
	
	private String getCityNameById(int id) {
		String cityName = "";
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT city_name FROM cities WHERE city_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			cityName = rs.getString("city_name");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cityName;
	}
	
}
