package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import amazon.abstracts.AbstractDAO;
import amazon.model.User;

public class UserDAO extends AbstractDAO {
	
	public void addUser(User user) {
		
		AddressDAO addrDao = new AddressDAO();
		int newAddressID = addrDao.addAddress(user.getAddress());
		try {
			PreparedStatement ps = getConnection().prepareStatement("INSERT into users values(null, ?, ?, ?, ?, ? );");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.geteMail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, newAddressID);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
