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
	public Session authenticate(String[] credentials) throws java.rmi.RemoteException;
	
	public List<Item> browseProducts(Session session);
	
//	@RequiresRole("customer")
//	public void purchaseItems(Session session);
	
	@RequiresRole("admin")
	public void updateProduct(Session session, Item item);
	
	@RequiresRole("customer")
	public boolean saveProductToCart(Session session, int[] productInfo);
	
	@RequiresRole("customer")
	public List<Item> viewShoppingCartProducts(Session session);
	
	@RequiresRole("customer")
	public boolean purchaseItems(Session session);
	
	

}
