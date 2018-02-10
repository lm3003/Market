//Honor Pledge:
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//lmodi

//Class to get Factories
public class FactoryCreator {
	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("MarketFactory")) {
			return new MarketFactory();
		}
		
		return null;
	}

}
