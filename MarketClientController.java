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
	

	public Session authenticate(String[] credentials) {
		Session session = null;
		try {
			session = this.myMarket.authenticate(credentials);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return session;
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
	
//	public void updateProduct(Session session, Item item) {
//		this.myMarket.updateProduct(session, item);
//	}
	
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
	
	
	

}
