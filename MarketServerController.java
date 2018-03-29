import java.io.Serializable;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Market side controller
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

	/**
	 * Implemented remote method from market interface.
	 */
	public Session authenticate(String[] credentials) {
		return this.marketModel.authenticate(credentials);
	}
	
	public List<Item> browseProducts(){
		return this.marketModel.browseProducts();
	}
	
	public void updateProduct(Item item) {
//		MarketModel.getInstance().updateProduct(item);
	}
	
	public boolean saveProductToCart(int[] productInfo) {
		return this.marketModel.saveProductToCart(productInfo);
	}
	
	public List<Item> viewShoppingCartProducts() {
		return this.marketModel.viewShoppingCartProducts();
	}
	
	
	public boolean purchaseItems() {
		return this.marketModel.purchaseItems();
	}
	

}
