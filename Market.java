//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

/**
 * This interface serves as the proxy between the MarketServer and the
 * MarketClient. The MarketClient must implement this method.
 *
 */

public interface Market extends java.rmi.Remote{
	
	/**
	 * Gets the Transaction ID number.
	 * 
	 * @return Transaction ID
	 * @throws java.rmi.RemoteException
	 */
	public boolean authenticate(String[] credentials) throws java.rmi.RemoteException;

}
