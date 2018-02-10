

public class User {
	private String userName;
	private String password;
	
	public User(String[] credentials) {
		this.userName = credentials[0];
		this.password = credentials[1];
	}
	
	public boolean authenticate() {
    	if((this.userName.equals("customer") && this.password.equals("customer")) 
    			|| (this.userName.equals("admin") && this.password.equals("admin"))) {
    		return true;
    	}else {
    		return false;
    	}
    }

}
