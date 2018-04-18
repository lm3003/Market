import java.io.Serializable;
//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String roleType;
	private int isAuthenticated;
	
	//No arg constructor
	public User() {
		
	}
	
	//Const with arg
	public User(String firstname, String lastname, String username, String password, String roleType, int isAuthenticated) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.roleType = roleType;
		this.isAuthenticated = isAuthenticated;
	}

	//Getters and setters for this class below...
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public int isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(int isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

}
