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
		System.out.println("Admin Authenticated Successfully. \nWelcome Admin, Below are the items on sale...");
		this.adminViewController.browseProducts(session);
	}
}
