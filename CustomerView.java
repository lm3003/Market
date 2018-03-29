//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi


public class CustomerView{
	private CustomerViewController customerViewController;
	//default constructor
	public CustomerView() {
		this.customerViewController = new CustomerViewController();
	}
	
	//get customer view
	public void welcomeMessage(Session session) {
		System.out.println("Customer Authenticated Successfully. \nWelcome Customer, Below are the items on sale...");
		this.customerViewController.browseProducts(session);
	}
}
