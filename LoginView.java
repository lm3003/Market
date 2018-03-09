//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

import java.util.Scanner;


public class LoginView extends MarketView{
	private String[] credentials;
//	default Constructor
	public LoginView() {}
	
	// Ryan: Please include useful comments in each file.
	
	@Override
	void implementView() {
		performLogin();
	}
	
	public void performLogin() {
		String userName;
		String password;
		System.out.println("Welcome to Market App...\nPlease enter your Username and Password to sign in.");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");
		userName = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		this.credentials = new String[2];
		this.credentials[0] = userName;
		this.credentials[1] = password;
		FrontController frontController = new FrontController();
		//Invalid user view or customer view or admin view
		frontController.processAuthentication(this.credentials);
		scanner.close();
		System.exit(0);
	}

	
	
	
	
	

}
