import java.rmi.RemoteException;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

/**
 * This interface serves as the proxy between the MarketServer and the
 * MarketClient. The MarketServer must implement this method.
 *
 */

public interface Market extends java.rmi.Remote{
	
	/**
	 * Gets the Transaction ID number.
	 * 
	 * @return Transaction ID
	 * @throws java.rmi.RemoteException
	 */
	public Session authenticate(String[] credentials) throws RemoteException;
	
	public List<Item> browseProducts(Session session) throws RemoteException;
	
//	@RequiresRole("customer")
//	public void purchaseItems(Session session);
	
//	@RequiresRole("admin")
//	public void updateProduct(Session session, Item item);
	
	@RequiresRole("customer")
	public boolean saveProductToCart(Session session, int[] productInfo) throws RemoteException; 
	
	@RequiresRole("customer")
	public List<Item> viewShoppingCartProducts(Session session) throws RemoteException;
	
	@RequiresRole("customer")
	public boolean purchaseItems(Session session) throws RemoteException;
}
