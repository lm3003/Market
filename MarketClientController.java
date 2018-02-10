//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi



public class MarketClientController {
	private String[] credentials;
	private Market myMarket;
	public MarketClientController(String[] credentials) {
		this.credentials = credentials;
	}
	
	public boolean authenticate() {
		boolean serverMessage = false;
		try {
			MarketClient marketClient = new MarketClient();
			myMarket = marketClient.getConnectionInstance();
			serverMessage = myMarket.getAuthentication(credentials);
		}catch(Exception ex) {
			System.out.println("Client exception: " + ex.getMessage());
		}
		return serverMessage;
	}
	
	
	
	

}
