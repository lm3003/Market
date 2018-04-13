//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

import java.util.Scanner;


public class LoginView extends MarketView{
	private FrontController frontController;
//	default Constructor
	public LoginView() {
		this.frontController = new FrontController();
	}
	private Scanner scanner;
	// Ryan: Please include useful comments in each file.
	// Fixed: Added useful comments
	
	@Override
	void implementView() {
		welcomePage();
	}
	
	public void welcomePage() {
		System.out.println("Welcom to Market App...\nWhat would you like to do today?\nPlease enter your selection: ");
		System.out.println("1. Signup as a new customer\n2. Already a user? Signin");
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input) {
		case 1: 
			performSignup();
			break;
		case 2:
			performSignin();
			break;
		default:
			System.out.println("Invalid input. Exiting system...");
			System.exit(0);
		}
	}
	
	//perform user signin
	public void performSignup() {
		User newUser = getNewUserDetails();
		newUser.setRoleType("customer");
		boolean isRegistered = this.frontController.registerUser(newUser);
		if(isRegistered) {
			System.out.println("User registered successfully!!");
			performSignin();
		}else {
			System.out.println("A problem occured!! Please try again...");
			performSignup();
		}
	}
	
	//return user credentials
	private User getNewUserDetails() {
		User user = new User();
		System.out.print("\nPlease enter a First Name: ");
		user.setFirstname(scanner.next());
		System.out.print("\nPlease enter a Last Name: ");
		user.setLastname(scanner.next());
		System.out.print("\nPlease enter a username: ");
		user.setUsername(scanner.next());
		System.out.print("\nPlease enter a password: ");
		user.setPassword(scanner.next());
		return user;
	}
	
	//return registered user details
		private User getRegisteredUserDetails() {
			User user = new User();
			System.out.print("\nPlease enter a username: ");
			user.setUsername(scanner.next());
			System.out.print("\nPlease enter a password: ");
			user.setPassword(scanner.next());
			return user;
		}
	
	//Perform user authentication 
	public void performSignin() {
		System.out.println("\nPlease enter your Username and Password to sign in.");
		User registeredUser = getRegisteredUserDetails();
		//Invalid user view or customer view or admin view
		boolean isAuthenticated = frontController.processAuthentication(registeredUser);
		if(!isAuthenticated)
			welcomePage();
		scanner.close();
		System.exit(0);
	}

	
	
	
	
	

}
