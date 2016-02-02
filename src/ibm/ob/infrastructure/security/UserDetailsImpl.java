package ibm.ob.infrastructure.security;

import ibm.ob.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 8980686593109890814L;

	private Long userId;
	private String username;
	private String password;	
	private Set<UserRole> roles;
	

	public UserDetailsImpl(User user) {
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.password = user.getPassword();		
		this.roles = user.getRoles();		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();		
		for (UserRole role : this.roles) {
			 collection.add(role);
		}		
		return collection;
	}

	@Override
	public String getPassword() {		
		return this.password;
	}

	@Override
	public String getUsername() {		
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.userId != null;
	}
	
	public Long getUserId() {
		return userId;
	}

	   
}
