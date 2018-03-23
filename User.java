//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//User class to represent users
public class User {
	private String[] credentials;
	
	//default constructor
	public User() {
	}
	
	public String[] getCredentials() {
		return credentials;
	}

	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}
	
	// Ryan: This method could use some comments.
	// Fixed: Required comments added
	
	
	public Session authenticate() {
		Session session = new Session();
    	if(this.credentials[0].equals("customer") && this.credentials[1].equals("customer")) { // validating customer credentials
    		session.setRoleType("Customer");
    		session.setUserName(this.credentials[0]);				//If auth accepted, setup valid session values
    		session.setAuthenticated(true);
    		
    	}else if(this.credentials[0].equals("admin") && this.credentials[1].equals("admin")) { // validating admin credentials
    		session.setRoleType("Admin");
    		session.setUserName(this.credentials[0]);				//If auth accepted, setup valid session values
    		session.setAuthenticated(true);
    	}else {
    		session.setRoleType("Invalid");
    		session.setUserName(this.credentials[0]);				//If auth denied, setup invalid session values
    		session.setAuthenticated(false);
    	}
    	return session;
    }

}
