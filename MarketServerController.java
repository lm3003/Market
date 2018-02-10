import java.rmi.RemoteException;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


public class MarketServerController implements Market{
	
	private String[] credentials;

	/**
	 * Implemented remote method from market interface.
	 */
	public synchronized boolean getAuthentication(String[] credentials) throws RemoteException {
		this.credentials = credentials;
		MarketModel marketModel = new MarketModel(this.credentials);
		return marketModel.authenticate();
	}
	

}
