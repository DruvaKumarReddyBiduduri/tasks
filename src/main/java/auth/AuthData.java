package auth;

import user.User;

public class AuthData {
	public String message;
	public User user;
	
	
	public AuthData(String message, User user) {
		this.message = message;
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
