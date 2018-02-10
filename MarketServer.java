import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

// Ryan: Here we have a violation of separation of concerns in that
// we are mixing Server and "framework" information togther. We need to isolate
// the "framework" specific details in the form of a Controller.
// Fixed: Added a separate Server application controller to ensure separation of concerns.

/**
 * MarketServer - Must implement any and all methods found in the Market
 * interface. The variable 'name' must include the location where the
 * MarketServer is going to be registered with RMI to run.
 */
public class MarketServer extends UnicastRemoteObject implements Market{
	
	public MarketServer(String name) throws RemoteException {
		super(); 
	}
	
	@Override
	public synchronized boolean authenticate(String[] credentials) throws RemoteException {
		MarketServerController marketServerController = new MarketServerController(credentials);
		return marketServerController.authenticate();
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
