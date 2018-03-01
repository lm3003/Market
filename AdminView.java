import java.util.Scanner;

//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi



public class AdminView{
	private AdminViewController adminViewController;
	//default constructor
	public AdminView() {
		this.adminViewController = new AdminViewController();
	}
	
	//Admin welcome message
	public void welcomeMessage(Session session) {
		System.out.println("Admin Authenticated Successfully. \nWelcome Admin, Please select menu item number to proceed:");
		System.out.println("1. Add Another Admin\n2. Browse Products\n3. Exit");
		Scanner scanner = new Scanner(System.in);
		int optionSelected = Integer.parseInt(scanner.next());
		switch(optionSelected) {
		case 1: 
			break;
		case 2:
			adminViewController.browseProducts(session);
			break;
		case 3:
			adminViewController.updateProduct(session);
			break;
		default:
			System.out.println("Invalid Menu item number! Exiting...");
			System.exit(0);
		}
		scanner.close();
	}
}
