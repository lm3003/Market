import java.rmi.RemoteException;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


//Client side controller for MVC architechture
public class MarketClientController {
	private Market myMarket;
	private MarketClient marketClient;
	public MarketClientController() {
		this.marketClient = new MarketClient();
		this.myMarket = this.marketClient.connect();
	}
	
	// Ryan: Does this class maintain high cohesion?
	// Fixed: Yes, it separates out the Java RMI layer with the client subsystem. 
	// Helps in delegating certain tasks as well as performing simple tasks such as catching exceptions.
	
	//register User
	public boolean registerUser(User newUser) {
		boolean isRegistered = false;
		try {
			isRegistered = this.myMarket.registerUser(newUser);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return isRegistered; 
	}
	

	public Session authenticate(User registeredUser) {
		Session session = null;
		try {
			session = this.myMarket.authenticate(registeredUser);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return session;
	}
	
	//add users to database
	public boolean addUsers(Session session, List<User> addUserList) {
		boolean isAdded = false;
		try {
			isAdded = this.myMarket.addUsers(session, addUserList);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return isAdded; 
	}
	
	//delete users from database
	public boolean deleteUsers(Session session, List<User> deleteUserList) {
		boolean isDeleted = false;
		try {
			isDeleted = this.myMarket.deleteUsers(session, deleteUserList);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return isDeleted; 
	}
	
	public List<Item> browseProducts(Session session) {
		List<Item> browseProducts = null;
		try {
			browseProducts = this.myMarket.browseProducts(session);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return browseProducts;
	}
	
	public boolean addProducts(Session session, List<Item> addProductList) {
		boolean isAdded = false;
		try {
			isAdded = this.myMarket.addProducts(session, addProductList);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return isAdded;
	}
	
	public boolean updateProducts(Session session, List<Item> updateProductList) {
		boolean isUpdated = false;
		try {
			isUpdated = this.myMarket.updateProducts(session, updateProductList);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return isUpdated;
	}
	
	//delegate action to update cart
	public boolean saveProductToCart(Session session, int[] productInfo){
		boolean saveProductToCart = false;
		try {
			saveProductToCart = this.myMarket.saveProductToCart(session, productInfo);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return saveProductToCart;
	}
	
	
	//delegate action to view shopping cart item
	public List<Item> viewShoppingCartProducts(Session session){
		List<Item> viewShoppingCartProducts = null;
		try {
			viewShoppingCartProducts = this.myMarket.viewShoppingCartProducts(session);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return viewShoppingCartProducts;
	}
	
	//delegate action to purchase items in shopping cart
	public boolean purchaseItems(Session session) {
		boolean purchaseItems = false;
		try {
			purchaseItems = this.myMarket.purchaseItems(session);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return purchaseItems;
	}
	
	//delegate action to delete product
	public boolean deleteProducts(Session session, List<Integer> deleteProductIdList) {
		boolean isDeleted = false;
		try {
			isDeleted = this.myMarket.deleteProducts(session, deleteProductIdList);
		}catch(RemoteException ex) {
			ex.printStackTrace();
		}
		return isDeleted;
	}
	
	
	

}
