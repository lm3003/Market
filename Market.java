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
	public boolean registerUser(User newUser) throws RemoteException;
	
	public Session authenticate(User registeredUser) throws RemoteException;
	
	public List<Item> browseProducts(Session session) throws RemoteException;
	
	@RequiresRole("admin")
	public boolean addUsers(Session session, List<User> addUserList) throws RemoteException;
	
	@RequiresRole("admin")
	public boolean deleteUsers(Session session, List<User> deleteUserList) throws RemoteException;
	
	@RequiresRole("admin")
	public boolean addProducts(Session session, List<Item> addProductList) throws RemoteException;
	
	@RequiresRole("admin")
	public boolean updateProducts(Session session, List<Item> updateProductList) throws RemoteException;
	
	@RequiresRole("admin")
	public boolean deleteProducts(Session session, List<Integer> deleteProductIdList) throws RemoteException;
	
	@RequiresRole("customer")
	public boolean saveProductToCart(Session session, int[] productInfo) throws RemoteException; 
	
	@RequiresRole("customer")
	public List<Item> viewShoppingCartProducts(Session session) throws RemoteException;
	
	@RequiresRole("customer")
	public boolean purchaseItems(Session session) throws RemoteException;
}
