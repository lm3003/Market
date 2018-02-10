//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

import java.util.Scanner;


public class LoginView extends MarketView{
	
//	default Constructor
	public LoginView() {}
	
	@Override
	void implementView() {
		performLogin();
	}
	
	public void performLogin() {
		String userName;
		String password;
		String[] credentials = new String[2];
		System.out.println("Welcome to Market App...\nPlease enter your Username and Password to sign in.");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");
		userName = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		credentials[0] = userName;
		credentials[1] = password;
		scanner.close();
		FrontController frontController = new FrontController(credentials);
		//Invalid user view or customer view or admin view
		frontController.processAuthentication();
		System.exit(0);
	}

	
	
	
	
	

}
