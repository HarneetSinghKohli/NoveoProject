package pageClasses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegisterPage {

	private String userID;
	private String username;
	private List<String> books;
	
	
	public List<String> getBooks() {
		return books;
	}
	public void setBooks(List<String> books) {
		this.books = books;
	}
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
