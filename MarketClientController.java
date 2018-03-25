import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


//Client side controller for MVC architechture
public class MarketClientController {
	private String[] credentials;
	private Market myMarket;
	private MarketClient marketClient;
	public MarketClientController() {
		this.marketClient = new MarketClient();
		this.myMarket = this.marketClient.getConnectionInstance();
	}
	
	// Ryan: Does this class maintain high cohesion?
	// Fixed: Yes, it separates out the Java RMI layer with the client subsystem. 
	// Helps in delegating certain tasks as well as performing simple tasks such as catching exceptions.
	
	public String[] getCredentials() {
		return this.credentials;
	}

	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}

	public Session authenticate(String[] credentials) {
		setCredentials(credentials);
		Session session = null;
		try {
			session = this.myMarket.authenticate(getCredentials());
		}catch(Exception ex) {
			System.out.println("Client exception: " + ex.getMessage());
		}
		return session;
	}
	
	public List<Item> browseProducts(Session session){
		return this.myMarket.browseProducts(session);
	}
	
	public void updateProduct(Session session, Item item) {
		this.myMarket.updateProduct(session, item);
	}
	
	//delegate action to update cart
	public boolean saveProductToCart(Session session, int[] productInfo) {
		return this.myMarket.saveProductToCart(session, productInfo);
	}
	
	
	//delegate action to view shopping cart item
	public List<Item> viewShoppingCartProducts(Session session){
		return this.myMarket.viewShoppingCartProducts(session);
	}
	
	//delegate action to purchase items in shopping cart
	public boolean purchaseItems(Session session) {
		return this.myMarket.purchaseItems(session);
	}
	
	
	

}
