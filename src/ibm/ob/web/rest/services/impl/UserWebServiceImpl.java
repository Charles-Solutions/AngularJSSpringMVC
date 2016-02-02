package ibm.ob.web.rest.services.impl;

import ibm.ob.entities.User;
import ibm.ob.repositories.UserRepository;
import ibm.ob.web.rest.json.UserData;
import ibm.ob.web.rest.services.UserWebService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservice/user")
public class UserWebServiceImpl implements UserWebService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	@ResponseBody
	public UserData saveUser(@RequestBody UserData userdata) {	
		User user = userdata.getUser();
		this.userRepository.save(user);		
		return new UserData(user);
	}

	@Override
	@RequestMapping(value= "/list", method= RequestMethod.GET)
	@ResponseBody
	public List<UserData> getUsers() {
		List<User> users = this.userRepository.getList();
		List<UserData> responseData = new ArrayList<UserData>();
		for (User user : users) {
			 responseData.add(new UserData(user));
		}		
		return responseData;
	}	

}
