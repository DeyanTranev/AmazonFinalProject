package amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			ps.setLong(4, user.getPassword().hashCode());
			ps.setInt(5, newAddressID);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeUserById(int id) {
		
		
		
	}
	
	public boolean login(String username, String password) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * from users WHERE e_mail = ? AND password = ?;");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
