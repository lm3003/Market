//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi
public class Dispatcher {
	
	private String userName;
	private MarketView customerView;
	private MarketView adminView;
	
	public Dispatcher(String userName) {
		this.userName = userName;
	}
	
	public void getView() {
		if(userName.equals("customer")) {
			customerView = new CustomerView();
				customerView.implementView();
		} else if (userName.equals("admin")) {
			adminView = new AdminView();
			 	adminView.implementView();
		}else {
			return;
		}
	}

}
