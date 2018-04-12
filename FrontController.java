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
	
	//add users to database
	public boolean addUsers(Session session, List<User> addUserList) {
		return this.marketClientController.addUsers(session, addUserList);
	}
	
	//delete users from database
	public boolean deleteUsers(Session session, List<User> deleteUserList) {
		return this.marketClientController.deleteUsers(session, deleteUserList);
	}
	
	//Register User
	public boolean registerUser(User newUser) {
		return this.marketClientController.registerUser(newUser);
	}


	//Get authentication result
	public Session getUserSession(User registeredUser) {
		return marketClientController.authenticate(registeredUser);
	}
	
	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}


	//Act on dispatcher as per authentication result
	public void processAuthentication(User registeredUser) {
		Session session = getUserSession(registeredUser);
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
	
	//delegate add procut action
	public boolean addProducts(Session session, List<Item> addProductList) {
		return this.marketClientController.addProducts(session, addProductList);
	}
	
	//delegate update product action
	public boolean updateProducts(Session session, List<Item> updateProductList) {
		return this.marketClientController.updateProducts(session, updateProductList);
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
	
	//delegate action to delete item from database
	public boolean deleteProducts(Session session, List<Integer> deleteProductIdList) {
		return this.marketClientController.deleteProducts(session, deleteProductIdList);
	}

}
