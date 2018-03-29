import java.io.Serializable;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class Session implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String roleType;
	private String userName;
	private boolean isAuthenticated;
	
	
	//Default constructor
	public Session() {
		
	}
	
	//Session instance with all the values assigned
	public Session(String roleType, String userName, boolean isAuthenticated) {
		this.roleType = roleType;
		this.userName = userName;
		this.isAuthenticated = isAuthenticated;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	
	
}
