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
	public void saveProductToCart(Session session, int productId) {
		this.myMarket.saveProductToCart(session, productId);
	}
	
	
	//delegate action to view shopping cart item
	public List<Item> viewShoppingCartProducts(Session session){
		return this.myMarket.viewShoppingCartProducts(session);
	}
	
	
	

}
