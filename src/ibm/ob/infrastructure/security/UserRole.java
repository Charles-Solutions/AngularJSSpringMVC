package ibm.ob.infrastructure.security;

import java.io.Serializable;

import ibm.ob.constants.Constants;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority, Serializable{
	
	USER(Constants.ROLE_USER),
	
	ADMIN(Constants.ROLE_ADMIN);
	
	private String value;	
	
	private UserRole(String role) {
		this.value = role;
	}	

	@Override
	public String getAuthority() {	
		return value;
	}

}
