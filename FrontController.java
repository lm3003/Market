
public class FrontController {
	private String[] credentials;
	private Dispatcher dispatcher;
	
	
	//Constructor accepts Credentials
	public FrontController() {
		
	}
	
	
	//Return the invalid view to user
	public String invalidView() {
		return "Username or Password is invalid";
	}
	
	public boolean isAuthenticated() {
		MarketClient marketClient = new MarketClient(credentials);
		return marketClient.authenticate();
	}
	
	public String getView(String[] credentials) {
		this.credentials = credentials;
		if(isAuthenticated()) {
			dispatcher = new Dispatcher(this.credentials[0]);
			return(dispatcher.getView());
		}else {
			return invalidView();
		}
	}

}
