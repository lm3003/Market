import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

/**
 * MarketServer - Must implement any and all methods found in the Bank
 * interface. The variable 'name' must include the location where the
 * MarketServer is going to be registered with RMI to run.
 */
public class MarketServer extends UnicastRemoteObject implements Market{
	
	private String name;

	public MarketServer(String name) throws RemoteException {
		super(); 
		this.name = name;
	}

	/**
	 * Implemented remote method from market interface.
	 */
	public synchronized String getItem() throws RemoteException {
		return "Hello Client";
	}
	public static void main(String[] args) {
		// Set the RMI Security Manager...
				System.setSecurityManager(new SecurityManager());
				
				try {
					System.out.println("Creating a Market Server!");
					
					// Location of MarketServer
					String name = "//tesla.cs.iupui.edu:2096/oad/MarketServer";
					
					// Create a new instance of a MarketServer.
					MarketServer market = new MarketServer(name);
					
					System.out.println("MarketServer: binding it to name: " + name);
					
					// Binds the MarketServer to the RMI Service.
					Naming.rebind(name, market);
					
					System.out.println("Market Server Ready!");
				} catch (Exception e){
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}

	}


}
