import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class ServerImpl extends UnicastRemoteObject implements Market, Serializable{
	// Ryan: Please include useful comments in each class.
	// Fixed: Useful comments added
	
	private static final long serialVersionUID = 1L;
	private MarketServerController marketServerController;
	public ServerImpl() throws RemoteException {
		this.marketServerController = new MarketServerController();
	}
	
	//delegating action to register user
	@Override
	public boolean registerUser(User newUser) throws RemoteException {
		return this.marketServerController.registerUser(newUser);
	}

	// delegating action to authenticate user
	@Override
	public Session authenticate(User registeredUser) throws RemoteException {
		return this.marketServerController.authenticate(registeredUser);
	}

	// delegating action to fetch available products
	@Override
	public List<Item> browseProducts(Session session) throws RemoteException {
		return this.marketServerController.browseProducts();
	}
	
	//delegating action to add product list
	@Override
	public boolean addProducts(Session session, List<Item> addProductList) {
		return this.marketServerController.addProducts(addProductList);
	}
	
	// delegating action to fetch saved products in cart
	@Override
	public boolean saveProductToCart(Session session, int[] productInfo) throws RemoteException {
		return this.marketServerController.saveProductToCart(productInfo);
	}

	// delegating action to view shopping cart products
	@Override
	public List<Item> viewShoppingCartProducts(Session session) throws RemoteException {
		return this.marketServerController.viewShoppingCartProducts();
	}
	
	// delegating action to purchase items in shopping cart
	@Override
	public boolean purchaseItems(Session session) throws RemoteException {
		return this.marketServerController.purchaseItems();
	}

	@Override
	public boolean updateProducts(Session session, List<Item> updateProductList) throws RemoteException {
		return this.marketServerController.updateProducts(updateProductList);		
	}
	
	@Override
	public boolean deleteProducts(Session session, List<Integer> deleteProductIdList) throws RemoteException {
		return this.marketServerController.deleteProducts(deleteProductIdList);
	}

	@Override
	public boolean addUsers(Session session, List<User> addUserList) throws RemoteException {
		return this.marketServerController.addUsers(addUserList);
	}

	@Override
	public boolean deleteUsers(Session session, List<User> deleteUserList) throws RemoteException {
		return this.marketServerController.deleteUsers(deleteUserList);
	}

	

	
	
	
}