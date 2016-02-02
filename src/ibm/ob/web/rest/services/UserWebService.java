package ibm.ob.web.rest.services;


import java.util.List;

import ibm.ob.web.rest.json.UserData;



public interface UserWebService {
	
	public UserData saveUser(UserData user);
	
	public List<UserData> getUsers();

}
