
public class ApplicationStartup {

	public static void main(String[] args) {
		AbstractFactory abstractFactory = FactoryCreator.getFactory("MarketFactory");
		MarketView marketView = abstractFactory.getView("LoginView");
		marketView.implementView();

	}

}
