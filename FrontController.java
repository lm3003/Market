import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//FrontController manages views
public class FrontController {
	private String[] credentials;
	private Dispatcher dispatcher;
	private MarketClientController marketClientController;
	
	//Default Constructor
	public FrontController() {
		this.marketClientController = new MarketClientController();
	}
	
	
	//Return the invalid view to user
	public void invalidView() {
		System.out.println("Username or Password is invalid");
	}
	//get credentials
	public String[] getCredentials() {
		return this.credentials;
	}


	//Get authentication result
	public Session getUserSession(String[] credentials) {
		return marketClientController.authenticate(credentials);
	}
	
	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}


	//Act on dispatcher as per authentication result
	public void processAuthentication(String[] credentials) {
		Session session = getUserSession(credentials);
		if(session.isAuthenticated()) {
			this.dispatcher = new Dispatcher(session);
			this.dispatcher.dispatchView();
		}else {
			invalidView();
		}
	}
	
	//delegate browse products action
	public List<Item> browseProducts(Session session) {
		return this.marketClientController.browseProducts(session);
	}
	
	//delegate update product action
	public void updateProduct(Session session, Item item) {
//		this.marketClientController.updateProduct(session, item);
	}
	
	//delegate action to update cart
	public boolean saveProductToCart(Session session, int[] productInfo) {
		return this.marketClientController.saveProductToCart(session, productInfo);
	}
	
	//delegate action to view shopping cart item
	public List<Item> viewShoppingCartProducts(Session session){
		return this.marketClientController.viewShoppingCartProducts(session);
	}
	
	//delegate action to purchase items in shopping cart
	public boolean purchaseItems(Session session) {
		return this.marketClientController.purchaseItems(session);
	}

}
