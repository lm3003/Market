
import java.util.*;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

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