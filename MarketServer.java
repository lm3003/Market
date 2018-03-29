import java.lang.reflect.Proxy;
import java.rmi.Naming;

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
public class MarketServer{
	

	public MarketServer(){
		
	}

	public static void main(String[] args) {
				// Set the RMI Security Manager...
				System.setSecurityManager(new SecurityManager());
				
				try {
					System.out.println("Creating a Market Server!");
					
					// Location of MarketServer
					String name = "//in-csci-rrpc01.cs.iupui.edu:2096/oad";
					
					//AuthorizationInvocationHandler to check at method invocation  if session is authenticated to proceed
					Market assignment = (Market) Proxy.newProxyInstance(Market.class.getClassLoader(), 
												new Class<?>[] {Market.class},
												new AuthorizationInvocationHandler(new ServerImpl()));
					
					System.out.println("MarketServer: binding it to name: " + name);
					
					// Binds the MarketServer to the RMI Service.
					Naming.rebind(name, assignment);
					
					System.out.println("Market Server Ready!");
				} catch (Exception e){
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}
		}
}
