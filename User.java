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
	
	
	public Session authenticate() {
		Session session = new Session();
    	if(this.credentials[0].equals("customer") && this.credentials[1].equals("customer")) {
    		session.setRoleType("Customer");
    		session.setUserName(this.credentials[0]);
    		session.setAuthenticated(true);
    		
    	}else if(this.credentials[0].equals("admin") && this.credentials[1].equals("admin")) {
    		session.setRoleType("Admin");
    		session.setUserName(this.credentials[0]);
    		session.setAuthenticated(true);
    	}else {
    		session.setRoleType("Invalid");
    		session.setUserName(this.credentials[0]);
    		session.setAuthenticated(false);
    	}
    	return session;
    }

}
