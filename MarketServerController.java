import java.io.Serializable;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Market side controller

//delegating requests to marketmodel ...
public class MarketServerController implements Serializable{

	private static final long serialVersionUID = 1L;
	private String[] credentials;
	private MarketModel marketModel;
	public MarketServerController() {
		this.marketModel = new MarketModel();
	}

	public String[] getCredentials() {
		return credentials;
	}

	public void setCredentials(String[] credentials) {
		this.credentials = credentials;
	}
	
	//method to delegate registering user action
	public boolean registerUser(User newUser) {
		return this.marketModel.registerUser(newUser);
	}

	/**
	 * Implemented remote method from market interface.
	 */
	public Session authenticate(User registeredUser) {
		return this.marketModel.authenticate(registeredUser);
	}
	
	public boolean addUsers(List<User> addUserList) {
		return this.marketModel.addUsers(addUserList);
	}

	public boolean deleteUsers(List<User> deleteUserList) {
		return this.marketModel.deleteUsers(deleteUserList);
	}
	
	public List<Item> browseProducts(){
		return this.marketModel.browseProducts();
	}
	
	public boolean addProducts(List<Item> addProductList) {
		return this.marketModel.addProducts(addProductList);
	}
	
	public boolean updateProducts(List<Item> updateProductList) {
		return this.marketModel.updateProducts(updateProductList);
	}
	
	public boolean saveProductToCart(String username, int[] productInfo) {
		return this.marketModel.saveProductToCart(username, productInfo);
	}
	
	public List<Item> viewShoppingCartProducts(String username) {
		return this.marketModel.viewShoppingCartProducts(username);
	}
	
	
	public boolean purchaseItems(String username) {
		return this.marketModel.purchaseItems(username);
	}
	
	public boolean deleteProducts(List<Integer> deleteProductIdList) {
		return this.marketModel.deleteProducts(deleteProductIdList);
	}
}
