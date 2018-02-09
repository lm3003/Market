
public class Dispatcher {
	
	private String userName;
	private CustomerView customerView;
	private AdminView adminView;
	
	public Dispatcher(String userName) {
		this.userName = userName;
	}
	
	public String getView() {
		if(userName.equals("customer")) {
			customerView = new CustomerView();
			return customerView.getView();
		} else if (userName.equals("admin")) {
			adminView = new AdminView();
			return adminView.getView();
		}else {
			return null;
		}
	}

}
