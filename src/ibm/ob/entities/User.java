package ibm.ob.entities;

import ibm.ob.infrastructure.security.UserRole;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(indexes={ @Index(name="username_index", columnList="username", unique = true) })
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387049828884662101L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId; 	
	
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	private String name;
	
	private String lastName;
	
	@Column
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime created;
	
	@Column
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime lastLogin;
	
	@ElementCollection(targetClass = UserRole.class)
	@CollectionTable(name = "role", joinColumns = @JoinColumn(name = "userId"))
	@Column(name = "roles", nullable = false, insertable=true, updatable=true)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles; 
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<UserRole> getRoles() {
	    return roles;
	}
	
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public DateTime getCreated() {
		return created;
	}
	
	public void setCreated(DateTime created) {
		this.created = created;
	}
	
	public DateTime getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}
