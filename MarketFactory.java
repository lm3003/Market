//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Get concrete view instances from MarketFactory
public class MarketFactory extends AbstractFactory {

	@Override
	public MarketView getView(String viewChoice) {
		if(viewChoice == null)
			return null;
		if(viewChoice.equalsIgnoreCase("LoginView")) {
			return new LoginView();
		}
		return null;
	}
	
}
