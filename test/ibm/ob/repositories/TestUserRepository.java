package ibm.ob.repositories;


import static org.junit.Assert.*;
import ibm.ob.entities.User;
import ibm.ob.infrastructure.security.EncryptorManager;
import ibm.ob.infrastructure.security.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:testing-context.xml" })
public class TestUserRepository {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	
	@Before	
	public void setUp(){	
		List<User> testUsers = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setEmail("alex_clavijo" + i + "@gmail.com");
			user.setUsername("alex" + i);
			user.setPassword(EncryptorManager.encryptPassword("acp"));
			user.setName("Alejandro" + i);
			user.setLastName("Clavijo" + i);
			user.setCreated(DateTime.now());
			
			Set<UserRole> roles = new HashSet<UserRole>();
			roles.add(UserRole.USER);
			user.setRoles(roles);
			testUsers.add(user);			
		}		
		userRepository.saveAll(testUsers);
	}	
	
	@Test	
	@Transactional
	public void saveUser(){			
		User user = new User();
		user.setEmail("alberto@gmail.com");
		user.setUsername("alber");
		user.setPassword(EncryptorManager.encryptPassword("acc"));
		user.setName("Alberto");
		user.setLastName("Clavijo");
		
		Set<UserRole> roles = new HashSet<UserRole>();
		roles.add(UserRole.ADMIN);
		user.setRoles(roles);		
		
		//userRepository.save(user);
		
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
		
	    assertNotNull(user.getUserId());	    
	  
	}
	
	 @Test	 
	 @Transactional
     public void getList(){		
		List<User> users = userRepository.getList();		
		assertEquals(10, users.size());
	}
	 
	@Test
	public void getUsername(){
		User user = (User) userRepository.getUserByUsername("alex3");		
		assertNotNull(user);		
	}	
	 
	@Test
	public void deleteAll(){			
		userRepository.deleteAll(userRepository.getList());		
		assertEquals(0, userRepository.getList().size());		
	}
	
	@Test
	public void checkUserPassword(){		
		assertTrue(EncryptorManager.checkPassword("acp", "F7qgI9zK3PdRKkktS2bFe75xnaRaI4aHxQI0oKVJj4eOZ9YTc7EZltPOVrU5ITEt"));
		assertTrue(EncryptorManager.checkPassword("acc", "ieDSTg7j70jPbpfvFQAfvNZDwDPDXiYES5TpIAXKmZpQu05Yuu0soDW/Xo4yIx8R"));	
	}
	
}
