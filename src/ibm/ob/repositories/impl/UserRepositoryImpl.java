package ibm.ob.repositories.impl;

import ibm.ob.entities.User;
import ibm.ob.repositories.UserRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends HibernateRepositoryImpl<User> implements UserRepository{

    	
	@Autowired
	public UserRepositoryImpl(SessionFactory factory) {
		super(factory);		
	}

	@Override
	protected Class<User> entityClass() {		
		return User.class;
	}

	@Override
	public User getUserByUsername(String username) {	
		return this.get("username", username);
	}
}
