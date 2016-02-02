package ibm.ob.repositories;

import ibm.ob.entities.User;

public interface UserRepository extends GenericRepository<User> {

	User getUserByUsername(String username);
	
	
}
