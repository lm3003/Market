import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

public class ServerImpl extends UnicastRemoteObject implements Market, Serializable{
	
	private static final long serialVersionUID = 1L;
	private MarketServerController marketServerController;
	public ServerImpl() throws RemoteException {
		this.marketServerController = new MarketServerController();
	}

	@Override
	public Session authenticate(String[] credentials) throws RemoteException{
		return this.marketServerController.authenticate(credentials);
	}

	@Override
	public List<Item> browseProducts(Session session) throws RemoteException{
		return this.marketServerController.browseProducts();
	}
	
	@Override
	public boolean saveProductToCart(Session session, int[] productInfo) throws RemoteException{
		return this.marketServerController.saveProductToCart(productInfo);
	}

	@Override
	public List<Item> viewShoppingCartProducts(Session session) throws RemoteException{
		return this.marketServerController.viewShoppingCartProducts();
	}
	
	@Override
	public boolean purchaseItems(Session session) throws RemoteException{
		return this.marketServerController.purchaseItems();
	}

//	@Override
//	public void updateProduct(Session session, Item item) {
//		this.marketServerController.updateProduct(item);		
//	}

	
	
	
}