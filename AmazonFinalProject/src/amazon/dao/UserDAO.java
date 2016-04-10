package amazon.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import amazon.exceptions.UserException;
import amazon.model.User;

public class UserDAO extends AbstractDAO implements IUserDAO {
	
	/* (non-Javadoc)
	 * @see amazon.dao.IUserDAO#addUser(amazon.model.User)
	 */
	@Override
	public void addUser(User user) {
		
		IAddressDAO addrDao = new AddressDAO();
		int newAddressID = addrDao.addAddress(user.getAddress());
		
		try {
			
			String salt = getSalt();
			
			PreparedStatement ps = getConnection().prepareStatement("INSERT into users values(null, ?, ?, ?, ?, ?, ?);");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.geteMail());
			ps.setString(4, securePassword(user.getPassword(), salt));
			//ps.setString(5, user.getRePassword());
			ps.setInt(5, newAddressID);
			ps.setString(6, salt);

			
			 ps.executeUpdate();
			
		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			
		}
	
	}
	
	private String getSaltFromUser(String userEmail) {
	
		String salt = "";
		try {
			   
			PreparedStatement ps = getConnection().prepareStatement("SELECT user_salt from users WHERE e_mail = ?;");
			
			ps.setString(1, userEmail);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				salt = rs.getString("user_salt");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salt;
	}
	
	
	@Override
	public String getFirstNameByEmail(String email) throws UserException  {
		String uname = "";
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT first_name from users WHERE e_mail = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				uname=rs.getString("first_name");
			}
			return uname;
			
		} catch (SQLException e) {
			
			throw new UserException("Username not found", e);
			
		}
		
	}
	

	@Override
	public boolean login(String userEmail, String password) throws UserException {
		try {
			
		String salt = getSaltFromUser(userEmail);
		String securePass = securePassword(password, salt);

			PreparedStatement ps = getConnection().prepareStatement("SELECT * from users WHERE e_mail = ? AND password = ?;");
			ps.setString(1, userEmail);
			ps.setString(2, securePass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

			throw new UserException("Incorrect e-mail or password", e);
		}
		return false;
		
	}
	
	public User getUserByEmail(String email) {
		IAddressDAO adao = new AddressDAO();
		User user = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM users WHERE e_mail = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), adao.getAddressById(rs.getInt(6)));
		} catch (SQLException | UserException e) {
			
			e.printStackTrace();
		}
		return user;
	}
	  private static String securePassword(String passwordToHash, String salt)
	    {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(salt.getBytes());
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            generatedPassword = sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
	
	 private static String getSalt() throws NoSuchAlgorithmException
	    {
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	        byte[] salt = new byte[16];
	        sr.nextBytes(salt);
	        return salt.toString();
	    }
}
