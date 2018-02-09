import java.util.Scanner;

public class LoginView {
	
//	default Constructor
	public LoginView() {
		
		
	}
	
	public static void main(String[] args) {
		String userName;
		String password;
		String[] credentials = new String[2];
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");
		userName = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		credentials[0] = userName;
		credentials[1] = password;
		scanner.close();
		FrontController frontController = new FrontController();
		//Invalid user view or customer view or admin view
		System.out.println(frontController.getView(credentials));
		System.exit(0);
	}
	
	
	
	

}
