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

/**
 * MarketClient - Value in the 'name' variable should be the location
 * of the MarketServer.
 *
 */
public class MarketClient {
	public static void main(String args[]){
		// RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		
		String serverMessage;

		try{
			String name = "//tesla.cs.iupui.edu:2096/oad/MarketServer";
			// Attempt to locate the MarketServer...
			Market myMarket = (Market) Naming.lookup(name);
			System.out.println("Poking Server");
			serverMessage = myMarket.getItem();
			System.out.println("Message from Server:" + serverMessage);	
		} catch(Exception e){
			System.out.println("MarketClient Exception: " +
			e.getMessage());
			e.printStackTrace();
		}
		
		System.exit(0);
	}
}
