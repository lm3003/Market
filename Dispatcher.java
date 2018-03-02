//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Dispatcher class for dispatching views
public class Dispatcher {
	
	private Session session;
	
	
	public Dispatcher(Session session) {
		this.session = session;
	}
	
	//Select views
	public void dispatchView() {
		if(this.session.getRoleType().equalsIgnoreCase("admin")) {
			AdminView adminView = new AdminView();
			adminView.welcomeMessage(this.session);
		} else if (this.session.getRoleType().equalsIgnoreCase("customer")) {
			CustomerView customerView = new CustomerView();
			customerView.welcomeMessage(this.session);
		}else {
			return;
		}
	}

}
