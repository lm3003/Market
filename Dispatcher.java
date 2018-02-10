//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Dispatcher class for dispatching views
public class Dispatcher {
	
	private String userName;
	
	
	public Dispatcher(String userName) {
		this.userName = userName;
	}
	
	//Select views
	public void dispatchView() {
		AbstractFactory marketFactory = FactoryCreator.getFactory("MarketFactory");
		if(userName.equals("customer")) {
			MarketView marketView = marketFactory.getView("customerView");
			marketView.implementView();
		} else if (userName.equals("admin")) {
			MarketView marketView = marketFactory.getView("adminView");
			marketView.implementView();
		}else {
			return;
		}
	}

}
