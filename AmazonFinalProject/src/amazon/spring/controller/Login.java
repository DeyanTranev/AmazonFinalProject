package amazon.spring.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Login {

	
	@NotNull(message = "Password can't be null.")
	@Email(message = "Invalid E-mail.")
	@NotEmpty(message = "Please enter your email addresss.")
	private String email;
	
	@NotNull(message = "Password can't be null.")
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 50, message = "Please enter your password.")
	private String pass;
	
	public Login() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
