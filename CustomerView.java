import java.util.Scanner;

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
		System.out.println("Customer Authenticated Successfully. \nWelcome Customer, Please select menu item number to proceed:");
		System.out.println("1. Browse Products\n2. View products in your cart\n3.Exit");
		Scanner scanner = new Scanner(System.in);
		int optionSelected = Integer.parseInt(scanner.next());
		switch(optionSelected) {
		case 1:
			this.customerViewController.browseProducts(session);
			break;
		case 2:
			this.customerViewController.viewShoppingCartProducts(session);
			break;
		default:
			System.out.println("Invalid Menu item number! Exiting...");
			System.exit(0);
		}
		scanner.close();
	}
}
