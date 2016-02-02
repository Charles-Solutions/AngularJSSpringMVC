package ibm.ob.web.rest.json;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ibm.ob.entities.User;

public class UserData {

	private final User user;  
	
	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	public UserData() {
		this.user = new User();
	}
	
	public UserData(User user) {
		this.user = user;
	}
	
	public Long getId(){
		return this.user.getUserId();
	}
	
	public void setId(Long id){
		this.user.setUserId(id);
	}
	
	public String getName(){
		return this.user.getName();
	}
	
	public void setName(String name){
		this.user.setName(name);
	}
	
	public String getLastName(){
		return this.user.getName();
	}
	
	public void setLastName(String lastName){
		this.user.setLastName(lastName);
	}
	
	public String getEmail(){
		return this.user.getEmail();
	}
	
	public void setEmail(String email){
		this.user.setEmail(email);
		this.user.setUsername(email);
	}
	
}
