import java.io.Serializable;
import java.rmi.RemoteException;
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
	public Session authenticate(String[] credentials) throws RemoteException {
		setCredentials(credentials);
		//Creating user instance...
		User user = new User();
		user.setCredentials(this.credentials);
		//Creating command
		Authenticate authenticate = new Authenticate(user);
		
		//Intializing invoker
		return marketModel.execute(authenticate);
	}
	
	public List<Item> browseProducts(){
		return marketModel.browseProducts();
	}
	
	public void updateProduct(Item item) {
		marketModel.updateProduct(item);
	}
	

}
