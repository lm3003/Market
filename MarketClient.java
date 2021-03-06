import java.rmi.Naming;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

// Ryan: Here we have a violation of separation of concerns in that
// we are mixing Client and "framework" information togther. We need to isolate
// the "framework" specific details in the form of a Controller.
// Fixed: I have now implemented MarketClientController to ensure separation of concerns. This class only deals with Java RMI


/**
 * MarketClient - Value in the 'name' variable should be the location
 * of the MarketServer.
 *
 */
public class MarketClient {
	private Market market;
	
	//default constructor
	public MarketClient() {
	}
	
//	public Market getConnectionInstance() {
//		connect();
//		return this.myMarket;
//	}
	
	//connect to server controller to authentication
	public Market connect() {
		// RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		try{
			String name = "//in-csci-rrpc01.cs.iupui.edu:2096/oad";
			
			// Attempt to locate the MarketServer...
			this.market = (Market) Naming.lookup(name);
			
		} catch(Exception e){
			System.out.println("MarketClient Exception: " +
			e.getMessage());
			e.printStackTrace();
		}
		return this.market;
	}
}
