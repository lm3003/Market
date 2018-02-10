//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Client side class for app startup
public class ApplicationStartup {

	public static void main(String[] args) {
		AbstractFactory marketFactory = FactoryCreator.getFactory("MarketFactory");
		MarketView marketView = marketFactory.getView("LoginView");
		marketView.implementView();

	}

}
