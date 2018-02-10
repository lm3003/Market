
public class MarketFactory extends AbstractFactory {

	@Override
	public MarketView getView(String viewChoice) {
		if(viewChoice == null)
			return null;
		if(viewChoice.equalsIgnoreCase("LoginView")) {
			return new LoginView();
		} else if(viewChoice.equalsIgnoreCase("AdminView")) {
			return new AdminView();
		} else if(viewChoice.equalsIgnoreCase("CustomerView")) {
			return new CustomerView();
		}
		return null;
	}
	
}
