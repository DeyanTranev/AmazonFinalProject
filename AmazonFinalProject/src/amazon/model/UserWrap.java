package amazon.model;

import javax.validation.constraints.NotNull;

public class UserWrap {
	
	@NotNull
	private User user;
	
	@NotNull
	private Address adress;
	


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	
}
