import java.rmi.Naming;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

/**
 * MarketClient - Value in the 'name' variable should be the location
 * of the MarketServer.
 *
 */
public class MarketClient {
	private String[] credentials;
	private Market myMarket;
	
	public MarketClient(String[] credentials) {
		this.credentials = credentials;
	}
	
	//connect to server controller to authentication
	public boolean authenticate() {
		boolean serverMessage = false;
		// RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		try{
			String name = "//tesla.cs.iupui.edu:2096/oad/MarketServer";
			// Attempt to locate the MarketServer...
			System.out.println("Authenticating...");
			myMarket = (Market) Naming.lookup(name);
			serverMessage= myMarket.getAuthentication(this.credentials);
		} catch(Exception e){
			System.out.println("MarketClient Exception: " +
			e.getMessage());
			e.printStackTrace();
		}
		
		return serverMessage;	
	}
}
