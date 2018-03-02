import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class ServerImpl implements Market, Serializable{
	private MarketServerController marketServerController;
	public ServerImpl() throws RemoteException { 
		this.marketServerController = new MarketServerController();
	}

	@Override
	public Session authenticate(String[] credentials) throws RemoteException {
		return this.marketServerController.authenticate(credentials);
	}

	@Override
	public List<Item> browseProducts(Session session) {
		return this.marketServerController.browseProducts();
	}

//	@Override
//	public void purchaseItems(Session session) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void updateProduct(Session session, Item item) {
		this.marketServerController.updateProduct(item);		
	}

	@Override
	public void saveProductToCart(Session session, int productId) {
		this.marketServerController.saveProductToCart(productId);
	}

	@Override
	public List<Item> viewShoppingCartProducts(Session session) {
		return this.marketServerController.viewShoppingCartProducts(session);
	}
	
	
	
}