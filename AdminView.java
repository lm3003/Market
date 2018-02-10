
public class AdminView extends MarketView {
	
	//default constructor
	public AdminView() {
		
	}
	
	//get admin view
	@Override
	void implementView() {
		welcomeMessage();
	}
	
	
	public void welcomeMessage() {
		System.out.println("Admin authenticated Successfully. \n Welcome Admin, what would you like to do today?"); 
	}

}
