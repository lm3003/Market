import java.rmi.RemoteException;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


public class MarketServerController{
	
	private String[] credentials;
	
	public MarketServerController() {
		super();
	}

	public MarketServerController(String[] credentials) {
		this.credentials = credentials;
	}

	/**
	 * Implemented remote method from market interface.
	 */
	public boolean authenticate() throws RemoteException {
		//Creating user instance...
		User user = new User(this.credentials);
		
		//Creating command
		Authenticate authenticate = new Authenticate(user);
		
		//Intializing invoker
		MarketModel marketModel = new MarketModel();
		return marketModel.execute(authenticate);
	}
	

}
