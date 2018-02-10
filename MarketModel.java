
// Ryan: Are you using all classes in the util package, if not please only include those you are.
// Fixed: Removed util as it is not being used


//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


// Ryan: Shouldn't the Model be doing something here?

// Fixed: For the first assignment, Model only was a part of the skeleton framework that we created according to the requirements.
// Now it helps in credential verification.

/**
 * 
 */
public class MarketModel {
	private String[] credentials;

    /**
     * Default constructor
     */
    public MarketModel() {
    }
    
    //constructor that accepts credentials
    public MarketModel(String[] credentials) {
    	this.credentials = credentials;
    }
    
    //return authentication results
    public boolean authenticate() {
    	String userName = credentials[0];
    	String password = credentials[1];
    	if((userName.equals("customer") && password.equals("customer")) || (userName.equals("admin") && password.equals("admin"))) {
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * 
     */
    public void marketModel() {
        // TODO implement here
    }
    

    /**
     * 
     */
    public void getItem() {
        // TODO implement here
    }

}