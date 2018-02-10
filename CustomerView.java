//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi
public class CustomerView extends MarketView{
	
	//default constructor
	public CustomerView() {
		
	}
	
	@Override
	void implementView() {
		welcomeMessage();
	}
	
	
	//get customer view
	public void welcomeMessage() {
		System.out.println("Customer Authenticated Successfully. \nWelcome Customer, what would you like to shop today?"); 
	}

}
