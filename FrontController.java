//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//FrontController manages views
public class FrontController {
	private String[] credentials;
	private Dispatcher dispatcher;
	
	
	//Constructor accepts Credentials
	public FrontController(String[] credentials) {
		this.credentials = credentials;
	}
	
	
	//Return the invalid view to user
	public void invalidView() {
		System.out.println("Username or Password is invalid");
	}
	
	//Get authentication result
	public boolean isAuthenticated() {
		MarketClientController marketClientController = new MarketClientController(credentials);
		return marketClientController.authenticate();
	}
	
	//Act on dispatcher as per authentication result
	public void processAuthentication() {
		if(isAuthenticated()) {
			dispatcher = new Dispatcher(this.credentials[0]);
			dispatcher.dispatchView();
		}else {
			invalidView();
		}
	}

}
