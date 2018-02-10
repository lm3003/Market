//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi



public class AdminView extends MarketView {
	
	//default constructor
	public AdminView() {
		
	}
	
	//get admin view
	@Override
	void implementView() {
		welcomeMessage();
	}
	
	//Admin welcome message
	public void welcomeMessage() {
		System.out.println("Admin authenticated Successfully. \nWelcome Admin, what would you like to do today?"); 
	}

}
