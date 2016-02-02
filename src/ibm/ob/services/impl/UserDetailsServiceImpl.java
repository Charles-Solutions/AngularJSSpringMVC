package ibm.ob.services.impl;

import javax.annotation.Resource;

import ibm.ob.entities.User;
import ibm.ob.infrastructure.security.UserDetailsImpl;
import ibm.ob.repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.get(username);
		return new UserDetailsImpl(user);
	}
	

	
}
