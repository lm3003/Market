
public class ApplicationStartup {

	public static void main(String[] args) {
		AbstractFactory marketFactory = FactoryCreator.getFactory("MarketFactory");
		MarketView marketView = marketFactory.getView("LoginView");
		marketView.implementView();

	}

}
